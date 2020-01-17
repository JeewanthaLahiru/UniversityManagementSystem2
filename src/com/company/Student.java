package com.company;
import java.text.ParseException;
import java.util.Scanner;

public class Student extends Authentication {
    private String name;
    private String username;
    private String password;
    private int age;
    private String courses;
    public void signup() throws ParseException {
        Scanner scan=new Scanner(System.in);
        System.out.println("Student registration form\n");
        System.out.println("Name: ");
        name=scan.next();
        System.out.println("Username: ");
        username=scan.next();
        System.out.println("Password: ");
        password=scan.next();
        System.out.println("Age: ");
        age=scan.nextInt();
        System.out.println("Select the courses: ");
        System.out.println("[1] SENG 11111 - Object Oriented Programming");
        System.out.println("[2] SENG 11112 - Introduction to databases");
        System.out.println("[3] SENG 11113 - Project management");
        courses=scan.next();
        SignUp student= new SignUp();
        student.signUP(name,username,password,age,1);
        student.SignUpCourses(name,courses,1);
    }

    public void signin(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Username: ");
        username = scan.next();
        setUsername(username);
        System.out.println("Password: ");
        password = scan.next();
        setPassword(password);
        Signin student = new Signin();
        int count;
        count=student.signIn(username,password,1);

        if(count == 0){
            return;
        }

        int reg_role2;
        int course;
        System.out.println("Please select an option");
        System.out.println("[1] exit");
        System.out.println("[2] Register a new course");
        reg_role2 = scan.nextInt();
        switch (reg_role2){
            case 1:
                System.out.println("\nBye!\n");break;
            case 2:
                System.out.println("[1] SENG 11111 - Object Oriented Programming");
                System.out.println("[2] SENG 11112 - Introduction to databases");
                System.out.println("[3] SENG 11113 - Project management");
                course = scan.nextInt();
                addMoreCourses(course);
                System.out.println("\nCourse added to your Courses.Bye!\n");
                break;
        }
    }

    public void addMoreCourses(int course){
        Signin student = new Signin();
        student.addMoreCourses(getUsername(),getPassword(),course,1);
    }
}
