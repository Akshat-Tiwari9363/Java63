public class day1 {

    public static void main(String[] args) {
        short s=100;//short
        long l=10000000000L;//long
        int a=100_0000_000;//integer
        int b=0b111;//binary
        int o=017;//octal
        int h=0x1f;//hexadecimal
        float f=10.5f;//float
        double d=12e10;//double
        boolean bool=true;//boolean
        char c='A';//char
        String n="Hello World";//String
        System.out.println("Short: "+s);
        System.out.println("Long: "+l);
        System.out.println("Integer: "+a);
        System.out.println("Binary: "+b);
        System.out.println("Octal: "+o);
        System.out.println("Hexadecimal: "+h);
        System.out.println("Float: "+f);
        System.out.println("Double: "+d);
        System.out.println("Boolean: "+bool);
        System.out.println("Char: "+c);
        System.out.println("String: "+n);

        //Type casting


        int i=1000000000;
        short s1=(short)i;//narrowing
        double d1=10.5;
        int i1=(int)d1;//narrowing
        short s2=100;
        int i2=s2;//widening
        double d2=s2;//widening
        System.out.println("Narrowing int to short: "+s1);
        System.out.println("Narrowing double to int: "+i1);
        System.out.println("Widening short to int: "+i2);
        System.out.println("Widening short to double: "+d2);

        //operators
        int x=10;
        int y=5;
        System.out.println("Addition: "+(x+y));
        System.out.println("Subtraction: "+(x-y));
        System.out.println("Multiplication: "+(x*y));
        System.out.println("Division: "+(x/y));
        System.out.println("Modulus: "+(x%y));
        System.out.println("Increment: "+(++x));
        System.out.println("Decrement: "+(--y));
        System.out.println("Relational: "+(x>y));
        System.out.println("Logical: "+(x>5 && y<10));
        System.out.println("Equality: "+(x==y));
        System.out.println("Ternary: "+(x>y ? "x is greater" : "y is greater"));

        // if-else statement

        int num=10;
        if(num>0){
            System.out.println("Positive number");
        }else if(num<0){
            System.out.println("Negative number");
        }else{
            System.out.println("Zero");
        }

        //switch statement

        int day=3;
        switch(day){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
        }

        //while loop do-while loop for loop
        int count=1;
        while(count<=5){
            System.out.println("While loop: "+count);
            count++;
        }
        int count2=1;
        do{
            System.out.println("Do-while loop: "+count2);
            count2++;
        }while(count2<=5);
        for(int i5=1;i5<=5;i5++){
            System.out.println("For loop: "+i5);
        }

    }
}