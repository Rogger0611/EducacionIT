package EducationIT.EduIT_76635;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;
import utils.AccesoBD;

public class AccesoBDTest 
{
	  @Test
	    public void conexion() throws ClassNotFoundException, SQLException 
	  {
		 try 
		  {
		 Connection con=AccesoBD.abrirConexionBD("localhost", "3306","db","root","1023911733");
		 System.out.println(con);  
	     if (con != null) {
	     System.out.println("Conexión exitosa a la base de datos");
	     //con.close();
	     
	     String query1 = "select * from empleados;";  
		 Statement stmt = con.createStatement();
	     ResultSet rs = stmt.executeQuery(query1);
	     System.out.println("CONSULTA TABLA EMPLEADOS");
	     while (rs.next()) 
	     	{
	            String myId = rs.getString(1);
	            String myName = rs.getString(2);
	            String myAge = rs.getString(3);
	            System.out.println(myId + " " + myName + " " + myAge);
	            
	        }
	     
	     System.out.println("");
	     String query2 = "select * from usuarios where id=1;";  
		 Statement stmt2 = con.createStatement();
	     ResultSet rs2 = stmt2.executeQuery(query2);
	     System.out.println("CONSULTA TABLA USUARIOS");
	     while (rs2.next()) 
	     	{
	            String id = rs2.getString(1);
	            String usuario = rs2.getString(2);
	            String pass = rs2.getString(3);
	            
	            System.out.println(id + " " + usuario + " " + pass);
	        }
	     
	     con.close();
	      } 
	        } catch (SQLException e) {
	            System.err.println("Error al intentar conectar a la base de datos: " + e.getMessage());
	           e.printStackTrace();
	        }
		  
	  }
	  }

