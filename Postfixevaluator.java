package main;
import java.util.Stack;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
public class Main implements ActionListener{
JFrame jf;
JLabel L1,L2;
JTextField t1;
JButton b3;
Main(){
jf=new JFrame("POSTFIX CALCULATOR");
L1=new JLabel("POSTFIX EVALUATOR");
L1.setFont(new Font("STIX Two Math", Font.BOLD,26));
L1.setBounds(150,60,120,50);
jf.add(L1);
L2=new JLabel("Enter Postfix Expression");
L2.setBounds(10,20,60,10);
jf.add(L2);
t1=new JTextField(15); 
t1.setBounds(50,100,200,30);

jf.add(t1);
b3=new JButton("Calculate");
b3.setBounds(40,90,85,20);
b3.addActionListener(this);
jf.add(b3);
jf.setSize(400,150);
jf.setLayout(new FlowLayout());
jf.setVisible(true);
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}
public void clearFields(){
t1.setText(null);}
public void actionPerformed(ActionEvent ae){
        Stack<Integer> stack = new Stack<>();
         String expression = t1.getText();
        for(int i = 0; i < expression.length(); i++)
        {
            char ch = expression.charAt(i);
              
            if(ch == ' ')
            continue;
            else if(Character.isDigit(ch))
            {
                int num = 0;
                while(Character.isDigit(ch))
                {
                    num = num*10 + (int)(ch-'0');
                    i++;
                    ch = expression.charAt(i);
                }
                i--;
                stack.push(num);
            }
            else
            {
                int value1 = stack.pop();
                int value2 = stack.pop();
                  
                switch(ch)
                {
                    case '+':
                    stack.push(value2+value1);
                    break;
                      
                    case '-':
                    stack.push(value2- value1);
                    break;
                      
                    case '/':
                    stack.push(value2/value1);
                    break;
                      
                    case '*':
                    stack.push(value2*value1);
                    break;
                    
                    case '^':
                    stack.push((int) Math.pow(value2,value1));
                    break;
            }
            }
        }

        JOptionPane.showMessageDialog(null, "OUTPUT: "+stack.pop());
    }
public static void main(String[] args) {
    new Main();
}}
