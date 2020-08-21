package com.mian.tacocloud.controller;

import com.mian.tacocloud.domain.Ingredient;
import com.mian.tacocloud.domain.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    @PostMapping
    public String processDesign(@Valid Taco myTaco, Errors errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            log.info(errors.toString());
            attributes.addAttribute("validatedResult", buildValidatedResult(errors));
            return "redirect:/design";
        }
        log.info("Processing design: " + myTaco);
        return "redirect:/orders/current";
    }

    private List<String> buildValidatedResult(Errors errors) {
        List<String> validatedResult = new ArrayList<>(errors.getAllErrors().size());
        for (ObjectError error : errors.getAllErrors()) {
            validatedResult.add(error.getDefaultMessage());
        }
        return validatedResult;
    }

    @GetMapping
    public String showDesignForm(Model model, @RequestParam(required = false) List<String> validatedResult) {
        if (!CollectionUtils.isEmpty(validatedResult)) {
            model.addAttribute("validatedResult", validatedResult);
        }
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        );
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("myTaco", new Taco());
        return "design";
    }

    private Object filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }

}
