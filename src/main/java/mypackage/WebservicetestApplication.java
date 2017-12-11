package mypackage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *访问地址
 * http://localhost:8070/ws/countries.wsdl
 * cxf访问地址
 * http://localhost:8070/services/hanhan?wsdl
 * */
@EnableScheduling
@SpringBootApplication
public class WebservicetestApplication {

	public static void main(String[] args) {

		SpringApplication.run(WebservicetestApplication.class, args);
	}
}
