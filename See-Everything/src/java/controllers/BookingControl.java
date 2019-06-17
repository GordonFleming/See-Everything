/*
 * Author: Gordon Fleming
 */
package controllers;

import database.DbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookingControl extends HttpServlet {

 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //Receives values and processes the request from the server
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  String venue = request.getParameter("venue");
  String activity = request.getParameter("activity");
  String week = request.getParameter("week");
  String day = request.getParameter("day");
  String period = request.getParameter("period");
  String staffName = request.getParameter("staffName");
  String date = request.getParameter("date");

  // validates the user's given input and gives relevant error message if invalid
  if (venue.isEmpty() || venue.equals("-1") || activity.isEmpty() || activity.equals("-1") || week.isEmpty() || day.isEmpty() || period.isEmpty() || staffName.isEmpty() || date.isEmpty()) { //Checks for certain invalid values
   RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
   //Outputs error message if invalid data was inputted
   out.print("<style>.alert {padding-right:10px;padding-left:10px;padding-top:5px;padding-bottom:5px;width:600px;background-color: #f44336;/* Red */color: white;margin-bottom: 15px;bottom: 0;position: absolute;left:50%;transform: translate(-50%); }"
            + ".closebtn { margin-left: 15px;color: white;font-weight: bold;float: right;font-size: 22px;line-height: 20px;cursor: pointer;transition: 0.3s;}"
            + ".closebtn:hover { color: black;}</style>"
            + "<script>function redirect() {window.location = \"http://localhost:8080/See-Everything/main.jsp\";}</script>"
            + "<div class=\"alert\"><span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';redirect();\">&times;</span><strong>Error!</strong> The booking was unsuccessful, make sure there are no blanks or invalid inputs.</div>");
   rd.include(request, response);
  } else {
   try {
    DbConnection dbconn=new DbConnection();                                     //Establishes the database connection
       try (Connection myconnection = dbconn.Connection()) {
           String query = "INSERT INTO tblBooking VALUES (?,?,?,?,?,?,?)";      //Inserts the users booking with relevant SQL statement
           try (PreparedStatement ps = myconnection.prepareStatement(query)){   //Generates the sql query
               ps.setString(1, venue);
               ps.setString(2, activity);
               ps.setString(3, week);
               ps.setString(4, day);
               ps.setString(5, period);
               ps.setString(6, staffName);
               ps.setString(7, date);
               
               ps.executeUpdate();                                              // executes the statement in the database                 
               ps.close();
               myconnection.close();
           }
           RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
           //Outputs success message if valid data was inputted
           out.print("<style>.success {padding-right:5px;padding-left:10px;padding-top:5px;padding-bottom:10px;width:600px;background-color: green; color: white;margin-bottom: 15px;bottom: 0;position: absolute;left:50%;transform: translate(-50%); }"
            + ".closebtn { margin-left: 15px;color: white;font-weight: bold;float: right;font-size: 22px;line-height: 20px;cursor: pointer;transition: 0.3s;}"
            + ".closebtn:hover { color: black;}</style>"
            + "<div class=\"success\"><span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span><strong>Success!</strong> Your booking was submitted to the server.</div>");
           rd.include(request, response);
       }
   } catch (SQLException ex){                                                     
   
            }
        }
    }
}