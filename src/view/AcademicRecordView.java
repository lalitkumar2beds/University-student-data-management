package view;

import database.DataStore;
import model.Enrollment;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AcademicRecordView extends JFrame {

    private User student;

    private JTable recordTable;
    private DefaultTableModel tableModel;

    public AcademicRecordView(User student) {

        this.student = student;

        setTitle("Academic Records");
        setSize(700,400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel(
                "Academic Records - " + student.getName(),
                SwingConstants.CENTER
        );

        title.setFont(new Font("Arial",Font.BOLD,18));
        title.setBorder(BorderFactory.createEmptyBorder(15,10,15,10));

        mainPanel.add(title,BorderLayout.NORTH);

        tableModel = new DefaultTableModel(
                new String[]{"Student ID","Course ID","Enrollment Date","Status"},0
        );

        recordTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(recordTable);

        mainPanel.add(scrollPane,BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();

        JButton refreshButton = new JButton("Refresh Records");

        bottomPanel.add(refreshButton);

        mainPanel.add(bottomPanel,BorderLayout.SOUTH);

        add(mainPanel);

        loadRecords();

        refreshButton.addActionListener(e -> loadRecords());

    }

    private void loadRecords(){

        tableModel.setRowCount(0);

        List<Enrollment> enrollments =
                DataStore.getInstance().getEnrollments();

        for(Enrollment e : enrollments){

            if(e.getStudentId().equals(student.getUserId())){

                tableModel.addRow(new Object[]{
                        e.getStudentId(),
                        e.getCourseId(),
                        e.getEnrollmentDate(),
                        e.getStatus()
                });

            }

        }

    }

}