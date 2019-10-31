package com.kch;
// Main class

import com.kch.storage.FileStorage;

import java.io.File;

public class Main {
    public static final int SCREEN_WIDTH = 600;    //게임전체 넓이 600 고정
    public static final int SCREEN_HEIGHT = 850;    //게임전체 높이 850 고정

    public static void main(String[] args) {
        FileStorage.load();
        Gui gui = new Gui();



    }
}
