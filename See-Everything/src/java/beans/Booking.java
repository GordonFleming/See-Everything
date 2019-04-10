package beans;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import database.Db_Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Booking 
{
    private String venue, day, week, staffName, Activity;
    int Period;
    
    // Constructor //

    public Booking(String venue, String day, String week, String staffName, String Activity, int Period) {
        this.venue = venue;
        this.day = day;
        this.week = week;
        this.staffName = staffName;
        this.Activity = Activity;
        this.Period = Period;
    }      
 
    // accessor methods //

    public String getVenue() {
        return venue;
    }

    public String getDay() {
        return day;
    }

    public String getWeek() {
        return week;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getActivity() {
        return Activity;
    }

    public int getPeriod() {
        return Period;
    }
    
    // mutator methods //

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setActivity(String Activity) {
        this.Activity = Activity;
    }

    public void setPeriod(int Period) {
        this.Period = Period;
    }
    
    // Inserts the booking by connecting to the database //
      
    public void registerUser()
    {
        try
        {    
            Db_Connection dbconn=new Db_Connection();
            Connection myconnection= dbconn.Connection();

            String sqlString="INSERT INTO tblVenues (TimeID, VenueID, StaffID, ActivityID, DateTimeID, VenueID, StaffID, ActivityID, Date) VALUES ('"+venue+"','"+day+"','"+week+"','"+staffName+"','"+Activity+"')";
            
            Statement myStatement = myconnection.createStatement();
            
            try
            {    
                myStatement.executeUpdate(sqlString);
                myStatement.close();
                myconnection.close();
            } catch (SQLException ex) {Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);}
        } catch (SQLException ex) {Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);}  
    }
    
    // Validates if booking is valid
    
    public static boolean loginUser(String venue, String day, String  week, String staffName, String  Activity, int Period) 
    {
            boolean check =false;
            try 
            {      
                Db_Connection dbconn = new Db_Connection();
                Connection myconnection = dbconn.Connection();
                
                PreparedStatement ps1 = myconnection.prepareStatement("select * from users where username=? and password=?");

                ps1.setString(1, venue);
                ps1.setString(2, day);
                ps1.setString(3, week);
                ps1.setString(4, staffName);
                ps1.setString(5, Activity);
                ps1.setInt(6, Period);
                ResultSet rs1 =ps1.executeQuery();
                check = rs1.next();

                myconnection.close();        
            }catch(Exception e){e.printStackTrace();}
            
            return check;    
    }
    
    // Fetches user data //
   /* 
    public void getUser()
    {
            try 
            {      
                Db_Connection dbconn=new Db_Connection();
                Connection myconnection= dbconn.Connection();
                
                String sqlString = "SELECT * FROM users WHERE username = '"+user+"'";
                Statement myStatement = myconnection.createStatement();
                ResultSet rs=myStatement.executeQuery(sqlString);

                while(rs.next())
                {
                    first_name= rs.getString("first_name");
                    last_name = rs.getString("last_name");
                    user= rs.getString("username");
                    pwd = rs.getString("password");
                }
                
                myStatement.close();
                myconnection.close();
                
            } catch (SQLException ex){
                Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);} 
            
    }
    */
}
