package atm;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

        
public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JButton next;
    JRadioButton married,unmarried,other,male ,female;
    JDateChooser date_Chooser;
    JTextField name_TextField , fname_TextField , email_TextField , address_TextField , city_TextField , state_TextField , pincode_TextField;
    
    SignupOne(){
        
        //custom layout
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L)+1000L);
        
        //heading
        JLabel formno = new JLabel("APPLICATION FROM NO. "+random);
        formno.setFont(new Font("raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        //sub heading
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        //name 
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        //name text field
        name_TextField = new JTextField();
        name_TextField.setFont(new Font("raleway",Font.BOLD,17));
        name_TextField.setBounds(300,140,400,30);
        add(name_TextField);
        
        
        //fname
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        //fname text field
        fname_TextField = new JTextField();
        fname_TextField.setFont(new Font("raleway",Font.BOLD,17));
        fname_TextField.setBounds(300,190,400,30);
        add(fname_TextField);
        
        
        // dob
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        //dob chooser
        date_Chooser = new JDateChooser();
        date_Chooser.setBounds(300,240,400,30);
        date_Chooser.setForeground(new Color(105,105,105));
        add(date_Chooser);
        
        //gender
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        // gender rb male
        male = new JRadioButton("male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.lightGray);
        add(male);
        // gender rb female
        female = new JRadioButton("female");
        female.setBounds(450,290,100,30);
        female.setBackground(Color.lightGray);
        add(female);
        //button group
        ButtonGroup gender_Group = new ButtonGroup();
        gender_Group.add(male);
        gender_Group.add(female);

        
        
        //email
        JLabel email = new JLabel("Email:");
        email.setFont(new Font("raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        //email text field
        email_TextField = new JTextField();
        email_TextField.setFont(new Font("raleway",Font.BOLD,17));
        email_TextField.setBounds(300,340,400,30);
        add(email_TextField);
        
        
        //marital
        JLabel marital = new JLabel("Marital:");
        marital.setFont(new Font("raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        // marital rb male
        married = new JRadioButton("married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.lightGray);
        add(married);
        // marital rb female
        unmarried = new JRadioButton("unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.lightGray);
        add(unmarried);
        other = new JRadioButton("other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.lightGray);
        add(other);
        //button group
        ButtonGroup marital_Group = new ButtonGroup();
        marital_Group.add(married);
        marital_Group.add(unmarried);
        marital_Group.add(other);
        
        
        //address
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        //address text field
        address_TextField = new JTextField();
        address_TextField.setFont(new Font("raleway",Font.BOLD,17));
        address_TextField.setBounds(300,440,400,30);
        add(address_TextField);
        
        
        //city
        JLabel city = new JLabel("City:");
        city.setFont(new Font("raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        //city text field
        city_TextField = new JTextField();
        city_TextField.setFont(new Font("raleway",Font.BOLD,17));
        city_TextField.setBounds(300,490,400,30);
        add(city_TextField);
        
        
        //state
        JLabel state = new JLabel("State:");
        state.setFont(new Font("raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        //state text field
        state_TextField = new JTextField();
        state_TextField.setFont(new Font("raleway",Font.BOLD,17));
        state_TextField.setBounds(300,540,400,30);
        add(state_TextField);
        
        
        //pincode
        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        //pincode text field
        pincode_TextField = new JTextField();
        pincode_TextField.setFont(new Font("raleway",Font.BOLD,17));
        pincode_TextField.setBounds(300,590,400,30);
        add(pincode_TextField);
        
        
        next = new JButton("NEXT");
        next.setBackground(Color.black);
        next.setForeground(Color.lightGray);
        next.setFont(new Font("raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);


        
        // background color
        getContentPane().setBackground(Color.lightGray);
        
        //frame
        setSize(800,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = name_TextField.getText();
        String fname = fname_TextField.getText();
        String dob = ((JTextField) date_Chooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "male";
        }else if(female.isSelected()){
            gender = "female";
        }
        String marital = null;
        if(married.isSelected()){
            marital = "married";
        }else if(unmarried.isSelected()){
            marital = "unmarried";
        }else if(other.isSelected()){
            marital = "other";
        }
        
        String email = email_TextField.getText();
        String address = address_TextField.getText();
        String city = city_TextField.getText();
        String state = state_TextField.getText();
        String pincode = pincode_TextField.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"name is required");
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        
    }
        
    public static void main(String args[]){
        new SignupOne();
    }
}
