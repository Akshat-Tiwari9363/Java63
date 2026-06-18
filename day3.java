//import package name
import com.example.day3p2;

//opps encapsulation
class Person{
    private String name;
    private int age;
    static int count=0;
    static {
        System.out.println("Static block executed");
    }
     {
        System.out.println("Instance block executed");
    }
    //constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }

    //this() constructor
    public Person() {
        this("Akshat", 21);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }
}

//inheritance single level inheritance
class Employee extends Person{
    private String department;

    public Employee(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    //this() constructor
    public Employee(String department) {
        this("John Doe", 30, department);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

//multilevel inheritance
class Manager extends Employee{
    private int teamSize;

    public Manager(String name, int age, String department, int teamSize) {
        super(name, age, department);
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
}

public class day3 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Bob", 30);
        System.out.println("Total persons created: " + Person.count);
        System.out.println("Person 1: " + p1.getName() + ", Age: " + p1.getAge());
        System.out.println("Person 2: " + p2.getName() + ", Age: " + p2.getAge());
        p1.setAge(26);
        System.out.println("Person 1 after age update: " + p1.getName() + ", Age: " + p1.getAge()); 
        p2.setName("Robert");
        System.out.println("Person 2 after name update: " + p2.getName() + ", Age: " + p2.getAge());
        Class.forName("Person");
        //reference creation
        Person p3=p1;
        System.out.println("Person 3: "+p3.getName()+", Age: "+p3.getAge());
        //null reference
        Person p4=null;
        //System.out.println(p4.getName()); //NullPointerException  
        //Garbage collection
        p4=new Person("Charlie", 35);
        System.out.println("Person 4: "+p4.getName()+", Age: "+p4.getAge());
        p4=null; // Eligible for garbage collection
        System.gc(); // Suggests the JVM to run the garbage collector
        //Anonymous object
        new Person("David", 40).getName(); // Anonymous object created and method called
        //Inheritance
        Employee e1=new Employee("Eve", 28, "HR");
        System.out.println("Employee 1: "+e1.getName()+", Age: "+e1.getAge()+", Department: "+e1.getDepartment());
        Manager m1=new Manager("Frank", 35, "IT", 5);
        System.out.println("Manager 1: "+m1.getName()+", Age: "+m1.getAge()+", Department: "+m1.getDepartment()+", Team Size: "+m1.getTeamSize());  
        
        //package usage
        day3p2 obj=new day3p2();
        String s[]={"hi","hello"};
        obj.main(s);
    }
}
