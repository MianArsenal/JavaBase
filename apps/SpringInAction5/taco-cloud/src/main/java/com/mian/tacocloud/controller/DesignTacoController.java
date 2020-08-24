package com.mian.tacocloud.controller;

import com.mian.tacocloud.domain.Ingredient;
import com.mian.tacocloud.domain.Order;
import com.mian.tacocloud.domain.Taco;
import com.mian.tacocloud.repository.IngredientRepository;
import com.mian.tacocloud.repository.TacoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;
    private final TacoRepository tacoRepository;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository, TacoRepository tacoRepository) {
        this.ingredientRepository = ingredientRepository;
        this.tacoRepository = tacoRepository;
    }

    @PostMapping
    public String processDesign(@Valid Taco myTaco, Errors errors, RedirectAttributes attributes, @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            log.info(errors.toString());
            attributes.addAttribute("validatedResult", buildValidatedResult(errors));
            return "redirect:/design";
        }
        Taco savedTaco = this.tacoRepository.save(myTaco);
        order.getTacos().add(savedTaco);
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
        List<Ingredient> ingredients = new ArrayList<>();
        this.ingredientRepository.findAll().forEach(ingredients::add);
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

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }
}
