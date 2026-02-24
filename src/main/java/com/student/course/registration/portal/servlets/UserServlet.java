package com.student.course.registration.portal.servlets;

import com.student.course.registration.portal.dto.UserDto;
import com.student.course.registration.portal.service.UsersServices;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    UsersServices userServices = new UsersServices();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException, ServletException {
        List<UserDto> userDtos = userServices.getAllUsers();
        request.setAttribute("UsersList", userDtos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("resources/pages/users.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String role = request.getParameter("user_role");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserDto userDto = new UserDto(firstName, lastName, role, email, password);
        userServices.addUser(userDto);
        response.sendRedirect("users");

    }
}
