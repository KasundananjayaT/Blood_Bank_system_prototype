/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Blood_Bank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Kasun Dhananjaya
 */
public class InsertAndRetriewAdvacedDD extends DatabaseConnection{
    private int PofRecords=1,LDidintPart;
    private  String GenratedDID,DID="0",LastRDID,RDID,DoFname,DoLname,DoNIC,year,month,day;
    public InsertAndRetriewAdvacedDD() {
    }
    
    public void InsertD(String DID,String Btype,double Height,double Weight,String LastDDate, int Suspisious) throws ClassNotFoundException, SQLException
    {
        
        super.databaseConnection();
       String statement="INSERT INTO `t_dorner` (`DID`, `Blood_Type`, `Height`, `Weight`, `LastDDate`, `Suspisious`, `BID`, `Availability`) VALUES (?, ?, ?, ?, ?, ?,?, ?)";
       PreparedStatement ps= super.getCon().prepareStatement(statement);
       ps.setString(1, DID);
       ps.setString(2, Btype);
       ps.setDouble(3, Height);
       ps.setDouble(4, Weight);
       ps.setString(5, LastDDate);
       ps.setInt(6, Suspisious);
       ps.setString(7, GenerateBID());
       ps.setInt(8, 1);
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
    public String GenerateBID() throws SQLException, ClassNotFoundException{
    {
       
        for(int i=0; i<6-CalculateLen(getPofRecords());i++)
        DID=DID+"0";
    }
        GenratedDID="BP"+DID+getPofRecords();
        return(GenratedDID);
}
    public void getMaxIndex() throws ClassNotFoundException, SQLException
    {
        super.databaseConnection();
        Statement statement=super.getCon().createStatement();
        String stmt="SELECT MAX(BID) FROM t_dorner";
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
    public void RetriewDID(String DID) throws ClassNotFoundException, SQLException
    {super.databaseConnection();
        Statement statement=super.getCon().createStatement();
        String stmt="SELECT DID FROM basic_dd where DID = '"+DID+"'";
        ResultSet rst=statement.executeQuery(stmt);
        if(rst.next()){
         RDID =  rst.getString(1);
        }
        super.closeDBcon(); 
    }
    public String getRdid()
    {
        return(RDID);
    }
    public void RetriewDD(String DID) throws ClassNotFoundException, SQLException
    {
        super.databaseConnection();
        Statement statement=super.getCon().createStatement();
        String stmt="SELECT Fname, Lname, NIC FROM basic_dd where DID = '"+DID+"'";
        ResultSet rst=statement.executeQuery(stmt);
        if(rst.next()){
         DoFname =  rst.getString(1);
         DoLname =  rst.getString(2);
         DoNIC = rst.getString(3);
        }
        super.closeDBcon(); 
        
    }
    public String getDornerDetails()
    {
        String DornerDetails="First Name: "+DoFname+"\n"+"Last Name: "+DoLname+"\n"+"NIC: "+DoNIC;
        return(DornerDetails);
    }
    public int CalculateAgeInMonths(){
        if(year!=null){
        LocalDate dob = LocalDate.of(Integer.parseInt(this.year),Integer.parseInt(this.month), Integer.parseInt(this.day));  
        LocalDate curDate = LocalDate.now();  
        Period period = Period.between(dob, curDate);  
        return(period.getMonths()+period.getYears()*12);}
        else
        {
        return(-1);
        }
        }

        public int CalculateAgeInMonths(int y,int m, int d){
        LocalDate dob = LocalDate.of(y,m, d);  
        LocalDate curDate = LocalDate.now();  
        Period period = Period.between(dob, curDate);  
        return(period.getMonths()+period.getYears()*12);}

    public void setLastDD(String DID) throws ClassNotFoundException, SQLException
    {
        super.databaseConnection();
        Statement statement=super.getCon().createStatement();
        String stmt="SELECT YEAR(max(LastDDate)) AS year,MONTH(max(LastDDate)) AS month,day (max(LastDDate)) As Day FROM t_dorner where DID ='"+DID+"';";
        ResultSet rst=statement.executeQuery(stmt);
        if(rst.next()){
        year=rst.getString("year");
        month= rst.getString("month");
        day=rst.getString("Day");
        }
        super.closeDBcon();
    }
    public String getBtype(String DID) throws ClassNotFoundException, SQLException
    {
        super.databaseConnection();
        Statement statement=super.getCon().createStatement();
        String stmt="select Blood_Type from t_dorner where DID ='"+DID+"'";
        ResultSet rst=statement.executeQuery(stmt);
        if(rst.next())
        {
            return(rst.getString(1));
        }
        else{return("");}
    }
}   


    

