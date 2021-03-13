package com.big.knock.domain.service;

import com.big.knock.domain.dal.entity.HostProperty;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HostPropertyService {

    HostProperty addProperty(HostProperty hostProperty);

    List<HostProperty> findAllHostedProperties();

    HostProperty findHostPropertyById(String id);

    ResponseEntity<HostProperty> updateProperty(String id, HostProperty hostPropertydetails);

    void deleteProperty(String id);
}
