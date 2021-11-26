package pers.hao.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.hao.bean.Car;
import pers.hao.bean.Person;

/**
 * @author hao
 */
public class IOCTest {
    /**
     * 存在的几个问题：
     * 1）src源码包开始的路径，称为类路径(classpath)的开始
     *   所有源码包里面的东西都会被合并放在类路径里面
     *   java: /bin/
     *   web: /WEB-INF/classes
     * 2）导包commons-logging-1.1.2.jar(依赖)
     * 3）先导包再创建配置文件
     */

    /**
     * 几个细节：
     * 1）ApplicationContext(IOC容器的接口)
     * 2）给容器注册一个组件，我们也从容器中按照id拿到了这个组件的对象？
     *    =>组件的创建工作，由容器完成
     *    =>容器中对象的创建在容器创建完成时就已经创建好了 new ClassPathXmlApplicationContext("ioc.xml")
     * 3）同一个组件在ioc容器中是单实例的；组件在容器启动完成之前都已经创建准备好
     * 4）容器中没有这个组件？ =>会报异常
     * 5）ioc容器在创建这个组件对象的时候，(property)会利用setter方法为javaBean的属性进行赋值
     * 6）javaBean的属性名由什么决定的？getter/setter方法是属性名，即set后面那串小写字母
     *    并非是声明的属性名；建议所有的getter/setter方法自动生成；
     */

    /**
     * 根据Spring的配置文件得到ioc容器对象
     */
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc3.xml");

    /**
     * 从容器中拿到这个组件
     */
    @Test
    public void test01() {
        //ApplicationContext: 代表ioc容器
        //ClassPathXmlApplicationContext: 当前应用的xml配置文件在ClassPath下
        Person bean01 = (Person) ioc.getBean("person01");
        Object aBean01 = ioc.getBean("person01");
        System.out.println(bean01);
        System.out.println(bean01 == aBean01);

        System.out.println("===============================");
        //Person bean03 = (Person) ioc.getBean("person03");
    }

    /**
     * => 根据bean的类型从IOC容器中获取bean的实例
     * 如果ioc容器中这个类型的bean有多个，查找就会报错
     */
    @Test
    public void test02() {
        //Person bean = ioc.getBean(Person.class);
        //System.out.println(bean);

        Person person01 = ioc.getBean("person01", Person.class);
        System.out.println(person01);

        Person person03 = ioc.getBean("person03", Person.class);
        System.out.println(person03);

        Person person04 = ioc.getBean("person04", Person.class);
        System.out.println(person04);
    }

    /**
     * =>正确的为各种属性赋值
     * 测试使用null值、引用类型默认是null；基本类型是默认值
     * 引用类型赋值(引用其他bean、引用内部bean)（测试）
     */
    @Test
    public void test03() {
        Person person01 = (Person) ioc.getBean("person01");
        System.out.println(person01.getLastName());
        System.out.println(person01.getCar());
        System.out.println(person01.getCar() == ioc.getBean("car01"));

        Car car01 = ioc.getBean("car01", Car.class);
        car01.setCarName("Motrix");
        System.out.println(person01.getCar());
    }

    @Test
    public void test04() {
        Person person01 = ioc.getBean("person01", Person.class);
        System.out.println(person01.getCar());
        Person person02 = ioc.getBean("person02", Person.class);
        System.out.println(person02);

        System.out.println("=====================================");
        System.out.println(person02.getProperties());
    }

    @Test
    public void test05() {
        Person person03 = ioc.getBean("person03", Person.class);
        System.out.println(person03.getMaps());
        Object myMap = ioc.getBean("myMap");
        System.out.println(myMap.getClass());
    }

    /**
     * 级联属性可以修改属性的属性。注意：原来的bean值可能会被修改
     */
    @Test
    public void test06()  {
        Person person04 = (Person) ioc.getBean("person04");
        Object car01 = ioc.getBean("car01");
        System.out.println("容器中的car：" + car01);
        System.out.println("Person中的car：" + person04.getCar());
    }

    /**
     * 抽象Bean不能被获取
     * Error creating bean with name 'person05': Bean definition is abstract
     */
    @Test
    public void test07() {
        //Object person05 = ioc.getBean("person05");
        //System.out.println(person05);
        Object person06 = ioc.getBean("person06");
        System.out.println(person06);
    }

    @Test
    public void test08() {
        System.out.println("容器启动完成...");
        Object bean = ioc.getBean("aBook");
        Object bean1 = ioc.getBean("aBook");
        System.out.println(bean == bean1);
    }

    @Test
    public void test09() {
        Object bean = ioc.getBean("airPlane01");
        System.out.println(bean);
        Object bean1 = ioc.getBean("airPlane02");
        System.out.println(bean1);
    }

    @Test
    public void test10() {
        Object bean = ioc.getBean("myFactoryBeanImple");
        Object bean1 = ioc.getBean("myFactoryBeanImple");
        System.out.println(bean == bean1);

    }
}