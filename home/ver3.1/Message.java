import java.awt.*;
import java.awt.event.*;

public class Message extends AppFunction implements ActionListener, ItemListener {
    private java.awt.List channelList;
    private TextArea messageArea;
    private TextField inputField;
    private Button sendButton;
    private MessageManager messageManager;
    private String currentChannel;

    public Message(MessageManager messageManager) {
        this.messageManager = messageManager;
        currentChannel = "離散数学"; // デフォルトのチャンネル
    }

    @Override
    public Panel panel() {
        Panel mainPanel = new Panel(new GridLayout(1, 2)); // 画面を縦に二等分

        // 左側（右半分の左側）のチャンネルリスト
        Panel channelPanel = new Panel(new BorderLayout());
        channelList = new java.awt.List();
        channelList.add("離散数学");
        channelList.add("データ構造とアルゴリズム");
        channelList.add("多変量解析");
        channelList.addItemListener(this);
        channelPanel.add(new Label("チャンネル"), BorderLayout.NORTH);
        channelPanel.add(channelList, BorderLayout.CENTER);

        // 右側（右半分の右側）のメッセージエリア
        Panel messagePanel = new Panel(new BorderLayout());
        messageArea = new TextArea();
        messageArea.setEditable(false);

        // メッセージ入力フィールドと送信ボタン
        inputField = new TextField();
        sendButton = new Button("送信");

        sendButton.addActionListener(e -> {
            String newMessage = inputField.getText();
            if (!newMessage.isEmpty()) {
                messageManager.addMessage(currentChannel, newMessage);
                updateMessageArea();
                inputField.setText("");
            }
        });

        Panel inputPanel = new Panel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        messagePanel.add(new Label("メッセージ"), BorderLayout.NORTH);
        messagePanel.add(messageArea, BorderLayout.CENTER);
        messagePanel.add(inputPanel, BorderLayout.SOUTH);

        mainPanel.add(channelPanel);
        mainPanel.add(messagePanel);

        updateMessageArea();

        return mainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // ここでは何もしない
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        currentChannel = channelList.getSelectedItem();
        updateMessageArea();
    }

    private void updateMessageArea() {
        messageArea.setText("");
        java.util.List<String> messages = messageManager.getMessages(currentChannel);
        for (String message : messages) {
            messageArea.append(message + "\n");
        }
    }
}
