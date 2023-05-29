/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Blood_Bank;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.List;
import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Kasun Dhananjaya
 */
public class BpRequest extends DatabaseConnection{

private Object [][]results = new String[30][];
private Object [][]resultsAccepted = new String[30][];
private int i=0,j=0;
    public void getRequstDetails() throws ClassNotFoundException, SQLException{
    super.databaseConnection();
        Statement statement=super.getCon().createStatement();
        String stmt="SELECT `RID` , `RBtype`, `count`, `RCategory` from requestblood where Accepted ='0' Order by case when RCategory LIKE '%Emer%' then 1 when RCategory LIKE '%Ur%' then 2 when RCategory LIKE '%rou%' then 3 END,RID";
        ResultSet rst=statement.executeQuery(stmt);
        java.sql.ResultSetMetaData rsmd=rst.getMetaData();
        while(rst.next()){
           results[i]=new String[] {rst.getString("RID"),rst.getString("RBtype"),rst.getString("count"),rst.getString("RCategory")};
           i++;
        }
        super.closeDBcon();
    }
    public String getValues(int p1,int p2) throws ClassNotFoundException, SQLException
    {
       return(String) (results[p1][p2]);
    } 
    public int getLength()
    {        
        return(i);
    }
    public void AcceptRequest(String RID) throws ClassNotFoundException, SQLException
    {
       super.databaseConnection();
       String statement="UPDATE requestblood set Accepted = ? where RID = '"+RID+"';";
       PreparedStatement ps= super.getCon().prepareStatement(statement);
       ps.setInt(1,1);
       ps.executeUpdate();
       super.closeDBcon();
        
    }
    public void getRequstAcceptedDetails() throws ClassNotFoundException, SQLException{
    super.databaseConnection();
        Statement statement=super.getCon().createStatement();
        String stmt="SELECT `RID` , `RBtype`, `count`, `RCategory` from requestblood where Accepted ='1' Order by case when RCategory LIKE '%Emer%' then 1 when RCategory LIKE '%Ur%' then 2 when RCategory LIKE '%rou%' then 3 END,RID";
        ResultSet rst=statement.executeQuery(stmt);
        while(rst.next()){
           resultsAccepted[j]=new String[] {rst.getString("RID"),rst.getString("RBtype"),rst.getString("count"),rst.getString("RCategory")};
           j++;
        }
        super.closeDBcon();
    }
        public int getAcceptedLength()
    {        
        return(j);
    }
    public String getAcceptedValues(int p1,int p2) throws ClassNotFoundException, SQLException
    {
       return(String) (resultsAccepted[p1][p2]);
    } 

}
