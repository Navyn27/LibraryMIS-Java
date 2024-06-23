package com.navyn.librarymanagementsys.ServiceImpls;

import com.navyn.librarymanagementsys.Exceptions.ResourceNotFoundException;
import com.navyn.librarymanagementsys.Exceptions.UsernameNotFoundException;
import com.navyn.librarymanagementsys.Models.UserData;
import com.navyn.librarymanagementsys.Repositories.UserRepository;
import com.navyn.librarymanagementsys.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public List<UserData> findAll(){
        return userRepository.findAll();
    }

    @Override
    public List<UserData> findByRole(String role) {
        return userRepository.findByRole(role);
    }

    @Override
    public UserData save(UserData user){
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return userRepository.save(user);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserData> userData = userRepository.findByEmail(username);
        //Convert userData to UserDetails
        return userData.map(UserDataDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }

    public UserData loadCurrentUser(String username) throws UsernameNotFoundException {
        Optional<UserData> userDetail = userRepository.findByEmail(username);
        return userDetail
                .orElseThrow(() -> new UsernameNotFoundException("User not found " +
                        username));
    }
    public String addUser(UserData userData) {
        userData.setPassword(encoder.encode(userData.getPassword()));
        userRepository.save(userData);
        return "User Added Successfully";
    }


    @Override
    public void delete(Long id){
        userRepository.delete(id);
    }

    @Override
    public Optional<UserData> findById(Long id){
        UserData user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User does not exist"));
        return Optional.ofNullable(user);
    }
}
