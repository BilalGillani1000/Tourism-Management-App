import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Bookedpkg extends JFrame implements ActionListener {
    JButton back;

    Bookedpkg(String username){
        setBounds(240,120,900,450);
        getContentPane().setBackground(new Color(70,130,180));
        setLayout(null);

        JLabel heading=new JLabel("Booked Package Details");
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

        JLabel id=new JLabel("Identity");
        id.setBounds(30,75,150,25);
        id.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(id);

        JLabel jid=new JLabel();
        jid.setBounds(190,75,150,25);
        jid.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jid);

        JLabel idnum=new JLabel("ID_Number");
        idnum.setBounds(30,110,150,25);
        idnum.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(idnum);

        JLabel jidnum=new JLabel();
        jidnum.setBounds(190,110,150,25);
        jidnum.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jidnum);

        JLabel ph=new JLabel("Phone");
        ph.setBounds(30,145,150,25);
        ph.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(ph);

        JLabel jph=new JLabel();
        jph.setBounds(190,145,150,25);
        jph.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jph);

        JLabel pac=new JLabel("Package");
        pac.setBounds(30,180,150,25);
        pac.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(pac);

        JLabel jpac=new JLabel();
        jpac.setBounds(190,180,150,25);
        jpac.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jpac);

        JLabel tper=new JLabel("Total Persons");
        tper.setBounds(30,215,150,25);
        tper.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(tper);

        JLabel jtper=new JLabel();
        jtper.setBounds(190,215,150,25);
        jtper.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jtper);

        JLabel tpri=new JLabel("Total Price");
        tpri.setBounds(30,250,150,25);
        tpri.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(tpri);

        JLabel jtpri=new JLabel();
        jtpri.setBounds(190,250,150,25);
        jtpri.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jtpri);


        back=new JButton("Back");
        back.setFont(new Font("Monospaced",Font.BOLD,16));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(370,360,100,25);
        back.addActionListener(this);
        add(back);


        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/bookedpkg.jpg"));
        Image img1=img.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(img1);
        JLabel img3=new JLabel(img2);
        img3.setBounds(350,40,500,300);
        add(img3);

        try {
            Connect con=new Connect();
            ResultSet rs=con.s.executeQuery("select * from bookpkg where Username='"+username+"'");
            while (rs.next()){
                juname.setText(rs.getString("username"));
                jid.setText(rs.getString("identity"));
                jidnum.setText(rs.getString("id_num"));
                jph.setText(rs.getString("phone"));
                jpac.setText(rs.getString("package"));
                jtper.setText(rs.getString("persons"));
                jtpri.setText(rs.getString("price"));

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
        new Bookedpkg("gillani_05");
    }
}
