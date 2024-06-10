import java.awt.*;

public class Calendar extends AppFunction {
    @Override
    public Panel panel() {
        Panel panel = new Panel();
        panel.add(new Label("カレンダー画面"));
        return panel;
    }
}
