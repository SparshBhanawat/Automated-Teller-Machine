package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    
    //global declaration
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
                
    //custom layaout
    setLayout(null);  
    
    //image
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image =  new JLabel(i3);
    image.setBounds(0,0,900,900);
    add(image);
    
    
    //heading
    JLabel text = new JLabel("Enter the amount you want to deposit");
    text.setBounds(190,300,400,20);
    text.setForeground(Color.white);
    text.setFont(new Font("system",Font.BOLD,17));
    image.add(text);
    
    //input amount
    amount = new JTextField();
    amount.setBounds(190,350,300,25);
    amount.setFont(new Font("raleway",Font.BOLD,22));
    image.add(amount);
    
    //deposit button
    deposit = new  JButton("Deposit");
    deposit.setBounds(355,485,150,30);
    deposit.addActionListener(this);
    image.add(deposit);
    
    //back button
    back = new  JButton("Back");
    back.setBounds(170,485,150,30);
    back.addActionListener(this);
    image.add(back);
    
    
    //frame
    setSize(900,900);
    setLocation(300,0);
    setUndecorated(true);
    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "please enter the amount you want to deposit");
            }else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values ('"+pinnumber+"','"+date+"','deposit','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+  " Deposit Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Deposit("");
    }
}
