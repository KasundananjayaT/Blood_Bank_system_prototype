/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Blood_Bank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Kasun Dhananjaya
 */
public class DornerAndPatientDetailsR extends DatabaseConnection{
    private int i=0;
    private Object [][] RetriewData= new String [20][];
    public void setDPdetails(String wno,String Bno,String date,String DID,String Fname, String Lname) throws SQLException, ClassNotFoundException
    {
        super.databaseConnection();
        Statement statement=super.getCon().createStatement();
        String stmt="select d.DID,d.Fname,d.Lname,d.NIC,d.No,d.Adl1,d.adl2,d.City,r.RBtype AS RB,a.date AS date,r.wnumber As wno,r.Bed_Number As bno,r.rid As rid from requestblood r inner join assignedbp a on a.RID=r.RID INNER join basic_dd d on d.DID=a.DID where ( r.wnumber='"+wno+"' and r.Bed_Number = '"+Bno+"' and a.date Like '%"+date+"%') or d.did='"+DID+"' or d.Fname='"+Fname+"' or d.Lname='"+Lname+"' Group by wno and bno";
        ResultSet rst=statement.executeQuery(stmt);
        rst.getRow();
        
        while(rst.next()){
           RetriewData[i]=new String[] {rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8),rst.getString(9),rst.getString(10),rst.getString(11),rst.getString(12)};
                   i++;
        }
        super.closeDBcon();
    
    
}
    public int getLength()
    {
        return(i);
    }
public String getDornerAndPatientDetails(int i, int j)
{
    return(RetriewData[i][j].toString());
}
}