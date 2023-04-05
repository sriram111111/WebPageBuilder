package com.demo1.demo1;

import com.demo1.demo1.elements.TreeHandler;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;


public class Application extends javafx.application.Application {

    public static Stage curStage;
    public static String curProjectName = "";
    public String projectLocation = "/home/local/ZOHOCORP/sriram-pt6515/IdeaProjects/demo1/src/main/Projects/Project.txt";

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("/com/demo1/demo1/elementsStyles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        this.curStage = stage;

        if(curProjectName == null || curProjectName.equals("")){
            Popup popup = new Popup();
            ComboBox<String> comboBox = new ComboBox<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(projectLocation));
            String temp = null;
            do{
                temp = bufferedReader.readLine();
                if(temp != null){
                    comboBox.getItems().add(temp);
                }
            }while(temp != null);

            Button button = new Button("Create New Project");
            button.setOnMouseClicked(mouseEvent -> {
                popup.hide();
                Popup popup2 = new Popup();

                TextField input = new TextField();
                input.setPrefSize(200,200);
                Button submit = new Button("create");
                popup2.getContent().addAll(input,submit);

                submit.setOnMouseClicked(mouseEvent2 -> {
                    Controller.load = false;
                    Application.curProjectName = input.getText();
                    try {
                        new Application().start(Application.curStage);
                        PrintWriter writer = new PrintWriter(new FileWriter(projectLocation, true));
                        writer.append(Application.curProjectName+"\n");
                        writer.flush();
                        writer.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    popup2.hide();
                });
                popup2.setWidth(500);
                popup2.setHeight(500);
                popup2.setX(600);
                popup2.setY(500);

                popup2.show(stage.getScene().getWindow());
            });
            popup.getContent().addAll(new HBox(new Label("Choose Project"),comboBox,button));
            popup.setHeight(800);
            popup.setWidth(800);
            popup.show(stage.getScene().getWindow());
            comboBox.setOnAction(actionEvent -> {
                Controller.load = false;
                curProjectName = comboBox.getValue();
                System.out.println("projectname"+curProjectName);
                try {
                    start(stage);
                    popup.hide();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        }

    }



    public static void main(String[] args) {

        launch();

    }
}