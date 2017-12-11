package mypackage.CXF.variable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)//1可以保证变量第一个被加载进来
@Component("vpp")
public class VariableFromApplication {
    @Value("${oppositeWebServiceAddress01}")
    public String oppositeWebServiceAddress01;

    @Value("${usernamekey01}")
    public String  usernamekey01;

    @Value("${username01}")
    public String username01;

    @Value("${passwordkey01}")
    public String passwordkey01;

    @Value("${password01}")
    public  String password01;
}
