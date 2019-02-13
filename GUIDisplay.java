import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.GridLayout;
import java.text.NumberFormat;
import javax.swing.text.MaskFormatter;
import java.awt.event.*;

/**
 * class GUIDisplay subclassing CalculatorIO
 *
 * @author (Aswathy Kanakarajan)
 * @version (02/09/2019)
 */
public class GUIDisplay extends CalculatorIO{
    /**
     * Constructs the Calculator Object
     */
    public GUIDisplay()
    {
        operations = new Operations();
        initCalculatorWindow();
    }
    
    private void initCalculatorWindow()
    {

        JFrame guiFrame = new JFrame();
        //make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("My Calculator");
        guiFrame.setSize(350,320);
        //This will center the JFrame in the middle of the screen
        guiFrame.setLocationRelativeTo(null);
        

        //The first JPanel contains a answer, expression and clear button
        final JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        
        // Answer Display Area
        JTextField display = new JTextField("0", 20);
        display.setEditable(false);
        
        //Editable question
        JTextField expression = new JTextField("", 20);
        setNumericOnly(expression);
        //Clear Button
        JButton evaluateBut = new JButton("Evaluate" );
        evaluateBut.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                operand2 = expression.getText();
                operand1 = display.getText();
                if(!operator.isEmpty() && !operand1.isEmpty()){
                   String output = operations.calcDoubleOperand(
                                                 GUIDisplay.this);
                    operator = "";
                    operand1 = ""; 
                    operand2 = "";
                    answer = output;
                    display.setText(output);
                    expression.setText(output);
                    if(output.equals("Infinity") || output.equals("NaN"))
                    {
                        expression.setEditable(false);
                    }
                }
                
            }
        });

        topPanel.add(display);
        topPanel.add(expression);
        topPanel.add(evaluateBut);

        JButton[] singleOperandBut = new JButton[operators.length];

        JButton[] doubleOperandBut = new JButton[operators2.length];
        
        final JPanel middlePanel = new JPanel();
        GridLayout experimentLayout2 = new GridLayout(0,4);
        middlePanel.setLayout(experimentLayout2);
        for(Integer i = 0; i < operators2.length ; i++){
            doubleOperandBut[i] = new JButton(operators2[i] );

            doubleOperandBut[i].addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                        expression.setEditable(true);
                        String op = event.getActionCommand();
                        if(op.equals("Clear")) {
                            expression.setText("");
                            display.setText("0");
                            operand1 = "";
                            operand2 = "";
                            operator = "";
                            answer = "";
                            expression.requestFocusInWindow();
                    
                        }
                        else{
                            if(operator.isEmpty()){
                                operator = op;
                                operand1 = expression.getText();
                                display.setText(operand1);
                                expression.setText("");
                                expression.requestFocusInWindow();
                            }else{
                                operand1 = display.getText();
                                operand2 = expression.getText();
                                if(!operand2.isEmpty()){
                                    String output = operations.
                                            calcDoubleOperand(GUIDisplay.this);
                                    display.setText(output);
                                    answer = output;
                                    operator = op;
                                    operand1 = output;
                                    operand2 = "";
                                    expression.setText("");
                                    if(output.equals("Infinity") || output.equals("NaN"))
                                    {
                                        expression.setEditable(false);
                                    }
                                }
                                expression.requestFocusInWindow();
                                
                            }
                        }
                    }
                });

            middlePanel.add(doubleOperandBut[i]);
        }

        final JPanel bottomPanel = new JPanel();
        GridLayout experimentLayout = new GridLayout(0,4);
        bottomPanel.setLayout(experimentLayout);
        for(Integer i = 0; i < operators.length ; i++){
            singleOperandBut[i] = new JButton(operators[i] );
            singleOperandBut[i].addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                        expression.setEditable(true);
                        String oldOperator = operator;
                        operator = event.getActionCommand();
                        operand1 = expression.getText();
                        String output = "";
                        String displayFormatOperator = "HexOctDecBin";
                        if(operator.startsWith("M") || displayFormatOperator.contains(operator))
                        {
                            output = operations.calcSingleOperand
                                                      (GUIDisplay.this);
                            expression.setText(output);
                            operator = oldOperator;
                            
                        }
                        else if(!operand1.isEmpty()){
                            output = operations.calcSingleOperand
                                                      (GUIDisplay.this);
                            display.setText(output);
                            expression.setText(output);
                            operator = ""; // Operation is done clear it
                            if(output.equals("Infinity") || output.equals("NaN"))
                            {
                                expression.setEditable(false);
                            }
                        }
                        else{
                            expression.requestFocusInWindow();
                            operator = ""; // Operation is done clear it
                        }
                        answer = output;
                        
                    }
                });

            bottomPanel.add(singleOperandBut[i]);
        }
               
        //The JFrame uses the BorderLayout layout manager.
        guiFrame.add(topPanel, BorderLayout.NORTH);
        //guiFrame.add(middlePanel, BorderLayout.CENTER);
        guiFrame.add(middlePanel, BorderLayout.CENTER);

        guiFrame.add(bottomPanel,BorderLayout.SOUTH);
        //make sure the JFrame is visible
        guiFrame.setVisible(true);
        //Add evaluate as default ction
        guiFrame.getRootPane().setDefaultButton(evaluateBut);
        
        expression.requestFocusInWindow();
    }
    
    /**
     * Allow only digits in the textfield
     *
     * @param  jTextField  TextField that needs restriction
     * @return    nil
     */
    public void setNumericOnly(JTextField jTextField){
        jTextField.addKeyListener(new KeyAdapter() {
             public void keyTyped(KeyEvent e) {
               char c = e.getKeyChar();
               switch(displayType){
                   case HexaDecimal : 
                   char charC = Character.toUpperCase(c);
                       if ((!Character.isDigit(c) && (charC <='A' || charC > 'F'))||
                          (c == KeyEvent.VK_BACK_SPACE) ||
                          (c == KeyEvent.VK_DELETE)) {
                            e.consume();
                       }
                   break;
                   case Binary : 
                       if ((!Character.isDigit(c) ||(Character.digit(c,10) > 1)||
                          (c == KeyEvent.VK_BACK_SPACE) ||
                          (c == KeyEvent.VK_DELETE))) {
                            e.consume();
                       }
                   break;
                   case Octal : 
                     
                       if ((!Character.isDigit(c) ||(Character.digit(c,10) > 7)||
                          (c == KeyEvent.VK_BACK_SPACE) ||
                          (c == KeyEvent.VK_DELETE))) {
                            e.consume();
                       }
                   break;
                   case Decimal : 
                      if (((!Character.isDigit(c) && (c != '.'))||
                      (c == KeyEvent.VK_BACK_SPACE) ||
                      (c == KeyEvent.VK_DELETE))) {
                        e.consume();
                      }
                   break;
                }

               
             }
        });
    }    
}


