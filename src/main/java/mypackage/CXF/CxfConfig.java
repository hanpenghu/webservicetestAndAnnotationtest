package mypackage.CXF;

import mypackage.CXF.IServices.NetbarServices;
import mypackage.CXF.interceptor.AuthInterceptor;
import mypackage.CXF.interceptor.AuthInterceptor02;
import org.apache.cxf.Bus;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;
/**
 *http://localhost:8070/hanhan/hanhan01?wsdl
 * 为访问接口
 * */
@Configuration
public class CxfConfig {
    @Autowired
    private Bus bus;
    @Autowired
    private NetbarServices netbarServices;

    //必须要有,相当于路径限定

    @Bean

    public ServletRegistrationBean cxfServlet(){

        return new ServletRegistrationBean(new CXFServlet(),"/hanhan/*");

    }


    @Bean
    public Endpoint endpoint01() {
        EndpointImpl endpoint = new EndpointImpl(bus,netbarServices);
        endpoint.publish("/hanhan01");//接口发布在 /hanhan 目录下
        //打印报文日志拦截器

        endpoint.getInInterceptors().add(new LoggingInInterceptor());

        endpoint.getInInterceptors().add(new LoggingOutInterceptor());

        //通过拦截器校验用户名与密码

        endpoint.getInInterceptors().add(new AuthInterceptor());
        return endpoint;
    }
    @Bean
    public Endpoint endpoint02() {
        EndpointImpl endpoint = new EndpointImpl(bus,netbarServices);
        endpoint.publish("/hanhan02");//接口发布在 /hanhan 目录下
        //打印报文日志拦截器

        endpoint.getInInterceptors().add(new LoggingInInterceptor());

        endpoint.getInInterceptors().add(new LoggingOutInterceptor());
        //通过拦截器校验用户名与密码

        endpoint.getInInterceptors().add(new AuthInterceptor());

        return endpoint;
    }
}