package org.example;


import java.sql.*;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/todotask";
    private static final String username = "root";
    private static final String password = "root";
    public static void main(String[] args){
        System.out.println("Connect with Database");
       try{
//           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection connection = DriverManager.getConnection(url,username,password);
           Statement statement = connection.createStatement();
           String query = "Select * from customer";
           ResultSet resultSet = statement.executeQuery(query);
           while(resultSet.next()){
               System.out.println(resultSet);
               int id = resultSet.getInt("customer_id");
               String email = resultSet.getString("email");
               String name =  resultSet.getString("name");
               String password = resultSet.getString("password");

               System.out.println(id+" "+email+" "+name+" "+password);
           }
       }catch (SQLException ex){
           ex.printStackTrace();
       }
    }
}