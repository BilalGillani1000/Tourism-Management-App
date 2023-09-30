import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Booktour extends JFrame implements ActionListener {

    JComboBox <String> drop1,drop2;
    String [] place={"Select Place","Valleys","Monuments","Historical Places"};
    String [] valley={"Murree","Skardu","Nagar","Swat","Chitral","Hunza","Naran","Kaghan","Nelum","Gilgit"};
    String [] monument={"Grand Jamia Masjid","Tomb Shah R.Alam","Teen Talwar","Baab-e-Khyber","Minar-e-Pakistan","Tomb of Jahanghir","Faisal Masjid","Badshahi Masjid","Ziarat Residency","Pakistan Monument"};
    String [] historical={"Baltit Fort","Derawar Fort","Lahore Fort","Rohtas Fort","Shigar Fort","Ranikot Fort","Rawat Fort","Harappa","Mohenjodaro","Taxila"};

    JLabel juname,jid,jidnum,jtp,jph;
    JButton chkpri,conbook,back;
    JTextField nper;
    String username;
    Booktour(String username){
        this.username=username;
        setBounds(240,120,900,450);
        setLayout(null);
        getContentPane().setBackground(new Color(70,130,180));

        JLabel l1=new JLabel("BOOK TOUR");
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

        JLabel sp=new JLabel("Select Tourist Place");
        sp.setBounds(30,85,200,25);
        sp.setFont(new Font("Monospaced",Font.PLAIN,16));
        add(sp);



        drop1=new JComboBox<>(place);
        drop1.setFont(new Font("Monospaced",Font.BOLD,14));
        drop1.setBounds(250,85,150,30);
        drop1.addActionListener(this);
        add(drop1);

        drop2=new JComboBox<>();
        drop2.setFont(new Font("Monospaced",Font.BOLD,14));
        drop2.setBounds(250,125,180,30);
        add(drop2);




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

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/booktour.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,350,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel i4=new JLabel(i3);
        i4.setBounds(450,50,400,250);
        add(i4);


        try {
            Connect con=new Connect();
            ResultSet rs=con.s.executeQuery("select * from cusdetails where Username='"+username+"'");
            while (rs.next()){
                juname.setText(rs.getString("username"));
                jid.setText(rs.getString("identity"));
                jidnum.setText(rs.getString("id_num"));

                jph.setText(rs.getString("ph_number"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        conbook=new JButton("Confirm Booking");
        conbook.setFont(new Font("Monospaced",Font.BOLD,16));
        conbook.setBackground(Color.BLACK);
        conbook.setForeground(Color.WHITE);
        conbook.setBounds(250,320,200,25);
        conbook.addActionListener(this);
        add(conbook);

        back=new JButton("Back");
        back.setFont(new Font("Monospaced",Font.BOLD,16));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(520,320,100,25);
        back.addActionListener(this);
        add(back);


        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==conbook) {
            try {
                Connect con=new Connect();
                con.s.executeUpdate("insert into booktour values('"+juname.getText()+"','"+drop2.getSelectedItem()+"','"+jid.getText()+"','"+jidnum.getText()+"','"+jph.getText()+"')");
                JOptionPane.showMessageDialog(null,"Tour Booked Successfully");
            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource()==back) {
            setVisible(false);
        }

        if (ae.getSource()==drop1){
            String select=(String) drop1.getSelectedItem();
            if (select.equals("Valleys")){
                updatedrop2(valley);
            } else if (select.equals("Monuments")) {
                updatedrop2(monument);
            } else if (select.equals("Historical Places")) {
                updatedrop2(historical);
            }else {
                drop2.removeAllItems();
            }
        }

    }
    public void updatedrop2(String [] items){
        drop2.removeAllItems();
        for (String item: items){
            drop2.addItem(item);
        }
    }





    public static void main(String[] args) {
        new Booktour("gillani_05");
    }
}
