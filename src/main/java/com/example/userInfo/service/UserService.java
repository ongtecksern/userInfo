
package com.example.userInfo.service;

import com.example.userInfo.entity.Town;
import com.example.userInfo.entity.UserInformation;
import com.example.userInfo.repository.TownRepository;
import com.example.userInfo.repository.UserInformationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInformationRepository userInformationRepository;

    @Autowired
    private TownRepository townRepository;

    public Optional<String> getTownByPostcode(String postcode) {
        return townRepository.findByPostcode(postcode).map(Town::getTown);
    }
    
    public Optional<String> getICByUser(String icNumber) {
        return userInformationRepository.findByIcNumber(icNumber).map(UserInformation::getIcNumber);
    }
    
    public List<UserInformation> getAllUsers() {
        return (List<UserInformation>) userInformationRepository.findAll();
    }

    public UserInformation saveUser(UserInformation user) {        
        return userInformationRepository.save(user);                  
    }
    
    public Optional<UserInformation> getUserById(Long id) {
        return userInformationRepository.findById(id);
    }
    
    public void deleteUser(Long id) {
        userInformationRepository.deleteById(id);
    }
}
