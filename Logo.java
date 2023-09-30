import javax.swing.*;
import java.awt.*;

public class Logo extends JFrame implements Runnable{
    Thread thread;
    Logo(){

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image img2=img.getImage().getScaledInstance(900,450,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel img1=new JLabel(img3);
        add(img1);
        setVisible(true);
        thread=new Thread(this);
        thread.start();
    }

    public void run(){
        try {
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        } catch (Exception e){}
    }



    public static void main(String[] args) {
        Logo var=new Logo();
        int j=1;
        for (int i=1;i<=450;j+=4,i+=4){
            var.setSize(j+i,i);
            var.setLocation(650-(j+i)/2,350-(j/2));
            try {
                Thread.sleep(10);
            } catch (Exception e) {}
        }
    }
}
