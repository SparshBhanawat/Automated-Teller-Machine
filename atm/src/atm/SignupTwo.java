package atm;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

        
public class SignupTwo extends JFrame implements ActionListener{
    
    String formno;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JTextField pan_TextField,aadhar_TextField;
    JComboBox category, income , religion,qualification ,occupation;
    
    SignupTwo(String formno){
        this.formno = formno;
        
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE 2");
        
        //custom layout
        setLayout(null);
                
        
        //sub heading
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        //religion 
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        //drop down religion
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Others"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        add(religion);
        
        
        //Category
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        //drop down Category
        String valCategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        add(category);
        
        
        // income
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        //drop down income
        String incomeCategory[] = {"Null","<1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300,240,400,30);
        add(income);
     
        //qualification
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("raleway",Font.BOLD,20));
        email.setBounds(100,290,200,30);
        add(email);
         //drop down Qualification
        String valQualification[] = {"Non-Graduate","Graduate","Post-Graduate","Doctorate","Other"};
        qualification = new JComboBox(valQualification);
        qualification.setBounds(300,290,400,30);
        add(qualification);
           
        
        //occupation
        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("raleway",Font.BOLD,20));
        marital.setBounds(100,340,200,30);
        add(marital);
        //drop down Occupation
        String valOccupation[] = {"Salaried","Self-Employed","Business","Student","Retired","Other"};
        occupation = new JComboBox(valOccupation);
        occupation.setBounds(300,340,400,30);
        add(occupation);
       
        
        //pan number
        JLabel address = new JLabel("PAN number:");
        address.setFont(new Font("raleway",Font.BOLD,20));
        address.setBounds(100,390,200,30);
        add(address);
        //address text field
        pan_TextField = new JTextField();
        pan_TextField.setFont(new Font("raleway",Font.BOLD,17));
        pan_TextField.setBounds(300,390,400,30);
        add(pan_TextField);
        
        
        //aadhar
        JLabel city = new JLabel("Aadhar number:");
        city.setFont(new Font("raleway",Font.BOLD,20));
        city.setBounds(100,440,200,30);
        add(city);
        //city text field
        aadhar_TextField = new JTextField();
        aadhar_TextField.setFont(new Font("raleway",Font.BOLD,17));
        aadhar_TextField.setBounds(300,440,400,30);
        add(aadhar_TextField);
        
        
        //senior citizen
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("raleway",Font.BOLD,20));
        state.setBounds(100,490,200,30);
        add(state);
         // yes
        syes = new JRadioButton("Yes");
        syes.setBounds(300,490,100,30);
        syes.setBackground(Color.lightGray);
        add(syes);
        // no
        sno = new JRadioButton("No");
        sno.setBounds(450,490,100,30);
        sno.setBackground(Color.lightGray);
        add(sno);
        //group
        ButtonGroup sGroup = new ButtonGroup();
        sGroup.add(sno);
        sGroup.add(syes);
        
        //existing account
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("raleway",Font.BOLD,20));
        pincode.setBounds(100,540,200,30);
        add(pincode);
        // yes
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,540,100,30);
        eyes.setBackground(Color.lightGray);
        add(eyes);
        // no
        eno = new JRadioButton("No");
        eno.setBounds(450,540,100,30);
        eno.setBackground(Color.lightGray);
        add(eno);
        //group
        ButtonGroup eGroup = new ButtonGroup();
        eGroup.add(eno);
        eGroup.add(eyes);
 
        
        
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
        String religions = (String)religion.getSelectedItem();
        String categorys = (String)category.getSelectedItem();
        String incomes = (String)income.getSelectedItem();
        String qualifications = (String)qualification.getSelectedItem();
        String occupations = (String)occupation.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "yes";
        }else if(sno.isSelected()){
            seniorcitizen = "no";
        }
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "married";
        }else if(eno.isSelected()){
            existingaccount = "unmarried";
        }
        
        String pan = pan_TextField.getText();
        String aadhar = aadhar_TextField.getText();

        
        try{
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+religions+"','"+categorys+"','"+incomes+"','"+qualifications+"','"+occupations+"','"+pan+"','"+aadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                
                //signup3
                new SignupThree(formno).setVisible(true);
                
        }catch(Exception e){
            System.out.println(e);
        }
        
        
    }
        
    public static void main(String args[]){
        new SignupTwo("");
    }
}
