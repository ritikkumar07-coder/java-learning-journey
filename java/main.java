// interface Polygon {
//     void getArea();

//     // default method
//     default void getSides() {
//         System.out.println("I can get sides of a polygon");
//     }
// }

// // imolements the interface
// class Rectangle implements Polygon {
//     public void getArea() {
//         int length = 6;
//         int breadth = 5;
//         int area = length * breadth;
//         System.out.println("The area of the rectangle is" + area);
//     }


// // overrides
// public void getSides() {
//     System.out.println("I have 4 sides");
//     }
// }

// // implements the interface
// class Square implements Polygon {
//     public void getArea() {
//         int length = 5;
//         int area = length * length;
//         System.out.println("The area of the square is " + area);
//     }
// }

// class main {
//     public static void main(String[] args) {

//         // create an object of Rectangle
//         Rectangle r1 = new Rectangle();
//         r1.getArea();
//         r1.getSides();

//         // create an object of Square
//         Square s1 = new Square();
//         s1.getArea();
//         s1.getSides();

//     }

// }

// class Animal{
//     void sound(){
//         System.out.println("make sound");
//     }
// }
// class Dog extends Animal{
//     void sound(){
//         System.out.println("barking");
//     }
// }
 
// public class main{
//     public static void main(String[] args) {
//         Animal MyDog = new Dog();
//         MyDog.sound();
//     }
// }


// class Person{
//     String name;
//     int age;

//     Person(String name, int age){

//         this.name = name;
//         this.age = age;
//     }
// }

// class Employee extends Person{
//     int employeeId;

//     Employee(String name,int age, int employeeId){
//         super(name, age);
//         this.employeeId = employeeId;
//     }
//     void display(){
//         System.out.println(name + " " + age + " " + employeeId);
//     }
// }

// public class main{
//     public static void main(String [] args){
//         Employee e = new Employee("Ritik", 21, 007);
//         e.display();
//     }
// }


class Book{
    private String title;
    private String author;
    private double price;

    Book(String title, String author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display(){
        System.out.println(title + " " + author + " " + price);
    }
}

public class main{
    public static void main(String[] args) {
        Book b = new Book("Java","Ritik", 490);
        b.display();
    }
}
