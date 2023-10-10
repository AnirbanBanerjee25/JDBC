package com.firstproject.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class JdbcApplication {

	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		try{
			String url="jdbc:mysql://localhost:3306/Sampledb";
			connection = DriverManager.getConnection(url,"root","anirban123");
			//creating a prepared statement
			/*String insertQuery="insert into student1(id,name,age,address)values(?,?,?,?)";
			PreparedStatement in=connection.prepareStatement(insertQuery);
			in.setLong(1,74);
			in.setString(2,"Abir");
			in.setInt(3,35);
			in.setString(4,"Bihar");
			int noofrowsupdated=in.executeUpdate();
			System.out.println(noofrowsupdated);*/
			String selectQuery="select * from student1";
			PreparedStatement ps= connection.prepareStatement(selectQuery);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getLong("id")+" "+rs.getString("name")+" "+rs.getInt("age")+" "+rs.getString("address"));

			}
			ps.close();
			rs.close();

		}catch(SQLException e){
			System.out.println(e);
		}finally {
			connection.close();
		}

	}

}
