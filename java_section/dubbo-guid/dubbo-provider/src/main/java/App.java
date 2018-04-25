import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        //1.读取spring 的配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-dubbo.xml");


        ((ClassPathXmlApplicationContext) applicationContext).start();
        System.out.println("*******服务启动完毕********");
        System.in.read();

    }
}
