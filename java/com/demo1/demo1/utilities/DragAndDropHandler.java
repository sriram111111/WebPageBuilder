package com.demo1.demo1.utilities;

import com.demo1.demo1.elements.Element;
import com.demo1.demo1.elements.TreeHandler;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class DragAndDropHandler {

    public static void addDragAndDrop(Button treeView){

        treeView.setOnDragDetected(event -> {

            Dragboard dragboard = treeView.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(treeView.getId());
            System.out.println(content.getString());
            dragboard.setContent(content);
            dragboard.setDragView(new WritableImage(1, 1));

            event.consume();

        });


        treeView.setOnDragEntered(event -> {
            Dragboard dragboard = event.getDragboard();
            if (dragboard.getString().equals(treeView.getId()))
                return;
            if (event.getGestureSource() != treeView && event.getDragboard().hasFiles()) {
                treeView.setPrefSize(20,20);
                treeView.setMinSize(20,20);
                treeView.setMaxSize(20,20);
                treeView.setStyle("-fx-background-color: black;");
            }
        });

        treeView.setOnDragExited(event -> {
            Dragboard dragboard = event.getDragboard();
            if (dragboard.getString().equals(treeView.getId()))
                return;
            if (event.getGestureSource() != treeView) {
                treeView.setPrefSize(10,10);
                treeView.setMinSize(10,10);
                treeView.setMaxSize(10,10);
                treeView.setStyle("-fx-background-color: transparent; -fx-graphic: url('file:///home/local/ZOHOCORP/sriram-pt6515/IdeaProjects/demo1/src/main/java/com/demo1/demo1/utilities/icons8-drag-16.png');");

            }
        });

        treeView.setOnDragOver(dragEvent -> {
            Dragboard dragboard = dragEvent.getDragboard();
            if (dragboard.getString().equals(treeView.getId()))
                return;
            dragEvent.acceptTransferModes(TransferMode.MOVE);
            treeView.setPrefSize(20,20);
            treeView.setMinSize(20,20);
            treeView.setMaxSize(20,20);
            treeView.setStyle("-fx-background-color: black;");
        });


        treeView.setOnDragDropped(event -> {
            try {
                Dragboard dragboard = event.getDragboard();
                if (dragboard.getString().equals(treeView.getId()))
                    return;
                System.out.println(dragboard.getString());
                Element e = TreeHandler.removeNode("id" + dragboard.getString());
                System.out.println("parent component" + treeView.getId());

                Element parent = ElementHandler.getElement("id" + treeView.getId());
                parent.addChild(e);

            }catch(Exception e){
                System.out.println("Exception in drag and drop");
                return;
            }


            event.setDropCompleted(true);
            DataHandler.save();
            event.consume();
        });

    }





}
