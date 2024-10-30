// 命令基類，定義了通用的命令介面。
abstract class Command {
    protected Application app;
    protected Editor editor;
    protected String backup;

    // 建構子，接收應用程式和編輯器的物件。
    public Command(Application app, Editor editor) {
        this.app = app;
        this.editor = editor;
    }

    // 儲存編輯器的狀態，以便後續進行撤銷。
    protected void saveBackup() {
        backup = editor.getText();
    }

    // 撤銷方法，恢復編輯器的狀態。
    public void undo() {
        editor.setText(backup);
    }

    // 抽象方法，強制子類提供自己的執行邏輯。
    public abstract boolean execute();
}

// 複製命令，將選取的文字存入剪貼簿。
class CopyCommand extends Command {
    public CopyCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public boolean execute() {
        app.clipboard = editor.getSelection();
        return false; // 不儲存於歷史記錄，因為狀態未改變。
    }
}

// 剪切命令，將選取的文字存入剪貼簿並刪除它。
class CutCommand extends Command {
    public CutCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public boolean execute() {
        saveBackup();
        app.clipboard = editor.getSelection();
        editor.deleteSelection();
        return true; // 儲存於歷史記錄，因為狀態改變。
    }
}

// 貼上命令，將剪貼簿中的內容插入到編輯器。
class PasteCommand extends Command {
    public PasteCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public boolean execute() {
        saveBackup();
        editor.replaceSelection(app.clipboard);
        return true; // 儲存於歷史記錄。
    }
}

// 撤銷命令，從歷史記錄中取出並撤銷最近的操作。
class UndoCommand extends Command {
    public UndoCommand(Application app) {
        super(app, null);
    }

    @Override
    public boolean execute() {
        app.undo();
        return false; // 撤銷不儲存於歷史記錄。
    }
}

// 編輯器類別，包含文字編輯的基本操作。
class Editor {
    private String text = "";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSelection() {
        // 假設返回選取的文字。
        return text; // 這裡簡化為返回整個文字。
    }

    public void deleteSelection() {
        text = ""; // 簡化為刪除所有文字。
    }

    public void replaceSelection(String content) {
        text = content; // 簡化為用內容取代文字。
    }
}

// 全域指令歷史記錄，實作為堆疊。
class CommandHistory {
    private final java.util.Stack<Command> history = new java.util.Stack<>();

    public void push(Command command) {
        history.push(command);
    }

    public Command pop() {
        return history.isEmpty() ? null : history.pop();
    }
}

// 應用程式類別，管理指令與編輯器的互動。
class Application {
    public String clipboard;
    public Editor activeEditor = new Editor();
    public CommandHistory history = new CommandHistory();

    // 建立 UI，綁定按鈕與指令。
    public void createUI() {
        // 綁定按鈕與對應的指令。
        executeCommand(new CopyCommand(this, activeEditor));
        executeCommand(new CutCommand(this, activeEditor));
        executeCommand(new PasteCommand(this, activeEditor));
        executeCommand(new UndoCommand(this));
    }

    // 執行指令並根據需要儲存到歷史記錄。
    public void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }

    // 撤銷最近的指令。
    public void undo() {
        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }
}

// 客戶端程式碼，展示如何使用命令模式。
public class Main {
    public static void main(String[] args) {
        Application app = new Application();
        app.activeEditor.setText("Hello, World!");

        System.out.println("初始文字: " + app.activeEditor.getText());

        // 執行複製、剪切、貼上和撤銷指令。
        app.executeCommand(new CopyCommand(app, app.activeEditor));
        app.executeCommand(new CutCommand(app, app.activeEditor));
        System.out.println("剪切後文字: " + app.activeEditor.getText());

        app.executeCommand(new PasteCommand(app, app.activeEditor));
        System.out.println("貼上後文字: " + app.activeEditor.getText());

        app.undo();
        System.out.println("撤銷後文字: " + app.activeEditor.getText());
    }
}
// 創建者類聲明的工廠方法必須返回一個產品類的物件。創建者的子類通常會提供該方法的實現。
abstract class Dialog {

    // 創建者還可提供一些工廠方法的默認實現。
    abstract Button createButton();

    // 請注意，創建者的主要職責並非是創建產品。其中通常會包含一些核心業務邏輯，
    // 這些邏輯依賴於由工廠方法返回的產品物件。子類可通過重寫工廠方法並使其返回
    // 不同類型的產品來間接修改業務邏輯。
    public void render() {
        // 調用工廠方法創建一個產品物件。
        Button okButton = createButton();
        // 現在使用產品。
        okButton.onClick(this::closeDialog);
        okButton.render();
    }

    // 假設這是一個對話方塊關閉的具體實現。
    private void closeDialog() {
        System.out.println("關閉對話方塊");
    }
}

// 具體創建者將重寫工廠方法以改變其所返回的產品類型。
class WindowsDialog extends Dialog {
    @Override
    Button createButton() {
        return new WindowsButton();
    }
}

class WebDialog extends Dialog {
    @Override
    Button createButton() {
        return new HTMLButton();
    }
}

// 產品介面中將聲明所有具體產品都必須實現的操作。
interface Button {
    void render();
    void onClick(Runnable action);
}

// 具體產品需提供產品介面的各種實現。
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("根據 Windows 樣式渲染按鈕");
    }

    @Override
    public void onClick(Runnable action) {
        System.out.println("綁定本地作業系統點擊事件");
        action.run();
    }
}

class HTMLButton implements Button {
    @Override
    public void render() {
        System.out.println("返回一個按鈕的 HTML 表述");
    }

    @Override
    public void onClick(Runnable action) {
        System.out.println("綁定網路流覽器的點擊事件");
        action.run();
    }
}

class Application {
    private Dialog dialog;

    // 程式根據當前配置或環境設定選擇創建者的類型。
    public void initialize() {
        String config = readApplicationConfigFile();

        if ("Windows".equalsIgnoreCase(config)) {
            dialog = new WindowsDialog();
        } else if ("Web".equalsIgnoreCase(config)) {
            dialog = new WebDialog();
        } else {
            throw new RuntimeException("錯誤！未知的作業系統。");
        }
    }

    private String readApplicationConfigFile() {
        // 模擬讀取設定檔，這裡返回 "Windows" 或 "Web"。
        return "Windows";  // 修改為 "Web" 可模擬不同環境。
    }

    // 當前用戶端代碼會與具體創建者的實例進行交互，但是必須通過其基本介面進行。
    public void main() {
        this.initialize();
        dialog.render();
    }
}

// 運行示例
public class Main {
    public static void main(String[] args) {
        Application app = new Application();
        app.main();
    }
}
