import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Bookpkg extends JFrame implements ActionListener {

    JLabel juname,jid,jidnum,jtp,jph;
    JButton chkpri,conbook,back;
    Choice spkg;
    JTextField nper;
    String username;
    Bookpkg(String username){
        this.username=username;
        setBounds(240,120,900,450);
        setLayout(null);
        getContentPane().setBackground(new Color(70,130,180));

        JLabel l1=new JLabel("BOOK PACKAGE");
        l1.setFont(new Font("Monospaced",Font.BOLD,22));
        l1.setBounds(350,10,300,25);
        l1.setForeground(Color.BLACK);
        add(l1);

        JLabel uname=new JLabel("Username");
        uname.setBounds(30,50,150,25);
        uname.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(uname);

        juname=new JLabel();
        juname.setBounds(190,50,150,25);
        juname.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(juname);

        JLabel sp=new JLabel("Select Package");
        sp.setBounds(30,85,150,25);
        sp.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(sp);

        spkg=new Choice();
        spkg.setFont(new Font("Monospaced",Font.BOLD,14));
        spkg.add("Diamond Package");
        spkg.add("Gold Package");
        spkg.add("Silver Package");
        spkg.setBounds(200,85,200,30);
        add(spkg);


        JLabel tper=new JLabel("Total Persons");
        tper.setBounds(30,120,150,25);
        tper.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(tper);

        nper=new JTextField(1);
        nper.setFont(new Font("Monospaced",Font.BOLD,16));
        nper.setBounds(200,120,200,25);
        nper.setBorder(BorderFactory.createEmptyBorder());
        add(nper);

        JLabel id=new JLabel("Identity");
        id.setBounds(30,155,150,25);
        id.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(id);

        jid=new JLabel();
        jid.setBounds(200,155,150,25);
        jid.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jid);

        JLabel idnum=new JLabel("ID_Num");
        idnum.setBounds(30,190,150,25);
        idnum.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(idnum);

        jidnum=new JLabel();
        jidnum.setBounds(200,190,150,25);
        jidnum.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jidnum);

        JLabel ph=new JLabel("Phone");
        ph.setBounds(30,225,150,25);
        ph.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(ph);

        jph=new JLabel();
        jph.setBounds(200,225,150,25);
        jph.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jph);

        JLabel tp=new JLabel("Total Price");
        tp.setBounds(30,260,150,25);
        tp.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(tp);

        jtp=new JLabel();
        jtp.setBounds(200,260,150,25);
        jtp.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(jtp);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookpkg.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel i4=new JLabel(i3);
        i4.setBounds(450,50,400,250);
        add(i4);

        try {
            Connect con=new Connect();
            ResultSet rs=con.s.executeQuery("select * from cusdetails where username='"+username+"'");
            while (rs.next()){
                juname.setText(rs.getString("username"));
                jid.setText(rs.getString("identity"));
                jidnum.setText(rs.getString("id_num"));
                jph.setText(rs.getString("ph_number"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        chkpri=new JButton("Check Price");
        chkpri.setFont(new Font("Monospaced",Font.BOLD,16));
        chkpri.setBackground(Color.BLACK);
        chkpri.setForeground(Color.WHITE);
        chkpri.setBounds(80,320,150,25);
        chkpri.addActionListener(this);
        add(chkpri);

        conbook=new JButton("Confirm Booking");
        conbook.setFont(new Font("Monospaced",Font.BOLD,16));
        conbook.setBackground(Color.BLACK);
        conbook.setForeground(Color.WHITE);
        conbook.setBounds(300,320,200,25);
        conbook.addActionListener(this);
        add(conbook);

        back=new JButton("Back");
        back.setFont(new Font("Monospaced",Font.BOLD,16));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(570,320,100,25);
        back.addActionListener(this);
        add(back);


        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==chkpri){
            String pack=spkg.getSelectedItem();
            int cost=0;
            if (pack.equals("Diamond Package")){
                cost=30000;
            } else if (pack.equals("Gold Package")) {
                cost=22000;
            } else if (pack.equals("Silver Package")) {

            }
            int persons=Integer.parseInt(nper.getText());
            cost*=persons;
            jtp.setText("Rs"+cost);


        } else if (ae.getSource()==conbook) {
            try {
                Connect con=new Connect();
                con.s.executeUpdate("insert into bookpkg values('"+juname.getText()+"','"+spkg.getSelectedItem()+"','"+nper.getText()+"','"+jid.getText()+"','"+jidnum.getText()+"','"+jph.getText()+"','"+jtp.getText()+"')");
                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
            }catch (Exception e){
                e.printStackTrace();
            }

        }else
            setVisible(false);
    }
    public static void main(String[] args) {
        new Bookpkg("gillani_05");
    }
}
