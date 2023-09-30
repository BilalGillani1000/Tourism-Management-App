import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paytm extends JFrame implements ActionListener {
    Paytm(){
        setBounds(240,120,900,450);
        JEditorPane pane=new JEditorPane();
        pane.setEditable(false);

        try {
            pane.setPage("https://paytm.com/rent-payment");

        }catch (Exception e){
            pane.setContentType("text/html");
                    pane.setText("<html>Could not load,Error 404</html>");
        }
        JScrollPane sc=new JScrollPane(pane);
        getContentPane().add(sc);

        JButton back=new JButton("Back");
        back.setFont(new Font("Monospaced",Font.PLAIN,16));
        back.setBounds(700,30,100,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        pane.add(back);


        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Payment();
    }

    public static void main(String[] args) {
        new Paytm();
    }
}
