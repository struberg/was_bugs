package at.struct.wasbugs.wasbug14;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@MyQualifier(value = "one")
public class RealServiceOne implements ServiceInterface {


    @Override
    public int meaningOfLife() {
        return 1;
    }

    @Override
    public String someString() {
        return "this string comes from the real service implementation with qualifier ONE";
    }
}
