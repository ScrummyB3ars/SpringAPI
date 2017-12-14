package api.subscribers;

public class postSubscriber {
    private String facebook_id;
    private Integer age_group_id;

    public String getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(String facebook_id) {
        this.facebook_id = facebook_id;
    }

    public Integer getAge_group_id() {
        return age_group_id;
    }

    public void setAge_group_id(Integer age_group) {
        this.age_group_id = age_group;
    }


    public postSubscriber() {
    }
}
