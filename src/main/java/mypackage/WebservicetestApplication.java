package mypackage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 *访问地址
 * http://localhost:8070/ws/countries.wsdl
 * cxf访问地址
 * http://localhost:8070/services/hanhan?wsdl
 * */
@SpringBootApplication
public class WebservicetestApplication {

	public static void main(String[] args) {

		SpringApplication.run(WebservicetestApplication.class, args);
	}
}
