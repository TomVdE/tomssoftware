package broadcast.tvde.be.mybroadcastapplication.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by tomvde on 19/12/2016.
 */
public class DataBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = DataBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {

        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age", 0);
        String street = intent.getStringExtra("street");
        int housenr = intent.getIntExtra("housenr", 0);

        Log.i(TAG, "Name: " + name + ", Age: " + age);
        Log.i(TAG, "street: " + street + ", housenr: " + housenr);

        Log.i(TAG, "Hello from DataBroadcastReceiver");
        Toast.makeText(context, "Hello from DataBroadcastReceiver", Toast.LENGTH_LONG).show();



    }
}
