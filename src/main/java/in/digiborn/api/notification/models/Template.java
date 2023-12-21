package in.digiborn.api.notification.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.Map;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "templates")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_templates")
    @SequenceGenerator(
        name = "seq_templates",
        allocationSize = 10,
        sequenceName = "seq_templates"
    )
    @Column(name = "template_id")
    private Long templateId;

    private String name;

    private String body;

    @Type(JsonType.class)
    @Column(name = "body_vars", columnDefinition = "jsonb")
    private Map<String, String> bodyVars;

}
