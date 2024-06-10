import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonPanel extends Panel {
    public ButtonPanel(ActionListener listener) {
        setLayout(new GridLayout(6, 1));
        
        Button button1 = new Button("ホーム");
        Button button2 = new Button("時間割");
        Button button3 = new Button("メール");
        Button button4 = new Button("カレンダー");
        Button button5 = new Button("出欠");
        Button button6 = new Button("設定");

        button1.addActionListener(listener);
        button2.addActionListener(listener);
        button3.addActionListener(listener);
        button4.addActionListener(listener);
        button5.addActionListener(listener);
        button6.addActionListener(listener);

        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
    }
}
