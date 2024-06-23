package com.navyn.librarymanagementsys.Controllers;

import com.navyn.librarymanagementsys.Exceptions.UsernameNotFoundException;
import com.navyn.librarymanagementsys.Models.AuthRequest;
import com.navyn.librarymanagementsys.Models.UserData;
import com.navyn.librarymanagementsys.Payloads.Requests.User;
import com.navyn.librarymanagementsys.ServiceImpls.JwtService;
import com.navyn.librarymanagementsys.ServiceImpls.UserDataDetails;
import com.navyn.librarymanagementsys.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/add")
    public UserData addUsers(@RequestBody UserData user){
        return userService.save(user);
    }

    @GetMapping("/{role}")
    public List<UserData> getUserByRole(@PathVariable String role){
        return userService.findByRole(role);
    }

    @GetMapping("/id/{id}")
    public Optional<UserData> getUserById(@PathVariable Long id){
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

    @GetMapping("/admin/list")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UserData> getAllUsers(){
        return userService.findAll();
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        System.out.println(authRequest.getUsername());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
//            UserDataDetails userData=(UserDataDetails) authentication.getPrincipal();
            return jwtService.generateToken(authRequest.getUsername(),"ADMIN");
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
