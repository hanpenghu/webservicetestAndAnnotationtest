package mypackage.CXFsClient.test;

import mypackage.CXF.IServices.NetbarServices;
import mypackage.CXFsClient.NetbarServices_Service;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.jupiter.api.Test;

public class TestOfClient {

    /**
     * 方式1.代理类工厂的方式,需要拿到对方的接口
     */
    @Test
    public void f2(){
        try {
            // 接口地址
            String address = "http://localhost:8070/hanhan/hanhan01?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            AuthorityParameter param = new AuthorityParameter
                    ("username", "admin",
                            "password", "123");

//            jaxWsProxyFactoryBean.getInInterceptors()
//                    .add(new AuthorityHeaderInterceptor(param));
            jaxWsProxyFactoryBean.getOutInterceptors().add(new AuthorityHeaderInterceptor(param));
//            jaxWsProxyFactoryBean.getInInterceptors()
//                    .add(new ClientLoginInterceptor("admin","123"));

            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(NetbarServices.class);


            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 创建一个代理接口实现
            NetbarServices cs = (NetbarServices) jaxWsProxyFactoryBean.create();
            // 数据准备
            String userName = "Leftso";
            // 调用代理接口的方法调用并返回结果
            String result = cs.sayHello(userName);
            System.out.println("返回结果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 动态调用方式
     * 使用动态调用方式要注意的就是，如果调用的服务接口返回的是一个自定义对象，
     * 那么结果Object[]中的数据类型就成了这个自定义对象(组件帮你自动生成了这个对象)，
     * 但是你本地可能并没有这个类，所以需要自行转换处理，
     * 最简单的是新建一个跟返回结果一模一样的类进行强转，当然更好的方式是封装一个通用的。
     */
    @Test
    public void f1(){
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8070/hanhan/hanhan02?wsdl");
        // 需要密码的情况需要加上用户名和密码,这个可以
//         client.getOutInterceptors().add(new ClientLoginInterceptor("admin","123"));
////下面的也可以
        AuthorityParameter param = new AuthorityParameter
                ("username", "admin",
                        "password", "123");
        client.getOutInterceptors().add(new AuthorityHeaderInterceptor(param));


        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("sayHello", "Leftso");
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }



}
