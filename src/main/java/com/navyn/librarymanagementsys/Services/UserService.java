package com.navyn.librarymanagementsys.Services;

import com.navyn.librarymanagementsys.Models.UserData;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserData> findAll();
    List<UserData> findByRole(String role);

    UserData save(UserData user);
    void delete(Long id);
    Optional<UserData> findById(Long id);

    UserDetails loadUserByUsername(String username);

    UserData loadCurrentUser(String username);
}
