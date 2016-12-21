package broadcast.tvde.be.mybroadcastapplication.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by tomvde on 19/12/2016.
 */
public class MyFirstBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = MyFirstBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Hello from 1st receiver, thread name : " + Thread.currentThread().getName());

        Toast.makeText(context, "Hello from 1st receiver", Toast.LENGTH_LONG).show();
        try {
            Thread.sleep(10000); //simulates long running task --> app will crash
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
