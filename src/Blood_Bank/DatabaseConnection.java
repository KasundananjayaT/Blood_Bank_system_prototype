/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Blood_Bank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Kasun Dhananjaya
 */
public abstract class DatabaseConnection {
    private Connection con;

    public DatabaseConnection()
    {
    }
    public void databaseConnection() throws ClassNotFoundException, SQLException
    {
        setCon(DriverManager.getConnection("jdbc:mysql://localhost:3306/bls1", "root", ""));
    }
    public void closeDBcon() throws SQLException
    {
        getCon().close();
    }

    /*public void setStatement(String TableName,String RColumnName,String FilteringColum ,String Privilage,String Uname) throws SQLException
    {
        Statement statement=con.createStatement();
        String stmt=("SELECT " + RColumnName +" FROM " +TableName+" WHERE User_Name = "+Uname ); 
        ResultSet rst=statement.executeQuery(stmt);
        if(rst.next()){
        QueryOut=rst.getString(1);
        }
    }*/

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }


    
}
