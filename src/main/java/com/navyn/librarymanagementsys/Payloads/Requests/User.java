package com.navyn.librarymanagementsys.Payloads.Requests;

import lombok.Data;

@Data
public class User {
    private Long UserId;
    private String firstName;
    private String role;
    private String email;
    private String password;
}
