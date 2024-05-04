package ma.enset.spring_tp.repositories;

import ma.enset.spring_tp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNom(String key);
    @Query("select p from Patient p where p.nom like :x")
    List<Patient> search(@Param("x") String mc);
    void deleteById(Long id);
}
