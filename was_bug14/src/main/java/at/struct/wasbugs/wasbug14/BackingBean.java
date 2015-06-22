package at.struct.wasbugs.wasbug14;

import org.apache.deltaspike.core.api.projectstage.ProjectStage;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class BackingBean {

    @Inject
    @Any
    private Instance<ServiceInterface> services;

    private @Inject ProjectStage projectStage;


    public int getMeaningOfLife(String useService) {
        return getService(useService).meaningOfLife();
    }

    public String getSomeString(String useService) {
        return getService(useService).someString();
    }

    public String getUsedServiceClass(String useService) {
        return getService(useService).getClass().getName();
    }

    public String getProjectStage() {
        return projectStage.toString();
    }


    private ServiceInterface getService(String qualifier) {
        return services.select(new MyQualifierLiteral(qualifier)).get();
    }


    private static class MyQualifierLiteral extends AnnotationLiteral<MyQualifier> implements MyQualifier {

        private String value;

        private MyQualifierLiteral(String value) {
            this.value = value;
        }

        @Override
        public String value() {
            return value;
        }
    }
}
