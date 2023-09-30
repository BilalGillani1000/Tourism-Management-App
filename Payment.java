import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment extends JFrame implements ActionListener {
    JButton back,pay;
    Payment(){
        setBounds(240,120,900,450);
        setLayout(null);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/pay.jpeg"));
        Image img1=img.getImage().getScaledInstance(900,450,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(img1);
        JLabel img3=new JLabel(img2);
        img3.setBounds(0,0,900,450);
        add(img3);

        pay=new JButton("PAY");
        pay.setFont(new Font("Monospaced",Font.BOLD,16));
        pay.setBounds(100,350,100,30);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        img3.add(pay);

        back=new JButton("BACK");
        back.setFont(new Font("Monospaced",Font.BOLD,16));
        back.setBounds(700,350,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        img3.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==pay){
            setVisible(false);
            new Paytm();
        }
        else
            setVisible(false);
    }

    public static void main(String[] args) {
        new Payment();
    }
}
