package at.struct.wasbugs.wasbug14;

import org.apache.deltaspike.core.api.projectstage.ProjectStage;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Stateless
public class BackingEjb {
    private @Inject ServiceInterface service;

    private @Inject ProjectStage projectStage;


    public int getMeaningOfLife() {
        return service.meaningOfLife();
    }

    public String getSomeString() {
        return service.someString();
    }

    public String getUsedServiceClass() {
        return service.getClass().getName();
    }

    public String getProjectStage() {
        return projectStage.toString();
    }
}
