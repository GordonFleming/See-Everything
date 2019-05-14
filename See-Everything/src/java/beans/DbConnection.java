/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import static beans.Dbproperty.DB_Class;
import static beans.Dbproperty.DB_URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author flemi
 */
public class DbConnection {
    Connection con;
    public DbConnection(){
        try{
            Class.forName(DB_Class);
            System.out.println("Loaded fine");
        }catch(Exception e){
            System.out.println("Unsuccessful");
        }
    }
    public Connection setConnection(){
        try{
            con=DriverManager.getConnection(DB_URL);
            System.out.println("Success");
            return con;
        }catch(Exception ex){
            System.out.println("Whoops");
            ex.printStackTrace();
            return null;
        }
    }
}
