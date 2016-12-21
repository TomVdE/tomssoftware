package broadcast.tvde.be.mybroadcastapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private int ctr = 1;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textView = (TextView) findViewById(R.id.textView2);
    }

    public void registerReceiver(View view) {

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_TIME_TICK);

        registerReceiver(timeTickReceiver, intentFilter);
    }

    public void unregisterReceiver(View view) {

        unregisterReceiver((timeTickReceiver));
    }

    private BroadcastReceiver timeTickReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            int minutes = ctr;

            textView.setText(minutes + " minute over");

            ctr++;

            Toast.makeText(context, "Hello from Time Tick Receiver", Toast.LENGTH_LONG).show();


        }
    };
}
