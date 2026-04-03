//login in,sign in 
//insert student details
//update 
//cannot if already exixts

//insert teacher details
// insert student details
//all crud op on student 
import java.util.Scanner;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Student extends Class_Management_main {
	Scanner sc=new Scanner(System.in);
	static final String url ="jdbc:postgresql://localhost:5432/jdbcconnection";
	static final String user1 ="student";
	static final String pass1="student";
	static final String user2 ="teacher";
	static final String pass2="teacher";

	public  boolean run=false;
	public void student_connection_insert(int s_id,String s_name,float scgpa,int year_of_study,int dept_id){
		try {
			
		//establish conn
		Connection conn=DriverManager.getConnection(url, user1, pass1);
		System.out.println("Connected to PostgreSQL successfully!");
		
		//stmt
		Statement stmt=conn.createStatement();
		
		//checking if already exists
		String check_entry = "SELECT s_id FROM student WHERE s_id = ?";
		try (PreparedStatement checkPstmt = conn.prepareStatement(check_entry)) {
            checkPstmt.setInt(1, s_id);
            ResultSet rs = checkPstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Entry Denied: Student with ID " + s_id + " already exists.");
                return;
            }
        }
		
		//insertion
		String insert_student="INSERT INTO student (s_id,s_name,scgpa, year_of_study,dept_id) VALUES (?, ?, ? ,? ,?)";
		try (PreparedStatement pstmt = conn.prepareStatement(insert_student)) {
            
            pstmt.setInt(1, s_id);
            pstmt.setString(2, s_name);
            pstmt.setFloat(3, scgpa);
            pstmt.setInt(4, year_of_study);
            pstmt.setInt(5, dept_id);
            

            // 4. Execute the update
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new record was inserted successfully!");
            }
        }
	
	}//end of main try
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//end of student_connection_insert
	public void student_connection_update(float s_cgpa,int s_yos,int std_id) {
		try {
			
			//establish conn
			Connection conn=DriverManager.getConnection(url, user1, pass1);
			System.out.println("Connected to PostgreSQL successfully!");
			
			//stmt
			Statement stmt=conn.createStatement();
			//insertion
			String update_student="UPDATE student SET scgpa = ?, year_of_study = ? WHERE s_id = ?";
			try (PreparedStatement pstmt = conn.prepareStatement(update_student)) {
	            
	            
	            pstmt.setFloat(1, s_cgpa);
	            pstmt.setInt(2, s_yos);
	            pstmt.setInt(3, std_id);
	          
	            int rowsUpdated = pstmt.executeUpdate();
	            if (rowsUpdated> 0) {
	                System.out.println("A new record was updated successfully!");
	            }
	        }
		
		}//end of main try
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}
	
	public void student_menu() {
		while(!run) {
			System.out.println("STUDENT_OPERATIONS \n 1.INSERT \n2.UPDATE \n 3.EXIT");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter the student table values");
				System.out.println("Enter the Student ID");
				int s_id=sc.nextInt();
				System.out.println("Enter the Student Name");
				String s_name=sc.next();
				System.out.println("Enter the Student CGPA");
				float scgpa=sc.nextFloat();
				System.out.println("Enter the Student Year of Study");
				int year_of_study=sc.nextInt();
				System.out.println("Enter the Student Department ID");
				int dept_id=sc.nextInt();
				student_connection_insert(s_id,s_name,scgpa,year_of_study,dept_id);
				break;
			case 2:
				System.out.println("Enter the New CGPA");
				float s_cgpa=sc.nextFloat();
				System.out.println("Enter the Year of Study");
				int s_yos=sc.nextInt();
				System.out.println("Enter the Student ID");
				int std_id=sc.nextInt();
				student_connection_update(s_cgpa,s_yos,std_id);
				break;
			case 3:
				System.out.println("You are Exited Successfully....");
				System.exit(0);
				break;
				
			}
				
		}
		
	}
//	public static void main(String args[]) {
//		Student Stdobj=new Student();
//		Stdobj.student_menu();
//		
//	}
	
	

}
