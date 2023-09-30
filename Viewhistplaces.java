import javax.swing.*;
import java.awt.*;

public class Viewhistplaces extends JFrame implements Runnable{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JLabel [] label=new JLabel [] {l1,l2,l3,l4,l5,l6,l7,l8,l9,l10};
    Thread thread;
    JLabel caption;

    public void run(){
        String [] text=new String[]{"Baltit Fort","Derawar Fort","Lahore Fort","Rohtas Fort","Shigar Fort","Ranikot Fort","Rawat Fort","Harappa","Mohenjodaro","Taxila"};
        try {
            for (int i=0;i<=9;i++){
                label[i].setVisible(true);
                caption.setText(text[i]);
                Thread.sleep(3000);
                label[i].setVisible(false);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    Viewhistplaces(){
        setBounds(240,120,900,450);

        caption=new JLabel();
        caption.setBounds(50,30,250,40);
        caption.setFont(new Font("Tahoma",Font.PLAIN,30));
        caption.setForeground(Color.WHITE);
        add(caption);

        ImageIcon img1=null,img2=null,img3=null,img4=null,img5=null,img6=null,img7=null,img8=null,img9=null,img10=null;
        ImageIcon [] img=new ImageIcon []{img1,img2,img3,img4,img5,img6,img7,img8,img9,img10};

        Image jmg1=null,jmg2=null,jmg3=null,jmg4=null,jmg5=null,jmg6=null,jmg7=null,jmg8=null,jmg9=null,jmg10=null;
        Image [] jmg=new Image []{jmg1,jmg2,jmg3,jmg4,jmg5,jmg6,jmg7,jmg8,jmg9,jmg10};

        ImageIcon kmg1=null,kmg2=null,kmg3=null,kmg4=null,kmg5=null,kmg6=null,kmg7=null,kmg8=null,kmg9=null,kmg10=null;
        ImageIcon [] kmg=new ImageIcon []{kmg1,kmg2,kmg3,kmg4,kmg5,kmg6,kmg7,kmg8,kmg9,kmg10};

        for (int i=0;i<=9;i++){
            img[i]=new ImageIcon(ClassLoader.getSystemResource("icons/place"+(i+1)+".jpg"));
            jmg[i]= img[i].getImage().getScaledInstance(900,450,Image.SCALE_DEFAULT);
            kmg[i]=new ImageIcon(jmg[i]);
            label[i]=new JLabel(kmg[i]);
            label[i].setBounds(0,0,900,450);
            add(label[i]);
        }
        thread=new Thread(this);
        thread.start();

        setVisible(true);

    }

    public static void main(String[] args) {
        new Viewhistplaces();

    }
}

