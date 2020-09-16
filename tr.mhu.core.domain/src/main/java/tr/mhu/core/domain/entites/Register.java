package tr.mhu.core.domain.entites;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author muludag on 13.09.2020
 */
@Data
@Entity
@Table(name = "REGISTER")
public class Register {
	@Id
	@NotNull
	@NotEmpty
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Length(min = 36, max = 36)
	@Column(name = "ID", nullable = false)
	private String id;

	@NotNull
	@NotEmpty
	@Length(min = 1, max = 1024)
	@Column(name = "TOKEN", nullable = false)
	private String token;

	@NotNull
	@NotEmpty
	@Length(min = 1, max = 50)
	@Column(name = "SYSTEM_NAME", nullable = false)
	private String systemName;

	@NotNull
	@Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
	@Column(name = "CREATED_DATE", nullable = false)
	private LocalDateTime createdDate;

	@NotNull
	@Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
	@Column(name = "EXPIRE_DATE", nullable = false)
	private LocalDateTime expireDate;
}
