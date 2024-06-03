//Home, Time, Mail, Calendar, Attend, Question などのクラスを作成し、それぞれの機能を別クラスに分けます。
//
//
import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener {
    Menu menu;
    Boolean isLoaded;
    Frame frame;
    String name;
    Panel infoPanel;

    public App() {
        isLoaded = false;
        frame = new Frame("サンプルフレーム");
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

    public void setMenuData(Menu menu) {
        this.menu = menu;
    }

    public void actionPerformed(ActionEvent e) {
        name = e.getActionCommand();
        if (name.equals("ホーム")) {
            setMenuData(new Home());
        } else if (name.equals("時間割")) {
            setMenuData(new Time());
        } else if (name.equals("メール")) {
            setMenuData(new Mail());
        } else if (name.equals("カレンダー")) {
            setMenuData(new Calendar());
        } else if (name.equals("出欠")) {
            setMenuData(new Attend());
        } else if (name.equals("質問")) {
            setMenuData(new Question());
        }
        infoCommand();
    }

    public void infoCommand() {
        if (isLoaded) {
            frame.removeAll();

            Panel panel2 = createButtonPanel();
            frame.add(panel2);

            if (menu != null) {
                frame.add(menu.panel());
            }

            frame.validate();
            frame.repaint();
        }
    }

    public void generateCommand() {
        if (!isLoaded) {
            Panel panel2 = createButtonPanel();
            frame.add(panel2);

            Label label2 = new Label("1");
            Label label3 = new Label("2");
            infoPanel.add(label2);
            infoPanel.add(label3);
            frame.add(infoPanel);
        }
    }

    private Panel createButtonPanel() {
        Panel panel2 = new Panel(new GridLayout(6, 1));
        Button button1 = new Button("ホーム");
        Button button2 = new Button("時間割");
        Button button3 = new Button("メール");
        Button button4 = new Button("カレンダー");
        Button button5 = new Button("出欠");
        Button button6 = new Button("質問");

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);

        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(button4);
        panel2.add(button5);
        panel2.add(button6);

        return panel2;
    }

    public static void main(String[] args) {
        App app = new App();
        app.createView();
    }
}
