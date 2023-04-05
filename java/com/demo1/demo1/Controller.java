package com.demo1.demo1;

import com.demo1.demo1.elements.TreeHandler;
import com.demo1.demo1.utilities.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class Controller{
    @FXML
    private VBox root;
    @FXML
    private TreeView<HBox> treeView;
    @FXML
    private TreeView<HBox> staticTreeView;
    @FXML
    private TreeView<HBox> cssTree;
    @FXML
    private WebView webView;
    @FXML
    private Pane rootPane;
    public static WebEngine wEngine;
    public String projectLocation = "/home/local/ZOHOCORP/sriram-pt6515/IdeaProjects/demo1/src/main/Projects/Project.txt";
    static boolean load = true;

    public static boolean isStatic = false;

    @FXML
    public Node getComponent(String id){

        return root.lookup("#"+id);
    }



    public void save(){

        DataHandler.save();
        wEngine.reload();
    }

    @FXML
    public void initialize() {
        rootPane.setVisible(false);
            new TreeHandler().initialize(treeView);
            StaticElementsHandler.init(staticTreeView,webView,rootPane);
        if(load == true && isStatic == false) {
            TreeHandler.addNode("head", "id2");
            TreeHandler.addNode("body", "id2");
        }

        if(isStatic == true){



        }

        System.out.println("calling");
        cssTree.setRoot(CssHandler.root);
        System.out.println("called");
        DataHandler.htmlFile = null;
        DataHandler.cssFile = null;

        wEngine = webView.getEngine();
        String userDataDirectory = System.getProperty("user.dir") + "/myapp";
        wEngine.setUserDataDirectory(new File(userDataDirectory));
        File f = new File("/home/local/ZOHOCORP/sriram-pt6515/IdeaProjects/demo1/src/main/"+Application.curProjectName+"/Html");
        if(!f.exists()){
            try {
                f.mkdirs();
                f = new File("/home/local/ZOHOCORP/sriram-pt6515/IdeaProjects/demo1/src/main/"+Application.curProjectName +"/Html/index.html");
                f.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        wEngine.load("file:///home/local/ZOHOCORP/sriram-pt6515/IdeaProjects/demo1/src/main/"+Application.curProjectName +"/Html/index.html");
        System.out.println("cur proj name"+Application.curProjectName);
        load = true;

    }

    @FXML
    public void showHtml() throws FileNotFoundException {




    }

    @FXML
    public void createProject(){
        Popup popup = new Popup();

        TextField input = new TextField();
        input.setPrefSize(200,200);
        Button submit = new Button("create");
        popup.getContent().addAll(input,submit);

        submit.setOnMouseClicked(mouseEvent -> {
            load = false;
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

            popup.hide();
        });
        popup.setWidth(500);
        popup.setHeight(500);
        popup.setX(600);
        popup.setY(500);

        popup.show(root.getScene().getWindow());

    }

    @FXML
    public void createStaticProject(){
        isStatic = true;
        createProject();

    }


}