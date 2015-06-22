package at.struct.wasbugs.wasbug14;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@MyQualifier(value = "two")
public class RealServiceTwo implements ServiceInterface {

    @Override
    public int meaningOfLife() {
        return 2;
    }

    @Override
    public String someString() {
        return "this string comes from the real service implementation with qualifier TWO";
    }
}
