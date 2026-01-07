# Core Java JDBC CRUD Application

A console-based CRUD (Create, Read, Update, Delete) application built using **Core Java and JDBC** with **PostgreSQL / MySQL** database support.

This project demonstrates real-world usage of:
- JDBC
- SQL
- Layered architecture (Entity, Service)
- Console-based user interaction
- Git & GitHub workflow

---

## 🚀 Features

- Add new user
- View all users in formatted table output
- Fetch user by ID before updating
- Update existing user details
- Delete user by ID
- Clean and structured JDBC code

---

## 🛠️ Tech Stack

- Java (Core Java)
- JDBC
- PostgreSQL / MySQL
- IntelliJ IDEA
- Git & GitHub

---

CoreJava/
│
├── src/
│ ├── Main.java
│ └── CrudOperations/
│ ├── UserEntity.java
│ ├── UserService.java
│ ├── DBConnectionPostgreSql.java
│ └── DBConnectionMySQL.java
│
├── .gitignore
└── README.md


---

## 🗄️ Database Schema

### Users Table

```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    contact_number VARCHAR(20)
);

▶️ How to Run the Project

Clone the repository:

git clone https://github.com/KiranDaud221122/CoreJavaProject.git


Open the project in IntelliJ IDEA

Configure database credentials in:

DBConnectionPostgreSql.java
or
DBConnectionMySQL.java


Run Main.java

📋 Sample Menu Output
==== USER CRUD MENU ====
1. Add User
2. View Users
3. Update User
4. Delete User
5. Exit

🎯 Learning Outcome

Strong understanding of JDBC workflow

SQL integration with Java

Proper CRUD implementation

Clean console-based application design

Practical Git & GitHub usage

👤 Author

Kiran Daud
GitHub: https://github.com/KiranDaud221122

## 📂 Project Structure

