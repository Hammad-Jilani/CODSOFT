import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends JFrame implements ActionListener {
    JButton enter,calculate;
    JTextField[] subjectField,marksField;
    JTextField txtNumber;
    JLabel percentage;
    JLabel grade;
    int count=0;
    public Main(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Percentage Calculator");
        heading.setBounds(200,10,200,30);
        heading.setFont(new Font("Roboto",Font.BOLD,16));
        add(heading);

        JLabel number = new JLabel("Number of subjects");
        number.setBounds(20,50,180,20);
        add(number);

        txtNumber = new JTextField("6");
        txtNumber.setBounds(180,50,150,20);
        add(txtNumber);

        enter = new JButton("Enter");
        enter.setBounds(350,50,80,20);
        enter.addActionListener(this);
        add(enter);

        calculate = new JButton("Calculate");
        calculate.setBounds(460,50,100,20);
        calculate.addActionListener(this);
        add(calculate);

        JLabel lblSubjectName = new JLabel("Subject Name");
        lblSubjectName.setBounds(120,100,100,20);
        add(lblSubjectName);

        JLabel lblMarks = new JLabel("Enter Marks");
        lblMarks.setBounds(300,100,100,20);
        add(lblMarks);

        JLabel lblPercentage = new JLabel("Percentage");
        lblPercentage.setBounds(110,500,100,20);
        add(lblPercentage);

        percentage = new JLabel();
        percentage.setBounds(240,500,100,20);
        percentage.setFont(new Font("Roboto",Font.PLAIN,13));
        add(percentage);

        JLabel lblGrade = new JLabel("Grade");
        lblGrade.setBounds(360,500,100,20);
        add(lblGrade);

        grade = new JLabel();
        grade.setBounds(480,500,100,20);
        grade.setFont(new Font("Roboto",Font.PLAIN,13));
        add(grade);

        setVisible(true);
        setBounds(200,50,580,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Main();
   }
   private void assignGrade(){
        if (Integer.parseInt(percentage.getText()) < 50){
            grade.setText("F");
        } else if (Integer.parseInt(percentage.getText()) < 60) {
            grade.setText("D");
        }else if (Integer.parseInt(percentage.getText()) < 70) {
            grade.setText("C");
        }else if (Integer.parseInt(percentage.getText()) < 80) {
            grade.setText("B");
        }else if (Integer.parseInt(percentage.getText()) < 90) {
            grade.setText("A");
        }else{
            grade.setText("A*");
        }
   }
   private void calculate(){
        int total = 0;
       for (int i = 0; i < marksField.length; i++) {
           total+= Integer.parseInt(marksField[i].getText());
       }
       percentage.setText(String.valueOf(((total)/Integer.parseInt(txtNumber.getText()))));
       repaint();
       revalidate();
       assignGrade();
   }
   private void display(){
       int numberOfSubject = Integer.parseInt(txtNumber.getText());
       if (subjectField != null) {
           for (JTextField field : subjectField) {
               remove(field);
           }
       }
       if (marksField != null) {
           for (JTextField field : marksField) {
               remove(field);
           }
       }
       subjectField = new JTextField[numberOfSubject];
       int count=-30;
       for (int i = 0; i < numberOfSubject ; i++) {
           subjectField[i] = new JTextField();
           count+=30;
           subjectField[i].setBounds(80,120+count,150,20);
           add(subjectField[i]);
       }

       marksField = new JTextField[numberOfSubject];
       count=-30;
       for (int i = 0; i < numberOfSubject ; i++) {
           marksField[i] = new JTextField();
           count+=30;
           marksField[i].setBounds(250,120+count,150,20);
           add(marksField[i]);
       }
       repaint();
       revalidate();
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enter){
            display();
        } else if (e.getSource() == calculate) {
            calculate();
        }
    }
}