package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import beans.Booking;
import javax.servlet.http.HttpSession;

public class BookingController extends HttpServlet 
{
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  
        {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try 
            {
                Booking booking = new Booking();
     
                booking.setVenue(request.getParameter("venue"));
                booking.setActivity(request.getParameter("Activity"));
                booking.setWeek(request.getParameter("week"));
                booking.setDay(request.getParameter("day"));
                booking.setPeriod(request.getParameter("Period"));
                booking.setStaffName(request.getParameter("staffName"));                
                booking.setDate(request.getParameter("date"));
                
                booking.inputBooking();

                out.println("<br>");
                out.println("<br>");
                out.println("<center>Great!!!</center>");
                RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
                rd.forward(request,response);
            } finally {out.close();}
        }
           
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
        {
            processRequest(request, response);
        }
        
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
        {
            processRequest(request, response);
        }
        
        @Override
        public String getServletInfo() 
        {
            return "Short description";
        }
}

