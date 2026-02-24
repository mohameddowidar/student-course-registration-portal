package com.student.course.registration.portal.servlets;

import com.student.course.registration.portal.dto.StudentDto;
import com.student.course.registration.portal.service.StudentService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    StudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {


        String email = request.getParameter("email");
        String password = request.getParameter("password");

        StudentDto studentDto= new StudentDto(email, password);
        studentService.addStudentDto(studentDto);
        request.setAttribute("userEmail", email);
        request.setAttribute("message", "تم تسجيل المستخدم بنجاح ✅");

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }
}