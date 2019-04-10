package connection;
import java.sql.*;
import java.io.*;
import java.util.*;
public class TakeConn {
	
  static Connection con;
  public static Connection getCon()  {
  try{
    FileInputStream fis = new FileInputStream("dbinfo.properties");
    Properties p = new Properties();
    p.load(fis);
    String dname = p.getProperty("dname");
    String url = p.getProperty("url");
    String user = p.getProperty("user");
    String pass = p.getProperty("pass");
    Class.forName(dname);
    con = DriverManager.getConnection(url,user,pass);
  }
  catch(SQLException sql){
    sql.printStackTrace();
  }
  catch(IOException ioe){
  ioe.printStackTrace();
  }
  catch(ClassNotFoundException cnfe){
  cnfe.printStackTrace();
  }
   return con ;
 }
 public static void main(String... ar){
	 TakeConn t = new TakeConn();
	 t.getCon();
	}
}
