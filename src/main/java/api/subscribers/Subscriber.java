package api.subscribers;

import javafx.beans.DefaultProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@javax.persistence.Table(name = "subscribers")
public class Subscriber {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String facebook_id;


    private Integer age_group_id;

    public Subscriber() {
        id = null;
        facebook_id = null;
        age_group_id = 0;
    }

    public Subscriber(Long id, String fb, int ag) {
        this.id = id;
        this.facebook_id = fb;
        this.age_group_id = ag;
    }

    public Long getId() {
        return id;
    }

    public String getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(String facebook_id) {
        this.facebook_id = facebook_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge_group_id() {
        return age_group_id;
    }

    public void setAge_group_id(int age_group_id) {
        this.age_group_id = age_group_id;
    }
}
