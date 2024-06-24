import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener {
    AppFunction appFunction;
    Boolean isLoaded;
    Frame frame;
    String name;
    Panel infoPanel;

    public App() {
        isLoaded = false;
        frame = new Frame("サンプルフレーム");
        frame.setExtendedState(Frame.MAXIMIZED_BOTH); // フルスクリーン表示
        name = "";
        infoPanel = new Panel(new GridLayout(2, 1));
    }

    public void createView() {
        frame.setLayout(new GridLayout(1, 2));
        frame.setSize(800, 400);

        generateCommand();
        infoCommand();

        frame.setVisible(true);
        isLoaded = true;
    }

    public void setAppFunction(AppFunction appFunction) {
        this.appFunction = appFunction;
    }

    public void actionPerformed(ActionEvent e) {
        name = e.getActionCommand();
        if (name.equals("ホーム")) {
            setAppFunction(new Home());
        } else if (name.equals("時間割")) {
            setAppFunction(new Time());
        } else if (name.equals("メッセージ")) {
            setAppFunction(new Message());
        } else if (name.equals("カレンダー")) {
            setAppFunction(new Calendar());
        } else if (name.equals("出欠")) {
            setAppFunction(new Attend());
        }
        infoCommand();
    }

    public void infoCommand() {
        if (isLoaded) {
            frame.removeAll();

            ButtonPanel buttonPanel = new ButtonPanel(this);
            frame.add(buttonPanel);

            if (appFunction != null) {
                frame.add(appFunction.panel());
            }

            frame.validate();
            frame.repaint();
        }
    }

    public void generateCommand() {
        if (!isLoaded) {
            ButtonPanel buttonPanel = new ButtonPanel(this);
            frame.add(buttonPanel);

            Label label2 = new Label("1");
            Label label3 = new Label("2");
            infoPanel.add(label2);
            infoPanel.add(label3);
            frame.add(infoPanel);
        }
    }
}
