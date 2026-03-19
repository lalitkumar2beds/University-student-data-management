package view;

import database.DataStore;
import model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class StudentListView extends JFrame {

    private JTable studentTable;
    private DefaultTableModel tableModel;

    public StudentListView() {

        setTitle("Student Records");
        setSize(600,400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Registered Students",SwingConstants.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,18));
        title.setBorder(BorderFactory.createEmptyBorder(15,10,15,10));

        mainPanel.add(title,BorderLayout.NORTH);

        tableModel = new DefaultTableModel(
                new String[]{"Student ID","Name","Email","Program"},0
        );

        studentTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(studentTable);

        mainPanel.add(scrollPane,BorderLayout.CENTER);

        JButton refreshButton = new JButton("Refresh List");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(refreshButton);

        mainPanel.add(buttonPanel,BorderLayout.SOUTH);

        add(mainPanel);

        loadStudents();

        refreshButton.addActionListener(e -> loadStudents());

    }

    private void loadStudents(){

        tableModel.setRowCount(0);

        List<Student> students = DataStore.getInstance().getStudents();

        for(Student student : students){

            tableModel.addRow(new Object[]{
                    student.getUserId(),
                    student.getName(),
                    student.getEmail(),
                    student.getProgram()
            });

        }

    }

}