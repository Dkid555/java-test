package annotations;

import org.springframework.stereotype.Component;

@Component
public class FunkMusic implements Music {
    @Override
    public String getSong() {
        return "Funky Time";
    }
}
