package com.student.course.registration.portal.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/DB_REPO_V1";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "12345";

    public static Connection getConnection() {
        try {
            // حمّل الـ Driver الأول
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("✅ الاتصال نجح!");
            return conn;

        } catch (Exception e) {
            System.out.println("❌ خطأ في الاتصال: " + e.getMessage());
            e.printStackTrace(); // طبع التفاصيل كاملة
            return null;
        }
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("✅ الاتصال اتقفل");
            }
        } catch (Exception e) {
            System.out.println("❌ خطأ في إغلاق الاتصال: " + e.getMessage());
        }
    }
}