import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Calendar extends AppFunction {
    private Panel calendarPanel;
    private Label monthLabel;
    private int month, year;
    private Map<String, java.util.List<String>> appointments; // 予定を保存するためのマップ

    public Calendar() {
        appointments = new HashMap<>();
    }

    @Override
    public Panel panel() {
        Panel panel = new Panel(new BorderLayout());

        calendarPanel = new Panel(new GridLayout(0, 7));
        monthLabel = new Label("", Label.CENTER);

        Panel headerPanel = new Panel(new BorderLayout());
        Button prevButton = new Button("<");
        Button nextButton = new Button(">");

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                month--;
                if (month < 0) {
                    month = 11;
                    year--;
                }
                updateCalendar();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                month++;
                if (month > 11) {
                    month = 0;
                    year++;
                }
                updateCalendar();
            }
        });

        headerPanel.add(prevButton, BorderLayout.WEST);
        headerPanel.add(monthLabel, BorderLayout.CENTER);
        headerPanel.add(nextButton, BorderLayout.EAST);

        panel.add(headerPanel, BorderLayout.NORTH);
        panel.add(calendarPanel, BorderLayout.CENTER);

        java.util.Calendar calendar = java.util.Calendar.getInstance();
        month = calendar.get(java.util.Calendar.MONTH);
        year = calendar.get(java.util.Calendar.YEAR);

        updateCalendar();

        return panel;
    }

    private void updateCalendar() {
        calendarPanel.removeAll();

        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : daysOfWeek) {
            calendarPanel.add(new Label(day, Label.CENTER));
        }

        java.util.Calendar calendar = new GregorianCalendar(year, month, 1);
        int firstDayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK);
        int daysInMonth = calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

        for (int i = 1; i < firstDayOfWeek; i++) {
            calendarPanel.add(new Label(""));
        }

        for (int day = 1; day <= daysInMonth; day++) {
            final int currentDay = day;
            Button dayButton = new Button(String.valueOf(currentDay));
            dayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String date = year + "-" + (month + 1) + "-" + currentDay;
                    showAppointmentsDialog(date);
                }
            });
            calendarPanel.add(dayButton);
        }

        monthLabel.setText(new GregorianCalendar(year, month, 1).getDisplayName(java.util.Calendar.MONTH, java.util.Calendar.LONG, Locale.getDefault()) + " " + year);

        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    private void showAppointmentsDialog(String date) {
        java.util.List<String> currentAppointments = appointments.getOrDefault(date, new ArrayList<>());

        TextArea textArea = new TextArea(10, 30);
        for (String appointment : currentAppointments) {
            textArea.append(appointment + "\n");
        }

        Panel panel = new Panel(new BorderLayout());
        panel.add(textArea, BorderLayout.CENTER);
        int result = JOptionPane.showConfirmDialog(null, panel, "Appointments for " + date, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String[] lines = textArea.getText().split("\n");
            java.util.List<String> newAppointments = Arrays.asList(lines);
            appointments.put(date, newAppointments);
        }
    }
}
