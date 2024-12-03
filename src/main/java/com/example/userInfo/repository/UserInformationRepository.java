
package com.example.userInfo.repository;

import com.example.userInfo.entity.UserInformation;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserInformationRepository extends CrudRepository<UserInformation, Long> {
    Optional<UserInformation> findByIcNumber(String icNumber);
}
