package ma.enset.spring_tp.repositories;

import ma.enset.spring_tp.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
