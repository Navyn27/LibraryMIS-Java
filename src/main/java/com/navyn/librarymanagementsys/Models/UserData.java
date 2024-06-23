package com.navyn.librarymanagementsys.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import com.navyn.librarymanagementsys.Enums.UserRole;
import lombok.NoArgsConstructor;

@Entity(name="user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserId;

    private String firstName;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String email;
    private String password;

    public String getRole() {
        return role.toString();
    }
}
