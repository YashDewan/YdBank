package bank.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    JButton deposit , withdrawl , fastcash , ministat , pinchange , viewbalance , exit , viewcard;
    String pinnum;
    Transactions(String pinnum){
        setTitle("YD's Bank");
        setSize(1080,800);
        setLocation(300,0);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        this.pinnum = pinnum;
        
        // Text on top : 
        JLabel txt = new JLabel("Please Select your Transaction");
        txt.setBounds(250,100,400,100);
        txt.setFont(new Font("Osward",Font.BOLD,20));
        txt.setForeground(Color.WHITE);
        add(txt);
        
        // deposit btn : 
        deposit = new JButton("Deposit Cash");
        deposit.setBounds(160,240,200,30);
        deposit.setFont(new Font("Raleway",Font.BOLD,20));
        deposit.addActionListener(this);
        add(deposit);

        // withdrawl btn : 
        withdrawl = new JButton("Withdrawl Cash");
        withdrawl.setBounds(450,240,200,30);
        withdrawl.setFont(new Font("Raleway",Font.BOLD,20));
        withdrawl.addActionListener(this);
        add(withdrawl);
        
        // fastcash btn : 
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(160,340,200,30);
        fastcash.setFont(new Font("Raleway",Font.BOLD,20));
        fastcash.addActionListener(this);
        add(fastcash);
        
        // pin change btn : 
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(450,340,200,30);
        pinchange.setFont(new Font("Raleway",Font.BOLD,20));
        pinchange.addActionListener(this);
        add(pinchange);

        // balanceenq btn : 
        viewbalance = new JButton("All Transactions");
        viewbalance.setBounds(160,440,200,30);
        viewbalance.setFont(new Font("Raleway",Font.BOLD,20));
        viewbalance.addActionListener(this);
        add(viewbalance);
        
        // showcard btn : 
        viewcard = new JButton("View ATM Card");
        viewcard.setBounds(450,440,200,30);
        viewcard.setFont(new Font("Raleway",Font.BOLD,20));
        viewcard.addActionListener(this);
        add(viewcard);

        // exit btn : 
        exit = new JButton("Exit");
        exit.setBounds(450,540,200,30);
        exit.setFont(new Font("Raleway",Font.BOLD,20));
        exit.addActionListener(this);
        add(exit);
        
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
               
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            System.exit(0);
        }else if(e.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnum).setVisible(true);
        }else if(e.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnum).setVisible(true);
        }else if(e.getSource() == fastcash){
            setVisible(false);
            new Fastcash(pinnum).setVisible(true);
        }else if(e.getSource() == pinchange){
            setVisible(false);
            new Pinchange(pinnum).setVisible(true);
        }else if(e.getSource() == viewbalance){
            setVisible(false);
            new ViewBalance(pinnum).setVisible(true);
        }else if(e.getSource() == viewcard){
            setVisible(false);
            new ViewCard(pinnum).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Transactions("");
    }


}
