package com.mian.tacocloud.demo.api;

import com.mian.tacocloud.domain.Ingredient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ConsumeRestfulApiByRestTemplateDemo {

    private RestTemplate restTemplate = new RestTemplate();

    public Ingredient getIngredientByIdV0(String ingredientId) {
        return this.restTemplate.getForObject("http://localhost:8080/ingredients/{id}",
                Ingredient.class, ingredientId);
    }

    public Ingredient getIngredientByIdV1(String ingredientId) {
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("id", ingredientId);
        return this.restTemplate.getForObject("http://localhost:8080/ingredients/{id}",
                Ingredient.class,
                urlVariables);
    }

    public Ingredient getIngredientByIdV2(String ingredientId) {
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("id", ingredientId);
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/ingredients/{id}")
                .build(urlVariables);
        return this.restTemplate.getForObject(url, Ingredient.class);
    }

    public Ingredient getIngredientByIdV3(String ingredientId) {
        ResponseEntity<Ingredient> responseEntity = this.restTemplate.getForEntity(
                "http://localhost:8080/ingredients/{id}",
                Ingredient.class, ingredientId);
        log.info("Fetched time: " + responseEntity.getHeaders().getDate());
        return responseEntity.getBody();
    }

    public void deleteIngredient(Ingredient ingredient) {
        this.restTemplate.delete("http://localhost:8080/ingredients/{id}",
                ingredient.getId());
    }

    public Ingredient createIngredientV0(Ingredient ingredient) {
        return this.restTemplate.postForObject("http://localhost:8080/ingredients",
                ingredient,
                Ingredient.class);
    }

    public URI createIngredientV1(Ingredient ingredient) {
        return this.restTemplate.postForLocation("http://localhost:8080/ingredients",
                ingredient);
    }

    public Ingredient createIngredientV2(Ingredient ingredient) {
        ResponseEntity<Ingredient> responseEntity = this.restTemplate.postForEntity(
                "http://localhost:8080/ingredients",
                ingredient,
                Ingredient.class
        );
        log.info("New resource created at " + responseEntity.getHeaders().getLocation());
        return responseEntity.getBody();
    }
}
