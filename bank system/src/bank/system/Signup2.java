package bank.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener{
    JComboBox relbox , incbox , edubox , ocpbox;
    JTextField pantxtf , aadhartxtf;
    JButton nextbtn2;
    JRadioButton senyes , senno , exno , exyes;
    String formno;
    
    Signup2(String formno){
        
        this.formno = formno;
        
        setTitle("YD's Bank");
        setSize(900,600);
        setLocation(350,200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        // title : 
        JLabel title = new JLabel("Page No. 2 : ADDITIONAL DETAILS");
        title.setBounds(200,6,800,100);
        title.setFont(new Font("Raleway" , Font.BOLD , 28));
        add(title);
        
        // religion : 
        JLabel rel = new JLabel("Religion");
        rel.setBounds(200,100,200,60);
        rel.setFont(new Font("Raleway" , Font.BOLD , 18));
        add(rel);
        // dropbox : 
        String relarr[] = {"Hindu" , "Muslim" , "Christians" , "Sikh" , "Others"}; 
        relbox = new JComboBox(relarr);
        relbox.setBounds(355, 123, 300, 20);
        relbox.setFont(new Font("Raleway" , Font.PLAIN , 17));
        add(relbox);
        
        // Income : 
        JLabel inc = new JLabel("Income");
        inc.setBounds(200,140,200,60);
        inc.setFont(new Font("Raleway" , Font.BOLD , 18));
        add(inc);
        // dropbox : 
        String incarr[] = {"Null" , "Up to ₹1 lac" , "₹1-5 lac" , "₹5-10 lac" , "Others"}; 
        incbox = new JComboBox(incarr);
        incbox.setBounds(355, 163, 300, 20);
        incbox.setFont(new Font("Raleway" , Font.PLAIN , 17));
        add(incbox);
        
        // Education qualifications : 
        JLabel edu = new JLabel("Education");
        edu.setBounds(200,180,200,60);
        edu.setFont(new Font("Raleway" , Font.BOLD , 18));
        add(edu);
        JLabel qua = new JLabel("Qualification");
        qua.setBounds(200,200,200,60);
        qua.setFont(new Font("Raleway" , Font.BOLD , 18));
        add(qua);
        // dropbox : 
        String eduarr[] = {"Non - Graduate" , "Graduate" , "Post Graduatation" , "Doctrate" , "Others"}; 
        edubox = new JComboBox(eduarr);
        edubox.setBounds(355, 203, 300, 20);
        edubox.setFont(new Font("Raleway" , Font.PLAIN , 17));
        add(edubox);
        
        // Occupation : 
        JLabel ocp = new JLabel("Occupation");
        ocp.setBounds(200,235,200,60);
        ocp.setFont(new Font("Raleway" , Font.BOLD , 18));
        add(ocp);
        // dropbox : 
        String ocparr[] = {"Student" , "Business" , "Salaried" , "Slef Employed" , "Others"}; 
        ocpbox = new JComboBox(ocparr);
        ocpbox.setBounds(355, 258, 300, 20);
        ocpbox.setFont(new Font("Raleway" , Font.PLAIN , 17));
        add(ocpbox);
        
        // PAN Number : 
        JLabel pan = new JLabel("PAN Number");
        pan.setBounds(200,275,200,60);
        pan.setFont(new Font("Raleway" , Font.BOLD , 18));
        add(pan);
        // textfield : 
        pantxtf = new JTextField();
        pantxtf.setBounds(355, 298, 300, 20);
        pantxtf.setFont(new Font("Raleway" , Font.PLAIN , 17));
        add(pantxtf);
        
        // Aadhar Number : 
        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(200,315,200,60);
        aadhar.setFont(new Font("Raleway" , Font.BOLD , 18));
        add(aadhar);
        // textfield : 
        aadhartxtf = new JTextField();
        aadhartxtf.setBounds(355, 338, 300, 20);
        aadhartxtf.setFont(new Font("Raleway" , Font.PLAIN , 17));
        add(aadhartxtf);
        
        // Senior Citizen : 
        JLabel sen = new JLabel("Senior Citizen");
        sen.setBounds(200,355,200,60);
        sen.setFont(new Font("Raleway" , Font.BOLD , 18));
        add(sen);
        // radio btns : 
        senyes = new JRadioButton("Yes");
        senyes.setBounds(395, 378, 100, 20);
        senyes.setFont(new Font("Raleway" , Font.PLAIN , 17));
        senyes.setBackground(Color.WHITE);
        add(senyes);
        senno = new JRadioButton("No");
        senno.setBounds(545, 378, 100, 20);
        senno.setFont(new Font("Raleway" , Font.PLAIN , 17));
        senno.setBackground(Color.WHITE);
        add(senno);
        //grp btn : 
        ButtonGroup grp2 = new ButtonGroup();
        grp2.add(senyes);
        grp2.add(senno);
        
        // Existing Account : 
        JLabel ex = new JLabel("Existing Account");
        ex.setBounds(200,395,200,60);
        ex.setFont(new Font("Raleway" , Font.BOLD , 18));
        add(ex);
        // radio btns : 
        exyes = new JRadioButton("Yes");
        exyes.setBounds(395, 418, 100, 20);
        exyes.setFont(new Font("Raleway" , Font.PLAIN , 17));
        exyes.setBackground(Color.WHITE);
        add(exyes);
        exno = new JRadioButton("No");
        exno.setBounds(545, 418, 100, 20);
        exno.setFont(new Font("Raleway" , Font.PLAIN , 17));
        exno.setBackground(Color.WHITE);
        add(exno);
        // btn grp :
        ButtonGroup grp = new ButtonGroup();
        grp.add(exyes);
        grp.add(exno);
        
        // Next Button : 
        nextbtn2 = new JButton("Next");
        nextbtn2.setBounds(377,470,110,30);
        nextbtn2.setForeground(Color.WHITE);
        nextbtn2.setBackground(Color.BLACK);
        nextbtn2.addActionListener(this);
        add(nextbtn2);
        
        setUndecorated(true);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String) relbox.getSelectedItem();
        String inc = (String) incbox.getSelectedItem();
        String edu = (String) edubox.getSelectedItem();
        String ocp = (String) ocpbox.getSelectedItem();
        String pan = pantxtf.getText();
        String aad = aadhartxtf.getText();
        String sen = null;
        if(senyes.isSelected()){
            sen = "Yes";
        }else if(senno.isSelected()){
            sen = "No";
        }
        String exacc = null;
        if(exyes.isSelected()){
            exacc = "Yes";
        }else if(exno.isSelected()){
            exacc = "No";
        }
        
        try{
            if(rel.equals("")){
                JOptionPane.showMessageDialog(null, "Please Select your Religion !!");
            }else if(inc.equals("")){
                JOptionPane.showMessageDialog(null, "Please Select your Income !!");
            }else if(edu.equals("")){
                JOptionPane.showMessageDialog(null, "Please Select your Eductaional Qualification !!");
            }else if(ocp.equals("")){
                JOptionPane.showMessageDialog(null, "Please Select your Occupation !!");
            }else if(sen == null){
                JOptionPane.showMessageDialog(null, "Please Select the option !!");
            }else if(exacc == null){
                JOptionPane.showMessageDialog(null, "Please Select the option !!");
            }else if(pan == null){
                JOptionPane.showMessageDialog(null, "Please Enter your PAN number !!");
            }else if(aad == null){
                JOptionPane.showMessageDialog(null, "Please Enter your Aadhar number !!");
            }else{
                Conn c = new Conn();
                String query = "INSERT INTO person_data_signup2 VALUES('"+formno+"','"+rel+"','"+inc+"','"+edu+"','"+ocp+"','"+sen+"','"+exacc+"','"+pan+"','"+aad+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Signup3(formno).setVisible(true);
            }
        }catch(Exception exp){
            System.out.println(exp);
        }
    }
    
    public static void main(String[] args){
        new Signup2("");
    }
    
}
