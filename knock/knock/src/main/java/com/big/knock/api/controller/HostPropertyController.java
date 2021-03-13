package com.big.knock.api.controller;

import com.big.knock.domain.dal.entity.HostProperty;
import com.big.knock.domain.service.HostPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/knock/")
public class HostPropertyController {

    public final HostPropertyService hostPropertyService;

    @Autowired
    public HostPropertyController(HostPropertyService hostPropertyService) {
        this.hostPropertyService = hostPropertyService;
    }

    @GetMapping(path = "/property")
    public ResponseEntity<List<HostProperty>> getAllHostedProperties(){
        List<HostProperty> properties = hostPropertyService.findAllHostedProperties();
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

    @GetMapping(path = "/property/{id}")
    public ResponseEntity<HostProperty> getHostPropertyById(@PathVariable("id") String id){
        HostProperty property = hostPropertyService.findHostPropertyById(id);
        return new ResponseEntity<>(property, HttpStatus.OK);
    }

    @PostMapping(path = "/property")
    public ResponseEntity<HostProperty> addProperty(@Valid @RequestBody HostProperty hostProperty){
        HostProperty newProperty = hostPropertyService.addProperty(hostProperty);
        return new ResponseEntity<>(newProperty, HttpStatus.CREATED);
    }

    @PutMapping(path = "/property/{id}")
    public ResponseEntity<HostProperty> updateProperty(@PathVariable("id") String id, @RequestBody HostProperty hostPropertydetails){
        return hostPropertyService.updateProperty(id, hostPropertydetails);
    }

    @DeleteMapping(path = "/property/{id}")
    public ResponseEntity<?> deleteProperty(@PathVariable("id") String id){
        hostPropertyService.deleteProperty(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
