/*
 * Author: Gordon Fleming
 */
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
            String urlHome = "jdbc:sqlite:C://Users/flemi/Documents/GitHub/See-Everything/See-Everything/SJC_DB.db";
            String urlSchool = "jdbc:sqlite:C://Users/24740/Documents/GitHub/See-Everything/See-Everything/SJC_DB.db";
            String urlLaptop = "jdbc:sqlite:/Users/gordonfleming/NetBeansProjects/See-Everything/See-Everything/SJC_DB.db";
            Connection myConnection = DriverManager.getConnection(urlHome);
          
            return myConnection;
            
        } catch (ClassNotFoundException | SQLException ex) {Logger.getLogger(Db_Connection.class.getName()).log(Level.SEVERE, null, ex);}
        return null;
    }
}

