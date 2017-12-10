package mypackage.CXF.interceptor;


import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.invoker.BeanInvoker;
import org.w3c.dom.NodeList;

/**
 * webservice权限拦截器
 * <p>
 *  根据用户名和密码进行拦截
 * </p>
 * @author zhaic
 * @since jdk1.6
 * 2016年6月22日
 *
 */
public class AuthInterceptor02 extends AbstractPhaseInterceptor<SoapMessage> {
    private static final String USER_NAME = "admin";

    private static final String USER_PASSWORD = "123";
    private SAAJInInterceptor saa = new SAAJInInterceptor();
    public AuthInterceptor02() {
        super(Phase.PRE_PROTOCOL); // 注意这个配置是拦截器被触发的阶段不能错
        getAfter().add(SAAJInInterceptor.class.getName());
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        // 获取到当前服务的接口名称,这里如果不需要也可以不要，我这里纯属是为了解决我们自己的业务问题
        Exchange exchange = message.getExchange();
        Service service = exchange.get(Service.class);
        Class<?>[] interfaces = ((BeanInvoker)service.getInvoker()).getServiceObject(exchange).getClass().getInterfaces();

        SOAPMessage mess = message.getContent(SOAPMessage.class);
        if (mess == null) {
            saa.handleMessage(message);
            mess = message.getContent(SOAPMessage.class);
        }

        SOAPHeader head = null;
        try {
            head = mess.getSOAPHeader();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (head == null) {
            return;
        }

        NodeList loginNameNodes = head.getElementsByTagName("username");
        NodeList passwordNodes = head.getElementsByTagName("password");
        if((null == loginNameNodes || loginNameNodes.getLength() == 0)
                || (null == passwordNodes || passwordNodes.getLength() == 0)) { // 以下边这种方式抛出异常可以被客户端接到
            SOAPException soapExc = new SOAPException("loginName and password can not null!");
            throw new Fault(soapExc);
        }
        String loginName = loginNameNodes.item(0).getTextContent();
        String password = passwordNodes.item(0).getTextContent();
        boolean validateResult = validateAuth(interfaces, loginName, password);
        if (validateResult) {
            SOAPException soapExc = new SOAPException("authentication failed!");
            throw new Fault(soapExc);
        } else {
            SOAPException soapExc = new SOAPException("webservice authentication error!");
            throw new Fault(soapExc);
        }
    }

    /**
     * 校验用户权限
     * @param clazzs 用户发布的服务类所实现的接口列表
     * @param loginName
     * @param password
     * @return
     */
    private boolean validateAuth(Class<?>[] clazzs, String loginName, String password) {
        // 这里写相关的权限校验代码
        if(USER_NAME.equals(loginName)&&USER_PASSWORD.equals(password)){
            return true;
        }else{
            return false;
        }
    }
}
