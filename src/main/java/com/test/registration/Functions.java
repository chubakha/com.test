package com.test.registration;

import com.codeborne.selenide.ElementsCollection;

public class Functions {
    public String[] getChosenOptions(ElementsCollection selectedOptions){
        String[] chosenList = new String[selectedOptions.size()];
        for (int i = 0; i < selectedOptions.size(); i++) {
            chosenList[i] = selectedOptions.get(i).getText();
        }
        return chosenList;
    }

}
