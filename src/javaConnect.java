    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pc
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class javaConnect {
    Connection conn;
 public static Connection ConnerDb(){
     try{
         Class.forName("org.sqlite.JDBC");
         Connection conn=DriverManager.getConnection(("jdbc:sqlite:C:\\Users\\pc\\Desktop\\javac\\Library_Management_System\\src\\information.sqlite"));
         return conn;
     }catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
         return null;
     }
 }
    
}
