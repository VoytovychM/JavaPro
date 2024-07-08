package practice20240619.interfaceexample.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import practice20240619.interfaceexample.MessageRenderer;

public class MainSpring {
    public static void main(String... args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ("spring/app-context.xml");

        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}