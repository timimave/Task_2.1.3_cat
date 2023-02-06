import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/*В классе AppConfig содержится метод, помеченный аннотацией как бин,
этот метод будет выполнен при запуске и его результат станет объектом,
управляемым Спрингом.*/



@Configuration
public class AppConfig {

    @Bean(name="helloworld")
    public HelloWorld getHelloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Hello World!");
        return helloWorld;
    }
    @Bean(name ="cat")
    @Scope("prototype")
    public Cat getCat() {
        Cat cat = new Cat("Борис");
        return cat;
    }
}

// Prototype Bean: это множественные экземпляры бина,
// которые создаются каждый раз, когда они запрашиваются