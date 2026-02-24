package com.student.course.registration.portal.dao;

import com.student.course.registration.portal.connection.DatabaseConnection;
import com.student.course.registration.portal.dto.CourseDto;
import com.student.course.registration.portal.dto.EnrollmentDto;
import com.student.course.registration.portal.dto.StudentDto;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDao {
    public void addEnrollment(EnrollmentDto enrollment){
        Connection conn = DatabaseConnection.getConnection();

        try {
            String sql = "INSERT INTO Enrollments (user_id, course_id) " +
                    "VALUES (?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, enrollment.getUserId());
            stmt.setInt(2, enrollment.getCourseId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding enrollment: " + e.getMessage());
            e.printStackTrace();
        }

    }

}
