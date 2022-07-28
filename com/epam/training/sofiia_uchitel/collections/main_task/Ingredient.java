package com.epam.training.sofiia_uchitel.collections.main_task;
import com.epam.training.sofiia_uchitel.collections.main_task.exceptions.SaladException;
import com.epam.training.sofiia_uchitel.collections.main_task.vеgetables.Vegetable;

public class Ingredient {
    private Vegetable vegetable;
    private int weightInG;

    public Ingredient(Vegetable vegetable, int weightInG) throws SaladException {
        setVegetable(vegetable);
        setWeightInG(weightInG);
    }

    public Vegetable getVegetable() {
        return vegetable;
    }

    public void setVegetable(Vegetable vegetable) {
        this.vegetable = vegetable;
    }

    public int getWeightInG() {
        return weightInG;
    }

    public void setWeightInG(int weightInG) throws SaladException {
        if (weightInG > 0)
            this.weightInG = weightInG;
        else
            throw new SaladException("Вес ингредиента должен быть больше 0");
    }

    public double getCalories() {
        return (double) weightInG / 100 * vegetable.getCalories();
    }

    public double getProteins() {
        return weightInG * vegetable.getProteins();
    }

    public double getFats() {
        return weightInG * vegetable.getFats();
    }

    public double getCarbohydrates() {
        return weightInG * vegetable.getCarbohydrates();
    }

    @Override
    public String toString() {
        return vegetable +
                " — " + weightInG +"гр.";
    }
}
