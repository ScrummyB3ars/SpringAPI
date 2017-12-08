package api.theme_tips;
import org.hibernate.annotations.Table;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@javax.persistence.Table(name = "theme_tips")
public class Theme_tip {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String picture;
    @NotBlank
    private String tip_content;
    @NotBlank
    private String rich_language;
    @NotBlank
    private String circumstances;
    @NotBlank
    private String ZILL_goal;
    @NotBlank
    private String development_goal;
    @NotBlank
    private Integer themes_id;
    @NotBlank
    private Integer age_group_id;

    public Theme_tip() {
    }

    public Theme_tip(String picture, String tip_content, String rich_language, String circumstances, String ZILL_goal, String development_goal, int themes_id, int age_group_id) {
        this.picture = picture;
        this.tip_content = tip_content;
        this.rich_language = rich_language;
        this.circumstances = circumstances;
        this.ZILL_goal = ZILL_goal;
        this.development_goal = development_goal;
        this.themes_id = themes_id;
        this.age_group_id = age_group_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTip_content() {
        return tip_content;
    }

    public void setTip_content(String tip_content) {
        this.tip_content = tip_content;
    }

    public String getRich_language() {
        return rich_language;
    }

    public void setRich_language(String rich_language) {
        this.rich_language = rich_language;
    }

    public String getCircumstances() {
        return circumstances;
    }

    public void setCircumstances(String circumstances) {
        this.circumstances = circumstances;
    }

    public String getZILL_goal() {
        return ZILL_goal;
    }

    public void setZILL_goal(String ZILL_goal) {
        this.ZILL_goal = ZILL_goal;
    }

    public String getDevelopment_goal() {
        return development_goal;
    }

    public void setDevelopment_goal(String development_goal) {
        this.development_goal = development_goal;
    }

    public int getThemes_id() {
        return themes_id;
    }

    public void setThemes_id(int themes_id) {
        this.themes_id = themes_id;
    }

    public int getAge_group_id() {
        return age_group_id;
    }

    public void setAge_group_id(int age_group_id) {
        this.age_group_id = age_group_id;
    }
}
