package bank.system;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup3 extends JFrame implements ActionListener {
    String formno;
    JRadioButton a1,a2,a3,a4;
    JCheckBox s1, s2, s3, s4, s5, s6;
    JCheckBox accept;
    JButton submit, cancel;
    
    Signup3(String formno){
        this.formno = formno;
        setTitle("YD's Bank");
        setSize(850,765);
        setLocation(350,80);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel title = new JLabel("Page No. 2 : ACCOUNT DETAILS");
        title.setBounds(200,6,800,100);
        title.setFont(new Font("Raleway" , Font.BOLD  , 28));
        add(title);
        
        // account type : 
        JLabel acctype = new JLabel("Account Type");
        acctype.setBounds(200,100,200,60);
        acctype.setFont(new Font("Raleway" , Font.BOLD  , 18));
        add(acctype);
        // radio btn 1 :
        a1 = new JRadioButton("Saving Account");
        a1.setBounds(200,150,180,20);
        a1.setBackground(Color.WHITE);
        a1.setFont(new Font("Raleway" , Font.PLAIN , 18));
        add(a1);
        // radio btn 2 :
        a2 = new JRadioButton("Fixed Deposit Account");
        a2.setBounds(400,150,250,20);
        a2.setBackground(Color.WHITE);
        a2.setFont(new Font("Raleway" , Font.PLAIN , 18));
        add(a2);
        // radio btn 3 :
        a3 = new JRadioButton("Current Account");
        a3.setBounds(200,180,180,20);
        a3.setBackground(Color.WHITE);
        a3.setFont(new Font("Raleway" , Font.PLAIN , 18));
        add(a3);
        // radio btn 4 :
        a4 = new JRadioButton("Recurring Deposit Account");
        a4.setBounds(400,180,250,20);
        a4.setBackground(Color.WHITE);
        a4.setFont(new Font("Raleway" , Font.PLAIN , 18));
        add(a4);
        // grp btn : 
        ButtonGroup grp = new ButtonGroup();
        grp.add(a2);
        grp.add(a1);
        grp.add(a3);
        grp.add(a4);
        
        // Card Number title : 
        JLabel card = new JLabel("Card Number");
        card.setBounds(200,240,250,20);
        card.setFont(new Font("Raleway" , Font.BOLD  , 18));
        add(card);
        // line : 
        JLabel cardline = new JLabel("Your 16 digits Card Number");
        cardline.setBounds(200,256,250,20);
        cardline.setFont(new Font("Raleway" , Font.PLAIN  , 14));
        add(cardline);
        // sample card num :
        JLabel cardnum = new JLabel("XXXX-XXXX-XXXX-4156");
        cardnum.setBounds(400,240,250,20);
        cardnum.setFont(new Font("Raleway" , Font.BOLD  , 18));
        add(cardnum);
        
        // Pin Number title : 
        JLabel pin = new JLabel("Pin Number");
        pin.setBounds(200,300,250,20);
        pin.setFont(new Font("Raleway" , Font.BOLD  , 18));
        add(pin);
        // line : 
        JLabel pinline = new JLabel("Your 4 digits Pin Number");
        pinline.setBounds(200,316,250,20);
        pinline.setFont(new Font("Raleway" , Font.PLAIN  , 14));
        add(pinline);
        // sample card num :
        JLabel pinnum = new JLabel("XXXX");
        pinnum.setBounds(400,300,250,20);
        pinnum.setFont(new Font("Raleway" , Font.BOLD  , 18));
        add(pinnum);
        
        // Services Requried : 
        JLabel ser = new JLabel("Services Requried");
        ser.setBounds(200,350,200,60);
        ser.setFont(new Font("Raleway" , Font.BOLD  , 18));
        add(ser);
        // check box 1 : 
        s1 = new JCheckBox("ATM Card");
        s1.setBounds(200,400,180,20);
        s1.setBackground(Color.WHITE);
        s1.setFont(new Font("Raleway" , Font.PLAIN , 18));
        add(s1);
        // check box 2 : 
        s2 = new JCheckBox("Internet Banking");
        s2.setBounds(400,400,180,20);
        s2.setBackground(Color.WHITE);
        s2.setFont(new Font("Raleway" , Font.PLAIN , 18));
        add(s2);
        // check box 3 : 
        s3 = new JCheckBox("Mobile Banking");
        s3.setBounds(200,430,180,20);
        s3.setBackground(Color.WHITE);
        s3.setFont(new Font("Raleway" , Font.PLAIN , 18));
        add(s3);
        // check box 4: 
        s4 = new JCheckBox("EMAIL & SMS Alert");
        s4.setBounds(400,430,200,20);
        s4.setBackground(Color.WHITE);
        s4.setFont(new Font("Raleway" , Font.PLAIN , 18));
        add(s4);
        // check box 5 : 
        s5 = new JCheckBox("Cheque Book");
        s5.setBounds(200,460,180,20);
        s5.setBackground(Color.WHITE);
        s5.setFont(new Font("Raleway" , Font.PLAIN , 18));
        add(s5);
        // check box 6: 
        s6 = new JCheckBox("E Statement");
        s6.setBounds(400,460,180,20);
        s6.setBackground(Color.WHITE);
        s6.setFont(new Font("Raleway" , Font.PLAIN , 18));
        add(s6);
        
        // Check box for accepting terms and conditions : 
        accept = new JCheckBox("I hereby declares that the above entered details are correct to");
        JLabel accept2 = new JLabel("the best of my knowledge");
        accept.setBounds(200,550,600,20);
        accept2.setBounds(225,570,600,20);
        accept.setBackground(Color.WHITE);
        accept2.setBackground(Color.WHITE);
        accept.setFont(new Font("Raleway" , Font.PLAIN , 14));
        accept2.setFont(new Font("Raleway" , Font.PLAIN , 14));
        add(accept);
        add(accept2);
        
        // Submit Button : 
        submit = new JButton("Submit");
        submit.setBounds(270,650,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        // Cancel Button : 
        cancel = new JButton("Cancel");
        cancel.setBounds(440,650,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String acctype = null;
            if(a1.isSelected()){
                acctype = "Saving Account";
            }else if(a2.isSelected()){
                acctype = "Fixed Deposit Account";
            }else if(a3.isSelected()){
                acctype = "Current Account";
            }else if(a4.isSelected()){
                acctype = "Recurring Deposit Account";
            }
            
            // Card Number generate by random number : 
            String cardnumstr ="";
            Random rand = new Random();
            for(int i=1;i<=12;i++){
                int x = rand.nextInt(10);   
                cardnumstr += x;
            }
            
            // PIN generate by random number : 
            String pinnumstr ="";
            for(int i=1;i<=4;i++){
                int x = rand.nextInt(10);   
                pinnumstr += x;
            }
            
            String service = "";
            if(s1.isSelected()){
                service += " ATM Card";
            }else if(s2.isSelected()){
                service += " Internet Banking";
            }else if(s3.isSelected()){
                service += " Mobile Banking";
            }else if(s4.isSelected()){
                service += " EMAIL & SMS Alert";
            }else if(s5.isSelected()){
                service += " Cheque Book";
            }else if(s6.isSelected()){
                service += " E Statement";
            }
            
            try{
                if(acctype == null){
                    JOptionPane.showMessageDialog(null, "Account type is requried");
                }else if(service.equals("")){
                    JOptionPane.showMessageDialog(null, "Please select the Service");
                }else if(accept.isSelected() == false){
                    JOptionPane.showMessageDialog(null, "Accept that your input data is correct");
                }else{
                    Conn c = new Conn();
                    String query1 = "INSERT INTO person_data_signup3 VALUES ('"+formno+"','"+acctype+"','"+cardnumstr+"','"+pinnumstr+"','"+service+"')";
                    c.s.executeUpdate(query1);
                    String query2 = "INSERT INTO login VALUES ('"+formno+"','"+cardnumstr+"','"+pinnumstr+"')";
                    c.s.executeUpdate(query2);
                    
                    // displaying user their card number and pin number : 
                    JOptionPane.showMessageDialog(null, "WELCOME TO YD'S BANK \n Card Number : " + cardnumstr + "\n Pin Number : " + pinnumstr);
                    setVisible(false);
                    JOptionPane.showMessageDialog(null,"You have to deposit some amount");
                    new Deposit(pinnumstr).setVisible(true);
                }
            
            }catch(Exception exp){
                System.out.println(exp);
            }
        }else{
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Signup3("");
    }
}
