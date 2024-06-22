package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
public class Balance extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;
    Balance(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        //button
        back = new JButton("Back");
        back.setBounds(165,520,150,30);
        back.addActionListener(this);
        image.add(back);
        long balance = 0;
        Conn c = new Conn();
        try{
            ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
                while(rs.next()){
                    if(rs.getString("type").equals("deposit")){
                        balance += Long.parseLong(rs.getString("amount"));
                    }else{
                        balance -= Long.parseLong(rs.getString("amount"));  
                    }
                }
        }catch(Exception e){
            System.out.println(e);
        }
        
        //current balance
        JLabel text = new JLabel("Your current Balance is Rs "+balance);
        text.setBounds(170,300,400,30);
        text.setFont(new Font("system",Font.BOLD,17));
        text.setForeground(Color.lightGray);
        image.add(text);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    
    public static void main(String args[]){
        new Balance("").setVisible(true);
    }
}
