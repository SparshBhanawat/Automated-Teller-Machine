package atm;
import javax.swing.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit , withdrawal, fastCash , exit,miniStatement,balance,changePin;
    String pinnumber;
    FastCash(String pinnumber){
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
        JLabel text = new JLabel("Select amount you want to withdraw");
        text.setBounds(218,300,700,35);
        text.setFont(new Font("system",Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);
        
        //button
        //deposit
        deposit = new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        //withdrawal
        withdrawal = new JButton("Rs 500");
        withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        //button
        fastCash = new JButton("Rs 1000");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);
        //ministatement
        miniStatement = new JButton("Rs 2000");
        miniStatement.setBounds(355,450,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        //change pin
        changePin = new JButton("Rs 5000");
        changePin.setBounds(170,485,150,30);
        changePin.addActionListener(this);
        image.add(changePin);
        //balance 
        balance = new JButton("Rs 10000");
        balance.setBounds(355,485,150,30);
        balance.addActionListener(this);
        image.add(balance);
        //exit
        exit = new JButton("Back");
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
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
                long balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("deposit")){
                        balance += Long.parseLong(rs.getString("amount"));
                    }else{
                        balance -= Long.parseLong(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!= exit && balance < Long.parseLong(amount)){
                    JOptionPane.showMessageDialog(null, "In Sufficient balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','withdrawal','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited successfully.");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    
    public static void main(String args[]){
        new FastCash("");
    }
}
