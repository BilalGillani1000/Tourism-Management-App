import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener {
    JButton create,back;
    JTextField tname,tnam,tpass,tans;
    Choice list;
    Signup(){
        setBounds(240,120,900,450);
      //  setBackground(Color.GRAY);
        setLayout(null);

        JPanel p1=new JPanel();
        p1.setBounds(0,0,350,450);
        p1.setLayout(null);
        add(p1);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/signup.jpg"));
        Image img1=img.getImage().getScaledInstance(350,450,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(img1);
        JLabel img3=new JLabel(img2);
        img3.setBounds(0,0,350,450);
        p1.add(img3);

        JPanel p2=new JPanel();
        p2.setBounds(350,0,550,450);
        p2.setBackground(new Color(70,130,180));
        p2.setLayout(null);
        add(p2);

        JLabel fname=new JLabel("Full Name");
        fname.setFont(new Font("Monospaced",Font.PLAIN,16));
        fname.setBounds(30,20,100,25);
        p2.add(fname);

        tname=new JTextField();
        tname.setFont(new Font("Monospaced",Font.BOLD,16));
        tname.setBounds(140,20,150,25);
        tname.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tname);

        JLabel uname=new JLabel("Username");
        uname.setFont(new Font("Monospaced",Font.PLAIN,16));
        uname.setBounds(30,65,100,25);
        p2.add(uname);

        tnam=new JTextField();
        tnam.setFont(new Font("Monospaced",Font.BOLD,16));
        tnam.setBounds(140,65,150,25);
        tnam.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tnam);

        JLabel pass=new JLabel("Password");
        pass.setFont(new Font("Monospaced",Font.PLAIN,16));
        pass.setBounds(30,110,100,25);
        p2.add(pass);

        tpass=new JTextField();
        tpass.setFont(new Font("Monospaced",Font.BOLD,16));
        tpass.setBounds(140,110,150,25);
        tpass.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tpass);

        JLabel sec=new JLabel("Add Security");
        sec.setFont(new Font("Monospaced",Font.PLAIN,16));
        sec.setBounds(30,155,120,25);
        p2.add(sec);

        JLabel q=new JLabel("Question");
        q.setFont(new Font("Monospaced",Font.PLAIN,16));
        q.setBounds(45,180,90,25);
        p2.add(q);

        list=new Choice();
        list.setFont(new Font("Monospaced",Font.BOLD,14));
        list.add("Your favourite sports?");
        list.add("Your lucky number?");
        list.add("Your favourite food?");
        list.add(" Your favourite movie?");
        list.setBounds(160,165,200,25);
        p2.add(list);

        JLabel ans=new JLabel("Answer");
        ans.setFont(new Font("Monospaced",Font.PLAIN,16));
        ans.setBounds(30,225,100,25);
        p2.add(ans);

        tans=new JTextField();
        tans.setFont(new Font("Monospaced",Font.BOLD,16));
        tans.setBounds(140,225,150,25);
        tans.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tans);

        create=new JButton("Create Account");
        create.setFont(new Font("Monospaced",Font.BOLD,16));
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setBounds(100,290,180,30);
        create.addActionListener(this);
        p2.add(create);

        back=new JButton("Back");
        back.setFont(new Font("Monospaced",Font.BOLD,16));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300,290,100,30);
        back.addActionListener(this);
        p2.add(back);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==create){
            String fullname=tname.getText();
            String username=tnam.getText();
            String answer=tans.getText();
            String password=tpass.getText();
            String security=list.getSelectedItem();

            String query="insert into signupinfo values('"+fullname+"','"+username+"','"+password+"','"+security+"','"+answer+"')";
            try {
                Connect con=new Connect();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Your Account Is Created Successfully\nNow Login Your Account");
                setVisible(false);
                new Login();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if (ae.getSource()==back) {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new Signup();
    }
}
