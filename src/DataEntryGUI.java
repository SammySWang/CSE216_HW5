import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.w3c.dom.Text;
import org.w3c.dom.events.Event;

import javax.swing.*;

public class DataEntryGUI extends Application implements EventHandler<ActionEvent>{


    private TextField text1 = new TextField();
    private TextField text2 = new TextField();
    private TextField text3 = new TextField();
    private TextField text4 = new TextField();
    private TextField text5 = new TextField();
    private TextField text6 = new TextField();
    private Button create = new Button("Create Profile");
    private Button close = new Button("Close");
    private Stage outsideStage = new Stage();
    private TextField[] arrayOfTexts = {text1,text2,text3,text4,text5,text6};


    @Override
    public void start(Stage primaryStage){

        GridPane gridpane = new GridPane();
        BorderPane x = new BorderPane();

        gridpane.setAlignment(Pos.CENTER);
        gridpane.setVgap(10);
        gridpane.setHgap(10);
        x.setCenter(create);
        gridpane.setPadding(new Insets(10,12,1,14));

        gridpane.add(text1, 0,0);
        gridpane.add(text2, 1,0);
        gridpane.add(text3, 0,1);
        gridpane.add(text4, 1,1);
        gridpane.add(text5, 0,2);
        gridpane.add(text6, 1,2);
        gridpane.add(x,0,3);
        gridpane.setColumnSpan(x,2);
        //x.setDisable(true);
        create.setDisable(true);

        text1.setPromptText("Name");
        text2.setPromptText("(###) ###-####");
        text3.setPromptText("Name");
        text4.setPromptText("(###) ###-####");
        text5.setPromptText("Name");
        text6.setPromptText("(###) ###-####");



        //create.setOnAction(event -> System.out.print("a")); also works

        //while(!notClickYet) {

            /*text1.setOnKeyReleased(event -> {
                if (event.getCode() == KeyCode.TAB) {
                    if (!text1.getText().matches("^[[A-Z]+[a-zA-Z]*[\s]{1}[A-Z]+[a-zA-Z]*]{0,20}$")) {
                        text1.setStyle("-fx-text-inner-color: red;");
                    }else {
                        text1.setStyle("-fx-text-inner-color: black;");
                    }
                }
            });*/

        text1.setOnKeyReleased(event -> {
            check_valid();
            if (event.getCode() == KeyCode.TAB) {

                if(text1.getText().isEmpty()) {
                    text1.setStyle("-fx-text-inner-color: black;");


                }
                else{
                    if(!text1.getText().matches("[A-Z][a-z]*[\\s]{1}[A-Z][a-z]*")) {

                        text1.setStyle("-fx-text-inner-color: red;");
                        check_valid();

                    }
                    else {
                        if(text1.getText().length() > 20){
                            text1.setStyle("-fx-text-inner-color: red;");
                            check_valid();
                        }else {
                            text1.setStyle("-fx-text-inner-color: black;");
                            check_valid();
                        }
                    }
                }
            }
        });
        text1.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                check_valid();
                if (newPropertyValue)
                {
                    if(text1.getText().isEmpty()){
                        text1.setStyle("-fx-text-inner-color: black;");


                    }else{

                    }
                }
                else
                {
                    if (!text1.getText().matches("[A-Z][a-z]*[\\s]{1}[A-Z][a-z]*")) {
                        text1.setStyle("-fx-text-inner-color: red;");
                        check_valid();
                    } else {
                        if(text1.getText().length() > 20){
                            text1.setStyle("-fx-text-inner-color: red;");
                            check_valid();
                        }else {
                            text1.setStyle("-fx-text-inner-color: black;");
                            check_valid();
                        }
                    }
                }
            }
        });
        //---------------------------------text 2-----------------------------
        text2.setOnKeyReleased(event -> {
            check_valid();
            if (event.getCode() == KeyCode.TAB) {
                if(text2.getText().isEmpty()) {
                    text2.setStyle("-fx-text-inner-color: black;");

                }
                else{
                    if(!text2.getText().matches("[(][0-9]{3}[)][\\s][0-9]{3}[-][0-9]{4}")) {
                        text2.setStyle("-fx-text-inner-color: red;");
                        check_valid();
                    }
                    else {
                        text2.setStyle("-fx-text-inner-color: black;");
                        check_valid();
                    }
                }
            }
        });
        text2.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                check_valid();
                if (newPropertyValue)
                {
                    if(text2.getText().isEmpty()){
                        text2.setStyle("-fx-text-inner-color: black;");

                    }else{

                    }
                }
                else
                {
                    if (!text2.getText().matches("[(][0-9]{3}[)][\\s][0-9]{3}[-][0-9]{4}")) {
                        text2.setStyle("-fx-text-inner-color: red;");
                        check_valid();
                    } else {
                        text2.setStyle("-fx-text-inner-color: black;");
                        check_valid();
                    }
                }
            }
        });
        //---------------------------------text 3-----------------------------
        text3.setOnKeyReleased(event -> {
            check_valid();
            if (event.getCode() == KeyCode.TAB) {
                if(text3.getText().isEmpty()) {
                    text3.setStyle("-fx-text-inner-color: black;");

                }
                else{
                    if(!text3.getText().matches("[A-Z][a-z]*[\\s]{1}[A-Z][a-z]*")) {

                        text3.setStyle("-fx-text-inner-color: red;");
                        check_valid();

                    }
                    else {
                        if(text3.getText().length() > 20){
                            text3.setStyle("-fx-text-inner-color: red;");
                            check_valid();
                        }else {
                            text3.setStyle("-fx-text-inner-color: black;");
                            check_valid();
                        }
                    }
                }
            }
        });
        text3.focusedProperty().addListener(new ChangeListener<Boolean>()
        {

            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                check_valid();
                if (newPropertyValue)
                {
                    if(text3.getText().isEmpty()){
                        text3.setStyle("-fx-text-inner-color: black;");

                    }else{

                    }
                }
                else
                {
                    if (!text3.getText().matches("[A-Z][a-z]*[\\s]{1}[A-Z][a-z]*")) {
                        text3.setStyle("-fx-text-inner-color: red;");
                        check_valid();
                    } else {
                        if(text3.getText().length() > 20){
                            text3.setStyle("-fx-text-inner-color: red;");
                            check_valid();
                        }else {
                            text3.setStyle("-fx-text-inner-color: black;");
                            check_valid();
                        }
                    }
                }
            }
        });
        //---------------------------------text 4-----------------------------
        text4.setOnKeyReleased(event -> {
            check_valid();
            if (event.getCode() == KeyCode.TAB) {
                if(text4.getText().isEmpty()) {
                    text4.setStyle("-fx-text-inner-color: black;");

                }
                else{
                    if(!text4.getText().matches("[(][0-9]{3}[)][\\s][0-9]{3}[-][0-9]{4}")) {
                        text4.setStyle("-fx-text-inner-color: red;");
                        check_valid();
                    }
                    else {
                        text4.setStyle("-fx-text-inner-color: black;");
                        check_valid();
                    }
                }
            }
        });
        text4.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                check_valid();
                if (newPropertyValue)
                {
                    if(text4.getText().isEmpty()){
                        text4.setStyle("-fx-text-inner-color: black;");

                    }else{

                    }
                }
                else
                {
                    if (!text4.getText().matches("[(][0-9]{3}[)][\\s][0-9]{3}[-][0-9]{4}")) {
                        text4.setStyle("-fx-text-inner-color: red;");
                        check_valid();
                    } else {
                        text4.setStyle("-fx-text-inner-color: black;");
                        check_valid();
                    }
                }
            }
        });
        //---------------------------------text 5-----------------------------
        text5.setOnKeyReleased(event -> {
            check_valid();
            if (event.getCode() == KeyCode.TAB) {
                if(text5.getText().isEmpty()) {
                    text5.setStyle("-fx-text-inner-color: black;");

                }
                else{
                    if(!text5.getText().matches("[A-Z][a-z]*[\\s]{1}[A-Z][a-z]*")) {

                        text5.setStyle("-fx-text-inner-color: red;");
                        check_valid();

                    }
                    else {
                        if(text5.getText().length() > 20){
                            text5.setStyle("-fx-text-inner-color: red;");
                            check_valid();
                        }else {
                            text5.setStyle("-fx-text-inner-color: black;");
                            check_valid();
                        }
                    }
                }
            }
        });
        text5.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                check_valid();
                if (newPropertyValue)
                {

                    if(text5.getText().isEmpty()){
                        text5.setStyle("-fx-text-inner-color: black;");

                    }else{

                    }
                }
                else
                {
                    if (!text5.getText().matches("[A-Z][a-z]*[\\s]{1}[A-Z][a-z]*")) {
                        text5.setStyle("-fx-text-inner-color: red;");
                        check_valid();
                    } else {
                        if(text5.getText().length() > 20){
                            text5.setStyle("-fx-text-inner-color: red;");
                            check_valid();
                        }else {
                            text5.setStyle("-fx-text-inner-color: black;");
                            check_valid();
                        }
                    }
                }
            }
        });
        //---------------------------------text 6-----------------------------
        text6.setOnKeyReleased(event -> {
            check_valid();
            if (event.getCode() == KeyCode.TAB) {
                if(text6.getText().isEmpty()) {
                    text6.setStyle("-fx-text-inner-color: black;");
                }
                else{
                    if(!text6.getText().matches("[(][0-9]{3}[)][\\s][0-9]{3}[-][0-9]{4}"))  {
                        text6.setStyle("-fx-text-inner-color: red;");
                        check_valid();
                    }
                    else {
                        text6.setStyle("-fx-text-inner-color: black;");
                        check_valid();
                    }
                }
            }
        });
        text6.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                check_valid();
                if (newPropertyValue)
                {
                    if(text6.getText().isEmpty()){
                        text6.setStyle("-fx-text-inner-color: black;");
                    }else{
                    }
                }
                else
                {
                    if (!text6.getText().matches("[(][0-9]{3}[)][\\s][0-9]{3}[-][0-9]{4}"))  {
                        text6.setStyle("-fx-text-inner-color: red;");
                        check_valid();
                    } else {
                        text6.setStyle("-fx-text-inner-color: black;");
                        check_valid();
                    }
                }
            }
        });

            Scene scene = new Scene(gridpane,500,350);
            primaryStage.setTitle("Data Entry GUI");
            primaryStage.setScene(scene);
            primaryStage.show();
            create.setOnAction(this);// when create is clicked
    }

    @Override
    public void handle(ActionEvent event) {
        //when button is clicked

        if(event.getSource() == create){
            if(checkName(text1.getText())){
                if(checkPhone(text2.getText())){
                    if(checkName(text3.getText())){
                        if(checkPhone(text4.getText())){
                            if(checkName(text5.getText())){
                                if(checkPhone(text6.getText())){
                                    for(TextField x: arrayOfTexts){
                                        //x.setDisable(true);
                                        x.setEditable(false);
                                    }
                                    start_correct(outsideStage);
                                }else{
                                    start_error(outsideStage);
                                }
                            }else{
                                start_error(outsideStage);
                            }
                        }else{
                            start_error(outsideStage);
                        }
                    }else{
                        start_error(outsideStage);
                    }
                }else{
                    start_error(outsideStage);
                }
            }else{
                start_error(outsideStage);
            }
        }

    }


    public static boolean checkName(String name){

        if(name.length() > 20) {
            return false;
        }
        else{
            if (name.matches("[A-Z][a-z]*[\\s]{1}[A-Z][a-z]*")) {

                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean checkPhone(String phone){
        if(phone.matches("[(][0-9]{3}[)][\\s][0-9]{3}[-][0-9]{4}")){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isGrayText(TextField x){

        if(x.getPromptText().equals("Name")){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isGrayPhone(TextField x){

        if(x.getPromptText().equals("(###) ###-####")){
            return true;
        }else{
            return false;
        }
    }

    public static void validNameBlack(TextField[] arrays){

        for(TextField x: arrays){
            if(checkName(x.getText())){
                x.setStyle("-fx-text-inner-color: black;");
            }else{
                x.setStyle("-fx-text-inner-color: red;");
            }
        }

    }

    public static void invalidNameRed(TextField[] arrays){

        for(TextField x: arrays){
            if(checkName(x.getText())){
                x.setStyle("-fx-text-inner-color: black;");
            }else{
                x.setStyle("-fx-text-inner-color: red;");
            }
        }

    }

    public static void validPhoneBlack(TextField[] arrays){

        for(TextField x: arrays){
            if(checkPhone(x.getText())){
                x.setStyle("-fx-text-inner-color: black;");
            }else{
                x.setStyle("-fx-text-inner-color: red;");
            }
        }

    }
    public static void invalidPhoneRed(TextField[] arrays){

        for(TextField x: arrays){
            if(checkPhone(x.getText())){
                x.setStyle("-fx-text-inner-color: black;");
            }else{
                x.setStyle("-fx-text-inner-color: red;");
            }
        }

    }

    public static boolean errorPop(TextField[] boxes){
        if(checkName(boxes[0].getText())) {
            if (checkPhone(boxes[1].getText())) {
                if (checkName(boxes[2].getText())) {
                    if (checkPhone(boxes[3].getText())) {
                        if (checkName(boxes[4].getText())) {
                            if (checkPhone(boxes[5].getText())) {
                                return false;
                            }else{
                                return true;
                            }
                        } else {
                            return true;

                        }
                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
            } else {
                return true;

            }
        }else{
            return true;
        }
    }
    
    public static boolean validPop(TextField[] boxes){
            if(checkName(boxes[0].getText())) {
                if (checkPhone(boxes[1].getText())) {
                    if (checkName(boxes[2].getText())) {
                        if (checkPhone(boxes[3].getText())) {
                            if (checkName(boxes[4].getText())) {
                                if (checkPhone(boxes[5].getText())) {
                                    for(TextField x: boxes){
                                        x.setEditable(false);
                                    }
                                    return true;
                                }else{
                                    return false;
                                }
                            } else {
                                return false;

                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;

                }
            }else{
                return false;
            }
        }

    public void start_correct(Stage correct_stage)
    {
        GridPane gridpane = new GridPane();
        BorderPane x = new BorderPane();

        gridpane.setAlignment(Pos.CENTER);
        gridpane.setVgap(10);
        gridpane.setHgap(10);
        x.setCenter(close);
        gridpane.setPadding(new Insets(10,12,1,14));
        gridpane.add(x,0,3);
        gridpane.setColumnSpan(x,2);
        Label correct_text = new Label("The profiles have been saved and added to the database.");
        correct_text.setAlignment(Pos.CENTER);
        gridpane.add(correct_text,0,0);
        Scene scene = new Scene(gridpane,800,100);
        correct_stage.setTitle("Data Saved");
        correct_stage.setScene(scene);
        correct_stage.show();
        //create.setDisable(true);
        close.setOnAction(e -> correct_stage.close());
    }

    public void start_error(Stage error_stage)
    {
        GridPane gridpane = new GridPane();
        BorderPane x = new BorderPane();

        gridpane.setAlignment(Pos.CENTER);
        gridpane.setVgap(10);
        gridpane.setHgap(10);
        x.setCenter(close);
        gridpane.setPadding(new Insets(10,12,1,14));
        gridpane.add(x,0,3);
        gridpane.setColumnSpan(x,2);
        Label error_text = new Label("Invalid input: you have attempted to provide one or more invalid input(s). Please correct the information displayed in red and retry.");
        error_text.setAlignment(Pos.CENTER);
        gridpane.add(error_text,0,0);
        Scene scene = new Scene(gridpane,800,100);
        error_stage.setTitle("Invalid input error");
        error_stage.setScene(scene);
        error_stage.show();
        close.setOnAction(e -> error_stage.close());
    }

    public void check_valid(){
        if(!text1.getText().equals("")) {
            if (!text2.getText().equals("")) {
                if (!text3.getText().equals("")) {
                    if (!text4.getText().equals("")) {
                        if (!text5.getText().equals("")) {
                            if (!text6.getText().equals("")) {
                                create.setDisable(false);
                            }else{
                                create.setDisable(true);
                            }
                        }else{
                            create.setDisable(true);
                        }
                    }else{
                        create.setDisable(true);
                    }
                }else{
                    create.setDisable(true);
                }
            }else{
                create.setDisable(true);
            }
        }else{
            create.setDisable(true);
        }
    }

    public static boolean buttonDisabled(TextField[] boxes,Button create){

        for(TextField x: boxes){
            if(x.getText().equals("")){
                create.setDisable(true);
                return true;
            }
        }
        create.setDisable(false);
        return false;

    }

    public static boolean buttonEnabled(TextField[] boxes,Button create){

        for(TextField x: boxes){
            if(x.getText().equals("")){
                create.setDisable(true);
                return false;
            }
        }
        create.setDisable(false);
        return true;

    }

   /* public static boolean invalidInformation(TextField[] boxes){

        for(TextField x: boxes){
            if()
        }
    }*/


    public static void main(String[] args){
        launch(args);
    }


}
