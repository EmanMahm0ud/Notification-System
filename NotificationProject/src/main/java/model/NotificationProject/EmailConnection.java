package model.NotificationProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmailConnection {
	Connection conn = null;
	
	EmailConnection(){
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
	public void addtoEmailQueue(String to, String subject,String content, String name, String language, String status) {
		java.sql.PreparedStatement pstmt1;
		try {
			pstmt1 = conn.prepareStatement("INSERT INTO  Email VALUES (?, ?, ?, ?, ?, ?)");
			pstmt1.setString(1, subject);// in email , to from subject which is same as context no3ha
			pstmt1.setString(2, content);
			pstmt1.setString(3, name);
			pstmt1.setString(4, to);
			pstmt1.setString(5, language);
			pstmt1.setString(6, status);
			
			pstmt1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteFromEmailQueue(String toEmail) {
		java.sql.PreparedStatement pstmt1;
		try
		{
			pstmt1 = conn.prepareStatement("DELETE FROM Email WHERE toMail= ? and status = 'true'");
			pstmt1.setString(1,toEmail);
			
			pstmt1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> dequeue(String toEmail) {
		ArrayList<String> inbox = new ArrayList<>();
		String query = "SELECT content FROM email WHERE toMail='" + toEmail + "'and status = 'true'";
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
