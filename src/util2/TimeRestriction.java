
package util2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 *
 * @author nikola.panajotovic
 */
public class TimeRestriction {
    
    public static int TESTDURATION;
    private static int DELAY = 1000;
    
    private int interval;
    
    private Timer timer;
    private JProgressBar bar;
    
    public TimeRestriction(JProgressBar bar){
        initTimeBar(bar);
        initTimer();
    }

    private void initTimer() {
        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(interval == 0){
                    timer.stop();
                    System.out.println("Timer stopped");
                }else {
                    interval--;
                    bar.setValue(interval);
                }
            }
        });
    }

    private void initTimeBar(JProgressBar bar) {
        this.bar = bar;
        bar.setMaximum(TESTDURATION);
        interval = this.bar.getMaximum();
        this.bar.setValue(interval);
    }
    
    public void startTime(){
        timer.start();
    }

}
