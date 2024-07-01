import java.awt.*;

public class Attend extends AppFunction {
    @Override
    public Panel panel() {
        Panel panel = new Panel();
        panel.add(new Label("出欠画面"));
        return panel;
    }
}
