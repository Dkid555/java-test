package annotations;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")  // as an example here can be - prototype, singleton, request, session, globalSession
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
