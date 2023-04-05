package com.demo1.demo1.utilities;

import com.demo1.demo1.elements.Element;

import java.util.HashMap;

public class ElementHandler {

    public static HashMap<String, Element> elements = new HashMap<String,Element>();

    public static Element getElement(String id){
        return elements.get(id);
    }

    public static void setProperties(Element e){
        String name = e.elementName;

        switch(name){
            case "html","head","body":
                e.canContainId = false;
                break;
            case "img","input":
                e.isClosable = false;
                break;
        }


    }


}
