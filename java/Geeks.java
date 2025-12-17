// // Single Inheritance
// class vehicle {
//     vehicle() {
//         System.out.println("This is a vehicle");
//     }

//     void fun1() {
//         System.out.println("Function 1 from vehicle class");
//     }

//     double fun2(int x, float y) {
//         System.out.println("Function 2 from vehicle class");
//         return (x + y);
//     }
// }

// class car extends vehicle {
//     car() //non parameterized or default constructor
//     {
//         System.out.println("This vehicle is car");
//     }
// }

// public class Inhertience {

//         public static void main(String[] args) {
//             car obj = new car();
//             obj.fun1();
//             double res=obj.fun2(3,40.0F);
//             System.out.println(res);
//         }
//     }

// multilevel inheritance

//class vehicle {
//    vehicle(){
//        System.out.println("This is a vehicle");
//    }
//}
//class Fourwheeler extends vehicle{
//    Fourwheeler(){
//        System.out.println("4 wheeler vehicles");
//    }
//}
//class car extends Fourwheeler{
//   car(){
//    System.out.println("This 4 wheeler vehicle is a car");
//   }
//}
//public class Geeks{
//    public static void main(String[] args) {
//        Fourwheeler obj = new Fourwheeler(); //Triggers all constructors in order
//    }
//}
//


class vehicle{
    vehicle() {

        System.out.println("This is a vehicle");
    }
}

class fourwheeler extends vehicle{
    fourwheeler() {

        System.out.println("This vehicle is a fourwheeler");
    }
}
class car extends vehicle{
    car() {
        System.out.println("This vehicle is a car");

    }
}
public class Geeks {
    public static void main(String[] args) {
        fourwheeler obj = new fourwheeler();

    }
}