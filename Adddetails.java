import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Adddetails extends JFrame implements ActionListener {
    JLabel lblusername,tfname;
    JTextField tnum,country,phone,email,address;

    JComboBox ddown;
    JButton Add,back;
    JRadioButton male,female;
    Adddetails(String username){
        setBounds(240,120,900,450);
        getContentPane().setBackground(new Color(70,130,180));
        setLayout(null);

        JLabel uname=new JLabel("Username");
        uname.setFont(new Font("Monospaced",Font.BOLD,16));
        uname.setBounds(30,20,150,25);
        add(uname);

        lblusername=new JLabel();
        lblusername.setBounds(190,20,150,25);
        lblusername.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(lblusername);



        JLabel id=new JLabel("Identity");
        id.setFont(new Font("Monospaced",Font.BOLD,16));
        id.setBounds(30,60,150,25);
        add(id);

        ddown=new JComboBox<>(new String[]{"CNIC","Passport","B-Form"});
        ddown.setFont(new Font("Monospaced",Font.BOLD,14));
        ddown.setBounds(190,60,200,25);
        ddown.setBackground(Color.WHITE);
        add(ddown);

        JLabel num=new JLabel("ID Number");
        num.setFont(new Font("Monospaced",Font.BOLD,16));
        num.setBounds(30,100,150,25);
        add(num);

        tnum=new JTextField();
        tnum.setFont(new Font("Monospaced",Font.BOLD,16));
        tnum.setBounds(190,100,200,25);
        tnum.setBackground(Color.WHITE);
        add(tnum);

        JLabel name=new JLabel("Name");
        name.setFont(new Font("Monospaced",Font.BOLD,16));
        name.setBounds(30,140,150,25);
        add(name);

        tfname=new JLabel();
        tfname.setBounds(190,140,150,25);
        tfname.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(tfname);

        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Monospaced",Font.BOLD,16));
        gender.setBounds(30,180,150,25);
        add(gender);

        male=new JRadioButton("Male");
        male.setFont(new Font("Monospaced",Font.BOLD,16));
        male.setBounds(190,180,70,25);
        add(male);

        female=new JRadioButton("Female");
        female.setFont(new Font("Monospaced",Font.BOLD,16));
        female.setBounds(270,180,90,25);
        add(female);

        ButtonGroup mf=new ButtonGroup();
        mf.add(male);
        mf.add(female);

        JLabel count=new JLabel("Country");
        count.setFont(new Font("Monospaced",Font.BOLD,16));
        count.setBounds(30,220,150,25);
        add(count);

        country=new JTextField();
        country.setFont(new Font("Monospaced",Font.BOLD,16));
        country.setBounds(190,220,200,25);
        country.setBackground(Color.WHITE);
        add(country);

        JLabel eml=new JLabel("Email");
        eml.setFont(new Font("Monospaced",Font.BOLD,16));
        eml.setBounds(30,260,150,25);
        add(eml);

        email=new JTextField();
        email.setFont(new Font("Monospaced",Font.BOLD,16));
        email.setBounds(190,260,200,25);
        email.setBackground(Color.WHITE);
        add(email);

        JLabel ads=new JLabel("Address");
        ads.setFont(new Font("Monospaced",Font.BOLD,16));
        ads.setBounds(30,300,150,25);
        add(ads);

        address=new JTextField();
        address.setFont(new Font("Monospaced",Font.BOLD,16));
        address.setBounds(190,300,200,25);
        address.setBackground(Color.WHITE);
        add(address);

        JLabel phn=new JLabel("Cell Number");
        phn.setFont(new Font("Monospaced",Font.BOLD,16));
        phn.setBounds(30,340,150,25);
        add(phn);

        phone=new JTextField();
        phone.setFont(new Font("Monospaced",Font.BOLD,16));
        phone.setBounds(190,340,200,25);
        phone.setBackground(Color.WHITE);
        add(phone);

        Add=new JButton("Add");
        Add.setFont(new Font("Monospaced",Font.BOLD,16));
        Add.setBounds(100,380,70,25);
        Add.setBackground(Color.BLACK);
        Add.setForeground(Color.WHITE);
        Add.addActionListener(this);
        add(Add);

        back=new JButton("Back");
        back.setFont(new Font("Monospaced",Font.BOLD,16));
        back.setBounds(700,380,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/adddetails.png"));
        Image img1=img.getImage().getScaledInstance(400,350,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(img1);
        JLabel img3=new JLabel(img2);
        img3.setBounds(420,20,400,350);
        add(img3);

        try {

            Connect con=new Connect();
            ResultSet rs=con.s.executeQuery("select * from signupinfo where Username='"+username+"'");

            while (rs.next()){
                lblusername.setText(rs.getString("Username"));
                tfname.setText(rs.getString("Fullname"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==Add){
            String un=lblusername.getText();
            String i=(String) ddown.getSelectedItem();
            String number=tnum.getText();
            String na=tfname.getText();
            String gen=null;
            if (male.isSelected())
                gen="Male";
            else
                gen="Female";
            String c=country.getText();
            String em=email.getText();
            String a=address.getText();
            String ph=phone.getText();

            try {
                Connect con=new Connect();
                String query="insert into cusdetails values('"+un+"','"+i+"','"+number+"','"+na+"','"+gen+"','"+c+"','"+em+"','"+a+"','"+ph+"')";
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Your details were added successfully");

            }catch (Exception e){
                e.printStackTrace();
            }

        }
        else
            setVisible(false);
    }



    public static void main(String[] args) {
        new Adddetails("gillani_05");
    }
}
