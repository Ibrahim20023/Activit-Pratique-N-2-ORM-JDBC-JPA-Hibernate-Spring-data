package ma.enset.spring_tp.service;

import ma.enset.spring_tp.entities.Consultation;
import ma.enset.spring_tp.entities.Medecin;
import ma.enset.spring_tp.entities.Patient;
import ma.enset.spring_tp.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient p);
    Medecin saveMedecin(Medecin m);
    RendezVous saveRendezVous(RendezVous r);
    Consultation saveConsultation(Consultation c);
    void deletePatientById(Long id);
    void deleteMedecinById(Long id);
    void deleteRendezVousById(String id);
    void deleteConsultationById(Long id);
}
