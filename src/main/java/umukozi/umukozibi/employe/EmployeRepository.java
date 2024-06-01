package umukozi.umukozibi.employe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long> {
    @Query(value="Select e.* from employe e where e.email =?1 LIMIT 1", nativeQuery = true)
    Optional<Employe> findEmployeByEmail(String email);

}
