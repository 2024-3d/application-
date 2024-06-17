package app.home;
import java.awt.Panel;
import java.awt.Label;
import java.awt.GridLayout;

import app.Menu;


public class Home implements Menu{
    Panel panel;
    Label label1;
    Label label2;
    String name;
    public Home(){
        name = "ホーム";
    }
    public String getName(){
        return name;
    }
    public Panel panel(){
        panel = new Panel(new GridLayout(2, 1));
        label1 = new Label("期限が近い課題");
        label2 = new Label("新しい連絡 : 3件");
        panel.add(label1);
        panel.add(label2);
        return panel;
    }
}
