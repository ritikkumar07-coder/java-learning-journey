// 1 quesotion.

// import java.util.Scanner;

// public class array {
//     public static void main(String[] args) {
//         Scanner sc =  new Scanner(System.in);
//         int a = 3;
//         int b = 4;

//         int [] [] array = new int[a][b];
//         System.out.println("Enter the matrix elements: ");
//         for(int i = 0; i < a; i++){
//             for(int j = 0; j < b; j++){
//                 array[i][j] = sc.nextInt();
//             }
//         }
//         System.out.println("The result: ");
//         for(int i = 0; i < b; i++){
//             for(int j = 0; j < a; j++){
//                 System.out.print(array[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }    
// }


// 2 question.

// import java.util.*;

// public class array {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int a = 4;
//         int b = 5;

//         int[][] array = new int[a][b];
//         System.out.println("Enter the array elements: ");
//         for (int i = 0; i < a; i++) {
//             for (int j = 0; j < b; j++) {
//                 array[i][j] = sc.nextInt();
//             }
//         }
//         System.out.println("\nOdd and Positive elements: ");
//         for (int i = 0; i < a; i++) {
//             for (int j = 0; j < b; j++) {
//                 if (array[i][j] > 0 && array[i][j] % 2 != 0) {
//                     System.out.print(array[i][j] + " ");
//                 }
//             }
//         }
//         System.out.println("\nEven and positive elements: ");
//         for (int i = 0; i < a; i++) {
//             for (int j = 0; j < b; j++) {
//                 if (array[i][j] > 0 && array[i][j] % 2 == 0) {
//                     System.out.print(array[i][j] + " ");
//                 }
//             }
//         }

//         System.out.println("\nNegative elements : ");
//         for (int i = 0; i < a; i++) {
//             for (int j = 0; j < b; j++) {
//                 if (array[i][j] < 0) {
//                     System.out.print(array[i][j] + " ");
//                 }
//             }
//         }
//     }
// }


// 3 question.

// import java.util.Scanner;

// public class array{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int a = 4;
//         int b = 5;
//         int[][]array = new int[a][b];
//         int[][] array2 = new int [a][b];
//         System.out.println("\nEnter the array elements: ");
//         for(int i = 0; i < a; i++){
//             for(int j = 0; j < b; j++){
//                 array[i][j] = sc.nextInt();
                
//             }
//         }
//         for(int i = 0; i < a; i++){
//             for(int j = 0; j < b; j++){
//                 array2[i][j] = array[i][j];
//             }
//         }
//         System.out.println("\nCopied array elements are: ");
//         for(int i = 0; i < a; i++){
//             for(int j = 0; j < b; j++){
//                 System.out.print(array2[i][j] +" ");
//             }
//             System.out.println();
//         }   
//     }
// }

// 4 question

// import java.util.Scanner;

// public class array{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int a = 2;
//         int b = 2;
//         int[][]array = new int[a][b];
//         System.out.println("\nEnter the array elements: ");
//         for(int i = 0; i < a; i++){
//             for(int j = 0; j < b; j++){
//                 array[i][j] = sc.nextInt();
                
//             }
//         }
//         long product = 1;
//         for(int i = 0; i < a; i++){
//             for(int j = 0; j < b; j++){
//                 product *= array[i][j];
//             }
//         }

//         System.out.println(product);
//     }
// }

// import java.util.Scanner;

// public class array{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int a = 2;
//         int b = 2;

//         int [][] array = new int[a][b];
//         System.out.println("enter the array elements: ");
//         for(int i =0; i<a; i++){
//             for(int j= 0; j<b; j++){
//                 array[i][j] = sc.nextInt();
//             }
//         }
//         long product = 1;
//         for(int i=0; i<a; i++){
//             for(int j=0; j< b; j++){
//                 product *= array[i][j]; 
//             }
//         }
//         System.out.println(product);
//     }
// }

// recap

// import java.util.Scanner;

// public class arr{
//     public static void main(String [] args){
//         Scanner sc = new Scanner(System.in);

//         int a = 3;
//         int b = 4;

//         int array[][] = new int[a][b];
//         System.out.println("Enter the matrix elements: ");
//         for(int i = 0; i < a; i++){
//             for(int j = 0; j < b; j++){
//                 array[i][j] = sc.nextInt();
//             }
//         }
//         System.out.println("The result: ");
//         for(int i =0; i< b; i++){
//             for(int j = 0; j < a; j++){
//                 System.out.print(array[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }
// }


import java.util.Scanner;
public class array{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = 4;
        int b = 5;

        int array[][] = new int [a][b];

        System.out.println("Enter the array elements: ");
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                array[i][j] = sc.nextInt();
            }
        }
        System.out.println("\nodd and positive elements: ");
        for(int i = 0; i < a; i++){
            for(int j=0; j<b; j++){
                if(array[i][j] > 0 && array[i][j] %2!=0){
                    System.out.print(array[i][j] + " ");
                }
            }
        }

        System.out.println("\neven and positive elements: ");
        for(int i = 0; i < a; i++){
            for(int j=0; j<b; j++){
                if(array[i][j] > 0 && array[i][j] %2==0){
                    System.out.print(array[i][j] + " ");
                }
            }
        }
        System.out.println("\nnegative elements: ");
        for(int i = 0; i < a; i++){
            for(int j=0; j<b; j++){
                if(array[i][j] < 0 ){
                    System.out.print(array[i][j] + " ");
                }
            }
        }
    }
}



















