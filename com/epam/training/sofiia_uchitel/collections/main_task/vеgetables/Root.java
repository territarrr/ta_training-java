package com.epam.training.sofiia_uchitel.collections.main_task.vеgetables;

import com.epam.training.sofiia_uchitel.collections.main_task.exceptions.SaladException;

public class Root extends Vegetable {
    private boolean inPeel;

    public Root(String name, boolean cut, double calories, double proteins, double fats, double carbohydrates, boolean inPeel) throws SaladException {
        super(name, cut, calories, proteins, fats, carbohydrates);
        this.inPeel = inPeel;
        if (isPrepared()) {
            prepare();
        }
    }

    public boolean isInPeel() {
        return inPeel;
    }

    public void unpeel() {
        inPeel = false;
    }

    //Перед добавлением обязательно очищаем от кожуры (если он порезан, но не очищен, то выбрасываем исключение)
    @Override
    public String prepareVegetable() throws SaladException {
        String cookingActionsString = "";
        if (!isCut()) {
            if (isInPeel()) {
                unpeel();
                cookingActionsString += "Продукт " + getName() + " очищаем от кожуры.\n";
            } else {
                cookingActionsString += "Продукт " + getName() + " уже очищен от кожуры.\n";
            }
            cookingActionsString += cut();
        } else {
            if (isInPeel())
                throw new SaladException("Продукт не был очищен от кожуры перед измельчением!");
        }
        cookingActionsString = "Продукт " + getName() + " готов к добавлению.\n";
        return cookingActionsString;
    }

    @Override
    public boolean isPrepared() {
        return !isInPeel() && isCut();
    }
}
