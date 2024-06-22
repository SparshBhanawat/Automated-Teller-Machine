package atm;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno ;
    SignupThree( String formno){
        this.formno = formno;
        setLayout(null);
        
        
        
        //heading
        JLabel li = new JLabel("PAGE 3: ACCOUNT DETAILS");
        li.setFont(new Font("raleway",Font.BOLD,22));
        li.setBounds(280,40,400,40);
        add(li);
        
        //account type
        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("raleway",Font.BOLD,20));
        type.setBounds(100,140,200,30);
        add(type);
        // saving account
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("raleway",Font.BOLD,16));
        r1.setForeground(Color.red);
        r1.setBackground(Color.lightGray);
        r1.setBounds(100,180,250,30);
        add(r1);
        //Fixed Deposite Account
        r2 = new JRadioButton("Fixed Deposite Account");
        r2.setFont(new Font("raleway",Font.BOLD,16));
        r2.setForeground(Color.red);
        r2.setBackground(Color.lightGray);
        r2.setBounds(350,180,250,30);
        add(r2);
        //Current Account
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("raleway",Font.BOLD,16));
        r3.setForeground(Color.red);
        r3.setBackground(Color.lightGray);
        r3.setBounds(100,220,250,30);
        add(r3);
        //Recurring Account
        r4 = new JRadioButton("Recurring Account");
        r4.setFont(new Font("raleway",Font.BOLD,16));
        r4.setBackground(Color.lightGray);
        r4.setForeground(Color.red);
        r4.setBounds(350,220,250,30);
        add(r4);
        //buttongroup
        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(r1);
        accountGroup.add(r2);
        accountGroup.add(r3);
        accountGroup.add(r4);
        
        //card
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("raleway",Font.BOLD,20));
        card.setBounds(100,300,200,30);
        add(card);
        
        JLabel carddetail = new JLabel("*Your 16 digit card number");
        carddetail.setFont(new Font("raleway",Font.BOLD,12));
        carddetail.setBounds(100,330,200,20);
        add(carddetail);
        
        //card number
        JLabel cnumber = new JLabel("XXXX-XXXX-XXXX-0021");
        cnumber.setFont(new Font("raleway",Font.BOLD,20));
        cnumber.setBounds(300,300,300,30);
        add(cnumber);
        
        //pin
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("raleway",Font.BOLD,20));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        JLabel pindetail = new JLabel("*Your 4 digit pin");
        pindetail.setFont(new Font("raleway",Font.BOLD,12));
        pindetail.setBounds(100,400,200,20);
        add(pindetail);
        
        //pin number
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("raleway",Font.BOLD,20));
        pnumber.setBounds(300,370,300,30);
        add(pnumber);
        
        //services required
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("raleway",Font.BOLD,20));
        services.setBounds(100,450,200,30);
        add(services);
        //checkboxes 
        //c1
        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("raleway",Font.BOLD,16));
        c1.setBackground(Color.lightGray);
        c1.setBounds(100,500,200,30);
        add(c1);
        //c2
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("raleway",Font.BOLD,16));
        c2.setBackground(Color.lightGray);
        c2.setBounds(350,500,200,30);
        add(c2);
        //c3
        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("raleway",Font.BOLD,16));
        c3.setBackground(Color.lightGray);
        c3.setBounds(100,550,200,30);
        add(c3);
        //c4
        c4 = new JCheckBox("Email & SMS Alert");
        c4.setFont(new Font("raleway",Font.BOLD,16));
        c4.setBackground(Color.lightGray);
        c4.setBounds(350,550,200,30);
        add(c4);
        //c5
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("raleway",Font.BOLD,16));
        c5.setBackground(Color.lightGray);
        c5.setBounds(100,600,200,30);
        add(c5);
        //c6
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("raleway",Font.BOLD,16));
        c6.setBackground(Color.lightGray);
        c6.setBounds(100,500,200,30);
        add(c6);
        //c7
        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge.");
        c7.setFont(new Font("raleway",Font.BOLD,12));
        c7.setBackground(Color.lightGray);
        c7.setBounds(100,680,600,30);
        add(c7);
        
        //buttons
        //submit
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.lightGray);
        submit.setBounds(250,720,100,30);
        submit.setFont(new Font("raleway",Font.BOLD,14));
        submit.addActionListener(this);
        add(submit);
        //cancel
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.lightGray);
        cancel.setBounds(420,720,100,30);
        cancel.setFont(new Font("raleway",Font.BOLD,14));
        cancel.addActionListener(this);
        add(cancel);
        
        //background color
        getContentPane().setBackground(Color.lightGray);
        
        //Frame size
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType = "";
            if(r1.isSelected()){
                accountType = "saving account";
            }else if(r2.isSelected()){
                accountType = "fixed deposite account"; 
            }else if(r3.isSelected()){
                accountType = "current account";
            }else if(r4.isSelected()){
                accountType = "recurring account";
            }
            
            Random random = new Random();   
            String cardnumber = ""+ Math.abs((random.nextLong()%90000000L) + 6349334900000000L);
            String pinnumber = "" + Math.abs((random.nextLong()%9000L)+1000L);
            
            String facility = "";
            if(c1.isSelected()){
                facility = facility + " ATM card";
            }else if(c2.isSelected()){
                facility = facility + " internet banking";
            }else if(c3.isSelected()){
                facility = facility + " mobile banking";
            }else if(c4.isSelected()){
                facility = facility + " email & sms alert";
            }else if(c5.isSelected()){
                facility = facility + " cheque book";
            }else if(c6.isSelected()){
                facility = facility + " e-statement";
            }
            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"account type is required");
                }else{
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";                    
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin Number: " + pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new SignupThree("");
    }
}
