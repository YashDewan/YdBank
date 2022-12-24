package bank.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener{
    String pinnum;
    JButton back , five , onet , twot , fivet , tent , cus;
    Fastcash(String pinnum){
        setTitle("YD's Bank");
        setSize(1080,800);
        setLocation(300,0);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        this.pinnum = pinnum;
        
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
        JLabel txt = new JLabel("Please Select your Amount");
        txt.setBounds(250,100,400,100);
        txt.setFont(new Font("Osward",Font.BOLD,20));
        txt.setForeground(Color.WHITE);
        img.add(txt);
        
        // rupees : 
        five = new JButton("Rs 500");
        five.setBounds(160,240,200,30);
        five.setFont(new Font("Raleway",Font.BOLD,20));
        five.addActionListener(this);
        img.add(five);

        onet = new JButton("Rs 1000");
        onet.setBounds(450,240,200,30);
        onet.setFont(new Font("Raleway",Font.BOLD,20));
        onet.addActionListener(this);
        img.add(onet);
        
        twot = new JButton("Rs 2000");
        twot.setBounds(160,340,200,30);
        twot.setFont(new Font("Raleway",Font.BOLD,20));
        twot.addActionListener(this);
        img.add(twot);

        fivet = new JButton("Rs 5000");
        fivet.setBounds(450,340,200,30);
        fivet.setFont(new Font("Raleway",Font.BOLD,20));
        fivet.addActionListener(this);
        img.add(fivet);
        
        tent = new JButton("Rs 10000");
        tent.setBounds(160,440,200,30);
        tent.setFont(new Font("Raleway",Font.BOLD,20));
        tent.addActionListener(this);
        img.add(tent);

        cus = new JButton("Custom input");
        cus.setBounds(450,440,200,30);
        cus.setFont(new Font("Raleway",Font.BOLD,20));
        cus.addActionListener(this);
        img.add(cus);
        
        back = new JButton("Back to Main Menu");
        back.setBounds(400,640,250,30);
        back.setFont(new Font("Raleway",Font.BOLD,20));
        back.addActionListener(this);
        img.add(back);
        
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            setVisible(false);
            new Transactions(pinnum).setVisible(true);
        }else if(e.getSource() == cus){
            setVisible(false);
            new Withdrawl(pinnum).setVisible(true);
        }else{
            // get amt from the buttons : 
            String amountInput = ((JButton)e.getSource()).getText().substring(3);
            Conn c = new Conn();
            long balance = 0;
            try{
               // count the total amount & then check that we can withdraw the money or not : 
                String query = "SELECT * FROM bank WHERE pin = '"+pinnum+"'";
                ResultSet rs = c.s.executeQuery(query); 
                //total of money : 
                while(rs.next()){
                    if(rs.getString("amountType").equals("withdraw")){
                        balance -= Integer.parseInt(rs.getString("amt"));
                    }else{
                        balance += Integer.parseInt(rs.getString("amt"));
                    }
                }
                //check : 
                if(balance < Integer.parseInt(amountInput)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                // entry in sql that money is deducted : 
                Date date = new Date();
                String query2 = "INSERT INTO bank VALUES('"+pinnum+"','withdraw','"+date+"','"+amountInput+"')";
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Amount of Rs '"+amountInput+"' succesfully withdrawled the money :)");
                setVisible(false);
                new Transactions(pinnum).setVisible(true);
            }catch(Exception exp){
                System.out.println(exp);
            }            
        }
    }
    
    public static void main(String []args){
        new Fastcash("");
    }
}