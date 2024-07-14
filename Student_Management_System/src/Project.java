import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame implements ActionListener {
    public Project(){

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1300,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1300,700);
        add(image);

        JMenuBar menuBar = new JMenuBar();

        JMenu Student = new JMenu("Student");
        Student.setForeground(Color.BLUE);

        ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image im2 = im1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        JMenuItem addStudent = new JMenuItem("Add Student",new ImageIcon(im2));
        addStudent.addActionListener(this);
        Student.add(addStudent);

        JMenu view = new JMenu("View Student");
        view.setForeground(Color.BLUE);
        im1= new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        im2 = im1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        JMenuItem viewStudent = new JMenuItem("View Student",new ImageIcon(im2));
        viewStudent.addActionListener(this);
        view.add(viewStudent);

        JMenu course = new JMenu("Course");
        course.setForeground(Color.BLUE);

        im1= new ImageIcon(ClassLoader.getSystemResource("icon/icon4.jpg"));
        im2 = im1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        JMenuItem viewCourse = new JMenuItem("View Course",new ImageIcon(im2));
        viewCourse.addActionListener(this);
        course.add(viewCourse);


        JMenu exams = new JMenu("Examination");
        exams.setForeground(Color.BLUE);
        menuBar.add(exams);

        im1= new ImageIcon(ClassLoader.getSystemResource("icon/icon16.png"));
        im2 = im1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        JMenuItem Results = new JMenuItem("Examination Result",new ImageIcon(im2));
        Results.setBackground(Color.WHITE);
        Results.addActionListener(this);
        exams.add(Results);

        im1= new ImageIcon(ClassLoader.getSystemResource("icon/icon17.png"));
        im2 = im1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        JMenuItem marks = new JMenuItem("Enter Marks",new ImageIcon(im2));
        marks.setBackground(Color.WHITE);
        marks.addActionListener(this);
        exams.add(marks);

        JMenu Leaves = new JMenu("Apply For Leaves");
        Leaves.setForeground(Color.BLUE);
        menuBar.add(Leaves);

        JMenuItem studentLeaves = new JMenuItem("Student Leaves");
        studentLeaves.addActionListener(this);
        studentLeaves.setBackground(Color.WHITE);
        Leaves.add(studentLeaves);

        menuBar.add(Student);
        menuBar.add(view);
        menuBar.add(course);
        menuBar.add(exams);
        menuBar.add(Leaves);

        setJMenuBar(menuBar);
        setBounds(0,0,1300,700);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Project();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Enter Marks"){
            new EnterMarks();
        } else if (e.getActionCommand() == "Add Student") {
            new AddStudent();
        } else if (e.getActionCommand() == "View Student") {
            new StudentDetails();
        } else if (e.getActionCommand() == "Student Leaves") {
            new StudentLeave();
        } else if (e.getActionCommand() == "Examination Result") {
            new Examination();
        } else if (e.getActionCommand() == "View Course") {
            new ViewCourse();
        }
    }
}
