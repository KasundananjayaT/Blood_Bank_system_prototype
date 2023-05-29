/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Blood_Bank;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Kasun Dhananjaya
 */
public class PasswordChange extends DatabaseConnection{
    public  PasswordChange(String Privilage,String Uname,String Pword) throws ClassNotFoundException, SQLException
    {
       super.databaseConnection();
       String statement="UPDATE `securityt` SET `User_Name`=?,`Password`=? WHERE `Privilage` = '"+Privilage+"';";
       PreparedStatement ps= super.getCon().prepareStatement(statement);
       ps.setString(1, Uname);
       ps.setString(2, Pword);
       ps.executeUpdate();
       super.closeDBcon();
    }
        public  PasswordChange(String Privilage,String Pword) throws ClassNotFoundException, SQLException
    {
       super.databaseConnection();
       String statement="UPDATE `securityt` SET `Password`=? WHERE `Privilage` = '"+Privilage+"';";
       PreparedStatement ps= super.getCon().prepareStatement(statement);
       ps.setString(1, Pword);
       ps.executeUpdate();
       super.closeDBcon();
    }
    
}
