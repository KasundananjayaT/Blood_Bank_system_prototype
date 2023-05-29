/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Blood_Bank;

import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Kasun Dhananjaya
 */

public  class LoginToSicurityDB extends DatabaseConnection{
    private String QueryOut;
    public LoginToSicurityDB()
    {
        
    }
 public  void  Retriew(String Name, String Privilage) throws SQLException, ClassNotFoundException
 {    super.databaseConnection();
     Statement statement=super.getCon().createStatement();
        String stmt="SELECT Password FROM securityt where User_Name = '"+Name+"' "+" And Privilage = '"+Privilage+"'";
        ResultSet rst=statement.executeQuery(stmt);
        if(rst.next()){
            setQueryout(rst.getString(1));
        }
        super.closeDBcon();
 }   
  public  void  Retriew(String Privilage) throws SQLException, ClassNotFoundException
 {    super.databaseConnection();
     Statement statement=super.getCon().createStatement();
        String stmt="SELECT Password FROM securityt where Privilage = '"+Privilage+"'";
        ResultSet rst=statement.executeQuery(stmt);
        if(rst.next()){
            setQueryout(rst.getString(1));
        }
        super.closeDBcon();
 } 
    public void setQueryout(String Qu)
    {
        QueryOut=Qu;
    }
    public String getQureyout()
    {
        return(QueryOut);
    }
 

    

}
