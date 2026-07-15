package com.jersey;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class StudentRepo {

    private Connection con=null;
    private Statement stmt=null;
    private PreparedStatement pstmt=null;


    public List<Student> getStudents(){
        List<Student> s=new ArrayList<>();
        try {
            con=new DBConnection().getConnection();
            stmt=con.createStatement();
            String query="select * from info";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                Student s1=new Student();
                s1.setId(rs.getInt("id"));
                s1.setName(rs.getString("name"));
                s1.setMarks(rs.getInt("marks"));
                s.add(s1);
            }
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new DBConnection().closeConnection(con);
        return s;
    }

    public Student getStudent(int id){
        Student s1=new Student();
        try {
            con=new DBConnection().getConnection();
            String query="select * from info where id=?";
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                s1.setId(rs.getInt("id"));
                s1.setName(rs.getString("name"));
                s1.setMarks(rs.getInt("marks"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        new DBConnection().closeConnection(con);
        return s1;
    }

    public void create(Student s1){
        try {
            con=new DBConnection().getConnection();
            String query="insert into info (id,name,marks) values(?,?,?)";
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1, s1.getId());
            pstmt.setString(2, s1.getName());
            pstmt.setInt(3, s1.getMarks());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new DBConnection().closeConnection(con);
    }

    public void update(Student s1){
        try {
            con=new DBConnection().getConnection();
            String query="update info set name=?,marks=? where id=?";
            pstmt=con.prepareStatement(query);
            pstmt.setString(1, s1.getName());
            pstmt.setInt(2, s1.getMarks());
            pstmt.setInt(3, s1.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new DBConnection().closeConnection(con);
    }

    public void delete(int id){
        try {
            con=new DBConnection().getConnection();
            String query="delete from info where id=?";
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new DBConnection().closeConnection(con);
    }

}
