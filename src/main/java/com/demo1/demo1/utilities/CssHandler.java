package com.demo1.demo1.utilities;

import com.demo1.demo1.Controller;
import com.demo1.demo1.elements.CssProperty;
import com.demo1.demo1.elements.Element;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Set;

public class CssHandler {

    public static TreeItem<HBox> root = new TreeItem<>();
    public static CssProperty copiedProperty;


    public static void loadComponent(Element e){
        root.getChildren().clear();
        Set<String> props = e.css.properties;
        CssProperty css = e.css;

        //Class-Name-Field
        TextField textField0 = new TextField(css.getStyleClass().trim());
        textField0.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                css.setStyleClass(textField0.getText()+" ");
            }
        });
        HBox box0 = new HBox(new Label("Class : "),textField0);
        TreeItem<HBox> item0 = new TreeItem<>(box0);
        System.out.println("entered");
        root.getChildren().add(item0);

        //Followup-Class-Name
        ObservableList<String> items01 = FXCollections.observableArrayList(css.classList);
        ChoiceBox<String> choiceBox01 = new ChoiceBox<>(items01);
        choiceBox01.setValue(css.getHtmlClass());
        choiceBox01.setOnAction(event -> {
            css.setHtmlClass(choiceBox01.getValue());
        });
        HBox box01 = new HBox(new Label("Follow-up Class : "),choiceBox01);
        TreeItem<HBox> item01 = new TreeItem<>(box01);
        root.getChildren().add(item01);

        if(props.contains("content")){
            TextField textField = new TextField(e.getContent());
            textField.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    e.setContent(textField.getText());
                    Label label = (Label) e.pane.getChildren().get(0);
                    label.setText(textField.getText());
                }
            });
            HBox box = new HBox(new Label("Content : "),textField);
            TreeItem<HBox> item = new TreeItem<>(box);
            System.out.println("entered");
            root.getChildren().add(item);
        }

        if(props.contains("color")){
            ColorPicker colorPicker = new ColorPicker(Color.web("000000"));
            colorPicker.setOnAction(event -> {
                css.setColor(colorPicker.getValue().toString());
            });
            HBox box = new HBox(new Label("Color : "),colorPicker);
            TreeItem<HBox> item = new TreeItem<>(box);
            System.out.println("entered");
            root.getChildren().add(item);
        }

        if(props.contains("background")){

            TreeItem<HBox> backgroundTree = new TreeItem<HBox>(new HBox(new Label("Background")));

            //Background-Color
            ColorPicker colorPicker = new ColorPicker(Color.web("000000"));
            colorPicker.setOnAction(event -> {
                css.setBackgroundColor(colorPicker.getValue().toString());
            });
            HBox box1 = new HBox(new Label("Background Color : "),colorPicker);
            TreeItem<HBox> item1 = new TreeItem<>(box1);
            backgroundTree.getChildren().add(item1);

            //Background-Image
            TextField textField = new TextField(css.getBackgroundImageUrl());
            textField.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setBackgroundImageUrl(textField.getText());
                }
            });
            HBox box2 = new HBox(new Label("Background Image Url : "),textField);
            TreeItem<HBox> item2 = new TreeItem<>(box2);
            backgroundTree.getChildren().add(item2);

            //Background-Repeat
            ObservableList<String> items1 = FXCollections.observableArrayList(
                    "repeat",
                    "repeat-x",
                    "repeat-y",
                    "no-repeat",
                    "space",
                    "round"
            );
            ChoiceBox<String> choiceBox = new ChoiceBox<>(items1);
            choiceBox.setOnAction(event -> {
                css.setBackgroundRepeat(choiceBox.getValue());
            });
            HBox box3 = new HBox(new Label("Background Repeat : "),choiceBox);
            TreeItem<HBox> item3 = new TreeItem<>(box3);
            backgroundTree.getChildren().add(item3);

            //Background-Position
            TextField textField2 = new TextField(css.getBackgroundPositionX()+"");
            textField2.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setBackgroundPositionX(textField2.getText());
                }
            });
            TextField textField3 = new TextField(css.getBackgroundPositionY()+"");
            textField3.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setBackgroundPositionY(textField3.getText());
                }
            });
            HBox box4 = new HBox(new Label("Background Position X : "),textField2);
            HBox box41 = new HBox(new Label("Background Position Y : "),textField3);
            TreeItem<HBox> item4 = new TreeItem<>(box4);
            TreeItem<HBox> item41 = new TreeItem<>(box41);
            backgroundTree.getChildren().add(item4);
            backgroundTree.getChildren().add(item41);

            //Background-Size
            TextField textField4 = new TextField(css.getBackgroundSize());
            textField4.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setBackgroundSize(textField4.getText());
                }
            });
            HBox box5 = new HBox(new Label("Background Size : "),textField4);
            TreeItem<HBox> item5 = new TreeItem<>(box5);
            backgroundTree.getChildren().add(item5);


            root.getChildren().add(backgroundTree);
        }

        if(props.contains("border")){
            TreeItem<HBox> borderTree = new TreeItem<HBox>(new HBox(new Label("Border")));

            //Border-Width
            TextField textField1 = new TextField(css.getBorderWidth());
            textField1.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setBorderWidth(textField1.getText());
                }
            });
            HBox box1 = new HBox(new Label("Width : "),textField1);
            TreeItem<HBox> item1 = new TreeItem<>(box1);
            borderTree.getChildren().add(item1);

            //Border-Style
            TextField textField2 = new TextField(css.getBorderStyle());
            textField2.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setBorderStyle(textField2.getText());
                }
            });
            HBox box2 = new HBox(new Label("Style : "),textField2);
            TreeItem<HBox> item2 = new TreeItem<>(box2);
            borderTree.getChildren().add(item2);

            //border-Color
            ColorPicker colorPicker = new ColorPicker(Color.web("000000"));
            colorPicker.setOnAction(event -> {
                css.setBorderColor(colorPicker.getValue().toString());
            });
            HBox box3 = new HBox(new Label("Color : "),colorPicker);
            TreeItem<HBox> item3 = new TreeItem<>(box3);
            borderTree.getChildren().add(item3);

            //Border-Top
            TreeItem<HBox> borderTopTree = new TreeItem<HBox>(new HBox(new Label("Border Top")));

            //Border-Top-Width
            TextField textField11 = new TextField(css.getBorderTopWidth());
            textField11.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setBorderTopWidth(textField11.getText());
                }
            });
            HBox box11 = new HBox(new Label("Width : "),textField11);
            TreeItem<HBox> item11 = new TreeItem<>(box11);
            borderTopTree.getChildren().add(item11);

            //Border-Top-Style
            TextField textField12 = new TextField(css.getBorderTopStyle());
            textField12.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setBorderTopStyle(textField12.getText());
                }
            });
            HBox box12 = new HBox(new Label("Style : "),textField12);
            TreeItem<HBox> item12 = new TreeItem<>(box12);
            borderTopTree.getChildren().add(item12);

            //border-Top-Color
            ColorPicker colorPicker11 = new ColorPicker(Color.web("000000"));
            colorPicker11.setOnAction(event -> {
                css.setBorderTopColor(colorPicker11.getValue().toString());
            });
            HBox box13 = new HBox(new Label("Color : "),colorPicker11);
            TreeItem<HBox> item13 = new TreeItem<>(box13);
            borderTopTree.getChildren().add(item13);

            borderTree.getChildren().add(borderTopTree);


            //Border-Bottom
            TreeItem<HBox> borderBottomTree = new TreeItem<HBox>(new HBox(new Label("Border Bottom")));

            //Border-Bottom-Width
            TextField textField21 = new TextField(css.getBorderBottomWidth());
            textField21.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setBorderBottomWidth(textField21.getText());
                }
            });
            HBox box21 = new HBox(new Label("Width : "),textField21);
            TreeItem<HBox> item21 = new TreeItem<>(box21);
            borderBottomTree.getChildren().add(item21);

            //Border-Bottom-Style
            TextField textField22 = new TextField(css.getBorderBottomStyle());
            textField22.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setBorderBottomStyle(textField22.getText());
                }
            });
            HBox box22 = new HBox(new Label("Style : "),textField22);
            TreeItem<HBox> item22 = new TreeItem<>(box22);
            borderBottomTree.getChildren().add(item22);

            //border-Bottom-Color
            ColorPicker colorPicker23 = new ColorPicker(Color.web("000000"));
            colorPicker23.setOnAction(event -> {
                css.setBorderBottomColor(colorPicker23.getValue().toString());
            });
            HBox box23 = new HBox(new Label("Color : "),colorPicker23);
            TreeItem<HBox> item23 = new TreeItem<>(box23);
            borderBottomTree.getChildren().add(item23);

            borderTree.getChildren().add(borderBottomTree);

            //Border-Right
            TreeItem<HBox> borderRightTree = new TreeItem<HBox>(new HBox(new Label("Border Right")));
            //Border-Width
            TextField textField31 = new TextField(css.getBorderRightWidth());
            textField31.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setBorderRightWidth(textField31.getText());
                }
            });
            HBox box31 = new HBox(new Label("Width : "),textField31);
            TreeItem<HBox> item31 = new TreeItem<>(box31);
            borderRightTree.getChildren().add(item31);

            //Border-Style
            TextField textField32 = new TextField(css.getBorderRightStyle());
            textField32.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setBorderRightStyle(textField32.getText());
                }
            });
            HBox box32 = new HBox(new Label("Style : "),textField32);
            TreeItem<HBox> item32 = new TreeItem<>(box32);
            borderRightTree.getChildren().add(item32);

            //border-Color
            ColorPicker colorPicker33 = new ColorPicker(Color.web("000000"));
            colorPicker33.setOnAction(event -> {
                css.setBorderRightColor(colorPicker33.getValue().toString());
            });
            HBox box33 = new HBox(new Label("Color : "),colorPicker33);
            TreeItem<HBox> item33 = new TreeItem<>(box33);
            borderRightTree.getChildren().add(item33);

            borderTree.getChildren().add(borderRightTree);

            //Border-Left
            TreeItem<HBox> borderLeftTree = new TreeItem<HBox>(new HBox(new Label("Border Left")));
            //Border-Width
            TextField textField41 = new TextField(css.getBorderLeftWidth());
            textField41.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setBorderLeftWidth(textField41.getText());
                }
            });
            HBox box41 = new HBox(new Label("Width : "),textField41);
            TreeItem<HBox> item41 = new TreeItem<>(box41);
            borderLeftTree.getChildren().add(item41);

            //Border-Style
            TextField textField42 = new TextField(css.getBorderLeftStyle());
            textField42.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setBorderLeftStyle(textField42.getText());
                }
            });
            HBox box42 = new HBox(new Label("Style : "),textField42);
            TreeItem<HBox> item42 = new TreeItem<>(box42);
            borderLeftTree.getChildren().add(item42);

            //border-Color
            ColorPicker colorPicker43 = new ColorPicker(Color.web("000000"));
            colorPicker43.setOnAction(event -> {
                css.setBorderLeftColor(colorPicker43.getValue().toString());
            });
            HBox box43 = new HBox(new Label("Color : "),colorPicker43);
            TreeItem<HBox> item43 = new TreeItem<>(box43);
            borderLeftTree.getChildren().add(item43);

            borderTree.getChildren().add(borderLeftTree);


            root.getChildren().add(borderTree);
        }

        if(props.contains("margin")){

            TreeItem<HBox> marginTree = new TreeItem<HBox>(new HBox(new Label("Margin")));

            //Margin-Top
            TextField textField1 = new TextField(css.getMarginTop());
            textField1.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setMarginTop(textField1.getText());
                }
            });
            HBox box1 = new HBox(new Label("Top : "),textField1);
            TreeItem<HBox> item1 = new TreeItem<>(box1);
            marginTree.getChildren().add(item1);

            //Margin-Bottom
            TextField textField2 = new TextField(css.getMarginBottom());
            textField2.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setMarginBottom(textField2.getText());
                }
            });
            HBox box2 = new HBox(new Label("Bottom : "),textField2);
            TreeItem<HBox> item2 = new TreeItem<>(box2);
            marginTree.getChildren().add(item2);

            //Margin-Right
            TextField textField3 = new TextField(css.getMarginRight());
            textField3.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setMarginRight(textField3.getText());
                }
            });
            HBox box3 = new HBox(new Label("Right : "),textField3);
            TreeItem<HBox> item3 = new TreeItem<>(box3);
            marginTree.getChildren().add(item3);

            //Margin-Left
            TextField textField4 = new TextField(css.getMarginLeft());
            textField4.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setMarginLeft(textField4.getText());
                }
            });
            HBox box4 = new HBox(new Label("Left : "),textField4);
            TreeItem<HBox> item4 = new TreeItem<>(box4);
            marginTree.getChildren().add(item4);

            root.getChildren().add(marginTree);
        }

        if(props.contains("padding")){

            TreeItem<HBox> paddingTree = new TreeItem<HBox>(new HBox(new Label("Padding")));

            //Padding-Top
            TextField textField1 = new TextField(css.getPaddingTop());
            textField1.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setPaddingTop(textField1.getText());
                }
            });
            HBox box1 = new HBox(new Label("Top : "),textField1);
            TreeItem<HBox> item1 = new TreeItem<>(box1);
            paddingTree.getChildren().add(item1);

            //Margin-Bottom
            TextField textField2 = new TextField(css.getPaddingBottom());
            textField2.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setPaddingBottom(textField2.getText());
                }
            });
            HBox box2 = new HBox(new Label("Bottom : "),textField2);
            TreeItem<HBox> item2 = new TreeItem<>(box2);
            paddingTree.getChildren().add(item2);

            //Margin-Right
            TextField textField3 = new TextField(css.getPaddingRight());
            textField3.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setPaddingRight(textField3.getText());
                }
            });
            HBox box3 = new HBox(new Label("Right : "),textField3);
            TreeItem<HBox> item3 = new TreeItem<>(box3);
            paddingTree.getChildren().add(item3);

            //Margin-Left
            TextField textField4 = new TextField(css.getPaddingLeft());
            textField4.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setPaddingLeft(textField4.getText());
                }
            });
            HBox box4 = new HBox(new Label("Left : "),textField4);
            TreeItem<HBox> item4 = new TreeItem<>(box4);
            paddingTree.getChildren().add(item4);

            root.getChildren().add(paddingTree);
        }

        if(props.contains("transform")){
            TreeItem<HBox> transformTree = new TreeItem<HBox>(new HBox(new Label("Transform")));

            //Position
            ObservableList<String> items1 = FXCollections.observableArrayList(
                    "static",
                    "relative",
                    "absolute",
                    "stick",
                    "fixed"
            );
            ChoiceBox<String> choiceBox = new ChoiceBox<>(items1);
            choiceBox.setOnAction(event -> {
                css.setPosition(choiceBox.getValue());
            });
            HBox box = new HBox(new Label("Position : "),choiceBox);
            TreeItem<HBox> item = new TreeItem<>(box);
            transformTree.getChildren().add(item);

            //Position-Top
            TextField textField1 = new TextField(css.getPositionTop());
            textField1.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setPositionTop(textField1.getText());
                }
            });
            HBox box1 = new HBox(new Label("Top : "),textField1);
            TreeItem<HBox> item1 = new TreeItem<>(box1);
            transformTree.getChildren().add(item1);

            //Position-Bottom
            TextField textField2 = new TextField(css.getPositionBottom());
            textField2.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setPositionBottom(textField2.getText());
                }
            });
            HBox box2 = new HBox(new Label("Bottom : "),textField2);
            TreeItem<HBox> item2 = new TreeItem<>(box2);
            transformTree.getChildren().add(item2);

            //Position-Right
            TextField textField3 = new TextField(css.getPositionRight());
            textField3.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setPositionRight(textField3.getText());
                }
            });
            HBox box3 = new HBox(new Label("Right : "),textField3);
            TreeItem<HBox> item3 = new TreeItem<>(box3);
            transformTree.getChildren().add(item3);

            //Position-Left
            TextField textField4 = new TextField(css.getPositionLeft());
            textField4.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setPositionLeft(textField4.getText());
                }
            });
            HBox box4 = new HBox(new Label("Left : "),textField4);
            TreeItem<HBox> item4 = new TreeItem<>(box4);
            transformTree.getChildren().add(item4);

            //Width
            TextField textField7 = new TextField(css.getWidth());
            textField7.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setWidth(textField7.getText());
                }
            });
            HBox box7 = new HBox(new Label("Width : "),textField7);
            TreeItem<HBox> item7 = new TreeItem<>(box7);
            transformTree.getChildren().add(item7);

            //Height
            TextField textField8 = new TextField(css.getHeight());
            textField8.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setHeight(textField8.getText());
                }
            });
            HBox box8 = new HBox(new Label("Height : "),textField8);
            TreeItem<HBox> item8 = new TreeItem<>(box8);
            transformTree.getChildren().add(item8);

            //Position Z
            TextField textField6 = new TextField(css.getPositionZ());
            textField6.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setPositionZ(textField6.getText());
                }
            });
            HBox box6 = new HBox(new Label("Z Index : "),textField6);
            TreeItem<HBox> item6 = new TreeItem<>(box6);
            transformTree.getChildren().add(item6);

            //Float
            TextField textField5 = new TextField(css.getFloatPosition());
            textField5.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setFloatPosition(textField5.getText());
                }
            });
            HBox box5 = new HBox(new Label("Float : "),textField5);
            TreeItem<HBox> item5 = new TreeItem<>(box5);
            transformTree.getChildren().add(item5);

            root.getChildren().add(transformTree);
        }

        if(props.contains("text")){
            TreeItem<HBox> textTree = new TreeItem<HBox>(new HBox(new Label("Text")));

            //Text-Align
            TextField textField1 = new TextField(css.getTextAlign());
            textField1.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setTextAlign(textField1.getText());
                }
            });
            HBox box1 = new HBox(new Label("Text Align : "),textField1);
            TreeItem<HBox> item1 = new TreeItem<>(box1);
            textTree.getChildren().add(item1);

            //Text-Decoration
            TextField textField2 = new TextField(css.getTextDecoration());
            textField2.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setTextDecoration(textField2.getText());
                }
            });
            HBox box2 = new HBox(new Label("Text Decoration : "),textField2);
            TreeItem<HBox> item2 = new TreeItem<>(box2);
            textTree.getChildren().add(item2);

            //Font-Color
            ColorPicker colorPicker = new ColorPicker(Color.web("000000"));
            colorPicker.setOnAction(event -> {
                css.setFontColor(colorPicker.getValue().toString());
            });
            HBox box3 = new HBox(new Label("Font Color : "),colorPicker);
            TreeItem<HBox> item3 = new TreeItem<>(box3);
            textTree.getChildren().add(item3);

            //Font-Size
            TextField textField4 = new TextField(css.getFontSize());
            textField4.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setFontSize(textField4.getText());
                }
            });
            HBox box4 = new HBox(new Label("Font Size : "),textField4);
            TreeItem<HBox> item4 = new TreeItem<>(box4);
            textTree.getChildren().add(item4);

            //Font-Family
            TextField textField5 = new TextField(css.getFontFamily());
            textField5.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setFontFamily(textField5.getText());
                }
            });
            HBox box5 = new HBox(new Label("Font Family : "),textField5);
            TreeItem<HBox> item5 = new TreeItem<>(box5);
            textTree.getChildren().add(item5);

            //Font-Style
            TextField textField6 = new TextField(css.getFontStyle());
            textField6.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setFontStyle(textField6.getText());
                }
            });
            HBox box6 = new HBox(new Label("Font Style : "),textField6);
            TreeItem<HBox> item6 = new TreeItem<>(box6);
            textTree.getChildren().add(item6);

            //Font-Weight
            TextField textField7 = new TextField(css.getFontWeight());
            textField7.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setFontWeight(textField7.getText());
                }
            });
            HBox box7 = new HBox(new Label("Font Weight : "),textField7);
            TreeItem<HBox> item7 = new TreeItem<>(box7);
            textTree.getChildren().add(item7);

            root.getChildren().add(textTree);
        }

        if(props.contains("grid")){
            TreeItem<HBox> gridTree = new TreeItem<HBox>(new HBox(new Label("Grid")));

            TextField textField1 = new TextField(css.getGridArea());
            textField1.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setGridArea(textField1.getText());
                }
            });
            HBox box1 = new HBox(new Label("Grid Area : "),textField1);
            TreeItem<HBox> item1 = new TreeItem<>(box1);
            gridTree.getChildren().add(item1);
            TextField textField2 = new TextField(css.getGridAutoColumns());
            textField2.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setGridAutoColumns(textField2.getText());
                }
            });
            HBox box2 = new HBox(new Label("Grid Auto Columns : "),textField2);
            TreeItem<HBox> item2 = new TreeItem<>(box2);
            gridTree.getChildren().add(item2);
            TextField textField3 = new TextField(css.getGridAutoFlow());
            textField3.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setGridAutoFlow(textField3.getText());
                }
            });
            HBox box3 = new HBox(new Label("Grid Auto Flow : "),textField3);
            TreeItem<HBox> item3 = new TreeItem<>(box3);
            gridTree.getChildren().add(item3);
            TextField textField4 = new TextField(css.getGap());
            textField4.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setGap(textField4.getText());
                }
            });
            HBox box4 = new HBox(new Label("Gap : "),textField4);
            TreeItem<HBox> item4 = new TreeItem<>(box4);
            gridTree.getChildren().add(item4);
            TextField textField5 = new TextField(css.getColumnGap());
            textField5.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setColumnGap(textField5.getText());
                }
            });
            HBox box5 = new HBox(new Label("Column Gap : "),textField5);
            TreeItem<HBox> item5 = new TreeItem<>(box5);
            gridTree.getChildren().add(item5);
            TextField textField6 = new TextField(css.getRowGap());
            textField6.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setRowGap(textField6.getText());
                }
            });
            HBox box6 = new HBox(new Label("Row Gap : "),textField6);
            TreeItem<HBox> item6 = new TreeItem<>(box6);
            gridTree.getChildren().add(item6);
            TextField textField7 = new TextField(css.getGridGap());
            textField7.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setGridGap(textField7.getText());
                }
            });
            HBox box7 = new HBox(new Label("Grid Gap : "),textField7);
            TreeItem<HBox> item7 = new TreeItem<>(box7);
            gridTree.getChildren().add(item7);
            TextField textField8 = new TextField(css.getGridAutoRows());
            textField8.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setGridAutoRows(textField8.getText());
                }
            });
            HBox box8 = new HBox(new Label("Grid Auto Rows : "),textField8);
            TreeItem<HBox> item8 = new TreeItem<>(box8);
            gridTree.getChildren().add(item8);
            TextField textField9 = new TextField(css.getGridColumns());
            textField9.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setGridColumns(textField9.getText());
                }
            });
            HBox box9 = new HBox(new Label("Grid Columns : "),textField9);
            TreeItem<HBox> item9 = new TreeItem<>(box9);
            gridTree.getChildren().add(item9);
            TextField textField10 = new TextField(css.getGridColumnStart());
            textField10.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setGridColumnStart(textField10.getText());
                }
            });
            HBox box10 = new HBox(new Label("Grid Column Start : "),textField10);
            TreeItem<HBox> item10 = new TreeItem<>(box10);
            gridTree.getChildren().add(item10);
            TextField textField11 = new TextField(css.getGridColumnGap());
            textField11.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setGridColumnGap(textField11.getText());
                }
            });
            HBox box11 = new HBox(new Label("Grid Column Gap : "),textField11);
            TreeItem<HBox> item11 = new TreeItem<>(box11);
            gridTree.getChildren().add(item11);
            TextField textField12 = new TextField(css.getGridColumnEnd());
            textField12.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setGridColumnEnd(textField12.getText());
                }
            });
            HBox box12 = new HBox(new Label("Grid Column End : "),textField12);
            TreeItem<HBox> item12 = new TreeItem<>(box12);
            gridTree.getChildren().add(item12);
            TextField textField13 = new TextField(css.getGridRow());
            textField13.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setGridRow(textField13.getText());
                }
            });
            HBox box13 = new HBox(new Label("Grid Row : "),textField13);
            TreeItem<HBox> item13 = new TreeItem<>(box13);
            gridTree.getChildren().add(item13);
            TextField textField14 = new TextField(css.getGridRowStart());
            textField14.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setGridRowStart(textField14.getText());
                }
            });
            HBox box14 = new HBox(new Label("Grid Row Start : "),textField14);
            TreeItem<HBox> item14 = new TreeItem<>(box14);
            gridTree.getChildren().add(item14);
            TextField textField15 = new TextField(css.getGridRow());
            textField15.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setGridRow(textField15.getText());
                }
            });
            HBox box15 = new HBox(new Label("GapGrid Row Gap : "),textField15);
            TreeItem<HBox> item15 = new TreeItem<>(box15);
            gridTree.getChildren().add(item15);
            TextField textField16 = new TextField(css.getGridRowEnd());
            textField16.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setGridRowEnd(textField16.getText());
                }
            });
            HBox box16 = new HBox(new Label("Grid Row End : "),textField16);
            TreeItem<HBox> item16 = new TreeItem<>(box16);
            gridTree.getChildren().add(item16);
            TextField textField17 = new TextField(css.getGridTemplate());
            textField17.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setGridTemplate(textField17.getText());
                }
            });
            HBox box17 = new HBox(new Label("Grid Template : "),textField17);
            TreeItem<HBox> item17 = new TreeItem<>(box17);
            gridTree.getChildren().add(item17);
            TextField textField18 = new TextField(css.getGridTemplateAreas());
            textField18.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setGridTemplateAreas(textField18.getText());
                }
            });
            HBox box18 = new HBox(new Label("Grid Template Areas : "),textField18);
            TreeItem<HBox> item18 = new TreeItem<>(box18);
            gridTree.getChildren().add(item18);
            TextField textField19 = new TextField(css.getGridTemplateColumns());
            textField19.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setGridTemplateColumns(textField19.getText());
                }
            });
            HBox box19 = new HBox(new Label("Grid Template Columns : "),textField19);
            TreeItem<HBox> item19 = new TreeItem<>(box19);
            gridTree.getChildren().add(item19);
            TextField textField20 = new TextField(css.getGridTemplateRows());
            textField20.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    css.setGridTemplateRows(textField20.getText());
                }
            });
            HBox box20 = new HBox(new Label("Grid Template Rows : "),textField20);
            TreeItem<HBox> item20 = new TreeItem<>(box20);
            gridTree.getChildren().add(item20);

            root.getChildren().add(gridTree);
        }

        if(props.contains("inline")){

            TextField textField1 = new TextField(e.getInline());
            textField1.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    e.setInline(textField1.getText());
                }
            });
            HBox box1 = new HBox(new Label("Inline : "),textField1);
            TreeItem<HBox> item1 = new TreeItem<>(box1);
            root.getChildren().add(item1);
        }


        TextArea textArea = new TextArea(css.getCustomStyles());
        textArea.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                css.setCustomStyles(textArea.getText());
            }
        });
        HBox box = new HBox(new Label("Custome Styles : "),textArea);
        TreeItem<HBox> item = new TreeItem<>(box);
        root.getChildren().add(item);

    }

}
