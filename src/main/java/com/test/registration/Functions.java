package com.test.registration;

import com.codeborne.selenide.ElementsCollection;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class Functions {
    public String[] getChosenOptions(ElementsCollection selectedOptions){
        String[] chosenList = new String[selectedOptions.size()];
        for (int i = 0; i < selectedOptions.size(); i++) {
            chosenList[i] = selectedOptions.get(i).getText();
        }
        return chosenList;
    }

}
