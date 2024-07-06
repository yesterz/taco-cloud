package com.yesterz.taco_cloud.web;

import java.util.Map;
import java.util.HashMap;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.yesterz.taco_cloud.Ingredient;
import com.yesterz.taco_cloud.Ingredient.Type;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("FLTO", 
            new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
        ingredientMap.put("COTO", 
            new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
        ingredientMap.put("CRBF", 
            new Ingredient("CRBF", "Ground Beef", Type.PROTEIN));
        ingredientMap.put("CARN", 
            new Ingredient("CARN", "Carnitas", Type.PROTEIN));
        ingredientMap.put("TMTO", 
            new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
        ingredientMap.put("LETC", 
            new Ingredient("LETC", "Lettuce", Type.VEGGIES));
        ingredientMap.put("CHED", 
            new Ingredient("CHED", "Cheddar", Type.CHEESE));
        ingredientMap.put("JACK", 
            new Ingredient("JACK", "Monterrey Jack", Type.SAUCE));
        ingredientMap.put("SLSA", 
                new Ingredient("SLSA", "Salsa", Type.SAUCE));
        ingredientMap.put("SRCR", 
            new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }

}
