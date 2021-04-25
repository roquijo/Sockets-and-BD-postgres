package server.bdConection;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DataSource {

	private static DataSource dataSource = null;
	private Connection con;

	private DataSource() {

		Properties conProperties = new Properties();

		try {
			conProperties.load(new FileInputStream("src/server/persistence/data/connection.properties"));

			String url = conProperties.getProperty("url");
			String user = conProperties.getProperty("user");
			String password = conProperties.getProperty("password");

			con = DriverManager.getConnection(url.trim(), user.trim(), password.trim());


			System.out.println("Successful connection");	

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DataSource getInstance(){
		if (dataSource == null){
			dataSource = new DataSource();
		}
		return dataSource;
	}
	public ResultSet runExecuteQuery(String sql){
		ResultSet resultSet = null;
		try {
			Statement statement = con.createStatement();
			resultSet = statement.executeQuery(sql);
			System.out.println("Successful query: "+sql);
			System.out.println("Sending object...");
		} catch (SQLException e) {
			System.out.println("Query error: "+e.getMessage());
		}
		return resultSet;
	}

	public boolean runExecuteUpdate(String sql){

		try {
			Statement statement = con.createStatement();
			if(statement.executeUpdate(sql) == 1) {
				System.out.println("Successful query: " + sql);
				System.out.println("Query done... ");
			}
			return true;
		} catch (SQLException e) {
			System.out.println("Query error: "+e.getMessage());
		}
		return false;
	}
}
