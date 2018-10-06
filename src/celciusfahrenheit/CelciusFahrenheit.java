/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celciusfahrenheit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.math.*;
/**
 *
 * @author Ariphael
 */
public class CelciusFahrenheit extends JFrame{
    private JTextField celciusField,fahrenheitField;
    private JLabel celciusLabel,fahrenheitLabel;
    private JButton convertButton,clearButton;
    public CelciusFahrenheit(){
        createView();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(true);
    }
    
    private void createView(){
        JPanel centrePanel=new JPanel();
        centrePanel.setLayout(new BorderLayout());
        centrePanel.setBorder(new EmptyBorder(0,10,0,10));
        getContentPane().add(centrePanel,BorderLayout.CENTER);
        
        JPanel southPanel=new JPanel();
        southPanel.setLayout(new BorderLayout());
        southPanel.setBorder(new EmptyBorder(0,10,0,10));
        getContentPane().add(southPanel,BorderLayout.SOUTH);
        
        JPanel northPanel=new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.setBorder(new EmptyBorder(0,10,0,10));
        getContentPane().add(northPanel,BorderLayout.NORTH);
        
        //NORTH
        celciusLabel=new JLabel("Celcius");
        northPanel.add(celciusLabel,BorderLayout.WEST);
        
        fahrenheitLabel=new JLabel("Fahrenheit");
        northPanel.add(fahrenheitLabel,BorderLayout.LINE_END);
        //
        
        //CENTRE
        celciusField=new JTextField();
        celciusField.setPreferredSize(new Dimension(100,20));
        centrePanel.add(celciusField,BorderLayout.WEST);
        
        fahrenheitField=new JTextField();
        fahrenheitField.setPreferredSize(new Dimension(100,20));
        centrePanel.add(fahrenheitField);
        //
        
        //SOUTH
        convertButton=new JButton("Convert");
        convertButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(celciusField.getText().length()>0
                        &&
                   fahrenheitField.getText().length()<1){
                    fahrenheitField.setText(String.valueOf(Math.round(
                                            1.8*Float.valueOf(
                                            celciusField.getText())
                                            + 32 *10000d)/10000d));
                }else if(fahrenheitField.getText().length()>0
                            &&
                         celciusField.getText().length()<1){
                    celciusField.setText(String.valueOf(Math.round(
                                            Double.valueOf(5.0f/9)*
                                            (Float.valueOf(
                                            fahrenheitField.getText()) - 32)
                                            *10000d)/10000d));
                }else{
                    createPopup("Error","Oops, either you didn't enter any values or"
                            + " you've entered two values");
                }
            }
        });
        southPanel.add(convertButton,BorderLayout.CENTER);
        clearButton=new JButton("Clear");
        clearButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                fahrenheitField.setText("");
                celciusField.setText("");
            }
        });
        southPanel.add(clearButton,BorderLayout.EAST);
        //
    }
    private void createPopup(String PopupName, String message){
        JFrame warningFrame=new JFrame(PopupName);
        warningFrame.setEnabled(true);
        warningFrame.setVisible(true);
        warningFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        warningFrame.setLocationRelativeTo(null);
        warningFrame.setResizable(false);
        warningFrame.setSize(400,100);
        
        JLabel labelMessage=new JLabel(message);
        warningFrame.getContentPane().add(labelMessage,BorderLayout.CENTER);
        
        JButton OK = new JButton("OK");
        OK.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                warningFrame.setEnabled(false);
                warningFrame.setVisible(false);
            }
        });
        warningFrame.getContentPane().add(OK,BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new CelciusFahrenheit().setVisible(true);
            }
        });
    }
    
}
