package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Operation
{
    public static void bankinfo(Statement statement)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println(" ----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" ***Banking System Application***");
        System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println(" 1. Create a new account  \n 2. Check Balance\n 3. Deposit the amount \n 4. Withdraw the amount  \n 5. Watch demo account \n 6. Exit  \n\nENTER YOUR CHOICE :: ");
        int key=scan.nextInt();
        operation(key,statement);
    }
    public static void operation(int key,Statement statement)
    {
        Scanner scan = new Scanner(System.in);
        procces bankprocess = new procces();


        switch (key)
        {
            case 1:
                System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                bankprocess.openAccount(statement);
                System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println();
                System.out.println("MAIN PAGE_:: PRESS 1 ::");
                if (scan.nextInt()==1)
                    bankinfo(statement);
                break;
            case 2:
                System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                bankprocess.checkBalance(statement);
                System.out.println();
                System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("MAIN PAGE_:: PRESS 1 ::");
                if (scan.nextInt()==1)
                    bankinfo(statement);
                break;
            case 3:
                System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println();
                System.out.println("---------WELCOME TO DEPOSITE PAGE---------------- ");
                bankprocess.deposit(statement);
                System.out.println();
                System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("MAIN PAGE_:: PRESS 1 ::");
                if (scan.nextInt()==1)
                    bankinfo(statement);
                break;
            case 4:
                System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                bankprocess.withdraw(statement);
                System.out.println();
                System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("MAIN PAGE_:: PRESS 1 ::");
                if (scan.nextInt()==1)
                    bankinfo(statement);
                break;
            case 5:
                System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                bankprocess.demoaccount(statement);
                System.out.println();
                System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("MAIN PAGE_:: PRESS 1 ::");
                if (scan.nextInt()==1)
                    bankinfo(statement);
                break;
            case 6:
                System.out.println("THANKS FOR USING OUT BANK APPLICATION");
                break;
        }
    }

}
