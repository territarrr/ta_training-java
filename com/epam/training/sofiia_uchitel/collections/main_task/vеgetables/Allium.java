package com.epam.training.sofiia_uchitel.collections.main_task.vеgetables;

import com.epam.training.sofiia_uchitel.collections.main_task.exceptions.SaladException;

public class Allium extends Root {
    //Каллорийность 1 ст.л. (17гр) масла
    private final double OIL_CALORIES_IN_SPOON = 152.8;
    //Часть впитываемого масла (20%)
    private final double ABSORBED_OIL = 0.2;

    private boolean fry;

    public Allium(String name, boolean cut, double calories, double proteins, double fats, double carbohydrates, boolean inPeel, boolean fry) throws SaladException {
        super(name, cut, calories, proteins, fats, carbohydrates, inPeel);
        this.fry = fry;
        if (isPrepared()) {
            prepare();
        }
    }

    public boolean isFry() {
        return fry;
    }

    //Считаем, что на 100гр продукта при обжарке нажно добавить 1ст.л.(17гр).
    //При обжарке впитывается 20% масла, поэтому изменяется калорийность
    public void fry() throws SaladException {
        fry = true;
        setCalories(getCalories() + OIL_CALORIES_IN_SPOON * ABSORBED_OIL);
    }

    //Перед добавлением обязательно очищаем (если он порезан, но не очищен, то выбрасываем исключение) от кожуры и указываем обжарен ли он
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
            cut();
            if (isFry()) {
                fry();
                cookingActionsString += "Продукт " + getName() + " обжариваем.\n";
            }
        } else {
            if (isInPeel())
                throw new SaladException("Продукт не был очищен перед измельчением!");
        }
        cookingActionsString += "Продукт " + getName() + " готов к добавлению.\n";
        return cookingActionsString;
    }
}
