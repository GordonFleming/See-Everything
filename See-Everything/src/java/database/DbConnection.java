/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import static database.Dbproperty.DB_Class;
import static database.Dbproperty.DB_URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author flemi
 */
public class DbConnection {
    Connection myConnection;
    public DbConnection(){                                                      //Establishes connection with the database
        try{
            Class.forName(DB_Class);
            System.out.println("Loaded fine");
        }catch(ClassNotFoundException e){
            System.out.println("Unsuccessful");
        }
    }
    public Connection Connection(){                                             //Verifies if the connection is successful
        try{
            myConnection =DriverManager.getConnection(DB_URL);
            System.out.println("Success");
            return myConnection;
        }catch(SQLException ex){
            System.out.println("Whoops");
            ex.printStackTrace();
            return null;
        }
    }
}
