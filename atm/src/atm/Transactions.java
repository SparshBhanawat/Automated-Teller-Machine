package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit , withdrawal, fastCash , exit,miniStatement,balance,changePin;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        //layout
        setLayout(null);
        
        //background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        // text
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(218,300,700,35);
        text.setFont(new Font("system",Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);
        
        //button
        //deposit
        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        //withdrawal
        withdrawal = new JButton("Withdrawal");
        withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        //button
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);
        //ministatement
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355,450,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        //change pin
        changePin = new JButton("Change PIN");
        changePin.setBounds(170,485,150,30);
        changePin.addActionListener(this);
        image.add(changePin);
        //balance 
        balance = new JButton("Balance");
        balance.setBounds(355,485,150,30);
        balance.addActionListener(this);
        image.add(balance);
        //exit
        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        //Frame
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdrawal){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastCash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==changePin){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balance){
            setVisible(false);
            new Balance(pinnumber).setVisible(true);
        }else if(ae.getSource()==miniStatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    
    public static void main(String args[]){
        new Transactions("");
    }
}
