# Student Management System (Java + JDBC + MySQL)

## Overview
A console-based Student Management System developed using Java, JDBC, and MySQL. The application allows users to perform CRUD operations on student records through a menu-driven interface.

## Technologies Used
- Java
- JDBC
- MySQL
- Eclipse IDE
- Git & GitHub

## Features
- Add Student
- View All Students
- Search Student by ID
- Search Student by Name
- Search Students by Branch
- Update Student Details
- Delete Student
- Count Total Students
- Sort Students by Marks
- Menu-Driven Console Interface

## Database Schema

### students

| Column | Data Type |
|----------|----------|
| id | INT |
| name | VARCHAR(100) |
| email | VARCHAR(100) |
| branch | VARCHAR(50) |
| marks | DOUBLE |

## JDBC Concepts Practiced
- JDBC Connection
- PreparedStatement
- ResultSet
- executeQuery()
- executeUpdate()
- CRUD Operations
- Aggregate Functions (COUNT)
- ORDER BY Queries
- Exception Handling

## Project Structure

src/
├── DBConnection.java
├── Student.java
├── StudentDAO.java
└── Main.java

## Sample Menu

1. Add Student
2. View Students
3. Search Student by ID
4. Search Student by Name
5. Search Student by Branch
6. Student Count
7. Update Student Details
8. Delete Student Details
9. Sort Students by Marks
10. Exit

## Author
Shubham