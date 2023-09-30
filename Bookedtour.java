import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Bookedtour extends JFrame implements ActionListener {
    JButton back;

    Bookedtour(String username){
        setBounds(240,120,900,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading=new JLabel("Booked Tour Details");
        heading.setFont(new Font("Monospaced",Font.BOLD,22));
        heading.setBounds(300,0,400,25);
        add(heading);


        JLabel uname=new JLabel("Username");
        uname.setBounds(30,40,150,25);
        uname.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(uname);

        JLabel juname=new JLabel();
        juname.setBounds(190,40,150,25);
        juname.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(juname);

        JLabel tourp=new JLabel("Tourist Place");
        tourp.setBounds(30,75,150,25);
        tourp.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(tourp);

        JLabel jtourp=new JLabel();
        jtourp.setBounds(190,75,150,25);
        jtourp.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jtourp);

        JLabel pac=new JLabel("Package");
        pac.setBounds(30,110,150,25);
        pac.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(pac);

        JLabel jpac=new JLabel();
        jpac.setBounds(190,110,150,25);
        jpac.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jpac);

        JLabel tper=new JLabel("Total Persons");
        tper.setBounds(30,145,150,25);
        tper.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(tper);

        JLabel jtper=new JLabel();
        jtper.setBounds(190,145,150,25);
        jtper.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jtper);

        JLabel tcos=new JLabel("Total Cost");
        tcos.setBounds(30,180,150,25);
        tcos.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(tcos);

        JLabel jtcos=new JLabel();
        jtcos.setBounds(190,180,150,25);
        jtcos.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jtcos);

        JLabel id=new JLabel("Identity");
        id.setBounds(30,215,150,25);
        id.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(id);

        JLabel jid=new JLabel();
        jid.setBounds(190,215,150,25);
        jid.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jid);

        JLabel idnum=new JLabel("ID_Number");
        idnum.setBounds(30,250,150,25);
        idnum.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(idnum);

        JLabel jidnum=new JLabel();
        jidnum.setBounds(190,250,150,25);
        jidnum.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jidnum);

        JLabel ph=new JLabel("Phone");
        ph.setBounds(30,285,150,25);
        ph.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(ph);

        JLabel jph=new JLabel();
        jph.setBounds(190,285,150,25);
        jph.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jph);


        back=new JButton("Back");
        back.setFont(new Font("Monospaced",Font.BOLD,16));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(370,360,100,25);
        back.addActionListener(this);
        add(back);


        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/bookedtour.jpg"));
        Image img1=img.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(img1);
        JLabel img3=new JLabel(img2);
        img3.setBounds(350,40,500,300);
        add(img3);

        try {
            Connect con=new Connect();
            ResultSet rs=con.s.executeQuery("select * from bookpkg where username='"+username+"'");
            while (rs.next()){
                juname.setText(rs.getString("username"));
                jid.setText(rs.getString("identity"));
                jidnum.setText(rs.getString("id_num"));
                jph.setText(rs.getString("phone"));
                jpac.setText(rs.getString("package"));
                jtper.setText(rs.getString("persons"));
                jtcos.setText(rs.getString("price"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            Connect con=new Connect();
            ResultSet rs=con.s.executeQuery("select * from booktour where username='"+username+"'");
            while (rs.next()){
                jtourp.setText(rs.getString("touristplace"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args) {
        new Bookedtour("gillani_05");
    }
}
