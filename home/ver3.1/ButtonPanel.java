import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonPanel extends Panel {
    public ButtonPanel(ActionListener listener) {
        setLayout(new GridLayout(5, 1)); // メニューがなくなったので5行に調整

        Button button1 = new Button("ホーム");
        Button button2 = new Button("時間割");
        Button button3 = new Button("メッセージ");
        Button button4 = new Button("カレンダー");
        Button button5 = new Button("出欠");

        button1.addActionListener(listener);
        button2.addActionListener(listener);
        button3.addActionListener(listener);
        button4.addActionListener(listener);
        button5.addActionListener(listener);

        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
    }
}
