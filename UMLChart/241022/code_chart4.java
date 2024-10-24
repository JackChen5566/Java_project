// 「抽象部分」定義控制部分的介面，它管理一個指向「實作部分」的物件引用，並將所有實際工作委派給該物件。
class RemoteControl {
    protected Device device;

    // 建構子，接收一個 Device 物件。
    public RemoteControl(Device device) {
        this.device = device;
    }

    // 開關電源的方法。
    public void togglePower() {
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    // 切換到下一個頻道。
    public void nextChannel() {
        device.setChannel(device.getChannel() + 1);
    }
}

// 「抽象部分」的進階擴展，提供額外的功能。
class AdvancedRemoteControl extends RemoteControl {
    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    // 靜音功能。
    public void mute() {
        device.setVolume(0);
    }
}

// 「實作部分」介面，定義了所有裝置的共用方法。
interface Device {
    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int percent);

    int getChannel();

    void setChannel(int channel);
}

// TV 的具體實作。
class Tv implements Device {
    private boolean enabled = false;
    private int volume = 50;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        enabled = true;
        System.out.println("TV 已啟用");
    }

    @Override
    public void disable() {
        enabled = false;
        System.out.println("TV 已關閉");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        volume = percent;
        System.out.println("TV 音量設為: " + volume);
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("TV 頻道切換至: " + channel);
    }
}

// Radio 的具體實作。
class Radio implements Device {
    private boolean enabled = false;
    private int volume = 30;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        enabled = true;
        System.out.println("Radio 已啟用");
    }

    @Override
    public void disable() {
        enabled = false;
        System.out.println("Radio 已關閉");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        volume = percent;
        System.out.println("Radio 音量設為: " + volume);
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("Radio 頻道切換至: " + channel);
    }
}

// 客戶端代碼
public class Application {
    public static void main(String[] args) {
        // 使用 TV 控制器
        Device tv = new Tv();
        RemoteControl tvRemote = new RemoteControl(tv);
        tvRemote.togglePower();
        tvRemote.nextChannel();

        // 使用 Radio 和進階控制器
        Device radio = new Radio();
        AdvancedRemoteControl radioRemote = new AdvancedRemoteControl(radio);
        radioRemote.togglePower();
        radioRemote.mute();
    }
}
