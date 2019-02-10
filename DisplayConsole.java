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

public class DisplayConsole {

    final private String [] operators = {"sin", "cos", "tan", "cosh", "tanh", "sinh", "x!", 
            "1/x", "%", "sqrt", "log", "+/-"};
    final private String [] operators2 = {"+", "-", "*", "/","pow", "Clear"} ;
    private String operand1 = "0";
    private String operand2 = "0";   
    private String operator = "";
    private Operations operations;

    public static void main(String[] args) 
    {
    
        
        new DisplayConsole();
    }
    
    public DisplayConsole()
    {
        
        operations = new Operations();

        JFrame guiFrame = new JFrame();
        //make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("My Calculator");
        guiFrame.setSize(300,300);
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
        JButton clearBut = new JButton("Evaluate" );
        clearBut.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(!operator.isEmpty() && !operand1.isEmpty()){
                    String output = operations.calc(operator, operand1,expression.getText());
                    operator = "";
                    operand1 = ""; 
                    operand2 = "";
                    display.setText(output);
                    expression.setText(output);
                }
                
            }
        });

        topPanel.add(display);
        topPanel.add(expression);
        topPanel.add(clearBut);

        JButton[] singleOperandBut = new JButton[operators.length];

        JButton[] doubleOperandBut = new JButton[operators2.length];
        
        final JPanel middlePanel = new JPanel();
        GridLayout experimentLayout2 = new GridLayout(0,3);
        middlePanel.setLayout(experimentLayout2);
        for(Integer i = 0; i < operators2.length ; i++){
            doubleOperandBut[i] = new JButton(operators2[i] );

            doubleOperandBut[i].addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                        String op = event.getActionCommand();
                        if(op.equals("Clear")) {
                            expression.setText("");
                            display.setText("0");
                            operand1 = "";
                            operand2 = "";
                            operator = "";
                            expression.requestFocusInWindow();
                        }
                        else{
                            if(operator.isEmpty()){
                                operator = op;
                                operand1 = expression.getText();
                                expression.setText("");
                                expression.requestFocusInWindow();
                            }else{
                                operand2 = expression.getText();
                                if(!operand2.isEmpty()){
                                    String output = operations.calc(operator, operand1, operand2);
                                    display.setText(output);
                                    operator = op;
                                    operand1 = output;
                                    operand2 = "";
                                    expression.setText("");
                                }
                                expression.requestFocusInWindow();
                                
                            }
                        }
                    }
                });

            middlePanel.add(doubleOperandBut[i]);
        }

        final JPanel bottomPanel = new JPanel();
        GridLayout experimentLayout = new GridLayout(0,3);
        bottomPanel.setLayout(experimentLayout);
        for(Integer i = 0; i < operators.length ; i++){
            singleOperandBut[i] = new JButton(operators[i] );
            singleOperandBut[i].addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                        String op = event.getActionCommand();
                        String input = expression.getText();
                        String output = "";
                        if(!input.isEmpty()){
                            if(op.equals("+/-")){
                                output = String.valueOf(0 - Double.parseDouble(input));
                            }else{
                                output = operations.calc(op, input);
                            }
                             
                            display.setText(output);
                            expression.setText(output);
                        }
                        else{
                            expression.requestFocusInWindow();
                        }
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
        expression.requestFocusInWindow();
    }
    
    public static void setNumericOnly(JTextField jTextField){
        jTextField.addKeyListener(new KeyAdapter() {
             public void keyTyped(KeyEvent e) {
               char c = e.getKeyChar();
               if (((!Character.isDigit(c) && (c != '.'))||
                  (c == KeyEvent.VK_BACK_SPACE) ||
                  (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                  }
             }
        });
    }    
}


