package com.demo1.demo1.utilities;

import com.demo1.demo1.Application;
import com.demo1.demo1.elements.Element;
import com.demo1.demo1.elements.TreeHandler;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;

import java.io.*;

public class DataHandler {

    public static Element root = TreeHandler.root;
    public static StringBuilder html;
    public static StringBuilder css;

    public static File htmlFile;
    public static File cssFile;
    static PrintWriter writer;

    public static void save(){
        html = new StringBuilder();
        css = new StringBuilder();
        getData(root);
        System.out.println(html);
        System.out.println(css);
        saveHtmlData(html.toString());
        saveCssData(css.toString());

    }

    public static void getData(Element e){

        html.append(e.openTag());
        if(e.elementName.equals("head")){
            html.append("<link rel=\"stylesheet\" href=\"../Styles/styles.css\">");
        }

        css.append(e.css);

        for(Element i : e.childs){
            getData(i);
        }

        html.append(e.closeTag());


    }

    public static void saveHtmlData(String s){
        if(htmlFile == null){
            htmlFile = new File("src/main/"+ Application.curProjectName +"/Html/index.html");
            if(!htmlFile.exists()) {
                try {
                    File temp = new File("src/main/"+Application.curProjectName+"/Html");
                    temp.mkdirs();
                    if (!htmlFile.exists()) {
                        System.out.println("file created at "+Application.curProjectName);
                        htmlFile.createNewFile();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

       try {
           writer = new PrintWriter(new FileWriter(htmlFile));
           writer.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           writer.flush();
           writer.close();
       }
    }


    private static void saveCssData(String s) {

        if(cssFile == null){
            cssFile = new File("src/main/"+ Application.curProjectName +"/Styles/styles.css");
            try {
                File temp = new File("src/main/"+Application.curProjectName+"/Styles");
                temp.mkdirs();
                if (!cssFile.exists()) {
                    cssFile.createNewFile();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        try {
            writer = new PrintWriter(new FileWriter(cssFile));
            writer.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.flush();
            writer.close();
        }

    }


}
