package com.mian.tacocloud.domain;

import lombok.Data;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Must exist name")
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;
    @NotNull(message = "You must choose at least 1 ingredient")
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    @ManyToMany(targetEntity = Ingredient.class)
    @JoinTable(name = "Taco_Ingredients",
            joinColumns = {@JoinColumn(name = "taco")},
            inverseJoinColumns = {@JoinColumn(name = "ingredient")},
            foreignKey = @ForeignKey(name = "taco"),
            inverseForeignKey = @ForeignKey(name = "ingredient"))
    private List<Ingredient> ingredients;
    @Column(name = "createdAt")
    private Date createdAt;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

    public void setIngredients(String ingredientStr) {
        if (StringUtils.isEmpty(ingredientStr)) {
            return;
        }
        if (CollectionUtils.isEmpty(this.ingredients)) {
            this.ingredients = new ArrayList<>();
        }
        ingredientStr = ingredientStr.substring(ingredientStr.indexOf("(") + 1, ingredientStr.lastIndexOf(")"));
        String[] splitIngredients = ingredientStr.split("\\),Ingredient\\(");
        for (String splitIngredient : splitIngredients) {
            String[] splitArray = splitIngredient.split(", ");
            this.ingredients.add(new Ingredient(
                    splitArray[0].split("=")[1],
                    splitArray[1].split("=")[1],
                    Ingredient.Type.valueOf(splitArray[2].split("=")[1])));
        }
    }
}
