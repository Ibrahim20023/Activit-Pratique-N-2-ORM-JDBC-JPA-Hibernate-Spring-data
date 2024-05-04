package ma.enset.spring_tp.service;

import jakarta.transaction.Transactional;
import ma.enset.spring_tp.entities.Consultation;
import ma.enset.spring_tp.entities.Medecin;
import ma.enset.spring_tp.entities.Patient;
import ma.enset.spring_tp.entities.RendezVous;
import ma.enset.spring_tp.repositories.ConsultationRepository;
import ma.enset.spring_tp.repositories.MedecinRepository;
import ma.enset.spring_tp.repositories.PatientRepository;
import ma.enset.spring_tp.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService{
    PatientRepository patientRepository;
    MedecinRepository medecinRepository;
    RendezVousRepository rendezVousRepository;
    ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient p) {
        return patientRepository.save(p);
    }

    @Override
    public Medecin saveMedecin(Medecin m) {
        return medecinRepository.save(m);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous r) {
        r.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(r);
    }

    @Override
    public Consultation saveConsultation(Consultation c) {
        return consultationRepository.save(c);
    }

    @Override
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public void deleteMedecinById(Long id) {
        medecinRepository.deleteById(id);
    }

    @Override
    public void deleteRendezVousById(String id) {
        rendezVousRepository.deleteById(id);
    }

    @Override
    public void deleteConsultationById(Long id) {
        consultationRepository.deleteById(id);
    }
}
