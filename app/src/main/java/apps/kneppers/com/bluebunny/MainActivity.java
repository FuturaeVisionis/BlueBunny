package apps.kneppers.com.bluebunny;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
    
    //I like programming with Android.
    // Without Java, I can't programme Android Apps!!

    MalibuCountDownTimer countDownTimer;
    long timeElapsed;
    boolean timerHasStarted = false;
    Button startB;
    TextView text;
    TextView timeElapsedView;

    long startTime = 50000;
    long interval = 1000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startB = (Button) this.findViewById(R.id.button);
        startB.setOnClickListener(this);

        text = (TextView) this.findViewById(R.id.timer);
        timeElapsedView = (TextView) this.findViewById(R.id.timeElapsed);
        countDownTimer = new MalibuCountDownTimer(startTime, interval);
        text.setText(text.getText() + String.valueOf(startTime));
    }

    @Override
    public void onClick(View v) {
        if (!timerHasStarted)
        {
            countDownTimer.start();
            timerHasStarted = true;
            startB.setText("Start");
        } else {
            countDownTimer.cancel();
            timerHasStarted = false;
            startB.setText("RESET");
        }
    }

    // CountDownTimer class
    public class MalibuCountDownTimer extends CountDownTimer {

        public MalibuCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {
            text.setText("Time's up!");
            timeElapsedView.setText("Time Elapsed: " + String.valueOf(startTime));
        }

        @Override
        public void onTick(long millisUntilFinished) {

            text.setText("Time remain:" + millisUntilFinished);
            timeElapsed = startTime - millisUntilFinished;
            timeElapsedView.setText("Time Elapsed: " + String.valueOf(timeElapsed));
        }
    }
}
