//import java.util.Scanner;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class TimeTable extends Teacher{
//	static final String user2 ="teacher";
//	static final String pass2="teacher";
	public boolean teacherConnectionInsertTimetable(int year_of_study, int day_order, String hour_no, String start_time, String end_time, int teacherid, String subject) {
	    try {
	        // 1. Establish connection
	        Connection conn = DriverManager.getConnection(url, user2, pass2);
	        
	        if (start_time.split(":").length == 2)
	        	start_time += ":00";
	        if (end_time.split(":").length == 2) 
	        	end_time += ":00";
	        
	        java.sql.Time starttime = java.sql.Time.valueOf(start_time);
	        java.sql.Time endtime = java.sql.Time.valueOf(end_time);

	        
	        String checkOverlap = "SELECT COUNT(*) FROM timetable WHERE day_order = ? AND " +
	                              "(year_of_study = ? OR t_id = ?) AND " +
	                              "(? < end_time AND ? > start_time)";

	        try (PreparedStatement checkPstmt = conn.prepareStatement(checkOverlap)) {
	            checkPstmt.setInt(1, day_order);
	            checkPstmt.setInt(2, year_of_study);
	            checkPstmt.setInt(3, teacherid);
	            checkPstmt.setTime(4, starttime); // New Start < Exist End
	            checkPstmt.setTime(5, endtime);   // New End > Exist Start

	            ResultSet rs = checkPstmt.executeQuery();
	            if (rs.next() && rs.getInt(1) > 0) {
	                System.out.println(" The class or teacher is already occupied during this time!");
	                return false; 
	            }
	        }

	        
	        String insertIntoTimetable = "INSERT INTO timetable (year_of_study, day_order, hour_no, start_time, end_time, t_id, subject) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement pstmt = conn.prepareStatement(insertIntoTimetable)) {
	            pstmt.setInt(1, year_of_study);
	            pstmt.setInt(2, day_order);
	            pstmt.setString(3, hour_no);
	            pstmt.setTime(4, starttime);
	            pstmt.setTime(5, endtime);
	            pstmt.setInt(6, teacherid);
	            pstmt.setString(7, subject);

	            int rowsInserted = pstmt.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("A new record was inserted successfully!");
	                return true;
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("Database Error: " + e.getMessage());
	    } catch (IllegalArgumentException e) {
	        System.err.println(" Please enter time as HH:MM or HH:MM:SS");
	    }
	    return false;
	}	
	public void teacherConnectionTimetableSelect() { 
		String selectTimetable = "SELECT * FROM timetable";

	    try (Connection conn = DriverManager.getConnection(url, user2, pass2)){
	    	
	    	Statement stmt=conn.createStatement();
	      
	    	ResultSet rstTimetable=stmt.executeQuery(selectTimetable);
    		System.out.println("timetable");
    		while (rstTimetable.next()) {
    			System.out.println(rstTimetable.getInt("year_of_study") + "   " + rstTimetable.getInt("day_order")+" "+rstTimetable.getString("hour_no")+""+rstTimetable.getString("start_time")+""+rstTimetable.getString("end_time")+""+""+rstTimetable.getInt("t_id")+""+rstTimetable.getString("subject"));
            }
	        
	    } catch (SQLException e) {
	        System.err.println("Delete Error: " + e.getMessage());
	        
	    }
	}
	
	public void teacherConnectionCreateTable() {
		try(Connection conn=DriverManager.getConnection(url,user2,pass2)){
			Statement stmt=conn.createStatement();
			
			String create_timetable="create table if not exists timetable(year_of_study int,day_order int,hour_no varchar(200),start_time time,end_time time,t_id int,subject varchar(100),constraint teacher_availability unique(t_id, day_order, start_time),CONSTRAINT unique_class_slot UNIQUE (year_of_study, day_order, hour_no))";
			stmt.executeUpdate(create_timetable);
			System.out.println("Table created successfully");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


}
