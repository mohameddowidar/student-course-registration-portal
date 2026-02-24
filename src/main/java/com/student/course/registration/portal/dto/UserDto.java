    package com.student.course.registration.portal.dto;

    public class UserDto {
        private int userId;
        private String firstName;
        private String lastName;
        private String role;

        private String email;
        private String password;

        public UserDto(int id, String firstName, String lastNAme, String role, String email, String password) {
            this.userId = id;
            this.firstName = firstName;
            this.lastName = lastNAme;
            this.role = role;
            this.email = email;
            this.password = password;
        }
        public UserDto(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public UserDto(String firstName, String lastName, String role, String email, String password) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.role = role;
            this.email = email;
            this.password = password;
        }

        public UserDto(String firstName,String lastName,  String role){
            this.firstName =firstName ;
            this.role = role;
        }

        public UserDto(String firstName, String lastName, String userRole, int userId) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.role = userRole;
            this.userId = userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getUserId() {
            return userId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String fristNAme) {
            this.firstName = fristNAme;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastNAme) {
            this.lastName = lastNAme;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
