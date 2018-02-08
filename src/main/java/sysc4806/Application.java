package sysc4806;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import sysc4806.Controller.BuddyInfoController;


@SpringBootApplication
@ComponentScan(basePackageClasses = BuddyInfoController.class)
public class Application {

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class);
    }
}
