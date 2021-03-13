package com.big.knock.domain.dal.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "property")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class HostProperty extends ModelBase{

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "place", nullable = false)
    private String place;

    @Column(name = "capacity", nullable = false)
    //@Size(min = 1, max = 50, message = "Invalid price entered")
    private String capacity;

    @Column(name = "locality", nullable = false)
    private String locality;

    @Column(name = "amenities", nullable = false)
    private String amenities;

    @Column(name = "safety_amenities", nullable = false)
    private String safety_amenities;

    @Column(name = "extra_space", nullable = false)
    private String extra_space;

    @Column(name = "photo_url", nullable = false)
    private String photo_url;

    @Column(name = "property_description", nullable = false)
    private String property_description;

    @Column(name = "property_rules", nullable = false)
    private String property_rules;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "status", nullable = false)
    //@Size(min = 1, max = 1, message = "Invalid status length")
    private int status;
/*
    public HostProperty(String id, Date date_created, String address, String type, String place, String capacity, String locality, String amenities, String safety_amenities, String extra_space, String photo_url, String property_description, String property_rules, String price, int status) {
        super(id, date_created);
        this.address = address;
        this.type = type;
        this.place = place;
        this.capacity = capacity;
        this.locality = locality;
        this.amenities = amenities;
        this.safety_amenities = safety_amenities;
        this.extra_space = extra_space;
        this.photo_url = photo_url;
        this.property_description = property_description;
        this.property_rules = property_rules;
        this.price = price;
        this.status = status;
    }
    
 */
}
