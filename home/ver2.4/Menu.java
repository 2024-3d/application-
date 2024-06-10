import java.awt.*;

public class Menu extends AppFunction {
    @Override
    public Panel panel() {
        Panel panel = new Panel();
        panel.add(new Label("設定画面"));
        return panel;
    }
}
