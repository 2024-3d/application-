import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class Time extends AppFunction implements ActionListener {
    private Map<String, Lecture> lectures = new HashMap<>();

    public Time() {
        // 初期の授業データ（例）
        lectures.put("火4限", new Lecture("火", "4限", "数学"));
        lectures.put("金6限", new Lecture("金", "6限", "物理"));
    }

    @Override
    public Panel panel() {
        Panel panel = new Panel(new GridLayout(8, 7));
        String[] days = {"時間割", "月", "火", "水", "木", "金", "土"};
        String[] periods = {"1限", "2限", "3限", "4限", "5限", "6限", "7限"};

        for (String day : days) {
            panel.add(new Label(day, Label.CENTER));
        }

        for (int i = 0; i < periods.length; i++) {
            panel.add(new Label(periods[i], Label.CENTER));
            for (int j = 1; j < days.length; j++) {
                Button button = new Button(days[j] + periods[i]);
                button.addActionListener(this);
                panel.add(button);
            }
        }

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Lecture lecture = lectures.get(command);

        if (lecture != null) {
            showMessage("授業情報", lecture.getInfo());
        } else {
            showMessage("授業情報", "授業が存在しません");
        }
    }

    private void showMessage(String title, String message) {
        Frame messageFrame = new Frame(title);
        messageFrame.setSize(300, 200);
        messageFrame.add(new Label(message, Label.CENTER));
        messageFrame.setVisible(true);
    }
}
