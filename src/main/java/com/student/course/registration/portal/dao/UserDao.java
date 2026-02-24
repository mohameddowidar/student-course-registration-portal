package com.student.course.registration.portal.dao;

import com.student.course.registration.portal.connection.DatabaseConnection;
import com.student.course.registration.portal.dto.StudentDto;
import com.student.course.registration.portal.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public void addUserDTO(UserDto userDto) {
        Connection conn = DatabaseConnection.getConnection();

        if (conn == null) {
            System.out.println("❌ فشل الاتصال بقاعدة البيانات!");
            return;
        }

        try {
            String sql = "INSERT INTO USERS (first_name, last_name,user_role,email, password ) VALUES (?, ?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, userDto.getFirstName());
            stmt.setString(2, userDto.getLastName());
            stmt.setString(3, userDto.getRole());
            stmt.setString(4, userDto.getEmail());
            stmt.setString(5, userDto.getPassword());
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
    public boolean isUserExists(UserDto userDto) {
        Connection conn = DatabaseConnection.getConnection();

        try {
            String sql = "SELECT * FROM USERS WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, userDto.getEmail());
            stmt.setString(2, userDto.getPassword());

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
    public UserDto getUserByEmail (String email) {
        Connection conn = DatabaseConnection.getConnection();
        List<UserDto> userDtos = new ArrayList<>();
        UserDto userDto = null;
        try {
            String sql = "SELECT * FROM USERS WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                userDto = new UserDto(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("user_role"),
                        rs.getInt("user_id")
                );
            }

            return userDto;

        } catch (Exception e) {
            System.out.println("❌ خطأ أثناء التحقق: " + e.getMessage());
            e.printStackTrace();
            return userDto;
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }
    public List<UserDto> getAllUser() {
        Connection conn = DatabaseConnection.getConnection();
        List<UserDto> userDtos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM USERS";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                UserDto userDto = new UserDto(
                        rs.getString("first_name"),
                        rs.getString("user_role"),""
                );
                userDtos.add(userDto);

            }

            return userDtos;

        } catch (Exception e) {
            System.out.println("❌ خطأ أثناء التحقق: " + e.getMessage());
            e.printStackTrace();
            return userDtos;
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }
    public Integer getUsersNumber( ) {
        Connection conn = DatabaseConnection.getConnection();

        try {
            String sql = "select count(*) as number_of_users from USERS";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            Integer numberOfUsers = null;
            while (rs.next()) {
                 numberOfUsers  = rs.getInt("number_of_users");
            }

            rs.close();
            stmt.close();

            return numberOfUsers;

        } catch (Exception e) {
            System.out.println("❌ خطأ أثناء التحقق: " + e.getMessage());
            e.printStackTrace();
            return 0;
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }
    public Integer getStudentsNumber( ) {
        Connection conn = DatabaseConnection.getConnection();

        try {
            String sql = "select count(*) as number_of_users from USERS where user_role =  'STUDENT' ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            Integer numberOfUsers = null;
            while (rs.next()) {
                numberOfUsers  = rs.getInt("number_of_users");
            }

            rs.close();
            stmt.close();

            return numberOfUsers;

        } catch (Exception e) {
            System.out.println("❌ خطأ أثناء التحقق: " + e.getMessage());
            e.printStackTrace();
            return 0;
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }
}
