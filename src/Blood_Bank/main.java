/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Blood_Bank;





import Forms.DB.AAAWelcomePage;
import Forms.DB.AdminO;
import Forms.DB.AdvancedDD;
import Forms.DB.FPage;
import com.sun.tools.javac.jvm.Gen;
import com.sun.tools.jdeprscan.scan.Scan;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import sun.nio.cs.Surrogate;


/**
 *
 * @author Kasun Dhananjaya
 */

public class main {
    
        

    private static String SQL_INSERT;
        
    
public static boolean isAgeGreaterThan(String birthdateString, int minAge) {
        // Parse the birthdate string into a LocalDate object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthdate = LocalDate.parse(birthdateString, formatter);

        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthdate, currentDate);
        return age.getMonths() > minAge||age.getDays()== 0;}
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        System.out.print(isAgeGreaterThan("2023-05-16", 3));
        
                

}
        
             
}
