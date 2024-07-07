package com.yesterz.taco_cloud.data;

import java.util.Optional;

import com.yesterz.taco_cloud.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);

}
