package com.demo1.demo1.utilities;

import com.demo1.demo1.elements.Element;
import com.demo1.demo1.elements.TreeHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;

public class MenuHandler {

    public MenuButton getHtmlMenu(String pid){
        MenuButton menu = new MenuButton();
        MenuItem title = new MenuItem("title");
        MenuItem body = new MenuItem("body");
        MenuItem h1 = new MenuItem("h1");
        MenuItem h2 = new MenuItem("h2");
        MenuItem h3 = new MenuItem("h3");
        MenuItem h4 = new MenuItem("h4");
        MenuItem h5 = new MenuItem("h5");
        MenuItem h6 = new MenuItem("h6");
        MenuItem p = new MenuItem("p");
        MenuItem a = new MenuItem("a");
        MenuItem li = new MenuItem("li");
        MenuItem th = new MenuItem("th");
        MenuItem td = new MenuItem("td");
        MenuItem table = new MenuItem("table");
        MenuItem tr = new MenuItem("tr");
        MenuItem ol = new MenuItem("ol");
        MenuItem ul = new MenuItem("ul");
        MenuItem div = new MenuItem("div");
        MenuItem span = new MenuItem("span");
        MenuItem section = new MenuItem("section");
        MenuItem header = new MenuItem("header");
        MenuItem footer = new MenuItem("footer");
        MenuItem nav = new MenuItem("nav");
        MenuItem aside = new MenuItem("aside");
        MenuItem form = new MenuItem("form");
        MenuItem input = new MenuItem("input");
        MenuItem textarea = new MenuItem("textarea");
        MenuItem select = new MenuItem("select");
        MenuItem option = new MenuItem("option");
        MenuItem button = new MenuItem("button");
        MenuItem label = new MenuItem("label");
        MenuItem img = new MenuItem("img");
        Menu textMenu = new Menu("Text");
        textMenu.getItems().addAll(h1,h2,h3,h4,h5,h6,p,a);
        Menu containerMenu = new Menu("Containers");
        containerMenu.getItems().addAll(div,span,section,header,footer,nav,aside);
        Menu tableMenu = new Menu("Table");
        tableMenu.getItems().addAll(table,tr,td,th);
        Menu listMenu = new Menu("List");
        listMenu.getItems().addAll(ol,ul,li);
        Menu inputMenu = new Menu("Input");
        inputMenu.getItems().addAll(form,input,textarea,select,option,button,label);
        Menu otherMenu = new Menu("Others");
        otherMenu.getItems().addAll(img,title,body);
        menu.getItems().addAll(textMenu,containerMenu,tableMenu,listMenu,inputMenu,otherMenu);

        for(MenuItem item : textMenu.getItems()){
            item.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    String name = item.getText();
                    TreeHandler.addNode(name,"id"+pid);
                }
            });
        }

        for(MenuItem item : containerMenu.getItems()){
            item.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    String name = item.getText();
                    TreeHandler.addNode(name,"id"+pid);
                }
            });
        }

        for(MenuItem item : tableMenu.getItems()){
            item.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    String name = item.getText();
                    TreeHandler.addNode(name,"id"+pid);
                }
            });
        }

        for(MenuItem item : listMenu.getItems()){
            item.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    String name = item.getText();
                    TreeHandler.addNode(name,"id"+pid);
                }
            });
        }

        for(MenuItem item : inputMenu.getItems()){
            item.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    String name = item.getText();
                    TreeHandler.addNode(name,"id"+pid);
                }
            });
        }

        for(MenuItem item : otherMenu.getItems()){
            item.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    String name = item.getText();
                    TreeHandler.addNode(name,"id"+pid);
                }
            });
        }

        return menu;
    }


    public MenuButton getMoreMenu(String id, Element parent){

        MenuButton menu = new MenuButton("");

        //Delete
        MenuItem delete = new MenuItem("Delete");
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("log delete action");
                TreeHandler.removeNode("id"+id,parent,true);
            }
        });
        menu.getItems().add(delete);

        //Copy-Styles
        MenuItem copy = new MenuItem("Copy Styles");
        copy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("log copy action");
                CssHandler.copiedProperty = ElementHandler.getElement("id"+id).css.copy();
            }
        });
        menu.getItems().add(copy);

        //Paste-Styles
        MenuItem paste = new MenuItem("Paste Styles");
        paste.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("log paste action");
                if(CssHandler.copiedProperty == null)
                    return;
                System.out.println("log paste action"+CssHandler.copiedProperty.getId());
               ElementHandler.getElement("id"+id).css = CssHandler.copiedProperty;
               CssHandler.copiedProperty.setId(id);
            }
        });
        menu.getItems().add(paste);



        return menu;
    }


}
