package bank.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener{
    JPasswordField pintxtf , repintxtf;
    String pinnum;
    JButton change , back;
    
    Pinchange(String pinnum){
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
        JLabel txt = new JLabel("Change your Pin Number");
        txt.setBounds(130,200,400,100);
        txt.setFont(new Font("Osward",Font.BOLD,20));
        txt.setForeground(Color.WHITE);
        img.add(txt);
        
        // enter pin text : 
        JLabel pintxt = new JLabel("Enter old Pin");
        pintxt.setBounds(130,309,150,100);
        pintxt.setFont(new Font("Osward",Font.BOLD,20));
        pintxt.setForeground(Color.WHITE);
        img.add(pintxt);
        // enter pin : 
        pintxtf = new JPasswordField();
        pintxtf.setBounds(280 , 340 , 350 , 30);
        pintxtf.setFont(new Font("Osward",Font.BOLD,20));
        pintxtf.setForeground(Color.BLACK);
        img.add(pintxtf);
        
        // re enter pin text : 
        JLabel repintxt = new JLabel("Enter New Pin");
        repintxt.setBounds(130,409,150,100);
        repintxt.setFont(new Font("Osward",Font.BOLD,20));
        repintxt.setForeground(Color.WHITE);
        img.add(repintxt);
        // re enter pin : 
        repintxtf = new JPasswordField();
        repintxtf.setBounds(280 , 440 , 350 , 30);
        repintxtf.setFont(new Font("Osward",Font.BOLD,20));
        repintxtf.setForeground(Color.BLACK);
        img.add(repintxtf);
        
        // change pin btn : 
        change = new JButton("Change Pin");
        change.setBounds(130,540,200,30);
        change.setFont(new Font("Raleway",Font.BOLD,20));
        change.addActionListener(this);
        img.add(change);
        
        // back btn : 
        back = new JButton("Back to Main Menu");
        back.setBounds(400,540,230,30);
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
            String pin = pintxtf.getText();
            String repin = repintxtf.getText();
            
            if(pin.equals("")){
                JOptionPane.showMessageDialog(null,"Enter the Old Pin");
            }
            if(repin.equals("")){
                JOptionPane.showMessageDialog(null,"Enter the New Pin");
            }
            // matching the pin with orignal one : 
            if(!pin.equals(pinnum)){
                JOptionPane.showMessageDialog(null,"Old pin you entered is Wrong");
            }
            
            // changing pin by updating sql : 
            Conn c = new Conn();
            try{
                String query1 = "UPDATE bank SET pin = '"+repin+"' WHERE pin = '"+pin+"'";
                String query2 = "UPDATE login SET pinNumber = '"+repin+"' WHERE pinNumber = '"+pin+"'";
                String query3 = "UPDATE person_data_signup3 SET pinNumber = '"+repin+"' WHERE pinNumber = '"+pin+"'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query3);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Pin Changed Successfully");
                
                setVisible(false);
                new Transactions(repin).setVisible(true);
            }catch(Exception exp){
                System.out.println(exp);
            }
        }
    }
    
    public static void main(String args[]){
        new Pinchange("");
    }

}
