import java.awt.Panel;
import java.awt.Label;
import java.awt.GridLayout;
public class Mail implements Menu{
    Panel panel;
    Label label1;
    Label label2;
    String name;
    public Mail(){
        name = "時間割";
    }
    public String getName(){
        return name;
    }
    public Panel panel(){
        panel = new Panel(new GridLayout(2, 1));
        label1 = new Label("時間割");
        label2 = new Label("時間割");
        panel.add(label1);
        panel.add(label2);
        return panel;
    }
}
