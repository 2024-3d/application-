import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class App implements ActionListener {
    private Map<String, AppFunction> appFunctionMap;
    private AppFunction currentAppFunction;
    private Boolean isLoaded;
    private Frame frame;
    private String name;
    private Panel infoPanel;
    private MessageManager messageManager;

    public App() {
        isLoaded = false;
        frame = new Frame("サンプルフレーム");
        frame.setExtendedState(Frame.MAXIMIZED_BOTH); // フルスクリーン表示
        name = "";
        infoPanel = new Panel(new GridLayout(2, 1));

        messageManager = new MessageManager();
        appFunctionMap = new HashMap<>();
        appFunctionMap.put("ホーム", new Home());
        appFunctionMap.put("時間割", new Time());
        appFunctionMap.put("メッセージ", new Message(messageManager));
        appFunctionMap.put("カレンダー", new Calendar());
        appFunctionMap.put("出欠", new Attend());
    }

    public void createView() {
        frame.setLayout(new GridLayout(1, 2));
        frame.setSize(800, 400);

        generateCommand();
        infoCommand();

        frame.setVisible(true);
        isLoaded = true;
    }

    public void setAppFunction(String functionName) {
        currentAppFunction = appFunctionMap.get(functionName);
    }

    public void actionPerformed(ActionEvent e) {
        name = e.getActionCommand();
        setAppFunction(name);
        infoCommand();
    }

    public void infoCommand() {
        if (isLoaded) {
            frame.removeAll();

            ButtonPanel buttonPanel = new ButtonPanel(this);
            frame.add(buttonPanel);

            if (currentAppFunction != null) {
                frame.add(currentAppFunction.panel());
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
