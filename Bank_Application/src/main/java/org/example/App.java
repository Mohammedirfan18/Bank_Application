package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class App 
{

    public static void main(String[] args)
    {
        String url="jdbc:mysql://localhost:3306/bank";
        String name = "root";
        String password = "Mi@mySql01";
        Scanner sc = new Scanner(System.in);
        try {
            Connection connection = DriverManager.getConnection(url,name,password);
            Statement statement = connection.createStatement();
            Operation op = new Operation();
            op.bankinfo(statement);
        } catch(Exception e)
        {
            e.printStackTrace();
        }


    }
}
