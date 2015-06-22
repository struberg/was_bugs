package at.struct.wasbugs.wasbug14;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RealService implements ServiceInterface {


    @Override
    public int meaningOfLife() {
        return 42;
    }

    @Override
    public String someString() {
        return "this string comes from the real service implementation";
    }
}
