import java.awt.Frame;
import java.awt.Panel;
import java.awt.Button;
import java.awt.Label;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App {
    public void createView() {
        Frame frame = new Frame("サンプルフレーム");
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(1, 2));  // フレーム全体のレイアウト設定

        //Panel panel1 = new Panel(new GridLayout(1, 2));
        Panel panel2 = new Panel(new GridLayout(6, 1));

        Button button1 = new Button("ホーム");
        Button button2 = new Button("時間割");
        Button button3 = new Button("メール");
        Button button4 = new Button("カレンダー");
        Button button5 = new Button("出欠");
        Button button6 = new Button("質問");

        panel2.add(button1);
        panel2.add(button2);
        //panel2.add(button3);
        //panel2.add(button4);
        //panel2.add(button5);
        //panel2.add(button6);

        Panel label = new Panel(new GridLayout(2, 1));
        Label label2 = new Label("1");
        Label label3 = new Label("2");
        label.add(label2);
        label.add(label3);


        frame.add(panel2);
        frame.add(label);

        //frame.add(panel1);

        // ウィンドウを閉じるためのリスナー追加
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        App app = new App();
        app.createView();
    }
}
