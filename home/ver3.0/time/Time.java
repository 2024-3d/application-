package app.time;
import java.awt.Panel;
import java.awt.Label;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import app.Menu;

public class Time implements Menu {
    Panel panel;
    Label label1;
    Label label2;
    String name;

    public Time() {
        name = "時間割";
    }

    public String getName() {
        return name;
    }

    public Panel panel() {
        panel = new Panel(new GridLayout(6, 6));
        return panel;
    }
}
