/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Blood_Bank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;;

/**
 *
 * @author Kasun Dhananjaya
 */
public class HgetBpacket extends DatabaseConnection{
    private int i=0,LRidintPart;
    private String RID="0",GenratedRID,LastRRID,Bcount;
    private String[] bloodType = new String[8];
    
    public void getPreferableType(String BType) throws ClassNotFoundException, SQLException
    {
        super.databaseConnection();
        Statement statement=super.getCon().createStatement();
        String stmt="SELECT Type FROM `bloodtype` WHERE `"+BType+"`=1;";
        ResultSet rst=statement.executeQuery(stmt);
        while(rst.next()){
        if(rst.getString(1)!= null){
        bloodType[i]=rst.getString(1);
        i++;}
        }
        super.closeDBcon();
    }
    public  String getBloodType(int j) throws ClassNotFoundException, SQLException
    {
        if(bloodType[j] != null)
        {
            return(bloodType[j]);
        }
        return null;
    }
    public void InsertData(String RCatogory,String Btype,int count, String Wnumber,int BedNumber,int age, double Weight) throws SQLException, ClassNotFoundException
    {
        super.databaseConnection();
       String statement="INSERT INTO `requestblood` (`RID`, `RCategory`, `RBtype`, `count`, `Wnumber`, `Bed_Number`, `Age`, `Weight`) VALUES (?,?,?,?,?,?,?,?);";
       PreparedStatement ps= super.getCon().prepareStatement(statement);
       ps.setString(1, GenerateRID());
       ps.setString(2, RCatogory);
       ps.setString(3, Btype);
       ps.setInt(4, count);
       ps.setString(5, Wnumber);
       ps.setInt(6, BedNumber);
       ps.setInt(7, age);
       ps.setDouble(8, Weight);
       ps.executeUpdate();
       super.closeDBcon();
    }
        public int getPofRecords() throws SQLException, ClassNotFoundException
    {
        seprateINT();
        return(LRidintPart+1);
    }
    public int CalculateLen(int n)
       {
           int count =0;
           while(n!=0)
           {
               n /= 10;
               count++;
           }
           return(count);
       }
    public String GenerateRID() throws SQLException, ClassNotFoundException{
    {
       
        for(int i=0; i<4-CalculateLen(getPofRecords());i++)
        RID=RID+"0";
    }
        GenratedRID="R"+RID+getPofRecords();
        return(GenratedRID);
}
    public void getMaxIndex() throws ClassNotFoundException, SQLException
    {
        super.databaseConnection();
        Statement statement=super.getCon().createStatement();
        String stmt="SELECT MAX(RID) FROM requestblood";
        ResultSet rst=statement.executeQuery(stmt);
        if(rst.next()){
            LastRRID=rst.getString(1);
        }
        super.closeDBcon();
 }   
    public void seprateINT() throws ClassNotFoundException, SQLException
    {
        getMaxIndex();
        
        StringBuffer num= new StringBuffer();
        for(int i=0;i<LastRRID.length();i++)
        {
            if(Character.isDigit(LastRRID.charAt(i)))
            {
                num.append(LastRRID.charAt(i));
            }
        }
            LRidintPart=Integer.parseInt(num.toString());
    }
    public int getCount(String BloodType) throws SQLException, ClassNotFoundException
    {
        super.databaseConnection();
        Statement statement=super.getCon().createStatement();
        String stmt="select count(BID) from t_dorner where Blood_Type='"+BloodType+"' and Availability='1';";
        ResultSet rst=statement.executeQuery(stmt);
        if(rst.next()){
            Bcount=rst.getString(1);
        }
        super.closeDBcon();
        return(Integer.parseInt(Bcount));
    }
    public void FillBloodStock(String Btype) throws ClassNotFoundException, SQLException
    {
       super.databaseConnection();
       String statement="Update blood_stock set Count =? WHERE BloodType ='"+Btype+"'";
       PreparedStatement ps= super.getCon().prepareStatement(statement);
       ps.setInt(1,getCount(Btype));
       ps.executeUpdate();
       super.closeDBcon();
    }
    public void UpdateStockTable() throws ClassNotFoundException, SQLException
    {
        super.databaseConnection();
        Statement statement=super.getCon().createStatement();
        String stmt="SELECT BloodType from blood_stock;";
        ResultSet rst=statement.executeQuery(stmt);
        while(rst.next())
        {
            FillBloodStock(rst.getString(1));
        }
        super.closeDBcon();
    }
    
}
