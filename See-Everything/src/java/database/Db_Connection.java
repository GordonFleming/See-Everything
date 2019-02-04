package database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Db_Connection 
{
    public Connection Connection()
    {
        try 
        {
            
            Class.forName("org.sqlite.JDBC");
            String techworld3g = "jdbc:sqlite:C:\\Users\\24740\\Documents\\GitHub\\Netbeans_Repository\\Users.db";
            Connection myConnection = DriverManager.getConnection(techworld3g);
          
            return myConnection;
            
        } catch (ClassNotFoundException | SQLException ex) {Logger.getLogger(Db_Connection.class.getName()).log(Level.SEVERE, null, ex);}
        return null;
    }
}

