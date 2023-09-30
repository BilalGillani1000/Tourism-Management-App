import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton apd,vpd,upd,cp,bp,vp,vv,vm,vhp,bt,vbt,py,cal,about,dpd;
    Dashboard(String username){
        this.username=username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(70,130,180));
        p1.setBounds(0,0,1370,50);
        add(p1);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/topicon.png"));
        Image img1=img.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(img1);
        JLabel img3=new JLabel(img2);
        img3.setBounds(2,0,70,50);
        p1.add(img3);

        JLabel top=new JLabel("Dashboard");
        top.setFont(new Font("Monospaced",Font.BOLD,25));
        top.setBounds(100,10,250,30);
        p1.add(top);

        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(70,130,180));
        p2.setBounds(0,50,320,680);
        add(p2);

       apd=new JButton("Add Personal Details");
        apd.setBounds(0,0,320,40);
        apd.setFont(new Font("Monospaced",Font.BOLD,20));
        apd.setForeground(Color.WHITE);
        apd.setBackground(Color.BLACK);
        apd.addActionListener(this);
        p2.add(apd);

        upd=new JButton("Update Personal Details");
        upd.setBounds(0,44,320,40);
        upd.setFont(new Font("Monospaced",Font.BOLD,20));
        upd.setForeground(Color.WHITE);
        upd.setBackground(Color.BLACK);
        upd.addActionListener(this);
        p2.add(upd);

        vpd=new JButton("View Your Details");
        vpd.setBounds(0,88,320,40);
        vpd.setFont(new Font("Monospaced",Font.BOLD,20));
        vpd.setForeground(Color.WHITE);
        vpd.setBackground(Color.BLACK);
        vpd.addActionListener(this);
        p2.add(vpd);

        dpd=new JButton("Delete Personal Details");
        dpd.setBounds(0,132,320,40);
        dpd.setFont(new Font("Monospaced",Font.BOLD,20));
        dpd.setForeground(Color.WHITE);
        dpd.setBackground(Color.BLACK);
        dpd.addActionListener(this);
        p2.add(dpd);

        cp=new JButton("Check Packages");
        cp.setBounds(0,176,320,40);
        cp.setFont(new Font("Monospaced",Font.BOLD,20));
        cp.setForeground(Color.WHITE);
        cp.setBackground(Color.BLACK);
        cp.addActionListener(this);
        p2.add(cp);

        bp=new JButton("Book Your Package");
        bp.setBounds(0,220,320,40);
        bp.setFont(new Font("Monospaced",Font.BOLD,20));
        bp.setForeground(Color.WHITE);
        bp.setBackground(Color.BLACK);
        bp.addActionListener(this);
        p2.add(bp);

        vp=new JButton("View Booked Package");
        vp.setBounds(0,264,320,40);
        vp.setFont(new Font("Monospaced",Font.BOLD,20));
        vp.setForeground(Color.WHITE);
        vp.setBackground(Color.BLACK);
        vp.addActionListener(this);
        p2.add(vp);

        vv=new JButton("View Valleys");
        vv.setBounds(0,308,320,40);
        vv.setFont(new Font("Monospaced",Font.BOLD,20));
        vv.setForeground(Color.WHITE);
        vv.setBackground(Color.BLACK);
        vv.addActionListener(this);
        p2.add(vv);

        vm=new JButton("View Monuments");
        vm.setBounds(0,352,320,40);
        vm.setFont(new Font("Monospaced",Font.BOLD,20));
        vm.setForeground(Color.WHITE);
        vm.setBackground(Color.BLACK);
        vm.addActionListener(this);
        p2.add(vm);

        vhp=new JButton("View Hist.Places");
        vhp.setBounds(0,396,320,40);
        vhp.setFont(new Font("Monospaced",Font.BOLD,20));
        vhp.setForeground(Color.WHITE);
        vhp.setBackground(Color.BLACK);
        vhp.addActionListener(this);
        p2.add(vhp);

        bt=new JButton("Book Your Tour");
        bt.setBounds(0,440,320,40);
        bt.setFont(new Font("Monospaced",Font.BOLD,20));
        bt.setForeground(Color.WHITE);
        bt.setBackground(Color.BLACK);
        bt.addActionListener(this);
        p2.add(bt);

        vbt=new JButton(" View Booked Tour");
        vbt.setBounds(0,484,320,40);
        vbt.setFont(new Font("Monospaced",Font.BOLD,20));
        vbt.setForeground(Color.WHITE);
        vbt.setBackground(Color.BLACK);
        vbt.addActionListener(this);
        p2.add(vbt);

        py=new JButton("Payment");
        py.setBounds(0,528,320,40);
        py.setFont(new Font("Monospaced",Font.BOLD,20));
        py.setForeground(Color.WHITE);
        py.setBackground(Color.BLACK);
        py.addActionListener(this);
        p2.add(py);

        cal=new JButton("Calculator");
        cal.setBounds(0,572,320,40);
        cal.setFont(new Font("Monospaced",Font.BOLD,20));
        cal.setForeground(Color.WHITE);
        cal.setBackground(Color.BLACK);
        cal.addActionListener(this);
        p2.add(cal);

        about=new JButton("About");
        about.setBounds(0,616,320,40);
        about.setFont(new Font("Monospaced",Font.BOLD,20));
        about.setForeground(Color.WHITE);
        about.setBackground(Color.BLACK);
        about.addActionListener(this);
        p2.add(about);

        JPanel p3=new JPanel();
        p3.setLayout(null);
        p3.setBounds(320,50,1080,680);
        add(p3);

        ImageIcon img4=new ImageIcon(ClassLoader.getSystemResource("icons/dash.jpg"));
        Image img5=img4.getImage().getScaledInstance(1080,680,Image.SCALE_DEFAULT);
        ImageIcon img6=new ImageIcon(img5);
        JLabel img7=new JLabel(img6);
        img7.setBounds(0,0,1080,680);
        p3.add(img7);

        JLabel text=new JLabel("Gillani Tourism and Travels");
        text.setBounds(300,50,500,40);
        text.setForeground(Color.DARK_GRAY);
        text.setFont(new Font("Monospaced",Font.BOLD,30));
        img7.add(text);

        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==apd){
            new Adddetails(username);
        } else if (ae.getSource()==vpd) {
            new Viewdetails(username);
        } else if (ae.getSource()==upd) {
            new Updetails(username);
        } else if (ae.getSource()==cp) {
            new CheckPackage();
        } else if (ae.getSource()==bp) {
            new Bookpkg(username);
        } else if (ae.getSource()==vp) {
            new Bookedpkg(username);
        }else if (ae.getSource()==vv) {
            new Viewvalleys();
        }else if (ae.getSource()==vm) {
            new Viewmonuments();
        }else if (ae.getSource()==vhp) {
            new Viewhistplaces();
        } else if (ae.getSource()==bt) {

            new Booktour(username);
        } else if (ae.
                getSource()==vbt) {
            new Bookedtour(username);
        } else if (ae.getSource()==py) {
            new Payment();
        } else if (ae.getSource()==cal) {
            try {
                Runtime.getRuntime().exec("calc.exe");

            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==about) {
            new About();
        } else if (ae.getSource()==dpd) {
          new Deletedetails(username);
        }
    }
    public static void main(String[] args)
    {
        new Dashboard("username");
    }
}
