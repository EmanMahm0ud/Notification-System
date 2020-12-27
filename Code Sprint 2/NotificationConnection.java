package model.NotificationProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NotificationConnection {
	Connection conn = null;
	
	NotificationConnection(){
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
	
	public ArrayList<NotificationTemplate>  getAllNotifications() {
		ArrayList<NotificationTemplate> notify = new  ArrayList<NotificationTemplate>();
		String query = "SELECT * FROM NotificationTemplate";
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(query);
			
			if(rs.next()) {
				do {
					NotificationTemplate n = new NotificationTemplate();
					n.setId(rs.getInt(1));
					n.setSubject(rs.getString(2));
					n.setContent(rs.getString(3));
					if (rs.getString(4).contentEquals("English"))
						n.setLanguage(LanguageEnum.English);
					else 
						n.setLanguage(LanguageEnum.Arabic);
					notify.add(n);
				} while(rs.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notify;
	}
	
	public void addNotification(NotificationTemplate notification) {
		java.sql.PreparedStatement pstmt1;
		try {
			pstmt1 = conn.prepareStatement("INSERT INTO NotificationTemplate VALUES (?, ?, ?, ?)");
			pstmt1.setInt(1, notification.getId());
			pstmt1.setString(2, notification.getSubject());
			pstmt1.setString(3, notification.getContent());
			pstmt1.setString(4, notification.getLanguage().toString());
			pstmt1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteNotification(int id) {
		java.sql.PreparedStatement pstmt1;
		try {
			pstmt1 = conn.prepareStatement("DELETE FROM NotificationTemplate WHERE id = ?");
			pstmt1.setInt(1, id);
			pstmt1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateNotification(int id, NotificationTemplate notification) {
		java.sql.PreparedStatement pstmt1;
		try {
			pstmt1 = conn.prepareStatement("UPDATE NotificationTemplate SET subject = ?, content = ?, language = ? WHERE id = ?");
			pstmt1.setString(1, notification.getSubject());
			pstmt1.setString(2, notification.getContent());
			pstmt1.setString(3, notification.getLanguage().toString());
			pstmt1.setInt(4, notification.getId());
			pstmt1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public NotificationTemplate getNotification(int id) {
		java.sql.PreparedStatement pstmt1;
		NotificationTemplate notification = new NotificationTemplate();
		
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM NotificationTemplate WHERE id = '" + id + "'");
			if(rs.next()) {
				notification.setId(rs.getInt(1));
				notification.setSubject(rs.getString(2));
				notification.setContent(rs.getString(3));
				if (rs.getString(4).contentEquals("English"))
					notification.setLanguage(LanguageEnum.English);
				else 
					notification.setLanguage(LanguageEnum.Arabic);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notification;
	}
	
}
