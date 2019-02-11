
/**
 * Abstract class CalculatorIO - Any IO should extend the Abstract class below
 *
 * @author (Aswathy Kanakarajan)
 * @version (02/09/2019)
 */
public abstract class CalculatorIO
{
    final protected String [] operators = {"sin", "cos", "tan", "cosh", "tanh", "sinh", "x!", 
            "1/x", "%", "sqrt", "log", "+/-", "M+","MC","MRC"};
    final protected String [] operators2 = {"+", "-", "*", "/","pow", "Clear"} ;
    protected String operand1 = "0";
    protected String operand2 = "0";   
    protected String operator = "";
    protected String answer = "";
    protected Operations operations;
    protected String memoryValue = "";
    /**
     * Returns the first Operatorand
     * @return    first Operatorand
     */
    public String getOperand1(){
        return operand1;
    }
    
    /**
     * Returns the second Operatorand
     * @return    second Operatorand
     */
    public String getOperand2(){
        return operand2;
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
    public String getMemoryValue(){
            return memoryValue;
    }  
    /**
     * Returns the Answer displayed in the screen
     * @return    Answer displayed in the screen
     */
    public void setMemoryValue(String value){
            memoryValue = value;
    }  
}
