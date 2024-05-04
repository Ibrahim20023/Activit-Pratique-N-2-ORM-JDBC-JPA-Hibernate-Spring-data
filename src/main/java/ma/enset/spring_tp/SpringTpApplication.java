package ma.enset.spring_tp;

import ma.enset.spring_tp.entities.*;


import ma.enset.spring_tp.repositories.MedecinRepository;
import ma.enset.spring_tp.repositories.PatientRepository;


import ma.enset.spring_tp.repositories.RendezVousRepository;
import ma.enset.spring_tp.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringTpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTpApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            IHospitalService hospitalService,
            PatientRepository patientRepository,
            MedecinRepository medecinRepository,
            RendezVousRepository rendezVousRepository){
        return args -> {
            Stream.of("Sara","Bilal", "Ibrahim").forEach(name ->
                    {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        patient.setScore(7);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("Zaim","Sajai", "Massine").forEach(name ->
            {
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setEmail("email@gmail.com");
                medecin.setSpecialite("Pediatre");

                hospitalService.saveMedecin(medecin);
            });

            Patient patient = patientRepository.findByNom("Ibrahim");

            Medecin medecin = medecinRepository.findMedecinByNom("Zaim");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            RendezVous saveRDV = hospitalService.saveRendezVous(rendezVous);
            System.out.println(saveRDV.getId());

            RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);

            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRapport("rapport");
            consultation.setRendezVous(rendezVous1);
            hospitalService.saveConsultation(consultation);


        };
    }
    
}