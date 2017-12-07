package api.subscribers;

import org.hibernate.annotations.Table;
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
    private int facebook_id;

    @NotBlank
    private int age_group;

    public Subscriber() {
        id = null;
        facebook_id = 0;
        age_group = 0;
    }

    public Subscriber(Long id, int fb, int ag) {
        this.id = id;
        this.facebook_id = fb;
        this.age_group = ag;
    }

    public Long getId() {
        return id;
    }

    public int getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(int facebook_id) {
        this.facebook_id = facebook_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUser_type() {
        return age_group;
    }

    public void setUser_type(int age_group) {
        this.age_group = age_group;
    }
}
