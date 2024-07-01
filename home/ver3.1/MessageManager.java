import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageManager {
    private Map<String, List<String>> channelMessages;

    public MessageManager() {
        channelMessages = new HashMap<>();
        initializeMessages();
    }

    private void initializeMessages() {
        List<String> discreteMathMessages = new ArrayList<>();
        discreteMathMessages.add("このクラスは水曜日の3限です。");
        discreteMathMessages.add("このクラスはオンデマンド授業です。教室に来る必要はありません。");
        channelMessages.put("離散数学", discreteMathMessages);

        List<String> dataStructuresMessages = new ArrayList<>();
        dataStructuresMessages.add("このクラスは月曜日の3限と4限です。");
        dataStructuresMessages.add("このクラスは対面授業です。教室に来てください。");
        channelMessages.put("データ構造とアルゴリズム", dataStructuresMessages);

        List<String> multivariateAnalysisMessages = new ArrayList<>();
        multivariateAnalysisMessages.add("このクラスは火曜日の5限です。");
        multivariateAnalysisMessages.add("このクラスは対面授業です。教室に来てください。");
        channelMessages.put("多変量解析", multivariateAnalysisMessages);
    }

    public List<String> getMessages(String channel) {
        return channelMessages.getOrDefault(channel, new ArrayList<>());
    }

    public void addMessage(String channel, String message) {
        channelMessages.computeIfAbsent(channel, k -> new ArrayList<>()).add(message);
    }
}
