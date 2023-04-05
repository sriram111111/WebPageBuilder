package com.demo1.demo1.elements;

import com.demo1.demo1.utilities.DataHandler;
import com.demo1.demo1.utilities.ElementHandler;
import javafx.scene.control.TreeView;

public class TreeHandler{

    public static Element tree = new Element("tree");
    public static Element root = new Element("html");


    public static Element addNode(String name, String pid){
        System.out.println(pid);
        Element parent = ElementHandler.getElement(pid);
        if(parent == null){
            System.out.println("parent null");
        }
        return new Element(name,parent);
    }

    public static void addStaticNode(String name, String pid){

    }

    public static void removeNode(String id, Element parent, boolean b) {

        int n = 0;
        System.out.println(parent.childs.get(n).id+"\n"+id);
        while(!parent.childs.get(n).id.equals(id.substring(2))){
            System.out.println("log loop2");
            n++;
        }

        parent.component.getChildren().remove(n);
        parent.childs.remove(n);
        if(b)
            DataHandler.save();

    }

    public static Element removeNode(String id){

        Element e = ElementHandler.getElement(id);

        removeNode(id,e.parent,false);
        return e;
    }


    public void initialize(TreeView treeView ) {
        treeView.setRoot(root.component);
    }
}
