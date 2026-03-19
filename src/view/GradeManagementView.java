package view;

import controller.GradeController;
import database.DataStore;
import model.Assessment;
import utils.IDGenerator;
import utils.ValidationUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class GradeManagementView extends JFrame {

    private JTextField courseField;
    private JTextField nameField;
    private JTextField weightField;
    private JTextField marksField;

    private JTable assessmentTable;
    private DefaultTableModel tableModel;

    public GradeManagementView(){

        setTitle("Assessment Management");
        setSize(750,420);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Course Assessment Management",SwingConstants.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,18));
        title.setBorder(BorderFactory.createEmptyBorder(15,10,15,10));

        mainPanel.add(title,BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(5,2,10,10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        formPanel.add(new JLabel("Course ID"));
        courseField = new JTextField();
        formPanel.add(courseField);

        formPanel.add(new JLabel("Assessment Name"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Weight (%)"));
        weightField = new JTextField();
        formPanel.add(weightField);

        formPanel.add(new JLabel("Maximum Marks"));
        marksField = new JTextField();
        formPanel.add(marksField);

        JButton createButton = new JButton("Add Assessment");

        formPanel.add(new JLabel());
        formPanel.add(createButton);

        mainPanel.add(formPanel,BorderLayout.WEST);

        tableModel = new DefaultTableModel(
                new String[]{"Assessment ID","Course ID","Name","Weight","Max Marks"},0
        );

        assessmentTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(assessmentTable);

        mainPanel.add(scrollPane,BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();

        JButton refreshButton = new JButton("Refresh List");

        bottomPanel.add(refreshButton);

        mainPanel.add(bottomPanel,BorderLayout.SOUTH);

        add(mainPanel);

        loadAssessments();

        createButton.addActionListener(e -> createAssessment());
        refreshButton.addActionListener(e -> loadAssessments());

    }

    private void createAssessment(){

        String courseId = courseField.getText();
        String name = nameField.getText();
        String weightText = weightField.getText();
        String maxMarksText = marksField.getText();

        if(!ValidationUtils.isValidName(name)){
            JOptionPane.showMessageDialog(this,"Invalid assessment name");
            return;
        }

        double weight;
        double maxMarks;

        try{
            weight = Double.parseDouble(weightText);
            maxMarks = Double.parseDouble(maxMarksText);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Weight and marks must be numbers");
            return;
        }

        String id = IDGenerator.generateAssessmentId();

        Assessment assessment =
                new Assessment(id,courseId,name,weight,maxMarks);

        new GradeController().addAssessment(assessment);

        JOptionPane.showMessageDialog(this,"Assessment created successfully");

        courseField.setText("");
        nameField.setText("");
        weightField.setText("");
        marksField.setText("");

        loadAssessments();

    }

    private void loadAssessments(){

        tableModel.setRowCount(0);

        List<Assessment> assessments =
                DataStore.getInstance().getAssessments();

        for(Assessment a : assessments){

            tableModel.addRow(new Object[]{
                    a.getAssessmentId(),
                    a.getCourseId(),
                    a.getAssessmentName(),
                    a.getWeight(),
                    a.getMaxMarks()
            });

        }

    }

}