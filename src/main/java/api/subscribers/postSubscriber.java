package api.subscribers;

public class postSubscriber {
    private String facebook_id;
    private String age_group;
    private String timestamp;

    public String getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(String facebook_id) {
        this.facebook_id = facebook_id;
    }

    public String getAge_group() {
        return age_group;
    }

    public void setAge_group(String age_group) {
        this.age_group = age_group;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public postSubscriber() {
    }
}
