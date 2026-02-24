# Student Course Registration Portal

A web-based application for managing student course registrations with role-based access. Built using Java Servlets, JSP, and JDBC, this project demonstrates a full-stack approach with MVC architecture.

---

## Core Features (MVP)

### 👤 Users & Roles
- **Student**: Enroll in courses, view schedule
- **Admin**: Manage courses, view enrollments, manage users

### 📚 Courses
- Create, update, and delete courses
- Capacity limit management
- Scheduling support

### 📝 Enrollment
- Students can enroll in courses
- Automatic capacity check to prevent overbooking
- Prevent duplicate enrollments

### 🔐 Authentication
- Login and logout functionality
- Session-based authentication for secure access

---

## Tech Stack

- **Backend**: Java Servlets, JDBC (DAO pattern)  
- **Frontend**: JSP, HTML, CSS, JavaScript  
- **Build Tool**: Maven  
- **Database**: Relational database (MySQL/PostgreSQL recommended)  

---

## Architecture

```text
Browser
   ↓
Servlets (Controller)
   ↓
Service Layer
   ↓
DAO (JDBC)
   ↓
Database