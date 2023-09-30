import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Forgotpass extends JFrame implements ActionListener {
    JTextField tnam,tname,tsec,tans,tpass;
    JButton search,retrieve,back;
    Forgotpass(){
        setBounds(240,120,900,450);
        getContentPane().setBackground(new Color(70,130,180));
        setLayout(null);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/forpass.png"));
        Image img1= img.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(img1);
        JLabel img3=new JLabel(img2);
        img3.setBounds(635,100,200,200);
        add(img3);

        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,550,350);
        add(p1);

        JLabel uname=new JLabel("Username");
        uname.setFont(new Font("Monospaced",Font.PLAIN,16));
        uname.setBounds(30,20,100,25);
        p1.add(uname);

        tnam=new JTextField();
        tnam.setFont(new Font("Monospaced",Font.BOLD,16));
        tnam.setBounds(140,20,150,25);
        tnam.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tnam);

        search=new JButton("Search");
        search.setFont(new Font("Monospaced",Font.BOLD,16));
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setBounds(310,20,150,25);
        search.addActionListener(this);
        p1.add(search);


        JLabel name=new JLabel("Name");
        name.setFont(new Font("Monospaced",Font.PLAIN,16));
        name.setBounds(30,60,100,25);
        p1.add(name);

        tname=new JTextField();
        tname.setFont(new Font("Monospaced",Font.BOLD,16));
        tname.setBounds(140,60,150,25);
        tname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tname);

        JLabel sec=new JLabel("Security  Question");
        sec.setFont(new Font("Monospaced",Font.PLAIN,16));
        sec.setBounds(30,100,180,25);
        p1.add(sec);

        tsec=new JTextField();
        tsec.setFont(new Font("Monospaced",Font.BOLD,16));
        tsec.setBounds(220,100,180,25);
        tsec.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tsec);

        JLabel ans=new JLabel("Answer");
        ans.setFont(new Font("Monospaced",Font.PLAIN,16));
        ans.setBounds(30,140,100,25);
        p1.add(ans);


        tans=new JTextField();
        tans.setFont(new Font("Monospaced",Font.BOLD,16));
        tans.setBounds(140,140,150,25);
        tans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tans);

        retrieve=new JButton("Retrieve Pass");
        retrieve.setFont(new Font("Monospaced",Font.BOLD,16));
        retrieve.setBackground(Color.BLACK);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(310,140,180,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel pass=new JLabel("Password");
        pass.setFont(new Font("Monospaced",Font.PLAIN,16));
        pass.setBounds(30,180,100,25);
        p1.add(pass);


        tpass=new JTextField();
        tpass.setFont(new Font("Monospaced",Font.BOLD,16));
        tpass.setBounds(140,180,150,25);
        tpass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tpass);

        back=new JButton("Back");
        back.setFont(new Font("Monospaced",Font.BOLD,16));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,240,150,30);
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);

        }
        public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==search){
            try {
                String query="select * from signupinfo where username='"+tnam.getText()+"'";
                Connect con=new Connect();
                ResultSet rs=con.s.executeQuery(query);
                while(rs.next()){

                    tname.setText(rs.getString("fullname"));
                    tsec.setText(rs.getString("security"));
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource()==retrieve) {
            try {
                String query="select * from signupinfo where username='"+tnam.getText()+"' AND answer='"+tans.getText()+"'";
                Connect con=new Connect();
                ResultSet rs=con.s.executeQuery(query);
                while(rs.next()){
                    tpass.setText(rs.getString("password"));
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==back) {
            setVisible(false);
            new Login();

        }

        }
    public static void main(String[] args) {
        new Forgotpass();
    }
}
