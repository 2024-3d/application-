import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Calendar extends AppFunction {
    private JPanel calendarPanel;
    private JLabel monthLabel;
    private int month, year;
    private Map<String, java.util.List<String>> appointments; // 予定を保存するためのマップ

    public Calendar() {
        appointments = new HashMap<>();
    }

    @Override
    public Panel panel() {
        Panel panel = new Panel(new BorderLayout());

        calendarPanel = new JPanel(new GridLayout(0, 7));
        monthLabel = new JLabel("", SwingConstants.CENTER);

        JPanel headerPanel = new JPanel(new BorderLayout());
        JButton prevButton = new JButton("<");
        JButton nextButton = new JButton(">");

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
            calendarPanel.add(new JLabel(day, SwingConstants.CENTER));
        }

        java.util.Calendar calendar = new GregorianCalendar(year, month, 1);
        int firstDayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK);
        int daysInMonth = calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

        for (int i = 1; i < firstDayOfWeek; i++) {
            calendarPanel.add(new JLabel(""));
        }

        for (int day = 1; day <= daysInMonth; day++) {
            final int currentDay = day;
            JButton dayButton = new JButton(String.valueOf(currentDay));
            dayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String date = year + "-" + (month + 1) + "-" + currentDay;
                    showAppointmentsDialog(date);
                }
            });
            calendarPanel.add(dayButton);
        }

        monthLabel.setText(calendar.getDisplayName(java.util.Calendar.MONTH, java.util.Calendar.LONG, Locale.getDefault()) + " " + year);

        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    private void showAppointmentsDialog(String date) {
        java.util.List<String> currentAppointments = appointments.getOrDefault(date, new ArrayList<>());

        JTextArea textArea = new JTextArea(10, 30);
        for (String appointment : currentAppointments) {
            textArea.append(appointment + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        int result = JOptionPane.showConfirmDialog(null, scrollPane, "Appointments for " + date, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String[] lines = textArea.getText().split("\n");
            java.util.List<String> newAppointments = Arrays.asList(lines);
            appointments.put(date, newAppointments);
        }
    }
}
