import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewCourse extends JFrame implements ActionListener {
    Choice semester;
    JTable table;
    JButton back;
    public ViewCourse(){
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Course");
        heading.setBounds(300,20,200,40);
        heading.setFont(new Font("Roboto",Font.BOLD,20));
        add(heading);

        JLabel lblSemester = new JLabel("Semester");
        lblSemester.setBounds(70,80,150,30);
        add(lblSemester);

        String sem[] = {"semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
        semester = new Choice();
        for(String s : sem){
            semester.addItem(s);
        }
        semester.setBounds(250,80,150,30);
        add(semester);

        table = new JTable();
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0,120,600,800);
        add(pane);

        loadData();

        semester.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                loadData();
            }
        });


        back = new JButton("Back");
        back.setBounds(450,80,100,20);
        back.addActionListener(this);
        add(back);


        setVisible(true);
        setBounds(200,40,600,500);
    }
    public static void main(String[] args) {
        new ViewCourse();
    }
    private void loadData(){
        Connect c = new Connect();
        try {
            ResultSet set = c.s.executeQuery("select * from Course where semester = '"+semester.getSelectedItem()+"'");
            table.setModel(DbUtils.resultSetToTableModel(set));
            set.close();
            c.s.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            setVisible(false);
        }
    }
}
