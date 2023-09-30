import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Updetails extends JFrame implements ActionListener {
    JLabel lblusername,tfname;
    JTextField tnum,country,phone,email,address,tid,tgen;

    JComboBox ddown;
    JButton Add,back;
    JRadioButton male,female;
    Updetails(String username){
        setBounds(240,120,900,450);
        getContentPane().setBackground(new Color(70,130,180));
        setLayout(null);

        JLabel heading=new JLabel("Update Your Details");
        heading.setBounds(350,0,400,20);
        heading.setFont(new Font("Monospaced",Font.BOLD,22));
        add(heading);

        JLabel uname=new JLabel("Username");
        uname.setBounds(30,20,150,25);
        uname.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(uname);

        lblusername=new JLabel();
        lblusername.setBounds(190,20,150,25);
        lblusername.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(lblusername);



        JLabel id=new JLabel("Identity");
        id.setBounds(30,60,150,25);
        id.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(id);

        tid=new JTextField();
        tid.setFont(new Font("Monospaced",Font.BOLD,16));
        tid.setBounds(190,60,200,25);
        tid.setBackground(Color.WHITE);
        add(tid);

        JLabel num=new JLabel("ID Number");
        num.setBounds(30,100,150,25);
        num.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(num);

        tnum=new JTextField();
        tnum.setFont(new Font("Monospaced",Font.BOLD,16));
        tnum.setBounds(190,100,200,25);
        tnum.setBackground(Color.WHITE);
        add(tnum);

        JLabel name=new JLabel("Name");
        name.setBounds(30,140,150,25);
        name.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(name);

        tfname=new JLabel();
        tfname.setBounds(190,140,150,25);
        tfname.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(tfname);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(30,180,150,25);
        gender.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(gender);

        tgen=new JTextField();
        tgen.setBounds(190,180,200,25);
        tgen.setBackground(Color.WHITE);
        add(tgen);

        JLabel count=new JLabel("Country");
        count.setBounds(30,220,150,25);
        count.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(count);

        country=new JTextField();
        country.setFont(new Font("Monospaced",Font.BOLD,16));
        country.setBounds(190,220,200,25);
        country.setBackground(Color.WHITE);
        add(country);

        JLabel eml=new JLabel("Email");
        eml.setBounds(30,260,150,25);
        eml.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(eml);

        email=new JTextField();
        email.setFont(new Font("Monospaced",Font.BOLD,16));
        email.setBounds(190,260,200,25);
        email.setBackground(Color.WHITE);
        add(email);

        JLabel ads=new JLabel("Address");
        ads.setBounds(30,300,150,25);
        ads.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(ads);

        address=new JTextField();
        address.setFont(new Font("Monospaced",Font.BOLD,16));
        address.setBounds(190,300,200,25);
        address.setBackground(Color.WHITE);
        add(address);

        JLabel phn=new JLabel("Cell Number");
        phn.setBounds(30,340,150,25);
        phn.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(phn);

        phone=new JTextField();
        phone.setFont(new Font("Monospaced",Font.BOLD,16));
        phone.setBounds(190,340,200,25);
        phone.setBackground(Color.WHITE);
        add(phone);

        Add=new JButton("Update");
        Add.setFont(new Font("Monospaced",Font.BOLD,16));
        Add.setBounds(100,380,100,25);
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

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/update.jpg"));
        Image img1=img.getImage().getScaledInstance(350,350,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(img1);
        JLabel img3=new JLabel(img2);
        img3.setBounds(450,60,350,300);
        add(img3);

        try {

            Connect con=new Connect();
            ResultSet rs=con.s.executeQuery("select * from cusdetails where Username='"+username+"'");

            while (rs.next()){
                lblusername.setText(rs.getString("username"));
                tid .setText(rs.getString("identity"));
                tnum .setText(rs.getString("id_num"));
                tfname .setText(rs.getString("name"));
                tgen .setText(rs.getString("gender"));
                country .setText(rs.getString("country"));
                email .setText(rs.getString("email"));
                address .setText(rs.getString("address"));
                phone .setText(rs.getString("ph_number"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==Add){
            String un=lblusername.getText();
            String i=tid.getText();
            String number=tnum.getText();
            String na=tfname.getText();
            String gen=tgen.getText();
            String c=country.getText();
            String em=email.getText();
            String a=address.getText();
            String ph=phone.getText();

            try {
                Connect con=new Connect();
                String query="update cusdetails set username='"+un+"',identity='"+i+"',id_num='"+number+"',name='"+na+"',gender='"+gen+"',country='"+c+"',email='"+em+"',address='"+a+"',ph_number='"+ph+"'";
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Your details were updates successfully");

            }catch (Exception e){
                e.printStackTrace();
            }

        }
        else
            setVisible(false);
    }



    public static void main(String[] args) {
        new Updetails("gillani_05");
    }
}
