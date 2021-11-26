package per.hao.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import per.hao.bean.Car;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class IOCTest {
    ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext02.xml");

    /**
     * 单例：Bean的生命周期
     *      （容器启动）构造器 -> 初始化方法 -> 销毁方法
     * 多实例：
     *      获取bean（构造器 -> 初始化方法）-> 容器关闭不会调用bean的销毁方法
     * 后置处理器：
     *      （容器启动）构造器 -> 后置处理器before -> 初始化方法 -> 后置处理器after -> bean初始化完成
     * 无论bean是否有初始化方法，后置处理器都会默认其有还会继续工作
     */
    @Test
    public void test01() {
        Object bean = ioc.getBean("book01");
        Object bean1 = ioc.getBean("book02");
        System.out.println("容器关闭了");
        ioc.close();
    }

    @Test
    public void test02() throws SQLException {
        DataSource bean = (DataSource) ioc.getBean(DataSource.class);
        System.out.println(bean.getConnection());
        Car bean1 = ioc.getBean(Car.class);
        System.out.println(bean1);
    }
}