package pers.hao.factory;

import org.springframework.beans.factory.FactoryBean;
import pers.hao.bean.Book;

import java.util.UUID;

/**
 * 实现了FactoryBean接口的类是Spring可以认识的工厂类
 * Spring会自动的调用工厂方法创建实例
 */
public class MyFactoryBeanImple implements FactoryBean<Book> {
    /**
     * getObject：工厂方法，返回创建的对象
     * @return
     * @throws Exception
     */
    @Override
    public Book getObject() throws Exception {
        System.out.println("MyFactoryBeanImple...帮你创建对象");
        Book book = new Book();
        book.setBookName(UUID.randomUUID().toString());
        return book;
    }

    /**
     * 返回创建对象的类型
     * Spring会自动调用这个方法来确定创建的对象是什么类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    /**
     * isSingleton：判断是否是单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
