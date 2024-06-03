import java.awt.*;

public class Time extends Menu {
    public Panel panel() {
        Panel panel = new Panel(new GridLayout(7, 7));
        
        String[] days = {"", "月", "火", "水", "木", "金", "土"};
        String[] periods = {"1限", "2限", "3限", "4限", "5限", "6限", "7限"};

        // Adding day labels
        for (String day : days) {
            panel.add(new Label(day, Label.CENTER));
        }

        // Adding periods and empty labels for timetable
        for (int i = 0; i < periods.length; i++) {
            panel.add(new Label(periods[i], Label.CENTER));
            for (int j = 0; j < days.length - 1; j++) {
                panel.add(new Label(" ", Label.CENTER));
            }
        }

        return panel;
    }
}
