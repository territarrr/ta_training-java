package com.epam.training.sofiia_uchitel.collections.main_task.vеgetables;

import com.epam.training.sofiia_uchitel.collections.main_task.exceptions.SaladException;

public class Marrow extends Vegetable {
    private boolean hasSeeds;

    public Marrow(String name, boolean cut, double calories, double proteins, double fats, double carbohydrates, boolean hasSeeds) throws SaladException {
        super(name, cut, calories, proteins, fats, carbohydrates);
        this.hasSeeds = hasSeeds;
        if (isPrepared()) {
            prepare();
        }
    }

    public boolean isHasSeeds() {
        return hasSeeds;
    }

    public void removeSeeds() {
        this.hasSeeds = false;
    }

    public boolean isPrepared() {
        return !isHasSeeds() && isCut();
    }

    //Перед добавлением обязательно очищаем от семян (если он порезан, но не очищен, то выбрасываем исключение)
    @Override
    public String prepareVegetable() throws SaladException {
        String cookingActionsString = "";
        if (!isCut()) {
            if (isHasSeeds()) {
                removeSeeds();
                cookingActionsString += "Продукт " + getName() + " очищаем от семян.\n";
            } else {
                cookingActionsString += "Продукт " + getName() + " уже очищен от семян.\n";
            }
            cut();
        } else {
            if (isHasSeeds()) throw new SaladException("Продукт не был очищен от семян перед измельчением!");
        }
        cookingActionsString += "Продукт " + getName() + " готов к добавлению.\n";
        return cookingActionsString;
    }
}
