package com.example.patientsmvc;

import com.example.patientsmvc.entities.Patient;
import com.example.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.method.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }
//@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(
                    new Patient(null, "Hiba ",new Date(),false,124));
            patientRepository.save(
                    new Patient(null, "Youssef ",new Date(),false,124));
            patientRepository.save(
                    new Patient(null, "Adam ",new Date(),true,104));
            patientRepository.save(
                    new Patient(null, "Mehdi ",new Date(),true,121));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
                    });



        };
    }
@Bean
     PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
  }
}
