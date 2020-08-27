package com.mian.tacocloud.repository.jpa;

import com.mian.tacocloud.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface JpaIngredientRepository extends CrudRepository<Ingredient, String> {
}
