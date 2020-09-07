package com.mian.tacocloud.domain;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Taco_Order")
public class Order implements Serializable {

    private static final long serialVersionUID = 9211045199234584443L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is required")
    private String orderName;
    @NotBlank(message = "Street is required")
    private String street;
    @NotBlank(message = "City is required")
    private String city;
    @NotBlank(message = "State is required")
    private String state;
    @NotBlank(message = "Zip is required")
    private String zip;
    @CreditCardNumber(message = "Not a valid credit card number, sample:5105105105105100")
    private String ccNumber;
    @Pattern(regexp = "^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)| {10}(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$",
            message = "Must be formatted yyyy-MM-dd, sample:2020-08-20")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV, sample:123")
    private String ccCvv;
    private Date placedAt;
    @ManyToMany(targetEntity = Taco.class)
    @JoinTable(name = "Taco_Order_Tacos",
            joinColumns = {@JoinColumn(name = "tacoOrder")},
            inverseJoinColumns = {@JoinColumn(name = "taco")},
            foreignKey = @ForeignKey(name = "tacoOrder"),
            inverseForeignKey = @ForeignKey(name = "taco"))
    List<Taco> tacos = new ArrayList<>();

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }

}
