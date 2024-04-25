package org.example;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class procces
{

    public void openAccount(Statement statement)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account No: ");
        long accNumber = sc.nextLong();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String userName = sc.nextLine();

        System.out.print("Enter Account type: ");
        String accType = sc.nextLine();

        System.out.print("Enter Balance: ");
        long accBalance = sc.nextLong();
        sc.nextLine();

try{
    int rowAffected = statement.executeUpdate("insert into bankinfo values("+accNumber+",'"+userName+"','"+accType+"',"+accBalance+")");
    if(rowAffected>0)
    {
        System.out.println("data inserted properly");
    }else{
        System.out.println("data insertion failed! try again");
        return;
    }
    ResultSet resultSet = statement.executeQuery("select * from bankinfo where userName='" + userName + "'");
    resultSet.next();
    System.out.println("------YOUR ACCOUNT DETAILS IS -------");
    System.out.println("Account no             :: " + resultSet.getLong("accNumber"));
    System.out.println("Name of account holder :: " + resultSet.getString("userName"));
    System.out.println("Account type           :: " + resultSet.getString("accType"));
    System.out.println("Balance                :: " + resultSet.getLong("accBalance"));
}catch (Exception e)
{
    e.printStackTrace();
}

    }
    public void demoaccount(Statement statement)
    {
        try {
            ResultSet resultSet = statement.executeQuery("select * from bankinfo where userName='demoname'");
            //            int demobalance = 50000;
            resultSet.next();
            System.out.println("Account no             :: " + resultSet.getLong("accNumber"));
            System.out.println("Name of account holder :: " + resultSet.getString("userName"));
            System.out.println("Account type           :: " + resultSet.getString("accType"));
            System.out.println("Balance                :: " + resultSet.getLong("accBalance"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deposit(Statement statement)
    {
        try {
            System.out.println("Enter your account number:");
            Scanner sc = new Scanner(System.in);
            long accNumber = sc.nextLong();
            System.out.println("Enter the Amount you want to deposit ::");
            long deposit = sc.nextInt();
            ResultSet resultSet = statement.executeQuery("SELECT accBalance FROM bankinfo WHERE accNumber=" + accNumber + "");
            if (resultSet.next()) {
               long Balance = resultSet.getLong("accBalance");
               long curr_balance = Balance+deposit;
               int rowCount = statement.executeUpdate("update bankinfo set accBalance="+ curr_balance +" where accNumber="+accNumber+"");
                System.out.println(" " + deposit + " is deposited into your Account");
                System.out.println("Current Available Balance is Rs = " + curr_balance);
                System.out.println("THANKS");
            } else {
                System.out.println("No account found for account number " + accNumber + "");
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void withdraw(Statement statement)
    {
        try {
            System.out.println("Enter your account number:");
            Scanner sc = new Scanner(System.in);
            long accNumber = sc.nextLong();
            System.out.println("Enter the Amount you want to withdraw:");
            long withdraw =sc.nextLong();
            ResultSet resultSet = statement.executeQuery("SELECT accBalance FROM bankinfo WHERE accNumber=" + accNumber + "");
            if (resultSet.next()) {
                long Balance = resultSet.getLong("accBalance");
                if(Balance < withdraw)
                {
                    System.out.println("Low Balance");
                    System.out.println("Current Available Balance is Rs  ::"+ Balance);
                    return;
                }
                long curr_balance = Balance-withdraw;
                int rowCount = statement.executeUpdate("update bankinfo set accBalance="+ curr_balance +" where accNumber="+accNumber+"");
                System.out.println(" " + withdraw+ " is debited from your Account");
                System.out.println("Current Available Balance is Rs = " + curr_balance);
                System.out.println("THANKS");
            } else {
                System.out.println("No account found for account number " + accNumber + "");
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void checkBalance(Statement statement) {
        try {
            System.out.println("Enter your account number:");
            Scanner sc = new Scanner(System.in);
            long accNumber = sc.nextLong();

            // Execute the query to retrieve the account balance
            ResultSet resultSet = statement.executeQuery("SELECT accBalance FROM bankinfo WHERE accNumber=" + accNumber + "");

            // Check if the result set has any rows
            if (resultSet.next()) {
                // Account balance found, print it
                System.out.println("Balance                :: " + resultSet.getLong("accBalance"));
                System.out.println("THANKS FOR BALANCE CHECKING");
            } else {
                // No account found for the provided account number
                System.out.println("No account found for account number " + accNumber + "");
            }

            // Close the result set
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
