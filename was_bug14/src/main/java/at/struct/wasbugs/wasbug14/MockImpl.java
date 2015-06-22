package at.struct.wasbugs.wasbug14;

import org.apache.deltaspike.core.api.exclude.Exclude;
import org.apache.deltaspike.core.api.projectstage.ProjectStage;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@ApplicationScoped
@MyQualifier(value = "one")
@Alternative
@Exclude(exceptIfProjectStage = ProjectStage.Development.class)
public class MockImpl implements ServiceInterface {


    @Override
    public int meaningOfLife() {
        return -732;
    }

    @Override
    public String someString() {
        return "this string is returned by the mock service";
    }
}
