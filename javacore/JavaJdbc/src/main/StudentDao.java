package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {
	// st ko database me insert krna hai
	// database me pahuchne ke bad answer ke liye ham boolean lenge
	public static boolean insertStudnet(Student st) {

		boolean f = false;

		try {
			// coneection create direct
			Connection con = ConnectionProvider.createConnection();

			// Sql query fire krne ke bad iska store krna ha db me (ye dynamic query hai)
			String query = "insert into student(name,phone,city)values(?,?,?)";

			// preapresttament connection pas hai mehotd
			PreparedStatement ps = con.prepareStatement(query);
			// ek ek value ham value(?,?,?) me dalenge // set the vlaue of parameter
			// st ka hame name chahiye isliye ham st.name call kernege ek ek krke tino
			ps.setString(1, st.getName());
			// st ka hame name chahiye isliye ham st.phone
			ps.setString(2, st.getPhone());
			// st ka hame name chahiye isliye ham st.city
			ps.setString(3, st.getCity());

			// after complte query now execute
			// jaise hi ye update hoga tab flag value bta dega
			ps.executeUpdate();
			f = true;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// return hamesha catch ke bahar hota hait flag vaue ko kya return kre do
		return f;

	}

	public static boolean deleteStudent(int id) throws SQLException {

		// variable flag
		boolean fl = false;

		// create connection
		Connection con = ConnectionProvider.createConnection();
		// fire sql query
		String query1 = "delete from Student where id=?";
		// prepareStatement passed
		PreparedStatement pst = con.prepareStatement(query1);
		// set the value parameter
		pst.setInt(1, id);
		// execute statement
		pst.executeUpdate();
		// after update value would be true
		fl = true;

		return fl;

	}

	// data ko show rne ke liye
	public static void allStudent() throws SQLException {

		// create connection
		Connection con = ConnectionProvider.createConnection();
		// fire sql query
		String query1 = "select * from student";
		// data jab show krna hai tab Statement lena hota hai (preapreStatement nahi le)
		// createStatement() mehod ko hi le
		Statement st = con.createStatement();
		// data jab lana hota tab executeQury dena hota hai and resultset me data store
		// krne ke liye use krte hai
		ResultSet set = st.executeQuery(query1);
		System.out.println("resultsetquery is ::" + set);
		// tabtak chalega jabtak resultset me next row hai
		while (set.next()) {
			// ek ek row ki detail print krne ke liye table ke sare column set kre number se
			// or column ka v de skte ho
//			int id = set.getInt(1);
//			String name =set.getString(2);
//			String phone = set.getString(3);
//			String city = set.getString(4);

			int id = set.getInt("id");
			String name = set.getString("name");
			String phone = set.getString("phone");
			String city = set.getString("city");

			System.out.println("id::" + id);
			System.out.println("name::" + name);
			System.out.println("phone::" + phone);
			System.out.println("city::" + city);
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		}

	}

	// update data
	public static void updateStudent(Student st) throws SQLException {

		// create connection
		Connection con = ConnectionProvider.createConnection();
		// fire update query for update
		String query = "update student set name=?, phone=?, city=? where id=?";

		Statement stmt = con.createStatement();
		
		int rs = stmt.executeUpdate(query);
		if(rs > 0) {
			System.out.println("Updated Successfully");
		}else
		{
			System.out.println("Not Updated");
		}
		
		con.close();

	}

}
