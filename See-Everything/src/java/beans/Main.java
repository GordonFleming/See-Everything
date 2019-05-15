/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
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
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws FileNotFoundException, ServletException, IOException{
        Main m = new Main();
        try (PrintWriter writer = new PrintWriter("C:\\Users\\24740\\Documents\\GitHub\\See-Everything\\See-Everything\\web\\JSON.js") //Path to JSON file
        ) {
            List<JSONObject> jObj = m.getJsonObject();
            writer.println("var locations = [");
            for(int i=0;i<jObj.size();i++){
                writer.println(jObj.get(i)+",");
                System.out.println(jObj.get(i)+",");
            }
            writer.println("];");
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
        rd.include(req, res);           
    }     
        public List<JSONObject>getJsonObject() throws SQLException{
            ConQuery empdao = new ConQuery();
            ResultSet resultSet = empdao.getResultSet();
            List<JSONObject> resList = JsonServices.getFormattedResult(resultSet);
            return resList;
    }        
        
}
