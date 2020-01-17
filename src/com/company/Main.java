package com.company;
import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner scan=new Scanner(System.in);
        Student mystudent= new Student();
        Lecture mylecture = new Lecture();
	    char sign_method='0';
	    int regi_role=0;
	    int reg_role2=0;
	    int course;
	    while(sign_method!='9'){
            System.out.println("Select, [1] sign up, [2] sign in.");
            sign_method=scan.next().charAt(0);
            switch (sign_method){
                case '1':
                    System.out.println("Please select your registration role [1] Lecturer [2] Student.");
                    regi_role=scan.nextInt();
                    switch (regi_role){
                        case 1:
                            mylecture.signUp();break;
                        case 2:
                            mystudent.signup();break;
                    }
                    break;
                case '2':
                    System.out.println("Please select your registration role [1] Lecturer [2] Student.");
                    regi_role=scan.nextInt();
                    switch (regi_role){
                        case 1:
                            mylecture.signin();
                            break;
                        case 2:
                            mystudent.signin();
                            break;
                    }
            }
        }
    }
}
