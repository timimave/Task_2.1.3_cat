import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/* Класс App содержит метод main, который запускает Спринг при создании контекста.
В контекст мы передаем класс AppConfig, который помечен аннотацией @Configuration -
так Спринг понимает, что это настроечный класс.*/

/*В методе main мы можем получить бин HelloWorld по имени и использовать в любом месте программы.
Спринг позволяет использовать различные типы бинов,
одни будут жить от старта до завершения программы,
другие будут создаваться при каждом запросе или открытии новой сессии,
третьи при каждом вызове будут создаваться новые. За это отвечает аннотация @Scope.*/

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean = (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean.getMessage());
        HelloWorld hWbean2 = (HelloWorld) applicationContext.getBean("helloworld");

        Cat cat1 = (Cat) applicationContext.getBean("cat");
        Cat cat2 = (Cat) applicationContext.getBean("cat");

        System.out.println(bean == hWbean2);
        System.out.println(cat1 == cat2);
    }
}




/*В Spring есть три типа бинов:

    Singleton Bean: это одиночный экземпляр бина, который живет во время жизни приложения.
    Он создается при инициализации контекста приложения и общий для всех клиентов.

    Prototype Bean: это множественные экземпляры бина,
    которые создаются каждый раз, когда они запрашиваются.

    Request Bean: это бин, созданный для каждого HTTP-запроса.
    Он живет в течение жизненного цикла запроса.

Каждый тип бина используется в различных ситуациях
в зависимости от потребностей приложения.*/