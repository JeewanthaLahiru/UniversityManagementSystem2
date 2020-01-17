package com.company;
import java.sql.*;

public class Signin {
    public int signIn (String username,String password,int role){
        int count =0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newsonoo", "root", "");
            Statement st = con.createStatement();
            String sqlQry=null;
            //int count =0;
            if (role == 1) {
                sqlQry = "select CourseName from stdCourses where StdNo=(select StdId from student where Username ='"+username+"' and Password = '"+password+"');";
            } else if (role == 2) {
                sqlQry = "select CourseName from lecCourses where LecNo=(select LecId from lecture where username = '"+username+"' and Password ='"+password+"');";
            }
            ResultSet rs = st.executeQuery(sqlQry);
            while (rs.next()) {
                System.out.println(rs.getString(1));
                count++;
            }
            if(count ==0){
                System.out.println("Login error.....");
            }
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return count;
    }

    public void addMoreCourses(String username,String password,int course,int role){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newsonoo", "root", "");
            Statement st = con.createStatement();
            String courseName = null;
            int courseId=0;
            if(course == 1){
                courseName = "SENG 11111 - Object Oriented Programming";
                courseId = 1;
            }else if(course ==2 ){
                courseName = "SENG 11112 - Introduction to databases";
                courseId = 2;
            }else if(course == 3){
                courseName = "SENG 11113 - Project management";
                courseId = 3;
            }
            String sqlQry = null;
            if(role == 2) {
                sqlQry = "insert into lecCourses(LecNo,CourseName,CourseNo) values((select LecId from lecture where username = '" + username + "' and Password = '" + password + "'),'" + courseName + "'," + courseId + ");";
            }else if(role == 1){
                sqlQry = "insert into stdCourses(StdNo,CourseName,CourseNo) values ((select StdId from student where username = '"+username+"' and password = '"+password+"' ),'"+courseName+"','"+courseId+"');";
            }
            st.executeUpdate(sqlQry);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
