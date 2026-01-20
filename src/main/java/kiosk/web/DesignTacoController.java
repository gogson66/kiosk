package kiosk.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import kiosk.Ingredient;
import kiosk.Order;
import kiosk.Ingredient.Type;
import kiosk.data.IngredientRepository;
import kiosk.data.TacoRepository;
import kiosk.Taco;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;
    private final TacoRepository tacoRepository;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository tacoRepository) {
        this.ingredientRepo = ingredientRepo;
        this.tacoRepository = tacoRepository;
    }

    @ModelAttribute(name = "order")
    public Order order () {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model) {

        return "design";
    }

    @PostMapping
    public String processDesign(@Valid @ModelAttribute("taco") Taco taco, Errors errors, @ModelAttribute Order order) {

        log.info("Message is here: " + errors.hasErrors() + errors.toString());

        if (errors.hasErrors()) {
            return "design";
        } 

        log.info("Processing design:" + taco);
        Taco saved = tacoRepository.save(taco);
        System.out.println("TACO: " + saved);
        order.addDesign(saved);
        log.info("after adding design" + order.getTacos());
        

        return "redirect:/orders/current";

    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {

        return ingredients.stream().filter((ingredient) -> ingredient.getType().equals(type)).collect(Collectors.toList());


    }
    
    @ModelAttribute
    public void addIngredients(Model model) {

        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(ingredient -> ingredients.add(ingredient));


    for (Type type : Ingredient.Type.values()) {
        model.addAttribute(
            type.toString().toLowerCase(),
            filterByType(ingredients, type)
        );
    }
}



    
}


