/*
Staci Tranquille
05/1/2024
Computer Program Design Section 002
Controller for Scientific Calculator Application. What the Calculator Does.
 */
package com.example.fxhelloworld;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

    @FXML
    public Button exit; //FXML for exit button

    @FXML
    private TextField txt_input; //Skinny box on top

    @FXML
    private TextField txt_result; //Big box on the bottom
    String op = ""; // Variable to store the current operation (+, -, *, /, etc.)
    double number1 = 0.0;
    double number2 = 0.0;

    /*
    Method for storing numbers and casting them to the input and result boxes.
    Takes the text from the button and turns puts it into the result box to be stored as
    numbers 1 & 2 in the operation method
     */
    public void Number (ActionEvent ae){
        String num = ((Button)ae.getSource()).getText();
        if(num.equals("±") && !txt_result.getText().contains("-")){
            txt_result.setText("-" + txt_result.getText());
            txt_input.setText("-" + txt_input.getText());
        }
        else if(num.equals("±") && txt_result.getText().contains("-")){
            txt_result.setText(txt_result.getText().replace("-",""));
            txt_input.setText(txt_input.getText().replace("-",""));
        }

        else {
            txt_result.setText(txt_result.getText() + num);
            txt_input.setText(txt_input.getText() + num);
        }

    }
    /*
    Method storing operation button values and numbers as they are pressed and displaying them
    in the input and result fields
     */
    public void Operation (ActionEvent ae){
        try {
            String operation = ((Button) ae.getSource()).getText();
            if (!operation.equals("=")) {
                if (!op.equals("")) {
                    return; // Ignore if an operation is already in progress
                }
                op = operation;
                txt_input.setText(txt_input.getText() + " " + op + " ");
                if (txt_result.getText().contains(".")) {
                    number1 = Double.parseDouble(txt_result.getText());
                } else {
                    number1 = (double) Long.parseLong(txt_result.getText());
                }
                txt_result.setText("");


            } else {

                if (op.equals("")) {
                    return; // Ignore if no operation is selected
                }
                txt_input.setText(txt_input.getText() + " = ");
                if (txt_result.getText().equals("")) {
                    OneNumCalculate(number1, op);
                } else if (txt_result.getText().contains(".")) {
                    number2 = Double.parseDouble(txt_result.getText());
                } else {
                    number2 = (double) Long.parseLong(txt_result.getText());
                }

                Calculate(number1, number2, op); // Perform calculation
                op = ""; //Reset Operation

            }
        } catch(NumberFormatException e){
            txt_result.setText("");
            txt_input.setText("");
        }
        catch(Exception e){
            txt_result.setText("An Error Occurred");
            txt_input.setText("");

        }
    }

    //Method for Exiting Program (Exit Button)
    @FXML
    public void Exit(ActionEvent event){
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    //Method for Clearing stored operations, numbers & text fields (C Button)
    public void Clear(ActionEvent ae){
        txt_result.setText("");
        number1 = 0;
        number2 = 0;
        op = "";
        txt_input.setText("");

    }

    //Method for handling all the operations that require two numbers to be solved
    public void Calculate(double n1, double n2, String op){
        double result = 0.0;
        switch (op){
            case "+":
                result = (n1 + n2);
                txt_result.setText(result  + "");
                txt_input.setText(txt_input.getText() + result);
                break;
            case "–":
                result = (n1 - n2);
                txt_result.setText(result  + "");
                txt_input.setText(txt_input.getText() + result);
                break;
            case "x":
                result = (n1 * n2);
                txt_result.setText(result  + "");
                txt_input.setText(txt_input.getText() + result);
                break;
            case "÷":
                if(n2 == 0){
                    txt_result.setText("Undefined");
                    break;
                }
                result = (n1 / n2);
                txt_result.setText(result  + "");
                txt_input.setText(txt_input.getText() + result);
                break;
            case "Mod":
                result = n1 % n2;
                txt_result.setText(result  + "");
                txt_input.setText(txt_input.getText() + result);
                break;
            case "10^n":
                result = n1 * Math.pow(10,n2);
                txt_result.setText(result  + "");
                txt_input.setText(txt_input.getText().replace("n", ""));
                txt_input.setText(txt_input.getText() + result);

                break;




        }
    }

    //Method for handling all the operations that only require 1 number
    public void OneNumCalculate(double num, String op){
        double result;


        switch(op) {
            case("%"):
                result = num / 100;
                txt_result.setText(result + "");
                txt_input.setText(txt_input.getText() + result);
                break;
            case("1/n"):
                result = 1/num;
                txt_result.setText(result + "");
                txt_input.setText(txt_input.getText() + result);
                break;
            case("x²"):
                result = Math.pow(num,2);
                txt_result.setText(result + "");
                txt_input.setText(txt_input.getText() + result);
                break;
            case("x³"):
                result = Math.pow(num,3);
                txt_result.setText(result + "");
                txt_input.setText(txt_input.getText() + result);
                break;
            case("√"):
                result = Math.sqrt(num);
                txt_result.setText(result + "");
                txt_input.setText(txt_input.getText() + result);
                break;
            case("abs"):
                result = Math.abs(num);
                txt_result.setText(result + "");
                txt_input.setText(txt_input.getText() + result);
                break;
            case "sin":
               result = Math.sin(num);
               txt_result.setText(result + "");
               txt_input.setText(txt_input.getText() + result);
               break;
            case "cos":
                result = Math.cos(num);
                txt_result.setText(result + "");
                txt_input.setText(txt_input.getText() + result);
                break;
            case "tan":
                result = Math.tan(num);
                txt_result.setText(result + "");
                txt_input.setText(txt_input.getText() + result);
                break;
            case "asin":
                result = Math.asin(num);
                txt_result.setText(result + "");
                txt_input.setText(txt_input.getText() + result);
                break;
            case "acos":
                result = Math.acos(num);
                txt_result.setText(result + "");
                txt_input.setText(txt_input.getText() + result);
                break;
            case "atan":
                result = Math.atan(num);
                txt_result.setText(result + "");
                txt_input.setText(txt_input.getText() + result);
                break;
            case "sinh":
                result = Math.sinh(num);
                txt_result.setText(result + "");
                txt_input.setText(txt_input.getText() + result);
                break;
            case "cosh":
                result = Math.cosh(num);
                txt_result.setText(result + "");
                txt_input.setText(txt_input.getText() + result);
                break;
            case "tanh":
                result = Math.tanh(num);
                txt_result.setText(result + "");
                txt_input.setText(txt_input.getText() + result);
                break;
            case "log":
                result = Math.log10(num);
                txt_result.setText(result + "");
                txt_input.setText(txt_input.getText() + result);
                break;
            case "ln":
                result = Math.log(num);
                txt_result.setText(result + "");
                txt_input.setText(txt_input.getText() + result);
                break;

        }
    }


    public void initialize(URL url, ResourceBundle rb){

    }

}
