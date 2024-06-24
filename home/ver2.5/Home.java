import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class Home implements Menu {
    Panel panel;
    Label assignmentDeadline;
    Label unreadMessages;
    java.awt.List subjectDetails;
    String name;
    
    public Home() {
        name = "ホーム";
    }

    public String getName() {
        return name;
    }

    public Panel panel() {
        panel = new Panel(new BorderLayout());
        
        // 上部パネル: 課題の提出期限と未読メッセージ一覧
        Panel topPanel = new Panel(new GridLayout(2, 1));
        assignmentDeadline = new Label("提出期限: " + LocalDate.now().plusDays(7).toString());
        unreadMessages = new Label("未読メッセージ: 3件");
        topPanel.add(assignmentDeadline);
        topPanel.add(unreadMessages);
        
        // 下部パネル: 提出科目の詳細
        Panel bottomPanel = new Panel(new BorderLayout());
        Label detailsLabel = new Label("提出期限の近い科目");
        subjectDetails = new List();
        
        // 提出科目の詳細リスト（ここに実際のデータを入れる）
        ArrayList<String> assignments = new ArrayList<>();
        assignments.add("離散数学: 提出期限 - 2024-06-15");
        assignments.add("データ構造とアルゴリズム: 提出期限 - 2024-06-20");
        assignments.add("多変量解析: 提出期限 - 2024-06-25");
        assignments.add("TOEIC: 提出期限 - 2024-06-17");
        
        // 現在の日付と1週間後の日付を取得
        LocalDate currentDate = LocalDate.now();
        LocalDate oneWeekLater = currentDate.plusDays(7);
        
        // 提出期限が1週間以内の課題をフィルタリングして追加
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (String assignment : assignments) {
            try {
                // 課題文字列を分割して提出期限を取得
                String[] parts = assignment.split(" - ");
                String dueDateString = parts[1].trim();
                LocalDate dueDate = LocalDate.parse(dueDateString, formatter);
                // 提出期限が1週間以内の場合、subjectDetailsに追加
                if (!dueDate.isAfter(oneWeekLater)) {
                    subjectDetails.add(assignment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        bottomPanel.add(detailsLabel, BorderLayout.NORTH);
        bottomPanel.add(subjectDetails, BorderLayout.CENTER);
        
        // 全体のパネルに追加
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(bottomPanel, BorderLayout.CENTER);
        // 再描画を要求
        panel.invalidate();
        panel.validate();
        panel.repaint();
        
        return panel;
    }
}
