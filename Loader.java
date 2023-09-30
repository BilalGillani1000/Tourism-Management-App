import javax.swing.*;
import java.awt.*;
public class Loader extends JFrame implements Runnable{
    String username;
    Thread t;
    JProgressBar load;

    public void run(){
        try {
            for (int i=1;i<=101;i++){
                int max=load.getMaximum();
                int cvalue= load.getValue();
                if (cvalue < max){

                    load.setValue(load.getValue() + 1);
                }
                else {
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    Loader(String username){
        this.username=username;

        t=new Thread(this);
        setBounds(240,120,900,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading=new JLabel("GILLANI TOURISM");
        heading.setFont(new Font("Monospaced",Font.BOLD,30));
        heading.setBounds(280,20,400,30);

        add(heading);

        load=new JProgressBar();
        load.setBounds(200,70,500,30);
        load.setStringPainted(true);
        add(load);

        JLabel loading=new JLabel("Loading...Please Wait");
        loading.setForeground(Color.RED);
        loading.setBounds(350,110,250,30);
        loading.setFont(new Font("Monospaced",Font.BOLD,18));
        add(loading);

        JLabel greet=new JLabel("Welcome "+username);
        greet.setFont(new Font("Monospaced",Font.BOLD,20));
        greet.setBounds(20,350,300,30);
        add(greet);
        t.start();

        setVisible(true);

    }

    public static void main(String[] args) {
        new Loader("");
    }
}
