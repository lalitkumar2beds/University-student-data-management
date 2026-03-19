# University-student-data-management

A Java-based desktop application developed using Object-Oriented Programming (OOP) principles to manage university student data, course enrolment, assessments, and academic records.



This system demonstrates the use of \*\*Java, Swing GUI, MVC architecture, and file-based data persistence\*\*.



---



\# Features



The system supports three main user roles:



\### Administrator

\- Create and manage users (Students, Lecturers, Admins)

\- Manage courses

\- Manage enrollments

\- Manage assessments

\- View student records



\### Lecturer

\- Manage assessments

\- Record student grades

\- Evaluate course performance



\### Student

\- Enroll in courses

\- View academic records

\- Access personal dashboard



---



\# Technologies Used



\- Java (OOP)

\- Java Swing (GUI)

\- MVC Architecture

\- File-based storage

\- Design Patterns

&nbsp; - Singleton

&nbsp; - Factory

&nbsp; - MVC



---



\# Project Structure





UniversityStudentDataManagementSystem

│

├── src

│ ├── main

│ │ └── Main.java

│ │

│ ├── model

│ ├── controller

│ ├── view

│ ├── database

│ ├── utils

│ └── factory

│

├── data

│

├── docs

│

└── README.md





---



\# System Requirements



Before running the project, ensure you have:



\- \*\*Java JDK 21 or higher installed\*\*

\- \*\*VS Code or any Java IDE\*\*

\- Terminal or command prompt



Check Java installation:





java -version

javac -version





---



\# First Run Instructions



Follow these steps to run the application on a new system.



\### Step 1: Clone or Download the Project



Download the project folder or clone the repository.



---



\### Step 2: Open Project



Open the root project folder in your IDE.



Example:





UniversityStudentDataManagementSystem





---



\### Step 3: Compile the Project



From the project root directory run:





javac -d bin src/main/Main.java src/model/.java src/controller/.java src/database/.java src/factory/.java src/utils/.java src/view/.java





---



\### Step 4: Run the Application



Run the main program:





java -cp bin main.Main





---



\# First Startup



When the system runs for the first time it automatically creates \*\*sample users and courses\*\*.



Example terminal output:





Starting University Student Data Management System...

Creating sample users and courses...

Sample data created successfully.





---



\# Default Login Accounts



\### Administrator





Email: admin@university.com



Password: admin123





\### Lecturer





Email: lecturer1@university.com



Password: pass123





\### Student





Email: student1@university.com



Password: pass123





---



\# Data Storage



The system uses \*\*file-based persistence\*\*.



All system data is saved inside the `data` folder:





data/

users.dat

students.dat

courses.dat

enrollments.dat

assessments.dat





These files are automatically created during the first run.



---



\# System Functionalities



The application supports the following core functionalities:



\- Role-based authentication

\- Student profile management

\- Course management

\- Course enrollment

\- Assessment creation

\- Grade recording

\- Academic record viewing



---



\# Design Principles



The system demonstrates key \*\*Object-Oriented Programming concepts\*\*:



\- Encapsulation

\- Inheritance

\- Polymorphism

\- Abstraction



It also uses \*\*design patterns\*\*:



\- MVC architecture

\- Singleton pattern (DataStore)

\- Factory pattern (UserFactory)

