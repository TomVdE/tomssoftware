package broadcast.tvde.be.mybroadcastapplication.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by tomvde on 19/12/2016.
 */
public class MySecondBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = MySecondBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Hello from 2nd receiver");

        Toast.makeText(context, "Hello from 2nd receiver", Toast.LENGTH_LONG).show();

    }
}
