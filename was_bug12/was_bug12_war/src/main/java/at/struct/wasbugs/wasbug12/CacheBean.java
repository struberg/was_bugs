package at.struct.wasbugs.wasbug12;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CacheBean {


    private @Inject CacheUsingService service;


    private CacheInfo info;


    @PostConstruct
    protected void init() {
        reload();
    }


    public CacheInfo getInfo() {
        return info;
    }


    public void reload() {
        info = service.getCacheInfo();
    }
}
