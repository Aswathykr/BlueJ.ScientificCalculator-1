import java.math.BigInteger;
import java.text.*;
/**
 * Write a description of class Operations here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Operations
{

    /**
     * Constructor for objects of class Operations
     */
    public Operations()
    {
    }

    /**
     * Adds two double values and returns a double
     *
     * @param  input1  first value for addition
     *         input2  second value for addition
     * @return    the sum of input1 and input2
     */
    public double add(double input1, double input2)
    {

        return input1 + input2;

    }

    public double subtract(double input1, double input2)
    {
        return input1 - input2;

    } 

    public double multiply(double input1, double input2)
    {
        return input1 * input2;
    }

    public double divide (double input1, double input2)
    {
        return input1 / input2;
    }

    public double pow(double input1 , double input2) {
        return Math.pow(input1,input2);
    }

    public double sin(double input1){
        return  Math.sin(input1);
    }

    public double cos(double input1){
        return Math.cos(input1);
    }

    public double tan(double input1){
        return Math.tan(input1);
    }

    public double cosh(double input1){
        return Math.cosh(input1);
    }

    public double tanh(double input1){
        return Math.tanh(input1);
    }

    public double sinh(double input1){
        return Math.sinh(input1);
    }

    public BigInteger factorial(int input1){
        BigInteger result = BigInteger.valueOf(1);
        for(int i = 1; i <= input1; i++){
            result = result.multiply(BigInteger.valueOf(i));
        } 
        return result;
    } 

    public double sqrt(double input1) {
        return Math.sqrt(input1);
    }

    public double modulous(double input1, double input2){
        return input1 % input2;
    }

    public double log(double input1){
        return Math.log(input1);
    }

    public double inverse(double input1){
        return 1/input1; 
    }

    public String calcSingleOperand(CalculatorIO displayObject){
        //sin(input);
        double dinput = 0;
        String operand1 = displayObject.getOperand1();
        if(!operand1.isEmpty()){
            dinput = Double.parseDouble(displayObject.getOperand1()); 
        }
        double answer = 0;
        String strAnswer = "";
        boolean handledStr = false;
        switch(displayObject.getOperator()){
            case "sin" : answer = sin(dinput);
            break;
            case "cos" : answer = cos(dinput);
            break;
            case "tan" : answer = tan(dinput);
            break;

            case "x!" : BigInteger bigAnswer = factorial((int)dinput);
                        NumberFormat formatter = new DecimalFormat("0.######E0");
                        strAnswer = formatter.format(bigAnswer);
                        handledStr = true;
            break; 
            case "sinh" : answer = sinh(dinput);
            break;
            case "cosh" : answer = cosh(dinput);
            break;
            case "tanh" : answer = tanh(dinput);
            break;

            case "1/x" : answer = inverse(dinput);
            break;
            case "%" : answer = divide(dinput,100);
            break;
            case "sqrt" : answer = sqrt(dinput);
            break;
            case "log" : answer = log(dinput);
            break;
            case "+/-" : answer = 0 - dinput;
            break;
            case "M+" : displayObject.setMemoryValue(displayObject.getOperand1());
                        answer = dinput;
            break;
            case "MC" : displayObject.setMemoryValue("0");
                        strAnswer = operand1;
                        handledStr = true;
            break;
            case "MRC" : answer = Double.parseDouble(displayObject.getMemoryValue()); ;
            break;
        } 
        if(!handledStr)
            strAnswer = String.valueOf(answer);
        return strAnswer;
    }

    public String calcDoubleOperand(CalculatorIO displayObject){
        double  dinput1 = Double.parseDouble(displayObject.getOperand1());
        double  dinput2 = Double.parseDouble(displayObject.getOperand2());
        double answer = 0;
        switch (displayObject.getOperator()){
            case "+" : answer = add(dinput1 , dinput2);
            break;
            case "-" : answer = subtract(dinput1,dinput2);
            break;
            case "*" : answer = multiply(dinput1,dinput2);
            break;
            case "/" : answer = divide(dinput1,dinput2);
            break;
            case "pow" : answer = pow(dinput1,dinput2);
            break;
            case "%" : answer = modulous(dinput1, dinput2);
            break;

        }
        return String.valueOf(answer);  
    } 
}

