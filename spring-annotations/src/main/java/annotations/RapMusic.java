package annotations;

import org.springframework.stereotype.Component;


@Component
public class RapMusic implements Music {
    public void doMyInit() {
        System.out.println("doing initialization");
    }

    public void doMyDestroy() {
        System.out.println("Doing my destroy");
    }

    @Override
    public String getSong() {
        return "50 Cent - Candy Shop";
    }
}
