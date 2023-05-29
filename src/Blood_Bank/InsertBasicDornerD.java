/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Blood_Bank;

import java.sql.*;

/**
 *
 * @author Kasun Dhananjaya
 */
public class InsertBasicDornerD extends DatabaseConnection{
    private int PofRecords=1,LDidintPart;
    private  String GenratedDID,DID="0",LastRDID;
    

    public InsertBasicDornerD() {
    }
    
    public void InsertD(String Fname,String Lname,String NIC,String DOB,int tel,String No, String Adl1,String Adl2,String City,String Gender) throws ClassNotFoundException, SQLException
    {
        
        super.databaseConnection();
        String statement="INSERT INTO `basic_dd` (`DID`, `Fname`, `Lname`, `NIC`, `DOB`, `Tel`, `No`, `AdL1`, `AdL2`, `City`,`Gender`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)" ;
        PreparedStatement ps=super.getCon().prepareStatement(statement);
        ps.setString(1, GenerateDID());
        ps.setString(2, Fname);
        ps.setString(3, Lname);
        ps.setString(4, NIC);
        ps.setString(5, DOB);
        ps.setInt(6, tel);
        ps.setString(7, No);
        ps.setString(8, Adl1);
        ps.setString(9, Adl2);
        ps.setString(10, City);
        ps.setString(11, Gender);
        ps.executeUpdate();
        super.closeDBcon();
    }
    public int getPofRecords() throws SQLException, ClassNotFoundException
    {
        seprateINT();
        
        return(LDidintPart+1);
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
    public String GenerateDID() throws SQLException, ClassNotFoundException{
    {
       
        for(int i=0; i<4-CalculateLen(getPofRecords());i++)
        DID=DID+"0";
    }
        GenratedDID="D"+DID+getPofRecords();
        return(GenratedDID);
}
    public void getMaxIndex() throws ClassNotFoundException, SQLException
    {
        super.databaseConnection();
        Statement statement=super.getCon().createStatement();
        String stmt="SELECT MAX(DID) FROM basic_dd";
        ResultSet rst=statement.executeQuery(stmt);
        if(rst.next()){
            LastRDID=rst.getString(1);
        }
        super.closeDBcon();
 }   
    public void seprateINT() throws ClassNotFoundException, SQLException
    {
        getMaxIndex();
        
        StringBuffer num= new StringBuffer();
        for(int i=0;i<LastRDID.length();i++)
        {
            if(Character.isDigit(LastRDID.charAt(i)))
            {
                num.append(LastRDID.charAt(i));
            }
        }
            LDidintPart=Integer.parseInt(num.toString());
    }
}
