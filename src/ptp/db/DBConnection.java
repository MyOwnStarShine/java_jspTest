package ptp.db;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	private static Connection conn = null;
	
	public static void main(String[] args) {
		/*DBConnection db = new DBConnection();
		System.out.print(db.open());*/
	}
	
	public static Connection open() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsptest", "root", "admin888");
			return conn;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}			
		return conn;
	}
	
	public static void close(ResultSet rs, Connection conn, PreparedStatement pstmt) {
		try {
			
			if (rs!=null) {
				rs.close();
				rs=null;
			}
			if (pstmt!=null) {
				pstmt.close();
				pstmt=null;
			}
			if (conn!=null) {
				conn.close();
				conn=null;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
