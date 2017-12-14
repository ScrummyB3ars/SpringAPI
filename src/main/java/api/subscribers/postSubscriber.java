package api.subscribers;

public class postSubscriber {
    private String facebook_id;
    private Integer age_group;

    public String getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(String facebook_id) {
        this.facebook_id = facebook_id;
    }

    public Integer getAge_group() {
        return age_group;
    }

    public void setAge_group(Integer age_group) {
        this.age_group = age_group;
    }


    public postSubscriber() {
    }
}
