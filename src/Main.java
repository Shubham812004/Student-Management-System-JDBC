import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Add Student details");
		System.out.println("2. View Student details");
		System.out.println("3. Search Student by id");
		System.out.println("4. Search Student by name");
		System.out.println("5. Search Student by branch");
		System.out.println("6. Student count");
		System.out.println("7. Update Student details");
		System.out.println("8. Delete Student details");
		System.out.println("9. Sort Students by marks");
		System.out.println("10. Exit");
		while (true) {
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				int id = sc.nextInt();
				sc.nextLine();
				String name = sc.nextLine();
				String email = sc.next();
				String branch = sc.next();
				double marks = sc.nextDouble();
				Student s = new Student(id, name, email, branch, marks);
				boolean ans = dao.addStudent(s);
				if (ans) {
					System.out.println("Student details added successfully");
				} else {
					System.out.println("failed to add student details");
				}
				break;
			case 2:
				dao.viewStudents();
				break;
			case 3:
				int id1 = sc.nextInt();
				dao.searchStudentById(id1);
				break;
			case 4:
				sc.nextLine();
				String name1 = sc.nextLine();
				dao.searchStudentByName(name1);
				break;
			case 5:
				sc.nextLine();
				String branch11 = sc.nextLine();
				dao.searchStudentByBranch(branch11);
				break;
			case 6:
				dao.countStudents();
				break;
			case 7:
				int id11 = sc.nextInt();
				sc.nextLine();
				String name11 = sc.nextLine();
				String email1 = sc.next();
				String branch1 = sc.next();
				double marks1 = sc.nextDouble();
				boolean ans1 = dao.updateStudent(id11, name11, email1, branch1, marks1);
				if (ans1) {
					System.out.println("Student details updated successfully");
				} else {
					System.out.println("failed to update student details");
				}
				break;
			case 8:
				int id111 = sc.nextInt();
				boolean ans2 = dao.deleteStudent(id111);
				if (ans2) {
					System.out.println("Students details deleted successfully");
				} else {
					System.out.println("delete failed");
				}
				break;
			case 9:
				dao.studentByAsc();
				break;
			case 10:
				System.out.println("Exiting...");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Choice");
			}
		}
	}
}
