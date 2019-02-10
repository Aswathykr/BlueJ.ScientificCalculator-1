import java.math.BigInteger;
/**
 * Write a description of class Operations here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Operations
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Operations
     */
    public Operations()
    {

         
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
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

    public String calc(String operator, String input){
        //sin(input);
        double dinput = Double.parseDouble(input); 
        double answer = 0;
        switch(operator){
            case "sin" : answer = sin(dinput);
            break;
            case "cos" : answer = cos(dinput);
            break;
            case "tan" : answer = tan(dinput);
            break;

            case "x!" : BigInteger bigAnswer = factorial((int)dinput);

            break; 
            case "sinh" : answer = sinh(dinput);
            break;
            case "cosh" : answer = cosh(dinput);
            break;
            case "tanh" : answer = tanh(dinput);
            break;

        } 
        return String.valueOf(answer);
    }

    public String calc(String operator, String input1, String input2){
        double  dinput1 = Double.parseDouble(input1);
        double  dinput2 = Double.parseDouble(input2);
        double answer = 0;
        switch (operator){
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

