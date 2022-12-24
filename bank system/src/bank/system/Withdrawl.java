package bank.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener{
    String pinnum;
    JTextField withamt;
    JButton withdraw , back;
    Withdrawl(String pinnum){
        this.pinnum = pinnum;
        setTitle("YD's Bank");
        setSize(1080,800);
        setLocation(300,0);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        // logo of bank :
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i22 = i11.getImage().getScaledInstance(180, 100, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel img2 = new JLabel(i33);
        img2.setBounds(440,0,180,75);
        add(img2);
        
        // background image : 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmanime.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1080, 760, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,30,1080,760);
        add(img);
        
        // Text on top : 
        JLabel txt = new JLabel("Please Enter the amount : ");
        txt.setBounds(130,200,400,100);
        txt.setFont(new Font("Osward",Font.BOLD,20));
        txt.setForeground(Color.WHITE);
        img.add(txt);
        
        // enter amt : 
        withamt = new JTextField();
        withamt.setBounds(130 , 350 , 500 , 30);
        withamt.setFont(new Font("Osward",Font.BOLD,20));
        withamt.setForeground(Color.BLACK);
        img.add(withamt);
        
        // deposit btn : 
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(130,440,200,30);
        withdraw.setFont(new Font("Raleway",Font.BOLD,20));
        withdraw.addActionListener(this);
        img.add(withdraw);
        setVisible(true);
        
        // back btn : 
        back = new JButton("Back to Main Menu");
        back.setBounds(400,650,230,30);
        back.setFont(new Font("Raleway",Font.BOLD,20));
        back.addActionListener(this);
        img.add(back);
        
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String amtToBeWithdrawled = withamt.getText();
        Date date = new Date();
        if(e.getSource() == back){
            setVisible(false);
            new Transactions(pinnum).setVisible(true);
        }else{
            if(withamt.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter some amount");
            }else{
                long balance = 0;
                Conn c = new Conn();
                try{
                    String q = "SELECT * FROM bank WHERE pin = '"+pinnum+"'";
                    ResultSet rs = c.s.executeQuery(q);
                    
                    while(rs.next()){
                        if(rs.getString("amountType").equals("withdraw")){
                            balance -= Integer.parseInt(rs.getString("amt"));
                        }else{
                            balance += Integer.parseInt(rs.getString("amt"));
                        }
                    }
                    
                    if(balance < Integer.parseInt(amtToBeWithdrawled)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }
                    
                    String query = "INSERT INTO bank VALUES('"+pinnum+"','withdraw','"+date+"','"+amtToBeWithdrawled+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Amount of Rs '"+amtToBeWithdrawled+"' succesfully withdrawled the money :)");
                    setVisible(false);
                    new Transactions(pinnum).setVisible(true);
                }catch(Exception exp){
                    System.out.println(exp);
                }
            }
        }
    }
    
    public static void main(String []args){
        new Withdrawl("");
    }
}
