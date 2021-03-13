package com.big.knock.domain.service;

import com.big.knock.domain.dal.entity.HostProperty;
import com.big.knock.domain.dal.repository.HostPropertyRepository;
import com.big.knock.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostPropertyServiceImpl implements HostPropertyService{

    private final HostPropertyRepository hostPropertyRepository;

    @Autowired
    public HostPropertyServiceImpl(HostPropertyRepository hostPropertyRepository) {
        this.hostPropertyRepository = hostPropertyRepository;
    }

    public HostProperty addProperty(HostProperty hostProperty){
        // add Property to database
        return hostPropertyRepository.save(hostProperty);
    }

    public List<HostProperty> findAllHostedProperties(){
        // list all properties from database
        return hostPropertyRepository.findAll();
    }

    public HostProperty findHostPropertyById(String id) throws UserNotFoundException{
        // find Property By Id
        return hostPropertyRepository.findHostPropertyById(id).
                orElseThrow(() -> new UserNotFoundException("User by id" + id + " was not found"));
    }

   public ResponseEntity<HostProperty> updateProperty(String id, HostProperty hostPropertydetails){

        HostProperty hostProperty = hostPropertyRepository.findHostPropertyById(id)
           .orElseThrow(() -> new UserNotFoundException("Employee not exist with id :" + id));

        hostProperty.setAddress(hostPropertydetails.getAddress());
        hostProperty.setType(hostPropertydetails.getType());
        hostProperty.setPlace(hostPropertydetails.getPlace());
        hostProperty.setCapacity(hostPropertydetails.getCapacity());
        hostProperty.setLocality(hostPropertydetails.getLocality());
        hostProperty.setAmenities(hostPropertydetails.getAmenities());
        hostProperty.setSafety_amenities(hostPropertydetails.getSafety_amenities());
        hostProperty.setExtra_space(hostPropertydetails.getExtra_space());
        hostProperty.setPhoto_url(hostPropertydetails.getPhoto_url());
        hostProperty.setProperty_description(hostPropertydetails.getProperty_description());
        hostProperty.setProperty_rules(hostPropertydetails.getProperty_rules());
        hostProperty.setPrice(hostPropertydetails.getPrice());
        hostProperty.setStatus(hostPropertydetails.getStatus());

        HostProperty updatedHostProperty = hostPropertyRepository.save(hostProperty);
        // update property in database
        return ResponseEntity.ok(updatedHostProperty);
    }

    public void deleteProperty(String id){
        // permanently remove property from database
        hostPropertyRepository.deleteHostPropertyById(id);
    }

}
