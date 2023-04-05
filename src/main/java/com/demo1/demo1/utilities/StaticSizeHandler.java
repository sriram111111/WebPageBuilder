package com.demo1.demo1.utilities;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StaticSizeHandler {

    public static Font getFont(String elementName){
        Font font = Font.font("Serif", FontWeight.BOLD, 32);

        return font;
    }


}
