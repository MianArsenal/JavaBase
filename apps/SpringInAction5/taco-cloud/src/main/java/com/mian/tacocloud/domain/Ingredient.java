package com.mian.tacocloud.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RestResource(rel = "ingredient", path = "ingredient")
@Entity
public class Ingredient implements Serializable {

    private static final long serialVersionUID = 533575897835314217L;

    @Id
    private final String id;
    private final String name;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
