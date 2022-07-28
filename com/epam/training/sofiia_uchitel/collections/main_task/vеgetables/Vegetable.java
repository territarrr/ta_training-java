package com.epam.training.sofiia_uchitel.collections.main_task.vеgetables;

import com.epam.training.sofiia_uchitel.collections.main_task.exceptions.SaladException;

public abstract class Vegetable {
    private final String name;
    private boolean prepared = false;
    private boolean cut;
    //КБЖУ на 100г продукта
    private double calories;
    private double proteins;
    private double fats;
    private double carbohydrates;

    public Vegetable(String name, boolean cut, double calories, double proteins, double fats, double carbohydrates) throws SaladException {
        this.name = name;
        this.cut = cut;
        setCalories(calories);
        setProteins(proteins);
        setFats(fats);
        setCarbohydrates(carbohydrates);
    }

    public String getName() {
        return name;
    }

    public boolean isCut() {
        return cut;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) throws SaladException {
        if (proteins >= 0)
            this.proteins = proteins;
        else
            throw new SaladException("Белки не могут быть отрицательными");
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) throws SaladException {
        if (carbohydrates >= 0)
            this.carbohydrates = carbohydrates;
        else
            throw new SaladException("Углеводы не могут быть отрицательными");
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) throws SaladException {
        if (fats >= 0)
            this.fats = fats;
        else
            throw new SaladException("Жиры не могут быть отрицательными");
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) throws SaladException {
        if (calories > 0)
            this.calories = calories;
        else
            throw new SaladException("Калорийность не может быть отрицательной");
    }

    public String cut() {
        if (!isCut()) {
            cut = true;
            return "Продукт " + getName() + " нарезаем.\n";
        } else {
            return "Продукт " + getName() + " уже нарезан.\n";
        }
    }

    public String prepare() throws SaladException {
        prepared = true;
        return prepareVegetable();
    }

    public abstract String prepareVegetable() throws SaladException;

    public abstract boolean isPrepared() throws SaladException;

    @Override
    public String toString() {
        return name + " (Калории, ккал:" + calories + "; Белки, г: " + proteins + "; Жиры, г: " + fats + "; Углеводы, г: " + carbohydrates + ")";
    }
}
