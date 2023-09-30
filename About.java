import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {
    About(){
        setBounds(400,140,600,500);
        setLayout(null);
        getContentPane().setBackground(new Color(70,130,180));

        JLabel text=new JLabel("Welcome to Gillani Tourism");
        text.setBounds(135,10,350,25);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Monospaced",Font.BOLD,22));
        add(text);

        String about= "At Gillani Tourism,\n"+ "Adventure and luxury intertwine to create unforgettable travel experiences. Step into a world of enchantment as we guide you through the hidden gems and awe-inspiring destinations of our breathtaking planet. Whether you seek thrilling escapades, cultural immersion, or serene retreats, Gillani Tourism is here to curate your dream vacation."+
                "\n\nWe believe that responsible travel is paramount. We strive to minimize our impact on the environment and actively contribute to the preservation of local cultures and natural wonders. By choosing us, you become part of a global community that values the world's diverse beauty and actively works towards its preservation."+
                "\n\nChoose Gillani Tourism, and let us take you on a journey of a lifetime. Unleash your wanderlust, embrace the unknown, and create memories that will forever shape your travel narrative. Discover the world with us, where every destination becomes a story waiting to be told."+
                "\n\nGmail: gillanitourism@gmail.com\n\n"+
                "Youtube: Gillani_Tourism.Official\n"+
                "At our youtube channel you can find amazing videos and pics of natural beauty. Wherever we go , we take snaps and present them to you"+
                "\n\n                                                                        THANK YOU!";

        TextArea area=new TextArea(about,10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,50,550,300);
        add(area);

        JButton back=new JButton("Back");
        back.setFont(new Font("Monospaced",Font.BOLD,16));
        back.setBounds(250,400,100,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    public static void main(String[] args) {
        new About();
    }
}
