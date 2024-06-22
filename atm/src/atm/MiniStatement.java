package atm;
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class MiniStatement extends JFrame{
    String pinnumber;
    MiniStatement(String pinnumber){
        setLayout(null);
        this.pinnumber = pinnumber;
        
        //frame
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.lightGray);
        
        //heading
        JLabel bank = new JLabel("Bank of India");
        bank.setBounds(150,20,100,20);
        bank.setFont(new Font("system",0,15));
        add(bank);
        
        //statement
        JLabel text = new JLabel();
        text.setBounds(20,140,400,200);
        add(text);
        
        //card no
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        //balance
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        Conn conn = new Conn();
        
        long bal = 0;
        try{

            ResultSet rs = conn.s.executeQuery(" select * from login where pinnumber = '"+pinnumber+"' ");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0,7)+"XXXXXXXXX");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
            while(rs.next()){
                text.setText(text.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                    if(rs.getString("type").equals("deposit")){
                        bal += Long.parseLong(rs.getString("amount"));
                    }else{
                        bal -= Long.parseLong(rs.getString("amount"));
                    }
            }
            
            balance.setText("Balance: "+bal);
            
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
    }
    public static void main(String args[]){
        new MiniStatement("").setVisible(true);
    }
    
}
