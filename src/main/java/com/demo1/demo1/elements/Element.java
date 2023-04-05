package com.demo1.demo1.elements;

import com.demo1.demo1.Controller;
import com.demo1.demo1.utilities.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Element {

    public String id;
    public String elementName;
    public Element parent;
    public ArrayList<Element> childs = new ArrayList<>();
    public CssProperty css;

    public Pane pane;

    public TreeItem<HBox> component;
    public HBox item;
    public Button element,dragger;
    public MenuButton add,more;

    private String content = "";
    public boolean canContainId = true;

    public String inline= "";

    public boolean isClosable = true;
    public boolean isMovedOnce = false;



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInline() {
        return inline;
    }

    public void setInline(String inlineValue) {
        this.inline= inlineValue;
    }

    public Element(String name, Element parent){
        id = IDGenerator.generateID();
        if(name.equals("html") || name.equals("head") || name.equals("body")){
            id = name;
        }
        this.parent = parent;
        elementName = name;
        element = new Button("<"+elementName+">");
        more = new MenuHandler().getMoreMenu(id,parent);
        element.setOnMouseClicked(event -> CssHandler.loadComponent(ElementHandler.getElement("id"+id)));
        add = new MenuHandler().getHtmlMenu(id);
        dragger = new Button("");
        dragger.setId(id);
        add.setId(id);
        element.setId(id);
        add.setStyle("-fx-background-color: white; -fx-graphic: url('file:///home/local/ZOHOCORP/sriram-pt6515/Downloads/icons8-plus-sign-16.png'); -fx-padding-top:25%");
        add.setPadding(new Insets(3,0,0,0));
        element.setStyle("-fx-background-color: transparent; -fx-padding: 0 0 0 0; -fx-font-size: 16px; -fx-text-fill: black; -fx-border-width: 0;");
        //more.setStyle("-fx-graphic: url('file:///home/local/ZOHOCORP/sriram-pt6515/Downloads/icons8-drag-16.png'); -fx-background-color: transparent;");
        more.setPadding(new Insets(3,0,0,0));
        dragger.setStyle("-fx-background-color: transparent; -fx-graphic: url('file:///home/local/ZOHOCORP/sriram-pt6515/IdeaProjects/demo1/src/main/java/com/demo1/demo1/utilities/icons8-drag-16.png');");
        dragger.setPadding(new Insets(10,0,0,0));
        DragAndDropHandler.addDragAndDrop(dragger);
        dragger.setPrefSize(10,10);
        dragger.setMinSize(10,10);
        dragger.setMaxSize(10,10);
        item = new HBox(element,add,more,dragger);

        item.setId("id"+id);
        component = new TreeItem<>(item);
        parent.addChild(this);
        ElementHandler.elements.put("id"+id,this);
        ElementHandler.setProperties(this);
        css = new CssProperty(id,name);
    }

    public Element(String name,Element parent,boolean isStatic){

        id = IDGenerator.generateID();



    }

    public Element(String name){
        id = IDGenerator.generateID();
        elementName = name;
        element = new Button(elementName);
        element.setOnMouseClicked(event -> CssHandler.loadComponent(ElementHandler.getElement(id)));
        add = new MenuHandler().getHtmlMenu(id);
        add.setId(id);
        add.setStyle("-fx-background-color: white; -fx-graphic: url('file:///home/local/ZOHOCORP/sriram-pt6515/Downloads/icons8-plus-sign-16.png');");
        element.setStyle("-fx-background-color: transparent; -fx-padding: 0 0 0 0; -fx-font-size: 16px; -fx-text-fill: black; -fx-border-width: 0;");
        item = new HBox(element,add);


        item.setId("id"+id);
        component = new TreeItem<>(item);
        ElementHandler.elements.put("id"+id,this);
        ElementHandler.setProperties(this);
        css = new CssProperty(id,name);
    }

    private Element(){}

    public void addChild(Element e){
        component.getChildren().add(e.component);
        childs.add(e);
        e.parent = this;
        System.out.println("finish");
    }

    public String openTag(){
        return "<"+elementName+((!canContainId)?"":" id=\"id"+id+"\"")+inline+(css.getHtmlClass().equals("")?"":" class=\""+css.getHtmlClass().trim()+"\"")+" >"+((!content.equals(""))?content:"\n");
    }

    public String closeTag(){
        if(isClosable)
            return "</"+elementName+">\n";
        return "";
    }

}
