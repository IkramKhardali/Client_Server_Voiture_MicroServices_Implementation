package ma.khardali.voiture;

import ma.khardali.voiture.Model.Client;
import ma.khardali.voiture.Model.Voiture;
import ma.khardali.voiture.Repository.VoitureRepository;
import ma.khardali.voiture.Service.ClientServiceVoiture;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.Transient;

@SpringBootApplication
public class VoitureApplication {

    @Bean
    public CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientServiceVoiture clientServiceVoiture){

        return args -> {
            Client c1 = clientServiceVoiture.clientById(2L);
            Client c2 = clientServiceVoiture.clientById(1L);
            System.out.println("**************************");
            System.out.println("Id est :" + c2.getId());
            System.out.println("Nom est :" + c2.getNom());
            System.out.println("**************************");
            System.out.println("**************************");
            System.out.println("Id est :" + c1.getId());
            System.out.println("Nom est :" + c1.getNom());
            System.out.println("Nom est :" + c1.getAge());
            System.out.println("**************************");
            voitureRepository.save(new Voiture(Long.parseLong("1"), "Toyota", "A 25 333", "Corolla", 1L, c2));
            voitureRepository.save(new Voiture(Long.parseLong("2"), "Renault", "B 6 3456", "Megane", 1L, c2));
            voitureRepository.save(new Voiture(Long.parseLong("3"), "Peugeot", "A 55 4444", "301", 2L, c1));
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(VoitureApplication.class, args);
    }
}
