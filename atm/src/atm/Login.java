package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


    public class Login extends JFrame implements ActionListener{

    //global declaration
    JButton clear , signup , login;
    JTextField cardTextField ;
    JPasswordField pinTextField;

    //constructor
    Login(){
        //title
        setTitle("Automated teller machine");

        //custom layout
        setLayout(null);

        //background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        //text
        JLabel text = new JLabel("welcome to bank");
        text.setBounds(200,40,400,40);
        text.setFont(new Font("Osward",Font.BOLD,38));
        add(text);

        // cardno 
        JLabel cardno = new JLabel("Card No:");
        cardno.setBounds(120,150,150,30);
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        add(cardno);

        //cardno text field
        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,17));
        add(cardTextField);

        // pin
        JLabel pin = new JLabel("PIN:");
        pin.setBounds(120,220,250,30);
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        add(pin);

        // pin text field
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,17));
        add(pinTextField);

                                                ///BUTTON///
        //login button
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        //clear button
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        //sign up button
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        //background color
        getContentPane().setBackground(Color.lightGray);

        //frame size
        setSize(800, 480);
        setVisible(true);
        setLocation(350,200);

        
    }
    
    //actions definition
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }else if(ae.getSource() == login){
            Conn conn = new Conn();
            String cardnumber =  cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pinnumber =  '"+pinnumber+"' ";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}


