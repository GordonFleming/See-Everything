/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.ConQuery;
import beans.JsonServices;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author flemi
 */
public class Main extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws FileNotFoundException, ServletException, IOException{ //Writes the formatted fields into JSON file
        Main m = new Main();
        try (PrintWriter writer = new PrintWriter("C:\\Users\\flemi\\Documents\\GitHub\\See-Everything\\See-Everything\\web\\JSON.js") //Path to JSON file
        ) {
            List<JSONObject> jObj = m.getJsonObject();
            writer.println("var locations = ["); //writes this string to the file to get the JSON file in the correct format
            for(int i=0;i<jObj.size();i++){
                writer.println(jObj.get(i)+",");
                System.out.println(jObj.get(i)+",");
            }
            writer.println("];"); //Closes off the JSON file by inserting this String
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
        rd.include(req, res);           
    }     
        public List<JSONObject>getJsonObject() throws SQLException{ //Outputs and 'returns' the JSON data
            ConQuery conn = new ConQuery(); //Establishes connection
            ResultSet resultSet = conn.getResultSet();
            List<JSONObject> resList = JsonServices.getFormattedResult(resultSet);
            return resList;
    }               
}
