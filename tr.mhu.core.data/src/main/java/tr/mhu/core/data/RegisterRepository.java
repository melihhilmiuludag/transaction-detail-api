package tr.mhu.core.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tr.mhu.core.domain.entites.Register;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author muludag on 13.09.2020
 */
public interface RegisterRepository extends JpaRepository<Register, String> {
	Optional<Register> findById(String id);

	@Query(" SELECT r " +
			"  FROM Register r " +
			"  Where " +
			"  r.expireDate <= :date" +
			"  and r.id = :id" )
	Optional<Register> getRegister(@Param("id") String id, @Param("date") LocalDateTime date);
}
