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


}
