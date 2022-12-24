package bank.system;

import java.sql.*;

// using JDBC connectivity to save the data in database..

// there are 5 steps in JDBC : 
// 1) Register the Driver
// 2) Create Connection 
// 3) Create Statement 
// 4) Execute Query
// 5) Close Connextion

public class Conn { // not making Main class bcz we will not directly run this class ..(we will make objects when we want to run this class)
    Connection c;
    Statement s;
    Conn(){
        // we will use exceptional handling bcz MySQL is a external entity , chances of errors are high in runtime : 
        try{
            // 1st step of JDBC : (import a library in which this driver exist)
//            Class.forName(com.mysql.cj.jdbc.Driver);
            // 2nd step : 
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem","root","root"); 
            // 3rd step : 
            s = c.createStatement();
        }catch(Exception exp){
            System.out.println(exp);
        }
    }
}
