package bank.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    //globally defining btns : 
    JButton signup , login , clear , exit;
    JTextField cardtxtf;
    JPasswordField pintxtf;
    
    Login(){
        setTitle("Senpai's Bank");
        setSize(900,500);
        setLocation(350,200);
        setLayout(null);
        
        // background color of frame : 
        getContentPane().setBackground(Color.WHITE);
        
        // logo image :
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        // image resizing : 
        Image i2 = i1.getImage().getScaledInstance(172,85,Image.SCALE_DEFAULT);
        //"ImageIcon" "JLabel" me ja skta h but "Image" nhi , so : 
        ImageIcon i3 = new ImageIcon(i2);
        // to show the image :
        JLabel logo = new JLabel(i3);
        // reloacte the image : 
        logo.setBounds(160,20,185,100);
        add(logo);
        
        // title : 
        JLabel title = new JLabel("YD SENPAI'S BANK");
        title.setBounds(390,20,400,100);
        title.setFont(new Font("Osward",Font.BOLD,38));
        add(title);
        
        // card number title and textfield :
        JLabel cardno = new JLabel("Card No.");
        cardno.setBounds(230 , 160 , 200 , 100);
        cardno.setFont(new Font("Osward" , Font.BOLD , 25));
        add(cardno);
        
        cardtxtf = new JTextField();
        cardtxtf.setBounds(400 , 200 , 230 , 30);
        add(cardtxtf);
        
        // pin number title and textfield :
        JLabel pinno = new JLabel("Pin No.");
        pinno.setBounds(230 , 210 , 200 , 100);
        pinno.setFont(new Font("Osward" , Font.BOLD , 25));
        add(pinno);
        
        pintxtf = new JPasswordField();
        pintxtf.setBounds(400 , 250 , 230 , 30);
        add(pintxtf);
        
        // buttons : 
        login = new JButton("Login");
        login.setBounds(300 ,310 , 100 , 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this); //catch the button if clicked..
        add(login);
        
        clear = new JButton("Clear");
        clear.setBounds(500 ,310 , 100 , 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this); //catch the button if clicked..
        add(clear);
        
        signup = new JButton("Sign Up");
        signup.setBounds(360 ,354 , 180 , 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this); //catch the button if clicked..
        add(signup);
        
        exit = new JButton("Exit");
        exit.setBounds(700 ,400 , 100 , 30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this); //catch the button if clicked..
        add(exit);
      
        setUndecorated(true);
        // everything is visible (MANDATORY STEP) :
        setVisible(true);
    }
    
    // mandatory to make this function if we use "ActionListener" is a interface
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clear){
            cardtxtf.setText("");
            pintxtf.setText("");
        }else if(e.getSource() == signup){
            setVisible(false);
            new Signup().setVisible(true);
        }else if(e.getSource() == login){
            Conn c = new Conn();
            String cardnum = cardtxtf.getText();
            String pinnum = pintxtf.getText();
            String query = "SELECT * FROM login WHERE cardNumber = '"+cardnum+"' AND pinNumber = '"+pinnum+"' ";
            try{
                // storing in this so that we can check :
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnum).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect card or pin number , Try Again :(");
                }
            }catch(Exception exp){
                System.out.println(exp);
            }
        }else if(e.getSource() == exit){
            System.exit(0);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args){
        // class ka object bnate hi frame dikh jaye , so ye constructor ko call krega...
        new Login();
    }
}
