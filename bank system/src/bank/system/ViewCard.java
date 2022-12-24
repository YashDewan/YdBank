package bank.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ViewCard extends JFrame implements ActionListener{
    String pinnum;
    JButton back , show;
    JLabel pinnumoncard , cardnum;
            
    ViewCard(String pinnum){
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
                
        // show btn : 
        show = new JButton("Show Card and Pin Number");
        show.setBounds(250,450,300,30);
        show.setFont(new Font("Raleway",Font.BOLD,20));
        show.setBackground(Color.WHITE);
        show.setForeground(Color.BLACK);
        show.addActionListener(this);
        img.add(show);
            
        // on card text of card number : 
        cardnum = new JLabel("XXXX - XXXX - XXXX");
        cardnum.setForeground(Color.WHITE);
        cardnum.setFont(new Font("Raleway",Font.BOLD,22));
        cardnum.setBounds(280,320,300,30);
        img.add(cardnum);

        // on card text of Pin number : 
        pinnumoncard = new JLabel("XXXX");
        pinnumoncard.setForeground(Color.WHITE);
        pinnumoncard.setFont(new Font("Raleway",Font.BOLD,18));
        pinnumoncard.setBounds(240,350,300,30);
        img.add(pinnumoncard);

        Conn c = new Conn();
        try{
            String query = "SELECT cardNumber FROM login WHERE pinNumber = '"+pinnum+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                cardnum.setText(rs.getString("cardNumber").substring(0,4) + " - XXXX - XX" + rs.getString("cardNumber").substring(10,12));
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        // atm card img :
        ImageIcon i111 = new ImageIcon(ClassLoader.getSystemResource("icons/cardd.png"));
        Image i222 = i111.getImage().getScaledInstance(564, 564, Image.SCALE_DEFAULT);
        ImageIcon i333 = new ImageIcon(i222);
        JLabel img3 = new JLabel(i333);
        img3.setBounds(200,150,400,320);
        img.add(img3);
        
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
        if(e.getSource() == back){
            setVisible(false);
            new Transactions(pinnum).setVisible(true);
        }else{
            Conn c = new Conn();
            System.out.println(pinnum);
            pinnumoncard.setText(pinnum);
            try{
                String query = "SELECT cardNumber FROM login WHERE pinNumber = '"+pinnum+"' ";
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    cardnum.setText(rs.getString("cardNumber").substring(0,4) + " - " + 
                            rs.getString("cardNumber").substring(4,8) + " - " +
                            rs.getString("cardNumber").substring(8,12));
            }
            }catch(Exception ex){
                System.out.println(ex);
            }    
        }
    }
    
    public static void main(String args[]){
        new ViewCard("");
    }
}
