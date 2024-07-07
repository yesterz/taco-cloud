package com.yesterz.taco_cloud;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yesterz.taco_cloud.data.IngredientRef;

import lombok.Data;

@Data
public class Taco {

  private Long id;

  private Date createAt = new Date();

  @NotNull
  @Size(min = 5, message = "Name must be at least 5 characters long")
  private String name;

  @Size(min = 1, message = "You must choose at least 1 ingredient")
  private List<IngredientRef> ingredients = new ArrayList<>(null);

  public void addIngredient(Ingredient taco) {
    this.ingredients.add(new IngredientRef(taco.getId()));
  }
}
