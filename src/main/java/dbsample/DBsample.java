/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbsample;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author c0663965
 */
public class DBsample {
    
    private static String table_name="aaabbbccc";
    
    private static Connection getConnection() throws SQLException{
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBsample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String host=System.getenv("OPENSHIFT_MYSQL_DB_HOST"); 
        String port=System.getenv("OPENSHIFT_MYSQL_DB_PORT"); 
        String username=System.getenv("OPENSHIFT_MYSQL_DB_USERNAME"); 
        String password=System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD"); 
        String name = "dbsample"; 
        String url="jdbc:mysql://" + host + ":" + port +"/" + name; 
          
        return DriverManager.getConnection(url,username,password); 
    }
    
    public static void createTable()
    {
        
        try
        {
            Connection conn=getConnection();
            
            Statement stmt=conn.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS " + table_name + 
                         " (id INTEGER not NULL, " +
                         " first VARCHAR(255), " + 
                         " sex VARCHAR(255), " + 
                         " age INTEGER, " + 
                         " PRIMARY KEY (id));"; 
            
            stmt.executeUpdate(sql);
            
            conn.close();
        }
        catch(SQLException ex)
        {
            System.out.println("SQL Exception " + ex.getMessage());
        }
    }
           
    public static void insertData(){
         
        try
        {
            Connection conn=getConnection();
            
            Statement stmt=conn.createStatement();
            
            stmt.executeUpdate("INSERT INTO " + table_name  + " VALUES(1, 'McBeal', 'Male',99)," +
                                                              "(2, 'Lee', 'Male',88)," +
                                                              "(3, 'Gagan', 'Male',77)," +
                                                              "(4, 'Elohor', 'Female',66)"+
                                                              "(5, 'Gurir', 'Male',100)");
                                                              "(5, 'Gurirfdasfdsaf', 'Male',100)");
            conn.close();
        }
        catch(SQLException ex)
        {
            System.out.println("SQL Exception" + ex.getMessage());
        }
    }

    public static String getTable(){
        
        String output="";

        try {
            Connection conn=getConnection();
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM "+ table_name);
            
            while(rs.next()){
                output+="<h1>"+rs.getString("id")+" "+rs.getString("first")+" "+rs.getString("sex")+" "+rs.getString("age")+" </h1>";
            }
            
            conn.close();
        }
        catch(SQLException ex)
        {
            output="SQL Exception" + ex.getMessage();
        }
        
        return output;
    }
}
