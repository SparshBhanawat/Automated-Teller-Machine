package atm;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        //custom layout
        setLayout(null);
        
        //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        //heading
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,280,500,30);
        text.setForeground(Color.lightGray);
        text.setFont(new Font("system",Font.BOLD,17));
        image.add(text);
        
        //new pin
        JLabel pinText = new JLabel("New pin: ");
        pinText.setBounds(165,320,180,30);
        pinText.setForeground(Color.lightGray);
        pinText.setFont(new Font("system",Font.BOLD,17));
        image.add(pinText);
        
        pin = new JPasswordField();
        pin.setBounds(330,320,180,30);
        pin.setFont(new Font("raleway",Font.BOLD,25));
        pin.setForeground(Color.lightGray);
        image.add(pin);
        
        //re - enter new pin
        JLabel rePinText = new JLabel("Re-enter new pin: ");
        rePinText.setBounds(165,360,180,30);
        rePinText.setForeground(Color.lightGray);
        rePinText.setFont(new Font("system",Font.BOLD,17));
        image.add(rePinText);
        
        repin = new JPasswordField();
        repin.setBounds(330,360 ,180,30);
        repin.setFont(new Font("raleway",Font.BOLD,25));
        repin.setForeground(Color.lightGray);
        image.add(repin);
        
        //button
        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(165,485,150,30);
        back.addActionListener(this);
        image.add(back);
        
        //frame
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
 
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try{
            String npin = pin.getText();
            String rpin = repin.getText();
            
            if(!rpin.equals(npin)){
                JOptionPane.showMessageDialog(null,"Entered Pin does not match.");
                return;
            }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter pin.");
                return;
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter re-pin.");
                return;
            }
            
            Conn conn = new Conn();
            String query1 = "update bank set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
            String query2 = "update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
            String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
            
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query3);
            conn.s.executeUpdate(query2);
            
            JOptionPane.showMessageDialog(null, "PIN changed successfully");
            
            setVisible(false);
            new Transactions(rpin).setVisible(true);

        }catch(Exception e){
            System.out.println(e);
        }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}
