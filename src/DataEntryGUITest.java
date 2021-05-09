import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.crypto.Data;

import static org.junit.Assert.*;

public class DataEntryGUITest {

    private TextField text1;
    private TextField text2;
    private TextField text3;
    private TextField text4;
    private TextField text5;
    private TextField text6;

    private Button create;

    @Before
    public void setUp() {
        JFXPanel x = new JFXPanel();
        text1 = new TextField();
        text2=  new TextField();
        text3 = new TextField();
        text4 = new TextField();
        text5 = new TextField();
        text6 = new TextField();
        create = new Button("Create Profile");

    }

    @After
    public void tearDown(){
        text1 = null;
        text2 = null;
        text3 = null;
        text4 = null;
        text5 = null;
        text6 = null;
        create = null;

    }

    @Test
    public void isGrayText_Test(){
        text1.setPromptText("Name");
        text3.setPromptText("Name");
        text5.setPromptText("Name");
        TextField[] nameBoxes = {text1,text3,text5};
        for(TextField x: nameBoxes){
            assertEquals(true,DataEntryGUI.isGrayText(x));
        }
    }

    @Test
    public void isGrayPhone_Test(){
        text2.setPromptText("(###) ###-####");
        text4.setPromptText("(###) ###-####");
        text6.setPromptText("(###) ###-####");
        TextField[] nameBoxes = {text2,text4,text6};
        for(TextField x: nameBoxes){
            assertEquals(true,DataEntryGUI.isGrayPhone(x));
        }
    }

    @Test
    public void checkName_Test(){
        text1.setText("aa");
        text3.setText("bb");
        text5.setText("cc");

        assertEquals(true, !DataEntryGUI.checkName(text1.getText()));
        assertEquals(true, !DataEntryGUI.checkName(text3.getText()));
        assertEquals(true, !DataEntryGUI.checkName(text5.getText()));

        text1.setText("A A");
        text3.setText("B B");
        text5.setText("Aaaaaa A");

        assertEquals(true, DataEntryGUI.checkName(text1.getText()));
        assertEquals(true, DataEntryGUI.checkName(text3.getText()));
        assertEquals(true, DataEntryGUI.checkName(text5.getText()));
    }

  /*  @Test
    public void checkName_ValidTest(){
        text1.setText("A A");
        text3.setText("B B");
        text5.setText("Aaaaaa A");

        assertEquals(true, DataEntryGUI.checkName(text1.getText()));
        assertEquals(true, DataEntryGUI.checkName(text3.getText()));
        assertEquals(true, DataEntryGUI.checkName(text5.getText()));

    }
*/
    @Test
    public void checkPhone_Test(){

        text2.setText("111");
        text4.setText("1");
        text6.setText("123 456 7891");

        assertEquals(true,!DataEntryGUI.checkPhone(text2.getText()));
        assertEquals(true,!DataEntryGUI.checkPhone(text4.getText()));
        assertEquals(true,!DataEntryGUI.checkPhone(text6.getText()));

        text2.setText("(111) 111-1111");
        text4.setText("(111) 111-1112");
        text6.setText("(222) 111-1112");

        assertEquals(true,DataEntryGUI.checkPhone(text2.getText()));
        assertEquals(true,DataEntryGUI.checkPhone(text4.getText()));
        assertEquals(true,DataEntryGUI.checkPhone(text6.getText()));
    }
/*    @Test
    public void checkPhone_ValidTest(){

        text2.setText("(111) 111-1111");
        text4.setText("(111) 111-1112");
        text6.setText("(222) 111-1112");

        assertEquals(true,DataEntryGUI.checkPhone(text2.getText()));
        assertEquals(true,DataEntryGUI.checkPhone(text4.getText()));
        assertEquals(true,DataEntryGUI.checkPhone(text6.getText()));
    }*/
    @Test
    public void validNameBlack_Red_Test(){

        text1.setText("A A");
        text3.setText("Aaaa Aa");
        text5.setText("Aaaa Aaa");
        TextField[] boxes = {text1,text3,text5};
        DataEntryGUI.validNameBlack(boxes);
        for(TextField x:boxes){
            assertEquals("-fx-text-inner-color: black;", x.getStyle());
        }

        text1.setText("a a");
        text3.setText("129 112");
        text5.setText("AAA A       ");
        DataEntryGUI.invalidNameRed(boxes);
        for(TextField x:boxes){
            assertEquals("-fx-text-inner-color: red;", x.getStyle());
        }
    }

/*    @Test
    public void invalidNameRed_Test(){

        text1.setText("a a");
        text3.setText("129 112");
        text5.setText("AAA A       ");
        TextField[] boxes = {text1,text3,text5};
        DataEntryGUI.invalidNameRed(boxes);
        for(TextField x:boxes){
            assertEquals("-fx-text-inner-color: red;", x.getStyle());
        }

    }*/

    @Test
    public void validPhoneBlack_Red_Test(){

        text2.setText("(111) 111-1111");
        text4.setText("(222) 111-1111");
        text6.setText("(333) 111-1111");
        TextField[] boxes = {text2,text4,text6};
        DataEntryGUI.validPhoneBlack(boxes);
        for(TextField x:boxes){
            assertEquals("-fx-text-inner-color: black;", x.getStyle());
        }

        text2.setText("111 111-1111");
        text4.setText("(222) 111-111");
        text6.setText("(333)111-1111");

        DataEntryGUI.invalidPhoneRed(boxes);
        for(TextField x:boxes){
            assertEquals("-fx-text-inner-color: red;", x.getStyle());
        }


    }

  /*  @Test
    public void invalidPhoneRed_Test(){

        text2.setText("111 111-1111");
        text4.setText("(222) 111-111");
        text6.setText("(333)111-1111");
        TextField[] boxes = {text2,text4,text6};
        DataEntryGUI.invalidPhoneRed(boxes);
        for(TextField x:boxes){
            assertEquals("-fx-text-inner-color: red;", x.getStyle());
        }

    }*/

    @Test
    public void buttonDisabled_Test(){
        text1.setText("Aa");
        text2.setText("Aa");
        text3.setText("Aa");
        text4.setText("Aa");
        text5.setText("Aa");
        text6.setText("");
        TextField[] boxes = {text1,text2,text3,text4,text5,text6};
        boolean disabled = DataEntryGUI.buttonDisabled(boxes,create);
        assertEquals(true,create.isDisabled());


        text1.setText("Aa");
        text2.setText("Aa");
        text3.setText("Aa");
        text4.setText("Aa");
        text5.setText("Aa");
        text6.setText("oll");

        boolean enabled = DataEntryGUI.buttonEnabled(boxes,create);
        assertEquals(true,!create.isDisabled());

    }

    @Test
    public void errorPop_Test(){


        text1.setText("Aa");
        text2.setText("Aa");
        text3.setText("Aa");
        text4.setText("Aa");
        text5.setText("Aa");
        text6.setText("oll");
        TextField[] boxes = {text1,text2,text3,text4,text5,text6};
        boolean invalid = DataEntryGUI.errorPop(boxes);
        assertEquals(true,invalid);
    }

    @Test
    public void validPop_Test(){

        text1.setText("A A");
        text2.setText("(111) 111-1111");
        text3.setText("A B");
        text4.setText("(111) 111-1111");
        text5.setText("Aa A");
        text6.setText("(111) 111-1111");
        TextField[] boxes = {text1,text2,text3,text4,text5,text6};
        boolean valid = DataEntryGUI.validPop(boxes);
        assertEquals(true,valid);
        assertEquals(true,!text1.isEditable());
        assertEquals(true,!text2.isEditable());
        assertEquals(true,!text3.isEditable());
        assertEquals(true,!text4.isEditable());
        assertEquals(true,!text5.isEditable());
        assertEquals(true,!text6.isEditable());
    }
   /* @Test
    public void buttonEnabled_Test(){
        text1.setText("Aa");
        text2.setText("Aa");
        text3.setText("Aa");
        text4.setText("Aa");
        text5.setText("Aa");
        text6.setText("oll");
        TextField[] boxes = {text1,text2,text3,text4,text5,text6};
        boolean enabled = DataEntryGUI.buttonEnabled(boxes,create);
        assertEquals(true,!create.isDisabled());

    }*/

    public TextField getText1() {
        return text1;
    }
    public void setText1(TextField text1) {
        this.text1 = text1;
    }
    public TextField getText2() {
        return text2;
    }
    public void setText2(TextField text2) {
        this.text2 = text2;
    }
    public TextField getText3() {
        return text3;
    }
    public void setText3(TextField text3) {
        this.text3 = text3;
    }
    public TextField getText4() {
        return text4;
    }
    public void setText4(TextField text4) {
        this.text4 = text4;
    }
    public TextField getText5() {
        return text5;
    }
    public void setText5(TextField text5) {
        this.text5 = text5;
    }
    public TextField getText6() {
        return text6;
    }
    public void setText6(TextField text6) {
        this.text6 = text6;
    }

    public Button getCreate() {
        return create;
    }
    public void setCreate(Button create) {
        this.create = create;
    }
}
