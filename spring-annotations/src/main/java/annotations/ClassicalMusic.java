package annotations;

import org.springframework.stereotype.Component;


@Component
public class ClassicalMusic implements Music {
    // factory method of calling
    @Override
    public String getSong() {
        return "Mozart";
    }

    public void doMyInit() {
        System.out.println("Doing Initialization");
    }

    public void doDestroy() {
        System.out.println("Destroying");
    }


}
