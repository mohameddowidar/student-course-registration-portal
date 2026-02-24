package com.student.course.registration.portal.dao;

import com.student.course.registration.portal.connection.DatabaseConnection;
import com.student.course.registration.portal.dto.StudentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDao {

    public void addStudentDTO(StudentDto studentDto) {
        Connection conn = DatabaseConnection.getConnection();

        if (conn == null) {
            System.out.println("❌ فشل الاتصال بقاعدة البيانات!");
            return;
        }

        try {
            String sql = "INSERT INTO students (email, password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentDto.getEmail());
            stmt.setString(2, studentDto.getPassword());

            int rows = stmt.executeUpdate();
            System.out.println("✅ تم إضافة " + rows + " طالب بنجاح");

            stmt.close();

        } catch (Exception e) {
            System.out.println("❌ خطأ أثناء الإضافة: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }
    public boolean isStudentExists(StudentDto studentDto) {
        Connection conn = DatabaseConnection.getConnection();

        try {
            String sql = "SELECT * FROM students WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentDto.getEmail());
            stmt.setString(2, studentDto.getPassword());

            ResultSet rs = stmt.executeQuery();

            boolean exists = rs.next();

            rs.close();
            stmt.close();

            return exists;

        } catch (Exception e) {
            System.out.println("❌ خطأ أثناء التحقق: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }

}
