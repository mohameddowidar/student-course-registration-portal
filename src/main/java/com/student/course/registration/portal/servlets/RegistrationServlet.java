package com.student.course.registration.portal.servlets;

import com.student.course.registration.portal.dto.CourseDto;
import com.student.course.registration.portal.dto.EnrollmentDto;
import com.student.course.registration.portal.service.CourseServices;
import com.student.course.registration.portal.service.EnrollmentServices;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    EnrollmentServices enrollmentServices = new EnrollmentServices();
    CourseServices courseServices = new CourseServices();


    @Override
    protected void doGet(HttpServletRequest request,

                         HttpServletResponse response)
            throws IOException, ServletException {
        List<CourseDto> courseDtoList = courseServices.getCourses();
        request.setAttribute("courseList", courseDtoList);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/resources/pages/register.jsp");

        dispatcher.forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Integer userId = (Integer) session.getAttribute("userId");
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        EnrollmentDto enrollmentDto = new EnrollmentDto(userId,courseId);
        enrollmentServices.addEnrollment(enrollmentDto);
        response.sendRedirect(request.getContextPath()+"/registration");
    }
}

