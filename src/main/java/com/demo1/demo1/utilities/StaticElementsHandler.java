package com.demo1.demo1.utilities;

import com.demo1.demo1.Controller;
import com.demo1.demo1.elements.Element;
import com.demo1.demo1.elements.TreeHandler;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;

import java.util.ArrayList;
import java.util.Arrays;

public class StaticElementsHandler {

    static boolean flag = false;

    public static void init(TreeView<HBox> tree, WebView webView, Pane pane){
        TreeItem<HBox> root = new TreeItem<>(new HBox(new Button("Elements")));
        tree.setRoot(root);

        ArrayList<String> components = new ArrayList<>();
        components.addAll(Arrays.asList("h1","h2","h3","h4","h5","h6","div","p","img","a","li","td","table","tr","th","ol","ul","li","form","input","textarea","select","button","label"));

        for (String s: components) {
            Button component = new Button(s);

            component.setOnDragDetected(mouseEvent -> {
                Dragboard db = component.startDragAndDrop(TransferMode.COPY);
                ClipboardContent content = new ClipboardContent();
                content.putString(component.getText());
                db.setContent(content);
                webView.setVisible(false);
                pane.setVisible(true);
                mouseEvent.consume();
            });

            root.getChildren().add(new TreeItem<>(new HBox(component)));

        }


        webView.setOnMouseEntered(mouseEvent -> {
            webView.setVisible(false);
            pane.setVisible(true);

        });

        pane.setOnMouseExited(mouseEvent -> {
            System.out.println("reloaded");
            DataHandler.save();
            Controller.wEngine.reload();
            if(flag == true)
                return;
            webView.setVisible(true);
            pane.setVisible(false);
        });

        pane.setOnDragOver(dragEvent -> {
            dragEvent.acceptTransferModes(TransferMode.ANY);
            dragEvent.consume();
        });

        pane.setOnDragDropped(dragEvent -> {
            dragEventMethod(dragEvent,pane,webView,pane);
        });

    }

    public static void dragEventMethod(DragEvent dragEvent, Pane pane, WebView webView,Pane childPane){
        System.out.println(childPane.getId());
        if(dragEvent.getTransferMode() == TransferMode.MOVE){
            System.out.println("second dropped"+dragEvent.getDragboard().getString());

            if(dragEvent.getDragboard().getString().contains("dragger")){
                Element e = ElementHandler.getElement("id"+dragEvent.getDragboard().getString().substring(7));
                double width = dragEvent.getX() - e.pane.getLayoutX();
                double height = dragEvent.getY() - e.pane.getLayoutY();

                e.pane.setPrefSize(width,height);
                HBox box = ((HBox)e.pane.getChildren().get(0));
                box.setPrefSize(width,height);
                box.getChildren().get(0).setLayoutX(dragEvent.getX());
                System.out.println(box.getChildren().get(0).getLayoutX()+"x of button");
                box.getChildren().get(0).setLayoutY(dragEvent.getY());
                e.css.setWidth(String.valueOf(width));
                e.css.setHeight(String.valueOf(height));

                flag = false;
                return;
            }

            Element e = ElementHandler.getElement("id"+dragEvent.getDragboard().getString());
            if(e.isMovedOnce){

                return;
            }
            if(childPane == pane){
                System.out.println("moved second time");
                e.pane.setLayoutX(dragEvent.getX());
                e.pane.setLayoutY(dragEvent.getY());

                e.css.setPositionLeft(String.valueOf(dragEvent.getX()));
                e.css.setPositionTop(String.valueOf(dragEvent.getY()));
            }else{
                e.isMovedOnce = true;
                System.out.println("move inside pane"+(dragEvent.getX()-pane.getLayoutX()));
                e.pane.setLayoutX(dragEvent.getX()-pane.getLayoutX());
                e.pane.setLayoutY(dragEvent.getY()-pane.getLayoutY());

                e.css.setPositionLeft(String.valueOf(dragEvent.getX()-pane.getLayoutX()));
                e.css.setPositionTop(String.valueOf(dragEvent.getY()-pane.getLayoutY()));
            }


            flag = false;
            return;
        }


        Dragboard db = dragEvent.getDragboard();
        System.out.println("entered drop of static"+db.getString());
        Pane p = new Pane();
        Label label = new Label(db.getString());
        String id = "idbody";
        if(!childPane.getId().equals("") && pane != childPane){
            id = "id"+childPane.getId();
        }
        Element e = TreeHandler.addNode(db.getString(), id);
        p.setId(e.id);
        if("divimgtabletrolul".contains(db.getString())){
            Button b = new Button("");
            b.setOnDragDetected(mouseEvent -> {
                Dragboard db3 = b.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putString("dragger"+e.id);
                db3.setContent(content);
                flag = true;
                webView.setVisible(false);
                pane.setVisible(true);
                mouseEvent.consume();
            });
            HBox box = new HBox();
            box.getChildren().addAll(b);
            box.setStyle("-fx-border: 5px solid; -fx-border-color: black;");
            p.getChildren().add(box);
        }else{
            p.getChildren().add(label);
        }

        childPane.getChildren().add(p);
        p.setLayoutX(dragEvent.getX());
        p.setLayoutY(dragEvent.getY());
//        p.setStyle("-fx-border:1px solid black;");
//        label.setStyle("-fx-border: 5px solid black; -fx-border-color: black;");

        p.setOnDragDetected(mouseEvent -> {
            Dragboard db2 = p.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(p.getId());
            ElementHandler.getElement("id"+p.getId()).isMovedOnce = false;
            db2.setContent(content);
            flag = true;
            webView.setVisible(false);
            pane.setVisible(true);
            System.out.println("enter p drag");
            mouseEvent.consume();
        });
        System.out.println(e.id);
        p.setOnMouseClicked(event -> CssHandler.loadComponent(ElementHandler.getElement("id"+e.id)));

        p.setOnDragDropped(dragEvent1 -> {
            dragEventMethod(dragEvent1,pane,webView,p);
        });

        label.setFont(StaticSizeHandler.getFont("h1"));
        e.pane = p;

        if(!"trthli".contains(db.getString())){
            e.css.setPosition("absolute");
            if(e.css.properties.contains("content")&&!"divimgtabletrolul".contains(db.getString()))
                e.setContent(db.getString());

            e.css.setWidth("max-content");
            e.css.setHeight("max-content");
            e.css.setPositionLeft(String.valueOf(dragEvent.getX()-1));
            e.css.setPositionTop(String.valueOf(dragEvent.getY()-17));
        }

        boolean success = true;
        dragEvent.setDropCompleted(success);
        dragEvent.consume();
    }


}
