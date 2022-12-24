package bank.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class Signup extends JFrame implements ActionListener{
    // global : 
    JTextField nametxtf , fnametxtf , emailtxtf , addtxtf , statetxtf , citytxtf , pinctxtf;
    JButton nextbtn;
    JDateChooser cal;
    JRadioButton frad , mrad , orad;
    int randno;
    
    // construtor : 
    Signup(){
        setTitle("YD's Bank");
        setSize(900,600);
        setLocation(350,200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // form number : 
        Random rand = new Random();
        randno = rand.nextInt((9999 - 100) + 1) + 10; // 4 digits random number
        JLabel formno = new JLabel("Application Form No. " + randno);
        formno.setBounds(185,12,600,40);
        formno.setFont(new Font("Raleway" , Font.BOLD , 38));
        add(formno);
        
        // page number 
        JLabel pageno = new JLabel("Page No. 1 : PERSONAL DETAILS");
        pageno.setBounds(290,35,600,60);
        pageno.setFont(new Font("Raleway" , Font.BOLD , 17));
        add(pageno);
        
        // Name : 
        JLabel name = new JLabel("Full Name");
        name.setBounds(190,100,200,60);
        name.setFont(new Font("Raleway" , Font.BOLD , 17));
        add(name);
        
        nametxtf = new JTextField();
        nametxtf.setBounds(340, 123, 300, 20);
        nametxtf.setFont(new Font("Raleway" , Font.PLAIN , 17));
        add(nametxtf);
        
        // Father's Name : 
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(190,140,200,60);
        fname.setFont(new Font("Raleway" , Font.BOLD , 17));
        add(fname);
        
        fnametxtf = new JTextField();
        fnametxtf.setBounds(340, 163, 300, 20);
        fnametxtf.setFont(new Font("Raleway" , Font.PLAIN , 17));
        add(fnametxtf);
        
        // D.O.B : 
        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(190,180,200,60);
        dob.setFont(new Font("Raleway" , Font.BOLD , 17));
        add(dob);
        
        //to add calender in D.O.B we have to add a jar file in libraies then import a library then you can use this..
        cal = new JDateChooser();
        cal.setBounds(340,203,300,20);
        cal.setForeground(Color.BLACK);
        add(cal);
        
        
        // Gender : 
        JLabel gender = new JLabel("Gender");
        gender.setBounds(190,220,200,60);
        gender.setFont(new Font("Raleway" , Font.BOLD , 17));
        add(gender);
        
        mrad = new JRadioButton("Male");
        mrad.setBounds(350, 243, 70 , 20);
        mrad.setBackground(Color.WHITE);
        add(mrad);
        
        frad = new JRadioButton("Female");
        frad.setBounds(450, 243, 80 , 20);
        frad.setBackground(Color.WHITE);
        add(frad);
        
        orad = new JRadioButton("Others");
        orad.setBounds(550, 243, 70, 20);
        orad.setBackground(Color.WHITE);
        add(orad);
        
        // both the radio button can select at a same time , to handle this : 
        ButtonGroup grp = new ButtonGroup();
        grp.add(mrad);
        grp.add(frad);
        
        
        // email : 
        JLabel email = new JLabel("E MAIL");
        email.setBounds(190,260,200,60);
        email.setFont(new Font("Raleway" , Font.BOLD , 17));
        add(email);
        
        emailtxtf = new JTextField();
        emailtxtf.setBounds(340, 283, 300, 20);
        emailtxtf.setFont(new Font("Raleway" , Font.PLAIN , 17));
        add(emailtxtf);
        
        
        // address : 
        JLabel address = new JLabel("Address");
        address.setBounds(190,300,200,60);
        address.setFont(new Font("Raleway" , Font.BOLD , 17));
        add(address);
        
        addtxtf = new JTextField();
        addtxtf.setBounds(340, 323, 300, 20);
        addtxtf.setFont(new Font("Raleway" , Font.PLAIN , 17));
        add(addtxtf);
        
        
        // city : 
        JLabel city = new JLabel("City");
        city.setBounds(190,340,200,60);
        city.setFont(new Font("Raleway" , Font.BOLD , 17));
        add(city);
        
        citytxtf = new JTextField();
        citytxtf.setBounds(340, 363, 300, 20);
        citytxtf.setFont(new Font("Raleway" , Font.PLAIN , 17));
        add(citytxtf);
        
        
        // state : 
        JLabel state = new JLabel("State");
        state.setBounds(190,380,200,60);
        state.setFont(new Font("Raleway" , Font.BOLD , 17));
        add(state);
        
        statetxtf = new JTextField();
        statetxtf.setBounds(340, 403, 300, 20);
        statetxtf.setFont(new Font("Raleway" , Font.PLAIN , 17));
        add(statetxtf);
        
        
        // pincode : 
        JLabel pincode = new JLabel("Pincode");
        pincode.setBounds(190,420,200,60);
        pincode.setFont(new Font("Raleway" , Font.BOLD , 17));
        add(pincode);
        
        pinctxtf = new JTextField();
        pinctxtf.setBounds(340, 443, 300, 20);
        pinctxtf.setFont(new Font("Raleway" , Font.PLAIN , 17));
        add(pinctxtf);
        
        
        // next button : 
        nextbtn = new JButton("Next");
        nextbtn.setBounds(385,495,110,30);
        nextbtn.setForeground(Color.WHITE);
        nextbtn.setBackground(Color.BLACK);
        nextbtn.addActionListener(this);
        add(nextbtn);
        
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = "" + randno;
        String name = nametxtf.getText();
        String fname = fnametxtf.getText();
        String dob = ((JTextField) cal.getDateEditor().getUiComponent()).getText();
        String add = addtxtf.getText();
        String pin = pinctxtf.getText();
        String gender = null;
        if(mrad.isSelected()){
            gender = "Male";
        }else if(frad.isSelected()){
            gender = "Female";
        }else if(orad.isSelected()){
            gender = "Others";
        }
        String email = emailtxtf.getText();
        String state = statetxtf.getText();
        String city = citytxtf.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name field is empty !!");
            }else if(pin.equals("")){
                JOptionPane.showMessageDialog(null, "Enter your pincode !!");
            }else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your City !!");
            }else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your State !!");
            }else if(email.equals("")){
                JOptionPane.showMessageDialog(null, "Enter a Valid E MAIL !!");
            }else if(gender == null){
                JOptionPane.showMessageDialog(null, "Choose your Gender !!");
            }else if(add.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your Address !!");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your Father's Name !!");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your Date Of Birth !!");
            }else{
                // if the value is present then insert into the sql database by query : 
                Conn c =new Conn();
                String query = "INSERT INTO person_data_signup VALUES('"+ formno+"', '"+name+"','"+fname+"', '"+dob+"', '"+add+"', '"+pin+"', '"+gender+"', '"+email+"', '"+state+"', '"+city+"');";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Signup2(formno).setVisible(true);
            }
        }catch(Exception exp){
            System.out.println(exp);
        }
        
    }
    
    public static void main(String[] args){
        new Signup();
    }

}
