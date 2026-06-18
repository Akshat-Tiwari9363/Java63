//class and object
class Car{
    String brand;
    String model;
    int year;

    void displayInfo(){
        System.out.println("Brand: "+brand);
        System.out.println("Model: "+model);
        System.out.println("Year: "+year);
    }
}
public class day2 {
    public static void main(String[] args) {
        //Array
        int[] arr=new int[5];
        for(int i=0;i<arr.length;i++){
           arr[i]=(int)(Math.random()*100);
        }
        //Enhanced for loop
        System.out.println("Array elements:");
        for(int num:arr){
            System.out.println(num);
        }
        //2D Array
        int[][] arr2D=new int[3][3];
        for(int i=0;i<arr2D.length;i++){
            for(int j=0;j<arr2D[i].length;j++){
                arr2D[i][j]=(int)(Math.random()*100);
            }
        }
        //Enhanced for loop for 2D array
        System.out.println("2D Array elements:");  
        for(int[] row:arr2D){
            for(int num:row){
                System.out.print(num+" ");
            }
            System.out.println();
        }
        //jagged array
        int[][] jaggedArray=new int[3][];
        jaggedArray[0]=new int[2];
        jaggedArray[1]=new int[3];
        jaggedArray[2]=new int[4];
        for(int i=0;i<jaggedArray.length;i++){
            for(int j=0;j<jaggedArray[i].length;j++){
                jaggedArray[i][j]=(int)(Math.random()*100);
            }
        }
        //Enhanced for loop for jagged array
        System.out.println("Jagged Array elements:");
        for(int[] row:jaggedArray){
            for(int num:row){
                System.out.print(num+" ");
            }
            System.out.println();
        }
        //objects array
        Car[] cars=new Car[3];
        cars[0]=new Car();
        cars[0].brand="Toyota";
        cars[0].model="Camry";
        cars[0].year=2020;
        cars[1]=new Car();
        cars[1].brand="Honda";
        cars[1].model="Civic";
        cars[1].year=2019;
        cars[2]=new Car();
        cars[2].brand="Ford";
        cars[2].model="Focus";
        cars[2].year=2021;
        //enhanced for loop for objects array
        System.out.println("Car objects:");
        for(Car car:cars){
            car.displayInfo();
            System.out.println();
        }  
        //Drawback of arrays: fixed size, no built-in methods for resizing, no type safety, can only store homogeneous data types, inefficient for large data sets, no built-in methods for searching, sorting, etc.
        System.out.println("Drawbacks of arrays:");
        System.out.println("- Fixed size");
        System.out.println("- No built-in methods for resizing");
        System.out.println("- No type safety");
        System.out.println("- Can only store homogeneous data types");
        System.out.println("- Inefficient for large data sets");
        System.out.println("- No built-in methods for searching, sorting, etc.");
        //String class and string methods
        String str1="Hello";
        System.out.println("String 1: "+str1);
        String str2="World";
        System.out.println("String 2: "+str2);
        String str3=str1+" "+str2;
        System.out.println("Concatenated String: "+str3);
        System.out.println("Length of String: "+str3.length());
        System.out.println("Character at index 1: "+str3.charAt(1));
        System.out.println("Substring from index 0 to 5: "+str3.substring(0,5));
        System.out.println("Index of 'o': "+str3.indexOf('o')); 
        System.out.println("Replace 'o' with 'a': "+str3.replace('o','a'));
        System.out.println("Uppercase: "+str3.toUpperCase());
        System.out.println("Lowercase: "+str3.toLowerCase());
        System.out.println("Trimmed String: "+str3.trim());
        System.out.println("String equals 'Hello World': "+str3.equals("Hello World"));
        System.out.println("String equals ignore case 'hello world': "+str3.equalsIgnoreCase("hello world"));
        System.out.println("String starts with 'Hello': "+str3.startsWith("Hello"));
        System.out.println("String ends with 'World': "+str3.endsWith("World"));
        //StringBuffer class and string builder class
        StringBuffer sb=new StringBuffer("Hello");
        System.out.println("StringBuffer: "+sb);
        sb.append(" World");
        System.out.println("StringBuffer after append: "+sb);
        sb.insert(5, " Java");
        System.out.println("StringBuffer after insert: "+sb);
        sb.delete(5, 10);
        System.out.println("StringBuffer after delete: "+sb);
        sb.reverse();
        System.out.println("StringBuffer after reverse: "+sb);
        StringBuilder sb1=new StringBuilder("Hello");
        System.out.println("StringBuilder: "+sb1);
        sb1.append(" World");
        System.out.println("StringBuilder after append: "+sb1);
        sb1.insert(5, " Java");
        System.out.println("StringBuilder after insert: "+sb1);
        sb1.delete(5, 10);
        System.out.println("StringBuilder after delete: "+sb1);
        sb1.reverse();
        System.out.println("StringBuilder after reverse: "+sb1);
        sb1.setLength(0);
        System.out.println("StringBuilder after setLength(0): "+sb1);
        sb1.capacity();
        System.out.println("StringBuilder capacity: "+sb1.capacity());
        sb1.ensureCapacity(50);
        System.out.println("StringBuilder capacity after ensureCapacity(50): "+sb1.capacity());
        sb1.trimToSize();
        System.out.println("StringBuilder capacity after trimToSize(): "+sb1.capacity());
        //difference between String, StringBuffer and StringBuilder: String is immutable, StringBuffer is mutable and thread-safe, StringBuilder is mutable and not thread-safe. StringBuffer is slower than StringBuilder because of synchronization overhead. StringBuilder is faster than StringBuffer because it does not have synchronization overhead. StringBuffer is used when multiple threads are accessing the same string, while StringBuilder is used when only one thread is accessing the string.
        System.out.println("Difference between String, StringBuffer and StringBuilder:");
        System.out.println("- String is immutable");
        System.out.println("- StringBuffer is mutable and thread-safe");
        System.out.println("- StringBuilder is mutable and not thread-safe");
        System.out.println("- StringBuffer is slower than StringBuilder because of synchronization overhead");
        System.out.println("- StringBuilder is faster than StringBuffer because it does not have synchronization overhead");
        System.out.println("- StringBuffer is used when multiple threads are accessing the same string, while StringBuilder is used when only one thread is accessing the string"); 
        System.out.println("StringBuffer and StringBuilder are more efficient than String when performing multiple string manipulations because they do not create new objects for each modification, while String creates a new object for each modification due to its immutability.");
        //preferred choice for string manipulation: StringBuilder is preferred for single-threaded applications, while StringBuffer is preferred for multi-threaded applications. String is not preferred for string manipulation due to its immutability, which can lead to performance issues when performing multiple modifications. StringBuilder and StringBuffer are more efficient for string manipulation because they do not create new objects for each modification, while String creates a new object for each modification due to its immutability.
        System.out.println("Preferred choice for string manipulation:");
        System.out.println("- StringBuilder is preferred for single-threaded applications");
        System.out.println("- StringBuffer is preferred for multi-threaded applications");
        System.out.println("- String is not preferred for string manipulation due to its immutability, which can lead to performance issues when performing multiple modifications");   
    }    
}
