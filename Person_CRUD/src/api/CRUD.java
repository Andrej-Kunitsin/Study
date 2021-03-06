package api;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CRUD {
	private Statement st;
	private Connection conn;
	public String query = "";

	private void getConn() {
		try {
			Class.forName("org.h2.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void closeConnection() {
		try {
			st.close();
			conn.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createPerson(Person p) throws SQLException {
		getConn();
		query = "INSERT INTO person VALUES(" + p.getId() + ",'" + p.getFName()
				+ "','" + p.getLName() + "'," + p.getAge() + ")";

		st.executeUpdate(query);
		closeConnection();
	}

	public Person[] readPerson() throws SQLException {
		getConn();
		Person[] personArr = null;

		try {
			ResultSet rs = st.executeQuery("Select * from Person");
			rs.last();
			int i = rs.getRow();
			rs.first();
			personArr = new Person[i];
			i = 0;
			do {
				Person p = new Person(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4));
				personArr[i++] = p;
			} while (rs.next());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return personArr;
	}

	public void updatePerson(Person p) throws SQLException {
		getConn();
		query = "Update Person set Fname = '" + p.getFName() + "',Lname = '"
				+ p.getLName() + "',Age = " + p.getAge() + " where id="
				+ p.getId();
		st.execute(query);
		closeConnection();
	}

	public void deletePerson(Person p) throws SQLException {
		getConn();
		query = "Delete From Person where id=" + p.getId();
		st.execute(query);
		closeConnection();
	}
}
