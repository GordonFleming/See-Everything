/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import database.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author flemi
 */
public class ConQuery {
    DbConnection dbconn = new DbConnection();
    private static final String SQL = "SELECT strftime('%H:%M', time('now','+2 hours'))as 'Time', Surname as StaffName, venue\n" +
                                        "FROM tblTimeTablesLocation\n" +
                                        "LEFT JOIN tblStaff on tblStaff.StaffID=tblTimeTablesLocation.StaffID,\n" +
                                        "(SELECT PeriodName FROM tblTimings\n" +
                                        "WHERE time('now','+2 hours') BETWEEN StartTime and EndTime\n" +
                                        "AND week = 'Blue' \n" +
                                        "AND WeekdayCode = strftime('%w',date('now')))subquery1\n" +
                                        "WHERE period = PeriodName\n" +
                                        "AND week = 'Maroon' \n" +
                                        "AND WeekdayCode = strftime('%w',date('now'))";
    Connection con = null;
    PreparedStatement pst=null;
    ResultSet resultSet=null;
    public ResultSet getResultSet(){
        try{
          con = dbconn.Connection();
            pst = con.prepareStatement(SQL);
            resultSet = pst.executeQuery();
        }catch(Exception ex){
            System.out.println("Whoops");
            ex.printStackTrace();
        }
        return resultSet;
    }
}
