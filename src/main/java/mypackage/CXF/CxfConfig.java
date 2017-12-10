package mypackage.CXF;

import mypackage.CXF.IServices.NetbarServices;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;
/**
 *http://localhost:8070/services/hanhan?wsdl
 * 为访问接口
 * */
@Configuration
public class CxfConfig {
    @Autowired
    private Bus bus;
    @Autowired
    private NetbarServices netbarServices;

    @Bean
    public Endpoint endpoint01() {
        EndpointImpl endpoint = new EndpointImpl(bus,netbarServices);
        endpoint.publish("/hanhan01");//接口发布在 /hanhan 目录下
        return endpoint;
    }
    @Bean
    public Endpoint endpoint02() {
        EndpointImpl endpoint = new EndpointImpl(bus,netbarServices);
        endpoint.publish("/hanhan02");//接口发布在 /hanhan 目录下
        return endpoint;
    }
}