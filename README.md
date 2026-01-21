# Student Information System (Java + MySQL)

A console-based Student Information System developed using Java and MySQL.
This project allows users to manage student records using a menu-driven interface.

---

## 📌 Features

- Add new student records
- View all students
- Search students by Student ID or Name
- Update student details
- Delete student records
- Input validation
- MySQL database connectivity using JDBC

---

## 🛠️ Technologies Used

- Java
- MySQL
- JDBC
- Command Line Interface (CMD)

---

## 🗂️ Project Structure

Student-Information-System-Java-MySQL  
│  
├── StudentInformationSystem.java  
├── StudentInformationSystemDB.java  
├── README.md  
└── .gitignore  

---

## 🗄️ Database Structure

Database Name: `student_db`  
Table Name: `students`

```sql
CREATE TABLE students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    grade VARCHAR(10),
    contact VARCHAR(15)
);
▶️ How to Run the Project
Compile:

bash

javac -cp .;mysql-connector-j-8.0.33.jar StudentInformationSystemDB.java
Run:


java -cp .;mysql-connector-j-8.0.33.jar StudentInformationSystemDB
🎯 Learning Outcomes
Java OOP concepts

MySQL database handling

JDBC connectivity

CRUD operations

👨‍🎓 Developed By
Satyam Sharma
BCA Student
Dr. Ram Manohar Lohia Avadh University

📄 License
This project is for educational purposes only.

yaml


---

### 🔹 STEP 3: Save & Close
- **Ctrl + S**
- Close Notepad

---

### 🔹 STEP 4: Git me add & push
```cmd
git add README.md
git commit -m "Added README file"
git push
