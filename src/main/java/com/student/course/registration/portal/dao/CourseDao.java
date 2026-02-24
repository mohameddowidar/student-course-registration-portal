package com.student.course.registration.portal.dao;

import com.student.course.registration.portal.connection.DatabaseConnection;
import com.student.course.registration.portal.dto.CourseDto;
import com.student.course.registration.portal.dto.StudentDto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {

    public void addCourseDTO(CourseDto courseDto) {
        Connection conn = DatabaseConnection.getConnection();

        if (conn == null) {
            System.out.println("❌ فشل الاتصال بقاعدة البيانات!");
            return;
        }

        try {
            String sql = "INSERT INTO Courses (Course_name, Course_description, Course_hours, start_date,end_date,registration_deadline,available_seats, created_by, created_date) VALUES (?,?, ?,?, ?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, courseDto.getCourseName());
            stmt.setString(2, courseDto.getCourseDescription());
            stmt.setInt(3, courseDto.getCourseHour());
            stmt.setDate(4, courseDto.getStartDate());
            stmt.setDate(5, courseDto.getEndDate());
            stmt.setDate(6, courseDto.getRegistrationDeadline());
            stmt.setInt(7, courseDto.getAvailableSeats());
            stmt.setString(8, courseDto.getCreatedBy());
            stmt.setDate(9, Date.valueOf(LocalDate.now()));
            int rows = stmt.executeUpdate();
            System.out.println(" تم إضافة " + rows + " طالب بنجاح");

            stmt.close();

        } catch (Exception e) {
            System.out.println("❌ خطأ أثناء الإضافة: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }

    public List<CourseDto> getAllCourses() {
        Connection conn = DatabaseConnection.getConnection();
        List<CourseDto> courseDtos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Courses ORDER BY created_date desc ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CourseDto courseDto = new CourseDto(
                        rs.getInt("id"),
                        rs.getString("course_name"),
                        rs.getString("course_description"),
                        rs.getInt("course_hours"),
                        rs.getString("created_by"),
                        rs.getDate("registration_deadline"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date"),
                        rs.getInt("available_seats")
                );

                courseDtos.add(courseDto);

            }

            return courseDtos;

        } catch (Exception e) {
            System.out.println("❌ خطأ أثناء التحقق: " + e.getMessage());
            e.printStackTrace();
            return courseDtos;
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }
    public Integer getCoursesNumber( ) {
        Connection conn = DatabaseConnection.getConnection();

        try {
            String sql = "select count(*) as number_of_Courses from courses";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            Integer numberOfCourses = null;
            while (rs.next()) {
                numberOfCourses  = rs.getInt("number_of_Courses");
            }

            rs.close();
            stmt.close();
            return numberOfCourses;
        } catch (Exception e) {
            System.out.println("❌ خطأ أثناء التحقق: " + e.getMessage());
            e.printStackTrace();
            return 0;
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }
}
