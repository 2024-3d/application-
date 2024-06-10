import java.awt.*;

public class Home extends AppFunction {
    @Override
    public Panel panel() {
        Panel panel = new Panel();
        panel.add(new Label("ホーム画面"));
        return panel;
    }
}
