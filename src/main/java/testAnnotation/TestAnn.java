package testAnnotation;

import utils.p;

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
        p.p(ator.name());//打印
        p.p(ator.age());
        /**
         *得到内部类上的注解,使用自定义值
         * */
        author at=TestAnn1.class.getAnnotation(author.class);
        p.p(at.name());
        p.p(at.age());
        try {
            /**
             *得到 public 属性上的注解
             * */
            author ato=TestAnn.class.getField("name").getAnnotation(author.class);
            p.p(ato.age());
            p.p(ato.name());
            /**
             *得到 private 属性上的注解
             * */
            author atoh = TestAnn.class.getDeclaredField("age").getAnnotation(author.class);
            p.p(atoh.name());
            p.p(atoh.age());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////