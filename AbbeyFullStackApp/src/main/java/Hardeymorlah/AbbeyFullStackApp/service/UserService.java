package Hardeymorlah.AbbeyFullStackApp.service;

import Hardeymorlah.AbbeyFullStackApp.config.AccountConfiguration;
import Hardeymorlah.AbbeyFullStackApp.model.DTOs.LoginRequest;
import Hardeymorlah.AbbeyFullStackApp.model.DTOs.LoginResponse;
import Hardeymorlah.AbbeyFullStackApp.model.User;
import Hardeymorlah.AbbeyFullStackApp.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class UserService {
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final AccountConfiguration accountConfiguration;

    public UserService(UserRepository userRepository, JWTService jwtService, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, AccountConfiguration accountConfiguration) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.accountConfiguration = accountConfiguration;
    }

    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<User> findUserById(long id) {
        return new ResponseEntity<>(userRepository.findById(id).orElseThrow(), HttpStatus.OK);
    }

    public ResponseEntity<User> findUserByUsername(String username) {
        return new ResponseEntity<>(userRepository.findByUsername(username), HttpStatus.OK);
    }
    public ResponseEntity<LoginResponse> authenticate(LoginRequest request) {

        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));


        if( auth != null ){
            User user = userRepository.findByUsername(request.getUsername());
            System.out.println(user);
            String token = jwtService.createToken(user);
            System.out.println(token);
            return new ResponseEntity<>(LoginResponse.builder().user(user).token(token).build(), HttpStatus.OK);
        } else {
            System.out.println("auth is null");
        }

        return null;
    }


    public ResponseEntity<User> createNewUser(User user) {
        passwordEncoder = accountConfiguration.passwordEncoder();
        user.setUsername(user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    public ResponseEntity<User> updateUser(long id, User updatedUser) {
        User existingUser = userRepository.findById(id).orElseThrow();
        existingUser.setUsername(updatedUser.getUsername());
        return new ResponseEntity<>(userRepository.save(existingUser), HttpStatus.ACCEPTED);
    }
    public ResponseEntity<User> deleteUser(long id) {
        User deletedUser = userRepository.findById(id).orElseThrow();
        userRepository.deleteById(id);
        return new ResponseEntity<>(deletedUser, HttpStatus.OK);


    }
}