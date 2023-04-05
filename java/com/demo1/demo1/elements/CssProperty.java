package com.demo1.demo1.elements;

import java.util.HashSet;
import java.util.Set;

public class CssProperty implements Cloneable{

    public String id;
    public boolean canContainId = true;
    public String htmlName;

    public String inline = "";

    public Set<String> properties = new HashSet<>();
    public static Set<String> classList = new HashSet<>();

    //Properties
    private String color = "";
    private String backgroundColor = "";
    private String content;

    private String backgroundImageUrl = "";
    private String backgroundRepeat = "";
    private String backgroundPositionX = "";
    private String backgroundPositionY = "";
    private String backgroundSize = "";

    private String borderWidth = "";
    private String borderStyle = "";
    private String borderColor = "";
    private String borderTopWidth = "";
    private String borderTopStyle = "";
    private String borderTopColor = "";
    private String borderBottomWidth = "";
    private String borderBottomStyle = "";
    private String borderBottomColor = "";
    private String borderLeftWidth = "";
    private String borderLeftStyle = "";
    private String borderLeftColor = "";
    private String borderRightWidth = "";
    private String borderRightStyle = "";
    private String borderRightColor = "";

    private String marginTop = "";
    private String marginBottom = "";
    private String marginRight = "";
    private String marginLeft = "";

    private String paddingTop = "";
    private String paddingRight = "";
    private String paddingBottom = "";
    private String paddingLeft = "";

    private String position = "";
    private String positionTop = "";
    private String positionBottom = "";
    private String positionLeft = "";
    private String positionRight = "";
    private String height = "";
    private String width = "";

    private String textAlign = "";
    private String textDecoration = "";
    private String fontColor = "";
    private String fontSize = "";
    private String fontFamily = "";
    private String fontStyle = "";
    private String fontWeight = "";

    private String gridArea = "";
    private String gridAutoColumns = "";
    private String gridAutoFlow = "";
    private String gap = "";
    private String columnGap = "";
    private String rowGap = "";
    private String gridGap = "";
    private String gridAutoRows = "";
    private String gridColumns = "";
    private String gridColumnStart = "";
    private String gridColumnGap = "";
    private String gridColumnEnd = "";
    private String gridRow = "";
    private String gridRowStart = "";
    private String gridRowEnd = "";
    private String gridTemplate = "";
    private String gridTemplateAreas = "";
    private String gridTemplateColumns = "";
    private String gridTemplateRows = "";
    private String floatPosition = "";
    private String positionZ = "";

    private String styleClass = " ";
    private String htmlClass = "";
    private String customStyles = "";


    public String getHtmlClass() {
        return htmlClass;
    }

    public void setHtmlClass(String htmlClass) {
        this.htmlClass = htmlClass;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String classProperty) {
        this.styleClass = classProperty;
    }

    public String getCustomStyles() {
        return customStyles;
    }

    public void setCustomStyles(String customStyles) {
        this.customStyles = customStyles;
    }

    public String getFloatPosition() {
        return floatPosition;
    }

    public void setFloatPosition(String floatPosition) {
        this.floatPosition = floatPosition;
    }

    public String getPositionZ() {
        return positionZ;
    }

    public void setPositionZ(String positionZ) {
        this.positionZ = positionZ;
    }

    public String getGridArea() {
        return gridArea;
    }

    public void setGridArea(String gridArea) {
        this.gridArea = gridArea;
    }

    public String getGridAutoColumns() {
        return gridAutoColumns;
    }

    public void setGridAutoColumns(String gridAutoColumns) {
        this.gridAutoColumns = gridAutoColumns;
    }

    public String getGridAutoFlow() {
        return gridAutoFlow;
    }

    public void setGridAutoFlow(String gridAutoFlow) {
        this.gridAutoFlow = gridAutoFlow;
    }

    public String getGap() {
        return gap;
    }

    public void setGap(String gap) {
        this.gap = gap;
    }

    public String getColumnGap() {
        return columnGap;
    }

    public void setColumnGap(String columnGap) {
        this.columnGap = columnGap;
    }

    public String getRowGap() {
        return rowGap;
    }

    public void setRowGap(String rowGap) {
        this.rowGap = rowGap;
    }

    public String getGridGap() {
        return gridGap;
    }

    public void setGridGap(String gridGap) {
        this.gridGap = gridGap;
    }

    public String getGridAutoRows() {
        return gridAutoRows;
    }

    public void setGridAutoRows(String gridAutoRows) {
        this.gridAutoRows = gridAutoRows;
    }

    public String getGridColumns() {
        return gridColumns;
    }

    public void setGridColumns(String gridColumns) {
        this.gridColumns = gridColumns;
    }

    public String getGridColumnStart() {
        return gridColumnStart;
    }

    public void setGridColumnStart(String gridColumnStart) {
        this.gridColumnStart = gridColumnStart;
    }

    public String getGridColumnGap() {
        return gridColumnGap;
    }

    public void setGridColumnGap(String gridColumnGap) {
        this.gridColumnGap = gridColumnGap;
    }

    public String getGridColumnEnd() {
        return gridColumnEnd;
    }

    public void setGridColumnEnd(String gridColumnEnd) {
        this.gridColumnEnd = gridColumnEnd;
    }

    public String getGridRow() {
        return gridRow;
    }

    public void setGridRow(String gridRow) {
        this.gridRow = gridRow;
    }

    public String getGridRowStart() {
        return gridRowStart;
    }

    public void setGridRowStart(String gridRowStart) {
        this.gridRowStart = gridRowStart;
    }

    public String getGridRowEnd() {
        return gridRowEnd;
    }

    public void setGridRowEnd(String gridRowEnd) {
        this.gridRowEnd = gridRowEnd;
    }

    public String getGridTemplate() {
        return gridTemplate;
    }

    public void setGridTemplate(String gridTemplate) {
        this.gridTemplate = gridTemplate;
    }

    public String getGridTemplateAreas() {
        return gridTemplateAreas;
    }

    public void setGridTemplateAreas(String gridTemplateAreas) {
        this.gridTemplateAreas = gridTemplateAreas;
    }

    public String getGridTemplateColumns() {
        return gridTemplateColumns;
    }

    public void setGridTemplateColumns(String gridTemplateColumns) {
        this.gridTemplateColumns = gridTemplateColumns;
    }

    public String getGridTemplateRows() {
        return gridTemplateRows;
    }

    public void setGridTemplateRows(String gridTemplateRows) {
        this.gridTemplateRows = gridTemplateRows;
    }

    public String getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }

    public String getTextAlign() {
        return textAlign;
    }

    public void setTextAlign(String textAlign) {
        this.textAlign = textAlign;
    }

    public String getTextDecoration() {
        return textDecoration;
    }

    public void setTextDecoration(String textDecoration) {
        this.textDecoration = textDecoration;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public String getFontWeight() {
        return fontWeight;
    }

    public void setFontWeight(String fontWeight) {
        this.fontWeight = fontWeight;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositionTop() {
        return positionTop;
    }

    public void setPositionTop(String positionTop) {
        this.positionTop = positionTop;
    }

    public String getPositionBottom() {
        return positionBottom;
    }

    public void setPositionBottom(String positionBottom) {
        this.positionBottom = positionBottom;
    }

    public String getPositionLeft() {
        return positionLeft;
    }

    public void setPositionLeft(String positionLeft) {
        this.positionLeft = positionLeft;
    }

    public String getPositionRight() {
        return positionRight;
    }

    public void setPositionRight(String positionRight) {
        this.positionRight = positionRight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getPaddingTop() {
        return paddingTop;
    }

    public void setPaddingTop(String paddingTop) {
        this.paddingTop = paddingTop;
    }

    public String getPaddingRight() {
        return paddingRight;
    }

    public void setPaddingRight(String paddingRight) {
        this.paddingRight = paddingRight;
    }

    public String getPaddingBottom() {
        return paddingBottom;
    }

    public void setPaddingBottom(String paddingBottom) {
        this.paddingBottom = paddingBottom;
    }

    public String getPaddingLeft() {
        return paddingLeft;
    }

    public void setPaddingLeft(String paddingLeft) {
        this.paddingLeft = paddingLeft;
    }

    public String getMarginTop() {
        return marginTop;
    }

    public void setMarginTop(String marginTop) {
        this.marginTop = marginTop;
    }

    public String getMarginBottom() {
        return marginBottom;
    }

    public void setMarginBottom(String marginBottom) {
        this.marginBottom = marginBottom;
    }

    public String getMarginRight() {
        return marginRight;
    }

    public void setMarginRight(String marginRight) {
        this.marginRight = marginRight;
    }

    public String getMarginLeft() {
        return marginLeft;
    }

    public void setMarginLeft(String marginLeft) {
        this.marginLeft = marginLeft;
    }

    public String getBorderTopWidth() {
        return borderTopWidth;
    }

    public void setBorderTopWidth(String borderTopWidth) {
        this.borderTopWidth = borderTopWidth;
    }

    public String getBorderTopStyle() {
        return borderTopStyle;
    }

    public void setBorderTopStyle(String borderTopStyle) {
        this.borderTopStyle = borderTopStyle;
    }

    public String getBorderTopColor() {
        return borderTopColor;
    }

    public void setBorderTopColor(String borderTopColor) {
        this.borderTopColor = borderTopColor;
    }

    public String getBorderBottomWidth() {
        return borderBottomWidth;
    }

    public void setBorderBottomWidth(String borderBottomWidth) {
        this.borderBottomWidth = borderBottomWidth;
    }

    public String getBorderBottomStyle() {
        return borderBottomStyle;
    }

    public void setBorderBottomStyle(String borderBottomStyle) {
        this.borderBottomStyle = borderBottomStyle;
    }

    public String getBorderBottomColor() {
        return borderBottomColor;
    }

    public void setBorderBottomColor(String borderBottomColor) {
        this.borderBottomColor = borderBottomColor;
    }

    public String getBorderLeftWidth() {
        return borderLeftWidth;
    }

    public void setBorderLeftWidth(String borderLeftWidth) {
        this.borderLeftWidth = borderLeftWidth;
    }

    public String getBorderLeftStyle() {
        return borderLeftStyle;
    }

    public void setBorderLeftStyle(String borderLeftStyle) {
        this.borderLeftStyle = borderLeftStyle;
    }

    public String getBorderLeftColor() {
        return borderLeftColor;
    }

    public void setBorderLeftColor(String borderLeftColor) {
        this.borderLeftColor = borderLeftColor;
    }

    public String getBorderRightWidth() {
        return borderRightWidth;
    }

    public void setBorderRightWidth(String borderRightWidth) {
        this.borderRightWidth = borderRightWidth;
    }

    public String getBorderRightStyle() {
        return borderRightStyle;
    }

    public void setBorderRightStyle(String borderRightStyle) {
        this.borderRightStyle = borderRightStyle;
    }

    public String getBorderRightColor() {
        return borderRightColor;
    }

    public void setBorderRightColor(String borderRightColor) {
        this.borderRightColor = borderRightColor;
    }

    public String getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(String borderWidth) {
        this.borderWidth = borderWidth;
    }

    public String getBorderStyle() {
        return borderStyle;
    }

    public void setBorderStyle(String borderStyle) {
        this.borderStyle = borderStyle;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBackgroundImageUrl() {
        return backgroundImageUrl;
    }

    public void setBackgroundImageUrl(String backgroundImageUrl) {
        this.backgroundImageUrl = backgroundImageUrl;
    }

    public String getBackgroundRepeat() {
        return backgroundRepeat;
    }

    public void setBackgroundRepeat(String backgroundRepeat) {
        this.backgroundRepeat = backgroundRepeat;
    }

    public String getBackgroundPositionX() {
        return backgroundPositionX;
    }

    public void setBackgroundPositionX(String backgroundPositionX) {
        this.backgroundPositionX = backgroundPositionX;
    }

    public String getBackgroundPositionY() {
        return backgroundPositionY;
    }

    public void setBackgroundPositionY(String backgroundPositionY) {
        this.backgroundPositionY = backgroundPositionY;
    }

    public String getBackgroundSize() {
        return backgroundSize;
    }

    public void setBackgroundSize(String backgroundSize) {
        this.backgroundSize = backgroundSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CssProperty(String id, String name){
        this.id = id;
        htmlName = name;

        properties.add("border");
        properties.add("display");
        properties.add("float");
        properties.add("transform");
        properties.add("margin");
        properties.add("padding");
        properties.add("text");
        properties.add("grid");
        properties.add("content");



        switch(name){
            case "html","head","body":
                canContainId = false;
                properties.add("color");
                properties.add("background");

                break;
            case "title","h1","h2","h3","h4","h5","h6","p","li","th","td":
                properties.add("color");
                properties.add("background");
                break;
            case "div","span","ul","ol","table","tr","section","form","header","footer","nav","aside","textarea","select","option","button","label":
                properties.add("background");
                break;
            case "img","input","a":
                properties.add("inline");
                break;
        }

    }

    @Override
    public String toString(){

        if(htmlName.equals("html"))
            classList.clear();

        System.out.println("log for loop");
        StringBuilder out = new StringBuilder();
        if(canContainId){
            out.append("#id"+id);
            System.out.println(styleClass);
            if(!styleClass.equals(" ")){
                int start = 0;
                int n = styleClass.indexOf(" ");
                System.out.println(n);
                while(n != -1){
                    System.out.println("log for loop3");
                    String s = styleClass.substring(start, n);
                    if(!classList.contains(s)){
                        out.append(",."+s);
                        classList.add(s);
                    }
                    start = n;
                    n = styleClass.substring(start+1).indexOf(" ");
                }
            }
        } else
            out.append(htmlName);
        out.append("{");

        if(!color.equals(""))
            out.append("\ncolor:#"+color.substring(2)+";");

        backgroundCode(out);
        borderCode(out);
        marginCode(out);
        paddingCode(out);
        transformCode(out);
        textCode(out);
        gridCode(out);
        customCode(out);

        out.append("\n}\n");
        return out.toString();
    }

    public void borderCode(StringBuilder out){
        if(!borderBottomColor.equals(""))
            out.append("\nborder-bottom-color : #"+borderBottomColor.substring(2)+";");
        if(!borderBottomStyle.equals(""))
            out.append("\nborder-bottom-style : "+borderBottomStyle+";");
        if(!borderBottomWidth.equals(""))
            out.append("\nborder-bottom-width : "+borderBottomWidth+";");
        if(!borderRightColor.equals(""))
            out.append("\nborder-right-color : #"+borderRightColor.substring(2)+";");
        if(!borderRightStyle.equals(""))
            out.append("\nborder-right-style : "+borderRightStyle+";");
        if(!borderRightWidth.equals(""))
            out.append("\nborder-right-width : "+borderRightWidth+";");
        if(!borderTopColor.equals(""))
            out.append("\nborder-top-color : #"+borderTopColor.substring(2)+";");
        if(!borderTopStyle.equals(""))
            out.append("\nborder-top-style : "+borderTopStyle+";");
        if(!borderTopWidth.equals(""))
            out.append("\nborder-top-width : "+borderTopWidth+";");
        if(!borderLeftColor.equals(""))
            out.append("\nborder-left-color : #"+borderLeftColor.substring(2)+";");
        if(!borderLeftStyle.equals(""))
            out.append("\nborder-left-style : "+borderLeftStyle+";");
        if(!borderLeftWidth.equals(""))
            out.append("\nborder-left-width : "+borderLeftWidth+";");
        if(!borderColor.equals(""))
            out.append("\nborder-color : #"+borderColor.substring(2)+";");
        if(!borderStyle.equals(""))
            out.append("\nborder-style : "+borderStyle+";");
        if(!borderWidth.equals(""))
            out.append("\nborder-width : "+borderWidth+";");
    }

    public void backgroundCode(StringBuilder out){
        if(!backgroundColor.equals(""))
            out.append("\nbackground-color:#"+backgroundColor.substring(2)+";");
        if(!backgroundPositionY.equals("") && !backgroundPositionX.equals(""))
            out.append("\nbackground-position : "+backgroundPositionX+" "+backgroundPositionY+";");
        if(!backgroundSize.equals(""))
            out.append("\nbackground-size : "+backgroundSize+";");
        if(!backgroundImageUrl.equals(""))
            out.append("\nbackground-image : url('"+backgroundImageUrl+"');");
        if(!backgroundRepeat.equals(""))
            out.append("\nbackground-repeat : "+backgroundRepeat+";");
    }

    public void marginCode(StringBuilder out){

        if(!marginTop.equals(""))
            out.append("\nmargin-top : "+marginTop+";");
        if(!marginBottom.equals(""))
            out.append("\nmargin-Bottom : "+marginBottom+";");
        if(!marginRight.equals(""))
            out.append("\nmargin-Right : "+marginRight+";");
        if(!marginLeft.equals(""))
            out.append("\nmargin-Left : "+marginLeft+";");

    }

    public void paddingCode(StringBuilder out){

        if(!paddingTop.equals(""))
            out.append("\npadding-top : "+paddingTop+";");
        if(!paddingBottom.equals(""))
            out.append("\npadding-Bottom : "+paddingBottom+";");
        if(!paddingRight.equals(""))
            out.append("\npadding-Right : "+paddingRight+";");
        if(!paddingLeft.equals(""))
            out.append("\npadding-Left : "+paddingLeft+";");

    }

    public void transformCode(StringBuilder out){

        if(!position.equals(""))
            out.append("\nposition : "+position+";");
        if(!positionTop.equals(""))
            out.append("\ntop : "+positionTop+";");
        if(!positionRight.equals(""))
            out.append("\nright : "+positionRight+";");
        if(!positionBottom.equals(""))
            out.append("\nbottom : "+positionBottom+";");
        if(!positionLeft.equals(""))
            out.append("\nleft : "+positionLeft+";");
        if(!width.equals(""))
            out.append("\nwidth : "+width+";");
        if(!height.equals(""))
            out.append("\nheight : "+height+";");
        if(!floatPosition.equals(""))
            out.append("\nfloat : "+floatPosition+";");
        if(!positionZ.equals(""))
            out.append("\nz-index : "+positionZ+";");

    }

    public void textCode(StringBuilder out){

        if(!textAlign.equals(""))
            out.append("\ntext-align : "+textAlign+";");
        if(!textDecoration.equals(""))
            out.append("\ntext-decoration : "+textDecoration+";");
        if(!fontColor.equals(""))
            out.append("\nfont-color : #"+fontColor+";");
        if(!fontSize.equals(""))
            out.append("\nfont-size : "+fontSize+";");
        if(!fontFamily.equals(""))
            out.append("\nfont-family : "+fontFamily+";");
        if(!fontStyle.equals(""))
            out.append("\nfont-style : "+fontStyle+";");
        if(!fontWeight.equals(""))
            out.append("\nfont-weight : "+fontWeight+";");

    }

    public void gridCode(StringBuilder out){
        int n = out.length();
        if(!gridArea.equals(""))
            out.append("\ngrid-area : "+gridArea+";");
        if(!gridAutoColumns.equals(""))
            out.append("\ngrid-auto-columns : "+gridAutoColumns+";");
        if(!gridAutoFlow.equals(""))
            out.append("\ngrid-auto-flow : "+gridAutoFlow+";");
        if(!gap.equals(""))
            out.append("\ngap : "+gap+";");
        if(!columnGap.equals(""))
            out.append("\ncolumn-gap : "+columnGap+";");
        if(!rowGap.equals(""))
            out.append("\nrow-gap : "+rowGap+";");
        if(!gridGap.equals(""))
            out.append("\ngrid-gap : "+gridGap+";");
        if(!gridAutoRows.equals(""))
            out.append("\ngrid-auto-rows : "+gridAutoRows+";");
        if(!gridColumns.equals(""))
            out.append("\ngrid-columns : "+gridColumns+";");
        if(!gridColumnStart.equals(""))
            out.append("\ngrid-column-start : "+gridColumnStart+";");
        if(!gridColumnGap.equals(""))
            out.append("\ngrid-column-gap : "+gridColumnGap+";");
        if(!gridColumnEnd.equals(""))
            out.append("\ngrid-column-end : "+gridColumnEnd+";");
        if(!gridRow.equals(""))
            out.append("\ngrid-row : "+gridRow+";");
        if(!gridRowStart.equals(""))
            out.append("\ngrid-row-start : "+gridRowStart+";");
        if(!gridRow.equals(""))
            out.append("\ngrid-row-gap : "+gridRow+";");
        if(!gridRowEnd.equals(""))
            out.append("\ngrid-row-end : "+gridRowEnd+";");
        if(!gridTemplate.equals(""))
            out.append("\ngrid-template : "+gridTemplate+";");
        if(!gridTemplateAreas.equals(""))
            out.append("\ngrid-template-areas : "+gridTemplateAreas+";");
        if(!gridTemplateColumns.equals(""))
            out.append("\ngrid-template-columns : "+gridTemplateColumns+";");
        if(!gridTemplateRows.equals(""))
            out.append("\ngrid-template-rows : "+gridTemplateRows+";");
        if(n != out.length())
            out.append("\ndisplay : grid");
    }

    public void customCode(StringBuilder out){
        if(!customStyles.equals("")){
            out.append("\n"+customStyles);
        }
    }

    public CssProperty copy() {
        try{
            return (CssProperty) this.clone();
        }catch(Exception e){
            return null;
        }

    }
}
