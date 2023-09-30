import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
  JButton fpass,sign,login;
  JTextField tname,tpass;

    Login(){
      setSize(900,450);
      setLocation(240,120);
      setLayout(null);

      JPanel p1=new JPanel();

      p1.setBounds(0,0,400,450);
      p1.setLayout(null);
      add(p1);

      ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
      Image img1=img.getImage().getScaledInstance(400,450,Image.SCALE_DEFAULT);
      ImageIcon img2=new ImageIcon(img1);
      JLabel img3=new JLabel(img2);
      img3.setBounds(0,0,400,450);
      p1.add(img3);

      JPanel p2=new JPanel();
      p2.setBackground(new Color(70,130,180));
      p2.setLayout(null);
      p2.setBounds(400,0,500,450);
      add(p2);

      JLabel uname=new JLabel("Username");
      uname.setFont(new Font("Monospaced",Font.BOLD,20));
      uname.setBounds(50,20,100,30);
      p2.add(uname);

      tname=new JTextField();
      tname.setBounds(120,60,200,30);
      tname.setBorder(BorderFactory.createEmptyBorder());
      p2.add(tname);

        JLabel upass=new JLabel("Password");
        upass.setFont(new Font("Monospaced",Font.BOLD,20));
        upass.setBounds(50,100,100,30);
        p2.add(upass);

        tpass=new JTextField();
        tpass.setBounds(120,140,200,30);
        tpass.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tpass);

        login=new JButton("LOGIN");
        login.setFont(new Font("Monospaced",Font.BOLD,16));
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLACK);
        login.setBounds(100,210,100,30);
        login.addActionListener(this);
        p2.add(login);

        JLabel or=new JLabel("OR");
        or.setFont(new Font("Monospaced",Font.BOLD,16));
        or.setForeground(Color.BLACK);
        or.setBounds(210,215,20,20);
        p2.add(or);

        sign=new JButton("SIGN UP");
        sign.setFont(new Font("Monospaced",Font.BOLD,16));
        sign.setForeground(Color.WHITE);
        sign.setBackground(Color.BLACK);
        sign.setBounds(240,210,110,30);
        sign.addActionListener(this);
        p2.add(sign);

        fpass=new JButton("FORGET PASSWORD?");
        fpass.setFont(new Font("Monospaced",Font.BOLD,16));
        fpass.setForeground(Color.WHITE);
        fpass.setBackground(Color.BLACK);
        fpass.setBounds(110,260,220,30);
        fpass.addActionListener(this);
        p2.add(fpass);


      setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
      if (ae.getSource() == login){
        try {
          String username=tname.getText();
          String password=tpass.getText();

          String query="select * from signupinfo where Username='"+username+"' AND Password='"+password+"'";
          Connect con=new Connect();
          ResultSet rs=con.s.executeQuery(query);
          if (rs.next()){
            setVisible(false);
            new Loader(username);
          }else{
            JOptionPane.showMessageDialog(null,"Incorrect Password or Username");
          }
        }catch (Exception e){
          e.printStackTrace();
        }

      } else if (ae.getSource() == sign) {
        setVisible(false);
        new Signup();
      } else if (ae.getSource() == fpass) {
        setVisible(false);
        new Forgotpass();
      }
    }

    public static void main(String[] args) {

      new Login();
    }
}
