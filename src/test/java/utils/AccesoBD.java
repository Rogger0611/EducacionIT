package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoBD {
	public static Connection abrirConexionBD(String server,String port,String dbName,String user,String password) throws SQLException, ClassNotFoundException{
		//Connection URL Syntax:"jdbc:mysql//ipaddress:portnumber/dbname"
		String dbUrl="jdbc:mysql://"+ server+ ":" + port + "/"+ dbName;
		
		System.out.println(dbUrl);
		
		//Load mysql jdbc driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//Create Connection to DB
		Connection con=DriverManager.getConnection(dbUrl,user,password);


		return con;

	}
}