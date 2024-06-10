import java.awt.*;

public class Mail extends AppFunction {
    @Override
    public Panel panel() {
        Panel panel = new Panel();
        panel.add(new Label("メール画面"));
        return panel;
    }
}
