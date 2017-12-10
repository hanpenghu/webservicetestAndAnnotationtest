package testAnnotation;

import utils.P;

@author
public class TestAnn {

    /**
     *内部类
     * */
    @author(name="刘梦好",age=22)
    class TestAnn1{

    }


    /**
     *属性
     * */
      @author(name="垃圾",age=999)
      public String name;
    @author(name="private垃圾",age=9990)
      private int age;
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[]args){
        /**
         *得到类上的注解,使用默认值
         * */
        author ator = TestAnn.class.getAnnotation(author.class);
        P.p(ator.name());//打印
        P.p(ator.age());
        /**
         *得到内部类上的注解,使用自定义值
         * */
        author at=TestAnn1.class.getAnnotation(author.class);
        P.p(at.name());
        P.p(at.age());
        try {
            /**
             *得到 public 属性上的注解
             * */
            author ato=TestAnn.class.getField("name").getAnnotation(author.class);
            P.p(ato.age());
            P.p(ato.name());
            /**
             *得到 private 属性上的注解
             * */
            author atoh = TestAnn.class.getDeclaredField("age").getAnnotation(author.class);
            P.p(atoh.name());
            P.p(atoh.age());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////