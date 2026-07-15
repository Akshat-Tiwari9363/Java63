package com.jersey;

import java.sql.Connection;

public class DBConnection {

    private String url="jdbc:mysql://localhost:3306/student";
    private String user="root";
    private String password="System@1234";

    public Connection getConnection(){
        Connection con=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=java.sql.DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public void closeConnection(Connection con){
        try {
            if(con!=null){
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}