package com.example.calculator;

import android.graphics.Path;

import java.util.ArrayList;

public class Operations {
    private String mTitle;

    public Operations(String title){
        mTitle = title;
    }

    public String getTitle(){ return mTitle;}

    public static ArrayList<Operations> createOperationsList(int x, Operations o){
        ArrayList<Operations> list = new ArrayList<>();
        for(int i = 0; i < x; i++){
            list.add(o);
        }
        return list;
    }
}
