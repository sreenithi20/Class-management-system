
import java.util.Scanner;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class Teacher extends Class_Management_main{
	Scanner sc=new Scanner(System.in);
	static final String url ="jdbc:postgresql://localhost:5432/jdbcconnection";
//	static final String user1 ="student";
//	static final String pass1="student";
	static final String user2 ="teacher";
	static final String pass2="teacher";
	public  boolean run=false;
	
	//insertion
	public void teacher_student_connection_insert(int s_id,String s_name,float scgpa,int year_of_study,int dept_id){
		try {
			
		//establish conn
		Connection conn=DriverManager.getConnection(url, user2, pass2);
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
	}
	
	public void teacher_student_connection_update(float s_cgpa,int s_yos,int std_id) {
		try {
			
			//establish conn
			Connection conn=DriverManager.getConnection(url, user2, pass2);
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
	
	public void teacher_student_connection_delete(int stdid) {
		String delete_student = "DELETE FROM student WHERE s_id = ?";

	    try (Connection conn = DriverManager.getConnection(url, user2, pass2);
	         PreparedStatement pstmt = conn.prepareStatement(delete_student)) {

	        pstmt.setInt(1, stdid);

	        int rowsDeleted = pstmt.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println(" Student with ID " + stdid + " was deleted successfully!");
	        } else {
	            System.out.println(" No student found with ID: " + stdid);
	        }

	    } catch (SQLException e) {
	        System.err.println("Delete Error: " + e.getMessage());
	        
	    }
	}
	
	public void teacher_student_connection_select() {
		String select_student = "SELECT * FROM student";

	    try (Connection conn = DriverManager.getConnection(url, user2, pass2)){
	    	
	    	Statement stmt=conn.createStatement();
	      
	    	ResultSet rst_student=stmt.executeQuery(select_student);
    		System.out.println("studdtable");
    		while (rst_student.next()) {
    			System.out.println(rst_student.getInt("s_id") + "   " + rst_student.getString("s_name")+" "+rst_student.getFloat("scgpa")+""+rst_student.getInt("year_of_study")+""+rst_student.getInt("dept_id"));
            }
	        
	    } catch (SQLException e) {
	        System.err.println("Delete Error: " + e.getMessage());
	        
	    }
	}
	public void teacher_connection_insert(int t_id,String t_name,String designation,java.math.BigDecimal salary,int dept_id){
		try {
			
		//establish conn
		Connection conn=DriverManager.getConnection(url, user2, pass2);
		System.out.println("Connected to PostgreSQL successfully!");
		
		//stmt
		Statement stmt=conn.createStatement();
		
		//checking if already exists
		String check_entry = "SELECT t_id FROM teacher WHERE t_id = ?";
		try (PreparedStatement checkPstmt = conn.prepareStatement(check_entry)) {
            checkPstmt.setInt(1, t_id);
            ResultSet rs = checkPstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Entry Denied: Student with ID " + t_id + " already exists.");
                return;
            }
        }
		
		//insertion
		String insert_student="INSERT INTO teacher (t_id,t_name,designation,salary,dept_id) VALUES (?, ?, ? ,? ,?)";
		try (PreparedStatement pstmt = conn.prepareStatement(insert_student)) {
            
            pstmt.setInt(1, t_id);
            pstmt.setString(2, t_name);
            pstmt.setString(3, designation);
            pstmt.setBigDecimal(4, salary);
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
	}
	
	public void teacher_connection_update(java.math.BigDecimal new_t_salary,String designation,int new_t_id) {
		try {
			
			//establish conn
			Connection conn=DriverManager.getConnection(url, user2, pass2);
			System.out.println("Connected to PostgreSQL successfully!");
			
			
			//stmt
			Statement stmt=conn.createStatement();
			//insertion
			String update_teacher="UPDATE teacher SET salary = ?, designation = ? WHERE t_id = ?";
			try (PreparedStatement pstmt = conn.prepareStatement(update_teacher)) {
	            
	            
	            pstmt.setBigDecimal(1, new_t_salary);
	            pstmt.setString(2, designation);
	            pstmt.setInt(3, new_t_id);
	          
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
	
	public void teacher_connection_delete(int tid) {
		String delete_teacher = "DELETE FROM teacher WHERE t_id = ?";

	    try (Connection conn = DriverManager.getConnection(url, user2, pass2);
	         PreparedStatement pstmt = conn.prepareStatement(delete_teacher)) {

	        pstmt.setInt(1, tid);

	        int rowsDeleted = pstmt.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println(" Teacher with ID " + tid + " was deleted successfully!");
	        } else {
	            System.out.println(" No Teacher found with ID: " + tid);
	        }

	    } catch (SQLException e) {
	        System.err.println("Delete Error: " + e.getMessage());
	        
	    }
	}
	
	public void teacher_connection_select() { 
		String select_teacher = "SELECT * FROM teacher";

	    try (Connection conn = DriverManager.getConnection(url, user2, pass2)){
	    	
	    	Statement stmt=conn.createStatement();
	      
	    	ResultSet rst_student=stmt.executeQuery(select_teacher);
    		System.out.println("teachertable");
    		while (rst_student.next()) {
    			System.out.println(rst_student.getInt("t_id") + "   " + rst_student.getString("t_name")+" "+rst_student.getString("designation")+""+rst_student.getFloat("salary")+""+rst_student.getInt("dept_id"));
            }
	        
	    } catch (SQLException e) {
	        System.err.println("Delete Error: " + e.getMessage());
	        
	    }
	}

	
		public void teacher_menu() {
			while(!run) {
				System.out.println("Do You Want To Manipulate Teacher or Student Table (1 or 2)");
				int opt=sc.nextInt();
				if(opt==1) {
					System.out.println("TEACHER OPERATIONS \n 1.INSERT \n2.UPDATE \n 3.DELETE \n 4.SELECT \n 5.EXIT");
					int choice_teacher_table=sc.nextInt();
					switch(choice_teacher_table) {
					case 1:
						System.out.println("Enter the teacher table values");
						System.out.println("Enter the Teacher's Salary");
						java.math.BigDecimal salary=sc.nextBigDecimal();
						System.out.println("Enter the Teacher ID");
						int t_id=sc.nextInt();
						
						System.out.println("Enter the Teacher Name");
						String t_name=sc.next();
						System.out.println("Enter the Teacher Designation");
						String designation=sc.next();
						
						System.out.println("Enter the Teacher's Department ID");
						int dept_id=sc.nextInt();
						teacher_connection_insert(t_id,t_name,designation,salary,dept_id);
						break;
					case 2:
						System.out.println("Enter the New Teacher Salary");
						java.math.BigDecimal new_t_salary=sc.nextBigDecimal();
						System.out.println("Enter the Teacher Designation");
						String t_designation=sc.next();
						System.out.println("Enter the Teacher ID");
						int new_t_id=sc.nextInt();
						teacher_connection_update(new_t_salary,t_designation,new_t_id);
						break;
					case 3:
						System.out.println("Enter Teacher ID to delete");
						int tid=sc.nextInt();
						teacher_connection_delete(tid);
						break;
					case 4:
						System.out.println("Displaying Teacher Table");
						teacher_connection_select();
						break;
					case 5:
						System.out.println("You are Exited Successfully....");
						System.exit(0);
						break;
						
					}
			}
				if(opt==2) {
				System.out.println("OPERATIONS IN STUDENT TABLE FOR TEACHER \n 1.INSERT \n2.UPDATE \n 3.DELETE \n 4.SELECT \n 5.EXIT");
				int choice_student_table=sc.nextInt();
				
				switch(choice_student_table) {
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
					teacher_student_connection_insert(s_id,s_name,scgpa,year_of_study,dept_id);
					break;
				case 2:
					System.out.println("Enter the New CGPA");
					float s_cgpa=sc.nextFloat();
					System.out.println("Enter the Year of Study");
					int s_yos=sc.nextInt();
					System.out.println("Enter the Student ID");
					int std_id=sc.nextInt();
					teacher_student_connection_update(s_cgpa,s_yos,std_id);
					break;
				case 3:
					System.out.println("Enter Student ID to delete");
					int stdid=sc.nextInt();
					teacher_student_connection_delete(stdid);
					break;
				case 4:
					System.out.println("Displaying Student Table");
					teacher_student_connection_select();
					break;
				case 5:
					System.out.println("You are Exited Successfully....");
					System.exit(0);
					break;
					
				}
				}
				
					
			}
		
			
		}
//		public static void main(String args[]) {
//			Teacher teacherobj=new Teacher();
//			teacherobj.teacher_menu();
//			
//		}

}

