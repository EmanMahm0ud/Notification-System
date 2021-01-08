package model.NotificationProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SMSConnection {
	Connection conn = null;
	
	SMSConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NotificationSystem", "root", "eman1210");       
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addtoSMSQueue( String context,String content, String name , String phone, String language, String status) {
		java.sql.PreparedStatement pstmt1;
		try {
			pstmt1 = conn.prepareStatement("INSERT INTO  SMS VALUES (?, ?, ?, ?, ?, ?)");
			
			pstmt1.setString(1,context);
			pstmt1.setString(2,content);
			pstmt1.setString(3,phone);
			pstmt1.setString(4,name);
			pstmt1.setString(5,language);
			pstmt1.setString(6,status);
	
			pstmt1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteFromSMSQueue(String phone) {
		java.sql.PreparedStatement pstmt1;
		try
		{
			pstmt1 = conn.prepareStatement("DELETE FROM SMS WHERE phone= ? and status = 'true'");
			pstmt1.setString(1,phone);
			
			pstmt1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> dequeue(String phone) {
		ArrayList<String> inbox = new ArrayList<>();
		String query = "SELECT content FROM SMS WHERE phone='" + phone + "'and status = 'true'";
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(query);
			
			if(rs.next()) {
				do {
					String str = rs.getString("content");
					inbox.add(str);
				} while(rs.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//deleteFromEmailQueue(toEmail);
		return inbox;
	}
}
