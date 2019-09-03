/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Gordon Fleming
 */
public class Dbproperty { //Stores the URL required for connection to the database (Different ones are used for the different computers I coded on)
    static String urlHome = "jdbc:sqlite:C://Users/flemi/Documents/GitHub/See-Everything/See-Everything/SJC_DB.db";
    static String urlSchool = "jdbc:sqlite:C://Users/24740/Documents/GitHub/See-Everything/See-Everything/SJC_DB.db";
    static String urlLaptop = "jdbc:sqlite:/Users/gordonfleming/NetBeansProjects/See-Everything/See-Everything/SJC_DB.db";
    public static final String DB_Class = "org.sqlite.JDBC";
    public static final String DB_URL = urlLaptop;   
}
