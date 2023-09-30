import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Deletedetails extends JFrame implements ActionListener {
    JButton del,back;
    String username;

    Deletedetails(String username){
        this.username=username;
        setBounds(240,120,900,450);
        getContentPane().setBackground(new Color(70,130,180));
        setLayout(null);

        JLabel uname=new JLabel("Username");
        uname.setBounds(30,20,150,25);
        uname.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(uname);

        JLabel juname=new JLabel();
        juname.setBounds(190,20,150,25);
        juname.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(juname);

        JLabel id=new JLabel("Identity");
        id.setBounds(30,60,150,25);
        id.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(id);

        JLabel jid=new JLabel();
        jid.setBounds(190,60,150,25);
        jid.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jid);

        JLabel idnum=new JLabel("ID Number");
        idnum.setBounds(30,100,150,25);
        idnum.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(idnum);

        JLabel jidnum=new JLabel();
        jidnum.setBounds(190,100,150,25);
        jidnum.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jidnum);

        JLabel name=new JLabel("Name");
        name.setBounds(30,140,150,25);
        name.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(name);

        JLabel jname=new JLabel();
        jname.setBounds(190,140,150,25);
        jname.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jname);

        JLabel gen=new JLabel("Gender");
        gen.setBounds(250,180,150,25);
        gen.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(gen);

        JLabel jgen=new JLabel();
        jgen.setBounds(410,180,150,25);
        jgen.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jgen);

        JLabel coun=new JLabel("Country");
        coun.setBounds(400,20,150,25);
        coun.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(coun);

        JLabel jcoun=new JLabel();
        jcoun.setBounds(560,20,150,25);
        jcoun.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jcoun);

        JLabel email=new JLabel("Email");
        email.setBounds(400,60,150,25);
        email.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(email);

        JLabel jemail=new JLabel();
        jemail.setBounds(560,60,250,25);
        jemail.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jemail);

        JLabel num=new JLabel("Cell Number");
        num.setBounds(400,100,150,25);
        num.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(num);

        JLabel jnum=new JLabel();
        jnum.setBounds(560,100,150,25);
        jnum.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jnum);

        JLabel adrs=new JLabel("Address");
        adrs.setBounds(400,140,150,25);
        adrs.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(adrs);

        JLabel jadrs=new JLabel();
        jadrs.setBounds(560,140,150,25);
        jadrs.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jadrs);

        del=new JButton("Delete");
        del.setFont(new Font("Monospaced",Font.BOLD,16));
        del.setForeground(Color.WHITE);
        del.setBackground(Color.BLACK);
        del.setBounds(300,220,100,25);
        del.addActionListener(this);
        add(del);

        back=new JButton("Back");
        back.setFont(new Font("Monospaced",Font.BOLD,16));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(500,220,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/delete.jpg"));
        Image img1=img.getImage().getScaledInstance(200,150,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(img1);
        JLabel img3=new JLabel(img2);
        img3.setBounds(0,250,300,190);
        add(img3);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,150,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel i4=new JLabel(i3);
        i4.setBounds(300,250,300,190);
        add(i4);

        ImageIcon l1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.jpg"));
        Image l2=l1.getImage().getScaledInstance(200,150,Image.SCALE_DEFAULT);
        ImageIcon l3=new ImageIcon(l2);
        JLabel l4=new JLabel(l3);
        l4.setBounds(600,250,300,190);
        add(l4);

        try {
            Connect con=new Connect();
            ResultSet rs=con.s.executeQuery("select * from cusdetails where Username='"+username+"'");
            while (rs.next()){
                juname.setText(rs.getString("username"));
                jid.setText(rs.getString("identity"));
                jidnum.setText(rs.getString("id_num"));
                jname.setText(rs.getString("name"));
                jgen.setText(rs.getString("gender"));
                jcoun.setText(rs.getString("country"));
                jemail.setText(rs.getString("email"));
                jnum.setText(rs.getString("address"));
                jadrs.setText(rs.getString("ph_number"));
            }




        }catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==del){
            try {
                Connect con=new Connect();
                con.s.executeUpdate("delete from signupinfo where username='"+username+"'");
                con.s.executeUpdate("delete from cusdetails where username='"+username+"'");
                con.s.executeUpdate("delete from bookpkg where username='"+username+"'");
                con.s.executeUpdate("delete from booktour where username='"+username+"'");

                JOptionPane.showMessageDialog(null,"Details Deleted Successfully");
                setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==back) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Deletedetails("gillani_05");
    }
}
