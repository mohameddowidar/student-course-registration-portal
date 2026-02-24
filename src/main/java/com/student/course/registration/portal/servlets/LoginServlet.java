package com.student.course.registration.portal.servlets;

import com.student.course.registration.portal.dto.UserDto;
import com.student.course.registration.portal.service.UsersServices;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UsersServices userServices = new UsersServices();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("resources/pages/login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserDto userDto = new UserDto(email, password);
        if (userServices.isUserExists(userDto)) {
            UserDto userDtoSession = userServices.getUserByEmail(email);
            HttpSession session = request.getSession();
            session.setAttribute("userEmail", email);
            session.setAttribute("firstName", userDtoSession.getFirstName());
            session.setAttribute("lastName", userDtoSession.getLastName());
            session.setAttribute("userRole", userDtoSession.getRole());
            session.setAttribute("userId", userDtoSession.getUserId());
            response.sendRedirect(request.getContextPath() + "/dashboard");
        } else {
            request.setAttribute("message", "this user does not exist in our system");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("resources/pages/login.jsp");
            requestDispatcher.forward(request, response);
        }

    }
}