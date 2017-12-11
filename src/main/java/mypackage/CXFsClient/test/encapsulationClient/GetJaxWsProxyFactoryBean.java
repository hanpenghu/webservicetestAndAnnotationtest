package mypackage.CXFsClient.test.encapsulationClient;
import mypackage.CXFsClient.test.AuthorityHeaderInterceptor;
import mypackage.CXFsClient.test.AuthorityParameter;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;


public class GetJaxWsProxyFactoryBean {

    private JaxWsProxyFactoryBean j=new JaxWsProxyFactoryBean();

    private Object serviceObj;

    public static GetJaxWsProxyFactoryBean gp(){
        return new GetJaxWsProxyFactoryBean();
    }

    public GetJaxWsProxyFactoryBean setUser(String usernamekey,String usernamevalue,String passwordkey,String passwordvalue){
        AuthorityParameter param = new AuthorityParameter(usernamekey, usernamevalue, passwordkey, passwordvalue);
        j.getOutInterceptors().add(new AuthorityHeaderInterceptor(param));
        return this;
    }

    public GetJaxWsProxyFactoryBean setClassType(Class clazz){
        // 设置接口类型
        j.setServiceClass(clazz);
        return this;
    }

    public GetJaxWsProxyFactoryBean setAddress(String addr){
        j.setAddress(addr);
        return this;
    }

    public GetJaxWsProxyFactoryBean createServie(){
        serviceObj = j.create();
        return this;
    }

    public Object getServiceObj(){
        return serviceObj;
    }

}
