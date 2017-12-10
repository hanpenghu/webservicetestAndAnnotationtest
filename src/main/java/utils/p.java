package utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class p {
    private String ads="";
    private StringBuffer sb=new StringBuffer();
    private List lin=new LinkedList();
    private List arl=new ArrayList();
    /**
     ****************************************************************************************
     * */
    /**
     *g得到s链式连接的字符串
     * */
    public String gad() {
        return ads;
    }

    /**
     * 先用gp得到一个新类,注意,一定要用gp得到new类,才能调用该方法
     *拼接字符串封装
     * 调用该方法链式增加字符串
     * 然后调用gad()得到结果
     * */
    public p sad(String str) {
        ads=sb.append(str).toString();
        return this;
    }

    @Test
    public void g(){
        String gad = p.gp().sad("韩寒").sad("梦如").gad();
        p.p(gad);//韩寒梦如
    }
    /**
     ****************************************************************************************
     * */
    /**
     *生成新类new封装
     * */

      public static p gp(){
          return new p();
      }


    /**
     *打印封装
     * */
        public static void p(Object o){
            System.out.println(o);
        }


    /**
     ****************************************************************************************
     * 生成linkedlist并装上东西
     * */
    public List getLin() {
        return lin;
    }

    public p setLin(Object o) {
        this.lin.add(o);
        return this;
    }

    @Test
    public void f(){
        List lin = p.gp().setLin(1).setLin(2).setLin(3).getLin();
        p.p(lin);//[1,2,3]
    }
    /**
     ****************************************************************************************
     * 生成arraylist并装上东西
     * */
    public List getArl() {
        return arl;
    }

    public p setArl(Object o) {
        this.arl.add(o);
        return this;
    }
    @Test
    public void f1(){
        List arl = p.gp().setArl(11).setArl(22).setArl(33).getArl();
        p.p(arl);////[11,22,33]

    }
    /**
     ****************************************************************************************
     * */


    /**
     ****************************************************************************************
     * */
}
/**
 ****************************************************************************************
 * */