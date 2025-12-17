import java.util.*;

class student{
    private double rollNo;
    private String name;
    private String course;
    private float marks;
    private char grade;

    public double getRollNo(){
        return rollNo;
    }
    public void setRollNo(double rollNo){
        this.rollNo = rollNo;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getcourse(){
        return course;
    }
    public void setcourse(String course){
        this.course = course;
    }
    public float getMarks(){
        return marks;
    }
    public void setMarks(float marks){
        this.marks = marks;
    }
    public char getGrade(){
        return grade;
    }
    public void setGrade(char grade){
        this.grade = grade;
    }

}

class StudentDetails{
    private Scanner sc = new Scanner(System.in);
    public void inputDetails(student s){
        System.out.println("Enter Roll Number: ");
        s.setRollNo(sc.nextDouble());
        sc.nextLine();

        System.out.println("Enter Name: ");
        s.setName(sc.nextLine());

        System.out.println("Enter Course: ");
        s.setcourse(sc.nextLine());

        float marks;
        while (true) {
            System.out.println("Enter Marks (0 - 100): ");
            marks = sc.nextFloat();
            if(marks >=0 && marks <=100) break;
            System.out.println("Invalid marks! Please enter marks between 0 - 100. ");
        }
        s.setMarks(marks);
        calculateGrade(s);
    }

    private void calculateGrade(student s){
        float marks = s.getMarks();
        if (marks >= 90){
            s.setGrade('A');
        }else if(marks >= 70){
            s.setGrade('B');
        }else if(marks >= 50){
            s.setGrade('C');
        }else{
            s.setGrade('D');
        }
    }

    public void displayDetails(student s){
        System.out.println("Roll No: " + s.getRollNo());
        System.out.println("Name: " + s.getName());
        System.out.println("Course: " + s.getcourse());
        System.out.println("Marks: " + s.getMarks());
        System.out.println("Grade: " + s.getGrade());
    }
}
public class studentmanagementsystem{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        StudentDetails Details = new StudentDetails();
        student[] students = new student[100];
        int count = 0;
        int choice;
        do {
            System.out.println("===== Student Record Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.println("Enter your Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    students[count] = new student();
                    Details.inputDetails(students[count]);
                    count++;
                    break;
                case 2:
                    if(count == 0){
                        System.out.println("No Records found! ");
                    }else{
                        for(int i = 0; i < count; i++){
                            Details.displayDetails(students[i]);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting! Thank you.");
                    break;
            
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3);
    }
}