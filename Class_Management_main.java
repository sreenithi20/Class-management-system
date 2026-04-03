import java.util.ArrayList;
import java.util.Scanner;

public class Class_Management_main {

	//users 
	public ArrayList <String> std_Login=new ArrayList<>();
	
	{
		std_Login.add("Sreenithi");
		std_Login.add("Reshmaa");
		std_Login.add("Mukhila");
		std_Login.add("Shivanii");
	}
	
	public ArrayList<String> std_Password=new ArrayList<>();
	{
		std_Password.add("23mss050");
		std_Password.add("23mss037");
		std_Password.add("23mss028");
		std_Password.add("23mss048");
	}
	
	public ArrayList <String> teacher_Login=new ArrayList<>();
	
	{
		teacher_Login.add("VaishnavaPriya");
		teacher_Login.add("Saranya");
		teacher_Login.add("Kovarthini");
		teacher_Login.add("Varshaa");
	}
	
	public ArrayList<String> teacher_Password=new ArrayList<>();
	{
		teacher_Password.add("23mss055");
		teacher_Password.add("23mss045");
		teacher_Password.add("23mss025");
		teacher_Password.add("23mss056");
	}


	public void SwitchCase() {
		Scanner sc=new Scanner(System.in);
		boolean auth=false;
		while (true) { 
		System.out.println("Enter the User Type \n1.Student  \n2.Teacher \n3.Exit ");
		int User_type=sc.nextInt();
		switch(User_type){
		case 1:
		    auth = false;
		    System.out.println("Do you want to \n 1.Login \n2.Sign-in");
		    int std_login_type=sc.nextInt();
		    if (std_login_type==1) {

		        while (!auth) {
		            System.out.println("Enter User Name");
		             String std_name = sc.next();

		            System.out.println("Enter User Password");
		             String std_pword = sc.next();

		            for (int i = 0; i < std_Login.size(); i++) {
		                if (std_Login.get(i).equals(std_name) && std_Password.get(i).equals(std_pword)) {
		                    auth = true;
		                    break;
		                }
		            }

		            if (!auth) {
		                System.out.println(" Incorrect username or password. Try again!\n");
		            }
		        }

		        System.out.println("Login Successful ");
		    }

		    else {   
		        System.out.println("Enter User Name for Signing-in ");
		        String std_nname = sc.next();
		        std_Login.add(std_nname);
		       

		        System.out.println("Enter User Password for Signing-in");
		        String std_npword = sc.next();
		        while(std_npword.contains(std_nname)) {
		        	System.out.println("Weak Password Try a Different one");
		        	std_npword=sc.next();
		        	std_Password.add(std_npword);
		        
		        }
		        std_Password.add(std_npword);

		        System.out.println("Account created  Now please login.\n");

		        
		        while (!auth) {
		            System.out.println("Enter User Name");
		            String std_name = sc.next();

		            System.out.println("Enter User Password");
		            String std_pword = sc.next();

		            for (int i = 0; i < std_Login.size(); i++) {
		                if (std_Login.get(i).equals(std_name) && std_Password.get(i).equals(std_pword)) {
		                    auth = true;
		                    break;
		                }
		            }

		            if (!auth) {
		                System.out.println("Incorrect username or password. Try again!\n");
		            }
		        }

		        System.out.println("Login Successful ");
		    }
		        Student stdobj=new Student();
			    stdobj.student_menu();
			    break;

			
		//case "teacher":
     case 2:

		    auth = false;

		    System.out.println("Do you want to \n 1.Login \n2.Sign-in");
		    //String ad_login_type = sc.nextLine().toLowerCase();
         int teacher_login_type=sc.nextInt();
		    if (teacher_login_type==1) {

		        while (!auth) {
		            System.out.println("Enter User Name");
		             String teacher_name = sc.next();

		            System.out.println("Enter User Password");
		            String teacher_pword = sc.next();

		            for (int i = 0; i < teacher_Login.size(); i++) {
		                if (teacher_Login.get(i).equals(teacher_name) && teacher_Password.get(i).equals(teacher_pword)) {
		                    auth = true;
		                    break;
		                }
		            }

		            if (!auth) {
		                System.out.println(" Incorrect username or password. Try again!\n");
		            }
		        }

		        System.out.println("Login Successful ");
		    }

		    else {   
		        System.out.println("Enter User Name for Signing-in ");
		        String teacher_nname = sc.next();
		        teacher_Login.add(teacher_nname);

		        
		        System.out.println("Enter User Password for Signing-in");
		        String teacher_npword = sc.next();
		        
		        while(teacher_npword.contains(teacher_nname)) {
		        	System.out.println("Weak Password Try a Different one");
		        	teacher_npword=sc.next();
		        	teacher_Password.add(teacher_npword);
		        
		        }
		        teacher_Password.add(teacher_npword);

		        System.out.println("Account created Now please login.\n");

		        
		        while (!auth) {
		            System.out.println("Enter User Name");
		            String teacher_name = sc.next();

		            System.out.println("Enter User Password");
		             String teacher_pword = sc.next();

		            for (int i = 0; i <teacher_Login.size(); i++) {
		                if (teacher_Login.get(i).equals(teacher_name) && teacher_Password.get(i).equals(teacher_pword)) {
		                    auth = true;
		                    break;
		                }
		            }

		            if (!auth) {
		                System.out.println(" Incorrect username or password. Try again\n");
		            }
		        }

		        System.out.println("Login Successful");
		    }
		    Teacher teacherobj=new Teacher();
		    teacherobj.teacher_menu();
		    break;
			
		//case "exit":
     case 3:
			System.out.println("You are Exited Successfully....");
			System.exit(0);
			break;
     }
  }
		
}

	public static void main(String args[]) {
		Class_Management_main menu=new Class_Management_main();
		menu.SwitchCase();
		
		
	}
}
