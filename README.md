# Class Management System

A robust, console-based Class Management System designed to streamline academic operations for both students and teachers. This application manages user authentication, course enrollments, and academic assignment tracking through a menu-driven interface.

---

## 🛠️ Technologies Used

- **Language:** Java (JDK 8+)
- **Database:** PostgreSQL
- **Database Connectivity:** JDBC (Java Database Connectivity)
- **Architecture:** Modular, Console-based Menu-driven Application

---

## 👥 Use Case Specification

### Actors
- **Student:** Can view enrolled courses, track assignments, and view statuses.
- **Teacher (Tutor):** Can manage courses, assign tasks, view student enrollments, and update records.

### Preconditions
- The student must be registered with a valid username and password.
- The teacher must be registered with a valid username and password.

### Postconditions
- Upon successful authentication, users are redirected to their respective personalized operation menus.

---

## 🔄 System Flow

### Main Flow (Successful Authentication)
1. **Login:** The user (Student/Teacher) enters their credentials on the terminal login interface.
2. **Authorization:** The system validates credentials against the PostgreSQL database via JDBC.
3. **Menu Access:** Access is granted, displaying a tailored menu based on the user's role.
4. **Operations:** The user inputs their choice to perform standard operations (e.g., viewing courses, managing assignments).
5. **Exit:** The user gracefully terminates the session.

### Alternate Flow (Authentication Failure)
- If a Student or Teacher attempts to log in with invalid credentials, the system denies access, displays an error message, and prompts them to try again.

---

## 🗄️ Database Schema & Architecture

The backend relies on a highly relational PostgreSQL structure ensuring data integrity via strict foreign key constraints:

*   **Students & Tutors:** Stores core user profiles and departmental data.
*   **Courses:** Linked directly to a specific `Tutor` (Many-to-One).
*   **Enrollment:** A junction table mapping `Students` to `Courses` to track registration year and status.
*   **Assignments:** Tracks academic tasks, deadlines, and completion statuses linked to both specific students and courses.

---
