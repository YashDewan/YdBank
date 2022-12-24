package bank.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ViewBalance extends JFrame implements ActionListener{
    String pinnum;
    JButton back;
    ViewBalance(String pinnum){
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
        
        // calculating total amount : 
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
        }catch(Exception exp){
             System.out.println(exp);
        }
                
        // Text on top : 
        JLabel txt = new JLabel("Your Total balance is '"+balance+"' ");
        txt.setBounds(280,100,400,100);
        txt.setFont(new Font("Osward",Font.BOLD,24));
        txt.setForeground(Color.WHITE);
        img.add(txt);
        
        // transactions txt : 
        JLabel head = new JLabel("TRANSACTION HISTORY");
        head.setBounds(130,200,400,100);
        head.setFont(new Font("Raleway",Font.BOLD,28));
        head.setForeground(Color.WHITE);
        img.add(head);
        // transactions history : 
        JLabel transhis = new JLabel();
        transhis.setBounds(130,250,800,500);
        transhis.setFont(new Font("Raleway",Font.BOLD,18));
        transhis.setForeground(Color.WHITE);
        img.add(transhis);
        Conn conn = new Conn();
        try{
            String query = "SELECT * FROM bank WHERE pin = '"+pinnum+"'";
            ResultSet rs2 = conn.s.executeQuery(query);
            while(rs2.next()){
                // setText append nhi krta update krta h isilie andr hm + lga k append krvate rhege : 
                transhis.setText(transhis.getText() + "<html>" + rs2.getString("date") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs2.getString("amountType")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs2.getString("amt")+"<br/><br/>");
            }
        }catch(Exception exp){
            System.out.println(exp);
        }
        
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
        }
    }
    
    public static void main(String []args){
        new ViewBalance("");
    }
}
