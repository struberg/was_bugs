package at.struct.wasbugs.wasbug13.be;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;

@ApplicationScoped
public class TimerMonitor
{

    private volatile Date nextTimeout;


    public Date getTimer()
    {
        return nextTimeout;
    }


    void setTimer(Date nextTimeout)
    {
        this.nextTimeout = nextTimeout;
    }

}
