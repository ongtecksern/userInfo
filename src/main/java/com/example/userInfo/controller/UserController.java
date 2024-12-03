
package com.example.userInfo.controller;

import com.example.userInfo.entity.UserInformation;
import com.example.userInfo.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<UserInformation> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserInformation> getEmployeeById(@PathVariable Long id) {
        Optional<UserInformation> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/town")
    public ResponseEntity<String> getTownByPostcode(@RequestParam("postcode") String postcode) {
        Optional<String> town = userService.getTownByPostcode(postcode);
        return town.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody UserInformation user) {
                
        Optional<String> town = userService.getTownByPostcode(user.getPostcode());
        Optional<String> userIC = userService.getICByUser(user.getIcNumber());
        if (town.isPresent()) {
            user.setTown(town.get());
        } else {
            return ResponseEntity.badRequest().body("Invalid postcode.");
        }
        
        if (userIC.isPresent()) {
            return ResponseEntity.badRequest().body("This user is found in database");
        } else {
            userService.saveUser(user);
            return ResponseEntity.ok("Data saved successfully.");
        }        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    
    
    
}
