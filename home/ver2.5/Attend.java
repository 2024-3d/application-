import java.awt.*;

public class Attend implements Menu {
    private String studentName;
    private int totalClasses;
    private int attendedClasses;

    public Attend(String studentName, int totalClasses, int attendedClasses) {
        this.studentName = studentName;
        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
    }

    @Override
    public String getName() {
        return studentName;
    }

    @Override
    public Panel panel() {
        Panel panel = new Panel();
        panel.setLayout(new GridLayout(3, 2));

        Label nameLabel = new Label("Student Name:");
        panel.add(nameLabel);
        Label nameValueLabel = new Label(studentName);
        panel.add(nameValueLabel);

        Label totalLabel = new Label("Total Classes:");
        panel.add(totalLabel);
        Label totalValueLabel = new Label(String.valueOf(totalClasses));
        panel.add(totalValueLabel);

        Label attendedLabel = new Label("Attended Classes:");
        panel.add(attendedLabel);
        Label attendedValueLabel = new Label(String.valueOf(attendedClasses));
        panel.add(attendedValueLabel);

        return panel;
    }

    // Method to calculate attendance percentage
    public double getAttendancePercentage() {
        if (totalClasses == 0) {
            return 0.0;
        }
        return (double) attendedClasses / totalClasses * 100;
    }

    public static void main(String[] args) {
        Attend student1 = new Attend("John Doe", 20, 15);
        Attend student2 = new Attend("Jane Smith", 20, 18);

        System.out.println("Student Name: " + student1.getName());
        System.out.println("Total Classes: " + student1.totalClasses);
        System.out.println("Attended Classes: " + student1.attendedClasses);
        System.out.println("Attendance Percentage: " + student1.getAttendancePercentage() + "%");

        Panel student1Panel = student1.panel();
        Panel student2Panel = student2.panel();

        Frame frame = new Frame("Student Attendance");

        frame.setLayout(new GridLayout(2, 1));
        frame.add(student1Panel);
        frame.add(student2Panel);

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
