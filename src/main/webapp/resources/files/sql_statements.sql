CREATE DATABASE DB_REPO_V1;
CREATE schema student_course_registration_portal;

CREATE TABLE USERS (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(1000),
    last_name VARCHAR(100),
    email VARCHAR(1000),
	password VARCHAR(1000)
);
ALTER TABLE USERS
DROP COLUMN  first_name,
DROP COLUMN last_name;
select * from students;
ALTER TABLE USERS
RENAME TO students;
DELETE FROM students WHERE id = 6;
CREATE TABLE Courses (
    id SERIAL PRIMARY KEY,
    Course_name VARCHAR(1000),
    Course_description VARCHAR(100),
	Course_hours INTEGER);
select * from students;
CREATE TABLE USERS (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(1000),
    last_name VARCHAR(100),
	user_role VARCHAR(1000),
    email VARCHAR(1000),
	password VARCHAR(1000)
);

INSERT INTO USERS (first_name, last_name, user_role, email, password) VALUES
('Ahmed', 'Ali', 'ADMIN', 'ahmed@portal.com', '123456'),
('Sara', 'Hassan', 'INSTRUCTOR', 'sara@portal.com', '123456'),
('Mohamed', 'Youssef', 'STUDENT', 'mohamed@portal.com', '123456'),
('Laila', 'Omar', 'STUDENT', 'laila@portal.com', '123456'),
('Khaled', 'Samir', 'INSTRUCTOR', 'khaled@portal.com', '123456'),
('Nour', 'Adel', 'STUDENT', 'nour@portal.com', '123456'),
('Hany', 'Mahmoud', 'ADMIN', 'hany@portal.com', '123456'),
('Mona', 'Fathy', 'STUDENT', 'mona@portal.com', '123456'),
('Omar', 'Tarek', 'INSTRUCTOR', 'omar@portal.com', '123456'),
('Aya', 'Mostafa', 'STUDENT', 'aya@portal.com', '123456');
ALTER TABLE USERS
ADD COLUMN user_id SERIAL PRIMARY KEY;

SELECT pg_get_serial_sequence('USERS', 'user_id');

ALTER SEQUENCE users_user_id_seq RESTART WITH 1000
CREATE TABLE USERS (
    user_id SERIAL PRIMARY KEY,  -- auto increment primary key
	id SERIAL,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    user_role VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100)
);

SELECT pg_get_serial_sequence('users', 'user_id');


DROP TABLE IF EXISTS USERS CASCADE;
ALTER SEQUENCE public.users_user_id_seq RESTART WITH 1000;
INSERT INTO USERS (first_name, last_name, user_role, email, password) VALUES
('Ahmed', 'Ali', 'ADMIN', 'ahmed@portal.com', '123456'),
('Sara', 'Hassan', 'INSTRUCTOR', 'sara@portal.com', '123456'),
('Mohamed', 'Youssef', 'STUDENT', 'mohamed@portal.com', '123456'),
('Laila', 'Omar', 'STUDENT', 'laila@portal.com', '123456'),
('Khaled', 'Samir', 'INSTRUCTOR', 'khaled@portal.com', '123456'),
('Nour', 'Adel', 'STUDENT', 'nour@portal.com', '123456'),
('Hany', 'Mahmoud', 'ADMIN', 'hany@portal.com', '123456'),
('Mona', 'Fathy', 'STUDENT', 'mona@portal.com', '123456'),
('Omar', 'Tarek', 'INSTRUCTOR', 'omar@portal.com', '123456'),
('Aya', 'Mostafa', 'STUDENT', 'aya@portal.com', '123456');
select * from USERS;
select * from courses;
ALTER TABLE courses
ADD COLUMN created_by VARCHAR(100),       
ADD COLUMN start_date DATE,                
ADD COLUMN end_date DATE,                  
ADD COLUMN registration_deadline DATE;  

ALTER TABLE courses
ADD COLUMN available_seats;
INSERT INTO courses 
(course_name, course_description, course_hours, available_seats, registration_deadline, start_date, end_date, created_by)
VALUES
('Java Basics', 'Introduction to Java programming', 40, 30, '2026-03-01', '2026-03-05', '2026-04-05', 'Admin'),
('Spring Boot', 'Learn Spring Boot for web apps', 50, 25, '2026-03-10', '2026-03-15', '2026-04-20', 'Admin'),
('Data Structures', 'DS and algorithms course', 60, 20, '2026-03-05', '2026-03-10', '2026-04-15', 'John'),
('SQL Basics', 'Learn SQL for database management', 30, 40, '2026-02-25', '2026-03-01', '2026-03-30', 'Jane'),
('Web Development', 'HTML, CSS, JS basics', 45, 35, '2026-03-07', '2026-03-10', '2026-04-10', 'Admin');

DELETE FROM courses;

ALTER TABLE courses
ADD COLUMN created_date Date Default  ;
CREATE TABLE registration (
   registration_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,
    registered_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES USERS(user_id),
    FOREIGN KEY (course_id) REFERENCES courses(id)
);
select * from courses;
CREATE TABLE Enrollments (
    enrollment_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    course_id INT NOT NULL,
    status VARCHAR(20) DEFAULT 'pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE,
    
    UNIQUE (user_id, course_id)
);

select * from Enrollments;
select * from courses;
select * from USERS;

select en.user_id, en.course_id, en.status , cs.course_name,
us.first_name
from Enrollments en 
	Inner Join courses cs on en.course_id = cs.id
	Inner Join USERS us on en.user_id = us.user_id; 

select count(*) as number_of_users from USERS ;
select count(*) from USERS where user_role =  'STUDENT' ;
select count(*) from courses;

