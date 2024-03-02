package in.digiborn.api.notification.models.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.Set;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "templates")
public class TemplateEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_templates")
    @SequenceGenerator(
        name = "seq_templates",
        allocationSize = 10,
        sequenceName = "seq_templates"
    )
    @Column(name = "template_id")
    private Long templateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "template_owner_id",
        foreignKey = @ForeignKey(name = "fk_template_owner_id")
    )
    private ClientEntity templateOwner;

    private String name;

    private String body;

    @Type(JsonType.class)
    @Column(name = "body_vars", columnDefinition = "jsonb")
    private Set<String> bodyVars;

}
