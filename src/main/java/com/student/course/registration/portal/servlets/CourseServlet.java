package com.student.course.registration.portal.servlets;

import com.student.course.registration.portal.dto.CourseDto;
import com.student.course.registration.portal.service.CourseServices;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/courses")
public class CourseServlet extends HttpServlet {
    CourseServices courseServices = new CourseServices();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException, ServletException {
        List<CourseDto> courseDtoList = courseServices.getCourses();
        request.setAttribute("courseList", courseDtoList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("resources/pages/courses.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String courseName = request.getParameter("name");
        String courseDescripition = request.getParameter("desc");
        String courseHoursStr = request.getParameter("hours");
        int courseHoursObj = Integer.parseInt(courseHoursStr);
        String availableSeats = request.getParameter("available_seats");
        int availableSeatsObj = Integer.parseInt(availableSeats);
        String registrationDeadline = request.getParameter("registration_deadline");
        String startDate = request.getParameter("start_date");
        String endDate = request.getParameter("end_date");
        java.sql.Date startDateObj = java.sql.Date.valueOf(startDate);
        java.sql.Date endDateObj = java.sql.Date.valueOf(endDate);
        java.sql.Date registrationDeadlineObj = java.sql.Date.valueOf(registrationDeadline);
        String createdBy = request.getParameter("created_by");

        CourseDto courseDto = new CourseDto(courseName, courseDescripition, courseHoursObj, createdBy,
                registrationDeadlineObj, startDateObj, endDateObj, availableSeatsObj);
        courseServices.addCourse(courseDto);
        response.sendRedirect("courses");

    }
}

