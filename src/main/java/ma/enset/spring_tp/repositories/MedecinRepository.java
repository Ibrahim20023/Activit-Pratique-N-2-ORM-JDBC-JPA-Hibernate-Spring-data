package ma.enset.spring_tp.repositories;

import ma.enset.spring_tp.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findMedecinByNom(String name);
}
