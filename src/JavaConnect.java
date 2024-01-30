
import javax.swing.JOptionPane;
import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pc
 */
public class JavaConnect {
        Connection conn;
 public static Connection ConnerDb(){
     try{
         Class.forName("org.sqlite.JDBC");
         Connection conn=DriverManager.getConnection(("jdbc:sqlite:C:\\Users\\pc\\Desktop\\javac\\Library_System\\src\\Data.sqlite"));
         return conn;
     }catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
         return null;
     }
 }
    
}


