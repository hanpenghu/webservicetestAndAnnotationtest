package mypackage.CXFsClient.test.encapsulationClient;
import mypackage.CXFsClient.NetbarServices;
//其实应该用上面那个,上面的才是客户端,但是因为我写在了同一个项目中,所以,导致了2个冲突了
//注意上面那个用动态代理可以直接用,但是下面这个NetbarService2种方式都能调用
//具体原因是因为用网址生成的客户端NetbarServices里面方法上的那个className路径不对,修改了就好了
//注意,生成的客户端NetbarServices有些不必要的注解自己试着要删掉,否则运行不成功
//import mypackage.CXF.IServices.NetbarServices;
import mypackage.CXF.variable.VariableFromApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import utils.p;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//@Order(10)
@Component
public class GetNetbarServicesProxy {//类开始地方

    private static NetbarServices netbarServices;
//////////////变量常量开始////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Autowired
    private VariableFromApplication vpp;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostConstruct
    public  void init(){
       netbarServices= (NetbarServices)GetJaxWsProxyFactoryBean.gp()
               .setUser(vpp.usernamekey01,vpp.username01,vpp.passwordkey01,vpp.password01)
               .setClassType(NetbarServices.class)
               .setAddress(vpp.oppositeWebServiceAddress01)
               .createServie()
               .getServiceObj();
   }

    @Scheduled(fixedDelay = 12*1000)
//    @Test
    public void  g(){

        p.p(netbarServices.sayHello("hello!!"));

    }



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}//类结束地方
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////