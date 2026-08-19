import { useContext, useEffect, useState } from "react";
import { Button } from "react-bootstrap";
import AppContext from "../Context/Context";
import axios from "../axios";
import unplugged from "../assets/unplugged.png";
import CheckoutPopup from "./CheckoutPopup";

const Cart = () => {
  const { cart, removeFromCart, updateCartQuantity, clearCart, refreshData } =
    useContext(AppContext);
  const [cartItems, setCartItems] = useState([]);
  const [totalPrice, setTotalPrice] = useState(0);
  const [showModal, setShowModal] = useState(false);
  const [isCheckingOut, setIsCheckingOut] = useState(false);

  useEffect(() => {
    let isMounted = true;

    const fetchImagesAndUpdateCart = async () => {
      if (!cart.length) {
        setCartItems([]);
        return;
      }

      try {
        const response = await axios.get("/products");
        const productsById = new Map(
          response.data.map((product) => [String(product.id), product])
        );

        const availableCartItems = cart
          .filter((item) => productsById.has(String(item.id)))
          .map((item) => ({
            ...productsById.get(String(item.id)),
            quantity: Math.min(
              item.quantity,
              Number(productsById.get(String(item.id)).stockQuantity) || item.quantity
            ),
          }));

        const cartItemsWithImages = await Promise.all(
          availableCartItems.map(async (item) => {
            try {
              const imageResponse = await axios.get(`/product/${item.id}/image`, {
                responseType: "blob",
              });
              const imageFile = new File(
                [imageResponse.data],
                item.imageName || `${item.name}-image`,
                { type: imageResponse.data.type }
              );
              const imageUrl = URL.createObjectURL(imageResponse.data);
              return { ...item, imageFile, imageUrl };
            } catch {
              return { ...item, imageFile: null, imageUrl: unplugged };
            }
          })
        );

        if (isMounted) {
          setCartItems(cartItemsWithImages);
        }
      } catch {
        if (isMounted) {
          setCartItems(cart);
        }
      }
    };

    fetchImagesAndUpdateCart();

    return () => {
      isMounted = false;
    };
  }, [cart]);

  useEffect(() => {
    const total = cartItems.reduce(
      (acc, item) => acc + Number(item.price) * Number(item.quantity),
      0
    );
    setTotalPrice(total);
  }, [cartItems]);

  const handleIncreaseQuantity = (itemId) => {
    const item = cartItems.find((cartItem) => cartItem.id === itemId);
    if (!item) return;

    if (item.quantity >= item.stockQuantity) {
      alert("Cannot add more than available stock");
      return;
    }

    updateCartQuantity(itemId, item.quantity + 1);
  };

  const handleDecreaseQuantity = (itemId) => {
    const item = cartItems.find((cartItem) => cartItem.id === itemId);
    if (!item) return;
    updateCartQuantity(itemId, Math.max(item.quantity - 1, 1));
  };

  const handleRemoveFromCart = (itemId) => {
    removeFromCart(itemId);
  };

  const handleCheckout = async () => {
    setIsCheckingOut(true);

    try {
      for (const item of cartItems) {
        if (item.quantity > item.stockQuantity) {
          throw new Error(`${item.name} has only ${item.stockQuantity} items in stock`);
        }

        const productPayload = {
          id: item.id,
          name: item.name,
          brand: item.brand,
          description: item.description,
          price: item.price,
          category: item.category,
          releaseDate: item.releaseDate,
          productAvailable: item.productAvailable,
          stockQuantity: item.stockQuantity,
        };
        const { imageFile, quantity } = item;
        const updatedProductData = {
          ...productPayload,
          stockQuantity: Number(item.stockQuantity) - Number(quantity),
          productAvailable: Number(item.stockQuantity) - Number(quantity) > 0,
        };

        const cartProduct = new FormData();
        if (imageFile) {
          cartProduct.append("imageFile", imageFile);
        }
        cartProduct.append(
          "product",
          new Blob([JSON.stringify(updatedProductData)], { type: "application/json" })
        );

        await axios.put(`/product/${item.id}`, cartProduct, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        });
      }

      clearCart();
      setCartItems([]);
      setShowModal(false);
      refreshData();
      alert("Purchase completed successfully");
    } catch (error) {
      alert(error.response?.data?.message || error.message || "Error during checkout");
    } finally {
      setIsCheckingOut(false);
    }
  };

  return (
    <div className="cart-container">
      <div className="shopping-cart">
        <div className="title">Shopping Bag</div>
        {cartItems.length === 0 ? (
          <div className="empty" style={{ textAlign: "left", padding: "2rem" }}>
            <h4>Your cart is empty</h4>
          </div>
        ) : (
          <>
            {cartItems.map((item) => (
              <li key={item.id} className="cart-item">
                <div className="item" style={{ display: "flex", alignContent: "center" }}>
                  <div>
                    <img src={item.imageUrl} alt={item.name} className="cart-item-image" />
                  </div>
                  <div className="description">
                    <span>{item.brand}</span>
                    <span>{item.name}</span>
                  </div>

                  <div className="quantity">
                    <button
                      className="plus-btn"
                      type="button"
                      name="button"
                      onClick={() => handleIncreaseQuantity(item.id)}
                    >
                      <i className="bi bi-plus-square-fill"></i>
                    </button>
                    <input type="button" name="name" value={item.quantity} readOnly />
                    <button
                      className="minus-btn"
                      type="button"
                      name="button"
                      onClick={() => handleDecreaseQuantity(item.id)}
                    >
                      <i className="bi bi-dash-square-fill"></i>
                    </button>
                  </div>

                  <div className="total-price" style={{ textAlign: "center" }}>
                    ${Number(item.price) * Number(item.quantity)}
                  </div>
                  <button className="remove-btn" onClick={() => handleRemoveFromCart(item.id)}>
                    <i className="bi bi-trash3-fill"></i>
                  </button>
                </div>
              </li>
            ))}
            <div className="total">Total: ${totalPrice}</div>
            <Button
              className="btn btn-primary"
              style={{ width: "100%" }}
              onClick={() => setShowModal(true)}
            >
              Checkout
            </Button>
          </>
        )}
      </div>
      <CheckoutPopup
        show={showModal}
        handleClose={() => setShowModal(false)}
        cartItems={cartItems}
        totalPrice={totalPrice}
        handleCheckout={handleCheckout}
        isCheckingOut={isCheckingOut}
      />
    </div>
  );
};

export default Cart;
