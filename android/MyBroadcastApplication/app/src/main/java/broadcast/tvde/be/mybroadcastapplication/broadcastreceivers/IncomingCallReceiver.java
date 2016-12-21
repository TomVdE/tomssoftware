package broadcast.tvde.be.mybroadcastapplication.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * Created by tomvde on 21/12/2016.
 */
public class IncomingCallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        
        if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            Toast.makeText(context, "Ringing state", Toast.LENGTH_SHORT).show();
        }

        if (state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
            Toast.makeText(context, "Received state", Toast.LENGTH_SHORT).show();
        }

        if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
            Toast.makeText(context, "Idle state", Toast.LENGTH_SHORT).show();
        }
    }
}
