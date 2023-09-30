import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {
    CheckPackage(){
        setBounds(240,120,900,450);

        String [] pkg1={"Diamond Package","6 Days & 7 Nights","Daily Breakfast","Daily Lunch","Daily Dinner","English Speaking Guide","Free Boating","Book Now","Summer Special Deal","Rs.30000","pkg1.jpg"};
        String [] pkg2={"Gold Package","4 Days & 5 Nights","Daily Breakfast","Daily Lunch","Daily Dinner","English Speaking Guide","Free Movie Show","Book Now","Summer Special Deal","Rs.22000","pkg2.jpeg"};
        String [] pkg3={"Silver Package","2 Days & 3 Nights","Daily Breakfast","Daily Lunch","Daily Dinner","English Speaking Guide","Free Snacks","Book Now","Summer Special Deal","Rs.15000","pkg3.jpg"};

        JTabbedPane tab=new JTabbedPane();
        JPanel p1=createpackage(pkg1);
        tab.addTab("Package 1",null,p1);

        JPanel p2=createpackage(pkg2);
        tab.addTab("Package 2",null,p2);

        JPanel p3=createpackage(pkg3);
        tab.addTab("Package 3",null,p3);

        add(tab);

        setVisible(true);

    }
    public JPanel createpackage(String [] pkg){
        JPanel p1=new JPanel();
        p1.setBackground(new Color(70,130,180));
        p1.setLayout(null);

        JLabel l1=new JLabel(pkg[0]);
        l1.setFont(new Font("Monospaced",Font.BOLD,25));
        l1.setBounds(350,10,300,25);
        l1.setForeground(Color.BLACK);
        p1.add(l1);

        JLabel l2=new JLabel(pkg[1]);
        l2.setFont(new Font("Monospaced",Font.BOLD,20));
        l2.setBounds(30,55,300,25);
        l2.setForeground(Color.WHITE);
        p1.add(l2);


        JLabel l3=new JLabel(pkg[2]);
        l3.setFont(new Font("Monospaced",Font.BOLD,20));
        l3.setBounds(30,90,200,25);
        l3.setForeground(Color.WHITE);
        p1.add(l3);


        JLabel l4=new JLabel(pkg[3]);
        l4.setFont(new Font("Monospaced",Font.BOLD,20));
        l4.setBounds(30,125,200,25);
        l4.setForeground(Color.WHITE);
        p1.add(l4);


        JLabel l5=new JLabel(pkg[4]);
        l5.setFont(new Font("Monospaced",Font.BOLD,20));
        l5.setBounds(30,160,200,25);
        l5.setForeground(Color.WHITE);
        p1.add(l5);


        JLabel l6=new JLabel(pkg[5]);
        l6.setFont(new Font("Monospaced",Font.BOLD,20));
        l6.setBounds(30,195,300,25);
        l6.setForeground(Color.WHITE);
        p1.add(l6);


        JLabel l7=new JLabel(pkg[6]);
        l7.setFont(new Font("Monospaced",Font.BOLD,20));
        l7.setBounds(30,230,200,25);
        l7.setForeground(Color.WHITE);
        p1.add(l7);

        JLabel l8=new JLabel(pkg[7]);
        l8.setFont(new Font("Monospaced",Font.BOLD,20));
        l8.setBounds(150,265,200,25);
        l8.setForeground(Color.RED);
        p1.add(l8);

        JLabel l9=new JLabel(pkg[8]);
        l9.setFont(new Font("Monospaced",Font.BOLD,20));
        l9.setBounds(30,310,300,25);
        l9.setForeground(Color.BLACK);
        p1.add(l9);

        JLabel l10=new JLabel(pkg[9]);
        l10.setFont(new Font("Monospaced",Font.BOLD,20));
        l10.setBounds(280,310,200,25);
        l10.setForeground(Color.BLACK);
        p1.add(l10);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/"+pkg[10]));
        Image img1=img.getImage().getScaledInstance(550,300,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(img1);
        JLabel img3=new JLabel(img2);
        img3.setBounds(350,50,500,230);
        p1.add(img3);

        return p1;
    }
    public static void main(String[] args) {
        new CheckPackage();
    }
}
