package broadcast.tvde.be.mybroadcastapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import broadcast.tvde.be.mybroadcastapplication.broadcastreceivers.MyFirstBroadcastReceiver;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendBroadcastMessage(View view) {
        //Intent broadcastIntent = new Intent(this, MyFirstBroadcastReceiver.class);

        Intent broadcastIntent = new Intent("my.custom.action.name");
        Bundle b = new Bundle();
        b.putString("title", "title");
        sendOrderedBroadcast(broadcastIntent, null, null,
                null, -1, "Android", b);

        //next line of code proves that the broadcasts are send asynchroniously and therefore processed
        //after this line

        Toast.makeText(this, "After Sending Broadcast", Toast.LENGTH_LONG).show();
    }

    public void broadcastToInnerReceiver(View view) {
        //Intent intent = new Intent(this, MyThirdBroadcastReceiver.class);
        //Intent intent = new Intent("my.custom.anotheraction.name");
        //sendBroadcast(intent);
    }

    public static class MyThirdBroadcastReceiver extends BroadcastReceiver {



        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(TAG, "Hello from 3rd Receiver");

            Toast.makeText(context, "Hello from 3rd Receiver", Toast.LENGTH_LONG).show();
        }
    }
}
