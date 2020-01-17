package com.company;

import java.text.ParseException;
import java.util.Scanner;

public class Lecture extends Authentication {
    private String name;
    private String username;
    private String password;
    private int age;
    private String courses;
    public void signUp(){

            Scanner scan=new Scanner(System.in);
            System.out.println("Lecture registration form\n");
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
            SignUp lecture= new SignUp();
            lecture.signUP(name,username,password,age,2);
            lecture.SignUpCourses(name,courses,2);
    }

    public void signin(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Username: ");
        username = scan.next();
        setUsername(username);
        System.out.println("Password: ");
        password = scan.next();
        setPassword(password);
        Signin lecture = new Signin();
        System.out.println("You are successfully registered following courses");
        int count;
        count = lecture.signIn(username,password,2);
        System.out.println("");
        if(count == 0)
            return;

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
                addMoreCourse(course);
                System.out.println("\nCourse added you your courses.Bye!\n");
                break;
        }
    }

    public void addMoreCourse(int course){
        Signin lecture = new Signin();
        lecture.addMoreCourses(getUsername(),getPassword(),course,2);
    }
}
