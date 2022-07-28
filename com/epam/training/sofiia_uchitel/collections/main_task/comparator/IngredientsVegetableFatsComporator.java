package com.epam.training.sofiia_uchitel.collections.main_task.comparator;

import com.epam.training.sofiia_uchitel.collections.main_task.Ingredient;

import java.util.Comparator;

//Компоратор для овощей в составе салата без учета веса
public class IngredientsVegetableFatsComporator implements Comparator<Ingredient> {

    @Override
    public int compare(Ingredient ingredient1, Ingredient ingredient2) {
        return Double.compare(ingredient1.getVegetable().getFats(), ingredient2.getVegetable().getFats());
    }
}
