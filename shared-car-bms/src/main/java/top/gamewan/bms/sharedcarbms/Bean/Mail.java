package top.gamewan.bms.sharedcarbms.Bean;

public class Mail {
    private String toAddress;
    private String title;
    private String content;

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }
}
