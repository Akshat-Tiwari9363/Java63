import axios from "../axios";
import { useState, useEffect, createContext } from "react";

const AppContext = createContext({
  data: [],
  isError: "",
  cart: [],
  addToCart: () => {},
  removeFromCart: () => {},
  updateCartQuantity: () => {},
  refreshData: () => {},
  clearCart: () => {},
});

const getStoredCart = () => {
  try {
    const storedCart = JSON.parse(localStorage.getItem("cart"));
    return Array.isArray(storedCart) ? storedCart : [];
  } catch {
    localStorage.removeItem("cart");
    return [];
  }
};

export const AppProvider = ({ children }) => {
  const [data, setData] = useState([]);
  const [isError, setIsError] = useState("");
  const [cart, setCart] = useState(getStoredCart);

  const addToCart = (product) => {
    setCart((currentCart) => {
      const existingProduct = currentCart.find((item) => item.id === product.id);

      if (existingProduct) {
        return currentCart.map((item) =>
          item.id === product.id
            ? {
                ...item,
                quantity: Math.min(
                  item.quantity + 1,
                  Number(item.stockQuantity) || item.quantity + 1
                ),
              }
            : item
        );
      }

      return [...currentCart, { ...product, quantity: 1 }];
    });
  };

  const removeFromCart = (productId) => {
    setCart((currentCart) =>
      currentCart.filter((item) => String(item.id) !== String(productId))
    );
  };

  const updateCartQuantity = (productId, quantity) => {
    setCart((currentCart) =>
      currentCart.map((item) =>
        String(item.id) === String(productId)
          ? {
              ...item,
              quantity: Math.max(
                1,
                Math.min(Number(quantity), Number(item.stockQuantity) || Number(quantity))
              ),
            }
          : item
      )
    );
  };

  const refreshData = async () => {
    try {
      const response = await axios.get("/products");
      setData(response.data);
      setIsError("");
    } catch (error) {
      setIsError(error.response?.data?.message || error.message);
    }
  };

  const clearCart = () => {
    setCart([]);
    localStorage.removeItem("cart");
  };
  
  useEffect(() => {
    refreshData();
  }, []);

  useEffect(() => {
    localStorage.setItem("cart", JSON.stringify(cart));
  }, [cart]);
  
  return (
    <AppContext.Provider
      value={{
        data,
        isError,
        cart,
        addToCart,
        removeFromCart,
        updateCartQuantity,
        refreshData,
        clearCart,
      }}
    >
      {children}
    </AppContext.Provider>
  );
};

export default AppContext;
