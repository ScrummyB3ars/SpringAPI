package hello.subscribers;

public class Subscriber {

    private final long id;
    private final String content;

    public Subscriber(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
