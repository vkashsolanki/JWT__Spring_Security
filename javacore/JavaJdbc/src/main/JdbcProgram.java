package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class JdbcProgram {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {

		System.out.println("*************Welcome to Student Crud App**********************");
		System.out.println();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("Press 1 For Add student ");
			System.out.println("Press 2 For Delete student ");
			System.out.println("Press 3 For Display student ");
			System.out.println("Press 4 For Update student ");
			System.out.println("Press 5 For Exit Application");
			System.out.println("=============================================================");
			// get choise enter number by user
			int i = Integer.parseInt(br.readLine());

			if (i == 1) {
				// add student
				System.out.println("Enter the use name");
				String name = br.readLine();
				System.out.println("Enter the use phone");
				String phone = br.readLine();
				System.out.println("Enter the use city");
				String city = br.readLine();
				// create object of student to store student
				Student stt = new Student(name, phone, city);
				// is studnet ki detail (st) ko database me save krna hai to iske liye
				// connection bana le
				// dao ka method ko call krke studnet ki value pass krde and confirm krne ke lye
				// boolean me hold kre
				boolean answer = StudentDao.insertStudnet(stt);

				// database me save hua ha ya ni idkelye if else lga le
				if (answer) {
					System.out.println("Successfully Student Added !..");

				} else {
					System.out.println("Something went Wrong !..");
				}

			} else if (i == 2) {
				// Delete Student for take user input
				System.out.println("Enter your id for Delete Student");
				int id1 = Integer.parseInt(br.readLine());
				// set id of student for delete from database
				boolean ie = StudentDao.deleteStudent(id1);

				// database me save hua ha ya ni idkelye if else lga le

				if (ie) {
					System.out.println("Delete Successfully");
				} else {
					System.out.println("Wrong Student id");
				}

			} else if (i == 3) {
				// Display Student
				StudentDao.allStudent();
				
				
				

			} else if (i == 4) {
				// Update Student
				System.out.println("Enter your id::");
				int readLine = Integer.parseInt(br.readLine());
				System.out.println("Enter the use name");
				String name = br.readLine();
				System.out.println("Enter the use phone");
				String phone = br.readLine();
				System.out.println("Enter the use city");
				String city = br.readLine();
				// create object of student to store student
				Student stt = new Student(name, phone, city);
				StudentDao.updateStudent(stt);
				

			} else if (i == 5) {
				// Exit ke liye break ka use karen
				break;
				

			}

		}
	}

}
