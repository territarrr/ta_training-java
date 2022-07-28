package com.epam.training.sofiia_uchitel.collections.main_task;

import com.epam.training.sofiia_uchitel.collections.main_task.comparator.IngredientsVegetableFatsComporator;
import com.epam.training.sofiia_uchitel.collections.main_task.exceptions.SaladException;

import java.util.ArrayList;
import java.util.Collections;

public class Salad {
    private final String name;
    private String recipe="";
    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    public Salad(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCookingActionToRecipe(String item) {
        recipe += item;
    }

    public void addIngredient(Ingredient ingredient) throws SaladException {
        if (ingredient.getVegetable().isPrepared()) {
            addCookingActionToRecipe("Ингредиент " + ingredient.getVegetable().getName() + " уже готов к добавлению.\n");
            ingredients.add(ingredient);
        } else {
            addCookingActionToRecipe(ingredient.getVegetable().prepare());
            ingredients.add(ingredient);
        }
        addCookingActionToRecipe("Ингредиент " + ingredient.getVegetable().getName() + " добавляем в салат " + getName() + ".\n");
    }

    //Подсчитать калорийность всего салата
    public double getCalories() {
        double sumCalories = 0;
        for (Ingredient ingredient :
                ingredients) {
            sumCalories += ingredient.getCalories();
        }
        return sumCalories;
    }

    //Провести сортировку овощей (без учета веса) для салата на основе жиров по возрастанию
    public String getIngredientsByFats() {
        Collections.sort(ingredients, new IngredientsVegetableFatsComporator());
        return ingredients.toString();
    }

    //Найти овощи в салате, соответствующие заданному диапазону калорийности.
    public String getIngredientsByCaloriesInRange(double startCalorie, double endCalorie) {
        ArrayList<Ingredient> ingredientInCaloriesRange = new ArrayList<>();
        for (Ingredient ingredient:
             ingredients) {
            if(ingredient.getVegetable().getCalories()>=startCalorie && ingredient.getVegetable().getCalories()<=endCalorie)
                ingredientInCaloriesRange.add(ingredient);
        }
        return ingredientInCaloriesRange.toString();
    }

    @Override
    public String toString() {
        return "Салат '" + name + '\'' +
                ". Ингредиенты: " + ingredients + "\nРецепт:\n" + recipe;
    }
}
