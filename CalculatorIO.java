import java.math.BigInteger;
import java.text.*;

/**
 * Abstract class CalculatorIO - Any IO should extend the Abstract class below
 *
 * @author (Aswathy Kanakarajan)
 * @version (02/09/2019)
 */
public abstract class CalculatorIO
{
    final protected String [] operators = {"sin", "cos", "tan", "cosh", "tanh", "sinh", "x!", 
            "1/x", "%", "sqrt", "log", "+/-", "Hex", "Oct", "Dec", "Bin", "M+","MC","MRC"};
    final protected String [] operators2 = {"+", "-", "*", "/","pow", "Clear"} ;
    public enum DisplayType {HexaDecimal, Octal, Decimal, Binary};
    
    protected String operand1 = "0";
    protected String operand2 = "0";   
    protected String operator = "";
    protected String answer = "";
    protected Operations operations;
    protected String memoryValue = "";
    protected DisplayType displayType = DisplayType.Decimal;
    /**
     * Returns the first Operatorand
     * @return    first Operatorand
     */
    public double getOperand1(){
        return formatOperandWithDisplayType(operand1);
    }
    public double formatOperandWithDisplayType(String operand){
        double operandValue = 0;
        if(!operand.isEmpty()){
            switch(displayType){
                case HexaDecimal : 
                operandValue = Integer.parseInt(operand, 16);
                break;
                case Binary : 
                operandValue = Integer.parseInt(operand, 2);
                break;
                case Octal : 
                operandValue = Integer.parseInt(operand, 8);
                break;
                case Decimal : 
                operandValue = Double.parseDouble(operand);
                break;
            }
        }
        return operandValue;
    }
    /**
     * Returns the second Operatorand
     * @return    second Operatorand
     */
    public double getOperand2(){
        return formatOperandWithDisplayType(operand2);
    }
    
    /**
     * Returns the Current Operator
     * @return    Current Operator
     */
    public String getOperator(){
            return operator;
    }   
    
    /**
     * Returns the Answer displayed in the screen
     * @return    Answer displayed in the screen
     */
    public String getAnswer(){
            return answer;
    }  
    /**
     * Returns the Answer displayed in the screen
     * @return    Answer displayed in the screen
     */
    public double getMemoryValue(){
            return formatOperandWithDisplayType(memoryValue);
    }  
    /**
     * Returns the Answer displayed in the screen
     * @return    Answer displayed in the screen
     */
    public void setMemoryValue(double value){
            memoryValue = getFormattedString(value);
    }  
    /**
     * Returns the Format Answer displayed in the screen
     * @return    Answer displayed in the screen
     */
    public DisplayType getDisplayType(){
            return displayType;
    }  
    /**
     * Set the Format in which Answer displayed in the screen
     * @return    Answer displayed in the screen
     */
    public void setDisplayType(DisplayType value){
            displayType = value;
    }  
    
    public String getFormattedString(Double value){
        String formattedString = "";
        int intValue = value.intValue();
        switch(displayType){
            case HexaDecimal : formattedString = Integer.toHexString(intValue);
            break;
            case Binary : formattedString = Integer.toBinaryString(intValue);
            break;
            case Octal : formattedString = Integer.toOctalString(intValue);
            break;
            case Decimal : formattedString = value.toString();
            break;
        }
        return formattedString;
    }
    
    public String getFormattedString(BigInteger value){
        String formattedString = "";
        switch(displayType){
            case HexaDecimal : formattedString = value.toString(16);
            break;
            case Binary : formattedString = value.toString(2);
            break;
            case Octal : formattedString = value.toString(8);
            break;
            case Decimal : NumberFormat formatter = new DecimalFormat("0.######E0");
                        formattedString = formatter.format(value);
            break;
        }
        return formattedString;
    }
}
