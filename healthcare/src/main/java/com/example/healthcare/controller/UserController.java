package com.example.healthcare.controller;
import com.example.healthcare.Status;
import com.example.healthcare.dao.UserRepository;
import com.example.healthcare.entities.User;
//import com.example.healthcare.service.PatientService;
import com.example.healthcare.service.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("User")
public class UserController {
    private static final Logger roles = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    UserRepository userRepository;
    //private PatientService patientService;

//    @GetMapping("/welcome")
//    public String user(){
//
//        return ("<h1> Welcome User</h1>");
//    }

    @ApiOperation("Add a new  User")
    @PostMapping("/register")
    public ResponseEntity<User> regsiterUser(@Valid @RequestBody User user) {
        User userNew = userService.addUser(user);
        log.info("Added a new User");
        return new ResponseEntity<>(userNew, HttpStatus.CREATED);
    }

//    @PostMapping("/login")
//    public ResponseEntity<User> validateUser(@Valid @RequestBody String userName, String password) {
////        log.info(userName+" "+password);
//        User user = userService.validateUser(userName, password);
////        log.info(String.valueOf(user));
////        log.info("this is logger");
////        user.setUsername(userName);
////        user.setPassword(password);
////        user.setRole("Admin");
//
////        userService.addUser(user);
////        log.info(String.valueOf(user));
////        log.info(userService.listUsers());
//        if (user != null){
//            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
//        }
//
//       else{
//        log.info(userService.listUsers());
//
//            return new ResponseEntity<>(user, HttpStatus.FORBIDDEN);
//       }
//
//    }


    @PostMapping("/login")
    public ResponseEntity<List<User>> loginUser(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();
        for (User other : users) {
            log.info(String.valueOf(other));
            String name=other.getUsername();
            String pass= other.getPassword();
            if (name.equals(user.getUsername()) && pass.equals(user.getPassword())) {
                userRepository.save(user);
                ResponseEntity<List<User>> listResponseEntity = new ResponseEntity<>(users, HttpStatus.ACCEPTED);
                return listResponseEntity;
            }
        }
        return new ResponseEntity<>(users, HttpStatus.FORBIDDEN);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<User> removeUser(@RequestBody User user) {
        User userRemoved = userService.removeUser(user);
        if (userRemoved != null)
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(user, HttpStatus.FORBIDDEN);
    }
}
