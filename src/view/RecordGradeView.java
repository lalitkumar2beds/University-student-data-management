package view;

import utils.GradeCalculator;
import utils.ValidationUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RecordGradeView extends JFrame {

    private JTextField studentField;
    private JTextField courseField;
    private JTextField marksField;
    private JTextField maxMarksField;

    private JTable gradeTable;
    private DefaultTableModel tableModel;

    private List<Double> weightedScores;

    public RecordGradeView(){

        weightedScores = new ArrayList<>();

        setTitle("Record Student Grades");
        setSize(700,400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Student Grade Recording",SwingConstants.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,18));
        title.setBorder(BorderFactory.createEmptyBorder(15,10,15,10));

        mainPanel.add(title,BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(5,2,10,10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        formPanel.add(new JLabel("Student ID"));
        studentField = new JTextField();
        formPanel.add(studentField);

        formPanel.add(new JLabel("Course ID"));
        courseField = new JTextField();
        formPanel.add(courseField);

        formPanel.add(new JLabel("Marks Obtained"));
        marksField = new JTextField();
        formPanel.add(marksField);

        formPanel.add(new JLabel("Maximum Marks"));
        maxMarksField = new JTextField();
        formPanel.add(maxMarksField);

        JButton recordButton = new JButton("Record Grade");

        formPanel.add(new JLabel());
        formPanel.add(recordButton);

        mainPanel.add(formPanel,BorderLayout.WEST);

        tableModel = new DefaultTableModel(
                new String[]{"Student ID","Course ID","Score","Letter Grade"},0
        );

        gradeTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(gradeTable);

        mainPanel.add(scrollPane,BorderLayout.CENTER);

        add(mainPanel);

        recordButton.addActionListener(e -> recordGrade());

    }

    private void recordGrade(){

        String studentId = studentField.getText();
        String courseId = courseField.getText();

        double marks;
        double maxMarks;

        try{

            marks = Double.parseDouble(marksField.getText());
            maxMarks = Double.parseDouble(maxMarksField.getText());

        }catch(Exception e){

            JOptionPane.showMessageDialog(this,"Marks must be numeric");
            return;

        }

        if(!ValidationUtils.isValidMarks(marks,maxMarks)){

            JOptionPane.showMessageDialog(this,"Invalid marks entered");
            return;

        }

        double weightedScore =
                GradeCalculator.calculateWeightedScore(marks,maxMarks,100);

        weightedScores.add(weightedScore);

        double finalScore =
                GradeCalculator.calculateFinalGrade(weightedScores);

        String grade =
                GradeCalculator.getLetterGrade(finalScore);

        tableModel.addRow(new Object[]{
                studentId,
                courseId,
                String.format("%.2f",finalScore),
                grade
        });

        studentField.setText("");
        courseField.setText("");
        marksField.setText("");
        maxMarksField.setText("");

    }

}