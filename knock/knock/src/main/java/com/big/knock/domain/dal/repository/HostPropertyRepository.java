package com.big.knock.domain.dal.repository;

import com.big.knock.domain.dal.entity.HostProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface HostPropertyRepository extends JpaRepository<HostProperty, String> {


    Optional<HostProperty> findHostPropertyById(String id);

    void deleteHostPropertyById(String id);
}
