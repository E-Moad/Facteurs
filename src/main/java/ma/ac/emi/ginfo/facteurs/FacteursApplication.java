package ma.ac.emi.ginfo.facteurs;

import ma.ac.emi.ginfo.facteurs.centrepostal.CentrePostal;
import ma.ac.emi.ginfo.facteurs.centrepostal.CentrePostalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FacteursApplication  {

	@Autowired
	private CentrePostalRepository centrePostalRepository;
	public static void main(String[] args) {
		SpringApplication.run(FacteursApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		centrePostalRepository.save(
//				new CentrePostal(
//						"Centre Rabat",
//						null,
//						"rue de france",
//						"qu23",
//						"rabat"));
//		centrePostalRepository.save(
//				new CentrePostal(
//						"Centre Tanger",
//						null,
//						"Bnimakada",
//						"qu01",
//						"tanger"));
//		List<CentrePostal> centrePostalList = centrePostalRepository.findAll();
//		centrePostalList.forEach(cP -> System.out.println(cP.toString()));
//		System.out.println("*********************");
//		CentrePostal centrePostal = centrePostalRepository.findById(1).orElse(null);
//		if(centrePostal != null) {
//			System.out.println(centrePostal.getNom());
//		}
//	}
}
