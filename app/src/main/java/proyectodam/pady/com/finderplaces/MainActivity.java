package proyectodam.pady.com.finderplaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TimerTask timer = new TimerTask() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, Controladora.class);

                startActivity(intent);
                finish();
            }
        };
        Timer time = new Timer();
        time.schedule(timer, SPLASH_SCREEN_DELAY);

    }

}
