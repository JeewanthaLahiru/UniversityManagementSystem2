package com.company;

import java.sql.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class SignUp {
    public void signUP(String name,String username,String password,int age,int role) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newsonoo","root","");
            Statement st = con.createStatement();
            String studentqry="insert into student (Name,Username,Password,age) values('"+name+"','"+username+"','"+password+"',"+age+");";
            String lectureqry="insert into lecture (Name,Username,Password,age) values('"+name+"','"+username+"','"+password+"',"+age+");";
            if(role==1) {
                st.executeUpdate(studentqry);
            }else if(role==2){
                st.executeUpdate(lectureqry);
            }

            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void SignUpCourses(String name,String courses,int role){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newsonoo","root","");
            Statement st = con.createStatement();

            NumberFormat format = NumberFormat.getInstance(Locale.US);
            Number number = format.parse(courses);
            int num1 = number.intValue();
            int i=0;

            //System.out.println(num1);


            while(num1>=1){
                i=num1%10;
                if (i == 1) {
                    if(role ==1) {
                        st.executeUpdate("insert into stdcourses(StdNo, CourseName, CourseNo) values ((select StdId from student where Name='" + name + "'),'SENG 11111 - Object Oriented Programming'," + i + ");");
                    }else if(role ==2 ){
                        st.executeUpdate("insert into lecCourses(LecNo,CourseName,CourseNo) values((select LecId from lecture where Name ='"+name+"'),'SENG 11111 - Object Oriented Programming',"+ i +");");
                    }
                }
                else if(i==2){
                    if(role == 1) {
                        st.executeUpdate("insert into stdcourses(StdNo, CourseName, CourseNo) values ((select StdId from student where Name='" + name + "'),'SENG 11112 - Introduction to databases'," + i + ");");
                    }else if(role == 2){
                        st.executeUpdate("insert into lecCourses(LecNo,CourseName,CourseNo) values((select LecId from lecture where Name ='"+name+"'),'SENG 11112 - Introduction to database',"+ i +");");
                    }

                }
                else if(i==3){
                    if(role == 1) {
                        st.executeUpdate("insert into stdcourses(StdNo, CourseName, CourseNo) values ((select StdId from student where Name='" + name + "'),'SENG 11113 - Project management'," + i + ");");
                    }else if(role ==2){
                        st.executeUpdate("insert into lecCourses(LecNo,CourseName,CourseNo) values((select LecId from lecture where Name ='"+name+"'),'SENG 11113 - Project management',"+ i +");");
                    }

                }

                num1=num1/10;
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
