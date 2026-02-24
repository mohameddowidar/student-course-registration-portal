package com.student.course.registration.portal.servlets;

import com.student.course.registration.portal.dto.CourseDto;
import com.student.course.registration.portal.service.CourseServices;
import com.student.course.registration.portal.service.UsersServices;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    CourseServices courseServices = new CourseServices();
    UsersServices usersServices = new UsersServices();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException, ServletException {
        Integer coursesNumber  = courseServices.getNumberOfCourses();
        Integer usersNumber = usersServices.getUsersNumber();
        Integer studentsNumber = usersServices.getStudentsNumber();
        request.setAttribute("coursesNumber", coursesNumber);
        request.setAttribute("usersNumber", usersNumber);
        request.setAttribute("studentsNumber", studentsNumber);
        RequestDispatcher dispatcher = request.getRequestDispatcher("resources/pages/dashboard.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

    }
}

