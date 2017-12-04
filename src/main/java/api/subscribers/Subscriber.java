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
    private int user_type;

    public Subscriber() {
        id = null;
        facebook_id = 0;
        user_type = 0;
    }

    public Subscriber(Long id, int fb, int ut) {
        this.id = id;
        this.facebook_id = fb;
        this.user_type = ut;
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
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }
}
