/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author flemi
 */
public class Main {
    ResultSet resultSet = null;
    EmpDAO empdao = new EmpDAO();
    public List<JSONObject>getJsonObject() throws SQLException{
        resultSet = empdao.getResultSet();
        List<JSONObject> resList = JsonServices.getFormattedResult(resultSet);
        return resList;
    }
    public static void main(String[] args) throws SQLException, IOException {
        Main m = new Main();
        PrintWriter writer = new PrintWriter("C:\\Users\\24740\\Documents\\GitHub\\See-Everything\\See-Everything\\web\\JSON.js");
        List<JSONObject> jObj = m.getJsonObject();
        writer.println("var locations = [");
        for(int i=0;i<jObj.size();i++){
            writer.println(jObj.get(i)+",");
            System.out.println(jObj.get(i)+",");
        }
        writer.println("];");
        writer.close();
    }
}
