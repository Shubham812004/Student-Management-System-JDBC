import java.sql.*;

public class StudentDAO {
	public boolean addStudent(Student student) {
		Connection connect = null;
		PreparedStatement pstmt = null;
		try {
			connect = DBConnection.getConnection();

			String sql = "INSERT INTO students VALUES(?,?,?,?,?)";
			pstmt = connect.prepareStatement(sql);

			pstmt.setInt(1, student.getId());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getEmail());
			pstmt.setString(4, student.getBranch());
			pstmt.setDouble(5, student.getMarks());

			int rowAffected = pstmt.executeUpdate();

			return rowAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.closeConnection(connect, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public void viewStudents() {
		Connection connect = null;
		PreparedStatement pstmt = null;

		try {
			connect = DBConnection.getConnection();

			String sql = "SELECT * FROM students";
			pstmt = connect.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int sid = rs.getInt(1);
				String sname = rs.getString(2);
				String semail = rs.getString(3);
				String sbranch = rs.getString(4);
				double smarks = rs.getDouble(5);

				System.out.println("id : " + sid);
				System.out.println("name : " + sname);
				System.out.println("email : " + semail);
				System.out.println("branch : " + sbranch);
				System.out.println("marks : " + smarks);
				System.out.println();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.closeConnection(connect, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void searchStudentById(int id) {
		Connection connect = null;
		PreparedStatement pstmt = null;

		try {
			connect = DBConnection.getConnection();

			String sql = "SELECT * FROM students WHERE id = ?";
			pstmt = connect.prepareStatement(sql);

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int sid = rs.getInt(1);
				String sname = rs.getString(2);
				String semail = rs.getString(3);
				String sbranch = rs.getString(4);
				double smarks = rs.getDouble(5);

				System.out.println("id : " + sid);
				System.out.println("name : " + sname);
				System.out.println("email : " + semail);
				System.out.println("branch : " + sbranch);
				System.out.println("marks : " + smarks);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.closeConnection(connect, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void searchStudentByName(String name) {
		Connection connect = null;
		PreparedStatement pstmt = null;

		try {
			connect = DBConnection.getConnection();

			String sql = "SELECT * FROM students WHERE name = ?";
			pstmt = connect.prepareStatement(sql);

			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int sid = rs.getInt(1);
				String sname = rs.getString(2);
				String semail = rs.getString(3);
				String sbranch = rs.getString(4);
				double smarks = rs.getDouble(5);

				System.out.println("id : " + sid);
				System.out.println("name : " + sname);
				System.out.println("email : " + semail);
				System.out.println("branch : " + sbranch);
				System.out.println("marks : " + smarks);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.closeConnection(connect, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void searchStudentByBranch(String branch) {
		Connection connect = null;
		PreparedStatement pstmt = null;

		try {
			connect = DBConnection.getConnection();
			String sql = "SELECT * FROM students WHERE branch = ?";
			pstmt = connect.prepareStatement(sql);

			pstmt.setString(1, branch);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int sid = rs.getInt(1);
				String sname = rs.getNString(2);
				String semail = rs.getString(3);
				String sbranch = rs.getString(4);
				double smarks = rs.getDouble(5);

				System.out.println("id : " + sid);
				System.out.println("name : " + sname);
				System.out.println("email : " + semail);
				System.out.println("branch : " + sbranch);
				System.out.println("marks : " + smarks);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connect.close();
				pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public void countStudents() {
		Connection connect = null;
		PreparedStatement pstmt = null;
		
		try {
			connect = DBConnection.getConnection();
			String sql = "SELECT count(*) FROM students";
			pstmt = connect.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("total number of students : " + rs.getInt(1));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				connect.close();
				pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

	public boolean updateStudent(int id, String name, String email, String branch, double marks) {
		Connection connect = null;
		PreparedStatement pstmt = null;

		try {
			connect = DBConnection.getConnection();
			String sql = "UPDATE students SET name = ?, email = ?, branch = ?, marks = ? WHERE id = ?";
			pstmt = connect.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, branch);
			pstmt.setDouble(4, marks);
			pstmt.setInt(5, id);

			int rowAffected = pstmt.executeUpdate();

			return rowAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.closeConnection(connect, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean deleteStudent(int id) {
		Connection connect = null;
		PreparedStatement pstmt = null;

		try {
			connect = DBConnection.getConnection();
			String sql = "DELETE FROM students WHERE id = ?";
			pstmt = connect.prepareStatement(sql);

			pstmt.setInt(1, id);
			int rowAffected = pstmt.executeUpdate();

			return rowAffected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.closeConnection(connect, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public void studentByAsc() {
		Connection connect = null;
		PreparedStatement pstmt = null;
		
		try {
			connect = DBConnection.getConnection();
			String sql = "SELECT * FROM students ORDER BY marks DESC ";
			pstmt = connect.prepareStatement(sql );
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int sid = rs.getInt(1);
				String sname = rs.getNString(2);
				String semail = rs.getString(3);
				String sbranch = rs.getString(4);
				double smarks = rs.getDouble(5);

				System.out.println("id : " + sid);
				System.out.println("name : " + sname);
				System.out.println("email : " + semail);
				System.out.println("branch : " + sbranch);
				System.out.println("marks : " + smarks);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				connect.close();
				pstmt.close();
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
		}
	}
}
