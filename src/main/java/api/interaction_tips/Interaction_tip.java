package api.interaction_tips;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@javax.persistence.Table(name = "interaction_tips")
public class Interaction_tip {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String tip_content;
    @NotBlank
    private Integer add_rich_language;
    @NotBlank
    private Integer type_id;

    public Interaction_tip() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTip_content() {
        return tip_content;
    }

    public void setTip_content(String tip_content) {
        this.tip_content = tip_content;
    }

    public Integer getAdd_rich_language() {
        return add_rich_language;
    }

    public void setAdd_rich_language(Integer add_rich_language) {
        this.add_rich_language = add_rich_language;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }
}
