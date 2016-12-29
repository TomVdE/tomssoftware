package broadcast.tvde.be.mybroadcastapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StickyBroadcastActivity extends AppCompatActivity {

    private static final String TAG = StickyBroadcastActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky_broadcast);
    }

    public void methodOne(View view) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);

        Intent intent = registerReceiver(null, intentFilter);

        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

        if (status == BatteryManager.BATTERY_STATUS_CHARGING) {
            Toast.makeText(this, "Battery Getting Charged", Toast.LENGTH_SHORT).show();
        }

        if (status == BatteryManager.BATTERY_STATUS_DISCHARGING) {
            Toast.makeText(this, "Battery Getting Discharged", Toast.LENGTH_SHORT).show();
        }

        if (status == BatteryManager.BATTERY_STATUS_FULL) {
            Toast.makeText(this, "Battery Fully Charged", Toast.LENGTH_SHORT).show();
        }

        Log.i(TAG, status + "");
    }

    public void methodTwo(View view) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);

        registerReceiver(batteryStatusReceiver, intentFilter);
    }

    private BroadcastReceiver batteryStatusReceiver = new BroadcastReceiver() {

        private static final String TAG = "Main Charger Receiver";

        @Override
        public void onReceive(Context context, Intent intent) {

            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

            if (status == BatteryManager.BATTERY_STATUS_CHARGING) {
                Toast.makeText(context, "Battery Getting Charged", Toast.LENGTH_SHORT).show();
            }

            if (status == BatteryManager.BATTERY_STATUS_DISCHARGING) {
                Toast.makeText(context, "Battery Getting Discharged", Toast.LENGTH_SHORT).show();
            }

            if (status == BatteryManager.BATTERY_STATUS_FULL) {
                Toast.makeText(context, "Battery Fully Charged", Toast.LENGTH_SHORT).show();
            }
            ExecutorService

            Log.i(TAG, status + "");
        }
    };
}
