
package com.example.userInfo.repository;

import com.example.userInfo.entity.Town;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TownRepository extends JpaRepository<Town, Long> {
    Optional<Town> findByPostcode(String postcode);
}
