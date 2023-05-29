/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Blood_Bank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Kasun Dhananjaya
 */
public class BloodStocks extends DatabaseConnection{
    private Object [][]BpCount=new String[8][];
    private int j=0;
    private String BID,DID;
   public void getBloodPacketCount() throws ClassNotFoundException, SQLException
   {
       super.databaseConnection();
        Statement statement=super.getCon().createStatement();
        String stmt="SELECT * FROM `blood_stock`";
        ResultSet rst=statement.executeQuery(stmt);
        while(rst.next()){
           BpCount[j]=new String[] {rst.getString("BloodType"),rst.getString("Count"),rst.getString("Minimum")};
           j++;
        }
        super.closeDBcon();
   }
       public String Data(int p1,int p2) throws ClassNotFoundException, SQLException
    {
       return(String) (BpCount[p1][p2]);
    }
    public int getLength()
    {
        return(j);
    }
    public void IssuesBp(String RID, String Rtype, String BID,String DID) throws ClassNotFoundException, SQLException
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        DateFormat time = new SimpleDateFormat("HH:mm:ss.SSS");
        Calendar cal = Calendar.getInstance();  
        String date = dateFormat.format(cal.getTime());
        String Time =time.format(cal.getTime());
        super.databaseConnection();
       String statement="INSERT INTO `assignedbp`(`RID`, `Rtype`, `BID`, `DID`, `Date`, `Time`) VALUES (?,?,?,?,?,?)";
       PreparedStatement ps= super.getCon().prepareStatement(statement);
       ps.setString(1, RID);
       ps.setString(2, Rtype);
       ps.setString(3, BID);
       ps.setString(4, DID);
       ps.setString(5, date);
       ps.setString(6,Time);
       ps.executeUpdate();
       super.closeDBcon();
    }
    public void setBID(String Btype) throws ClassNotFoundException, SQLException
    {
        super.databaseConnection();
        Statement statement=super.getCon().createStatement();
        String stmt="select min(BID) from t_dorner where Blood_Type='"+Btype+"' and Availability = '1';";
        ResultSet rst=statement.executeQuery(stmt);
        if(rst.next())
        {
            this.BID = rst.getString(1);  
        }
        super.closeDBcon();
}
    public String getBID()
    {
        return(BID);
    }
    public String getDID()
    {
        return(DID);
    }
    public void setDID(String BID) throws SQLException, ClassNotFoundException
    {
        super.databaseConnection();
        Statement statement=super.getCon().createStatement();
        String stmt="select DID from t_dorner where BID = '"+BID+"';";
        ResultSet rst=statement.executeQuery(stmt);
        if(rst.next())
        {
           this.DID= rst.getString("DID");
        }
        super.closeDBcon();
    }
        public void AcceptingRequest(String BID) throws SQLException, ClassNotFoundException
    {
       super.databaseConnection();
       String statement="Update t_dorner set Availability=? where BID ='"+BID+"' ";
       PreparedStatement ps= super.getCon().prepareStatement(statement);
       ps.setInt(1, 0);
       ps.executeUpdate();
       super.closeDBcon();
    }
    
}
