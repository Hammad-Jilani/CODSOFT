import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {
    JButton continues;
    public Splash(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/student.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,600);
        add(image);


        continues = new JButton("Continue");
        continues.setBounds(400,500,250,40);
        continues.setBackground(Color.BLACK);
        continues.setForeground(Color.WHITE);
        continues.addActionListener(this);
        add(continues);

        setVisible(true);
        setBounds(150,40,900,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Splash();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == continues){
            setVisible(false);
            new Login();
        }

    }
}
