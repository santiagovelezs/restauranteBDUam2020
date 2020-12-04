package uam.bd.restaurante.BD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uam.bd.restaurante.model.Repartidor;

@SpringBootApplication
public class BdApplication {

	public static void main(String[] args) {
		SpringApplication.run(BdApplication.class, args);
		Repartidor re=new Repartidor("esta es mi cedula", "este es mi nombre", "este es mi apellido", "este es mi email", "este es mi telefono");
		System.out.println(re.getNombre()+re.getCedula());
	}
    
}
