package broadcast.tvde.be.mybroadcastapplication.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by tomvde on 19/12/2016.
 */
public class SystemBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = SystemBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "hello from system broadcast receiver");
    }
}
