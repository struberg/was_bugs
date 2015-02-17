package at.struct.wasbugs.wasbug13.be;

import javax.ejb.Timer;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TimerMonitor
{

    private volatile Timer timer;


    public Timer getTimer()
    {
        return timer;
    }


    void setTimer(Timer timer)
    {
        this.timer = timer;
    }

}
