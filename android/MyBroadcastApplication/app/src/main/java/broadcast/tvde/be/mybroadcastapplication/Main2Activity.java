package broadcast.tvde.be.mybroadcastapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void sendBroadcast(View view) {
        Intent intent = new Intent("my.custom.actionwithdata.name");

        intent.putExtra("name", "tvde");
        intent.putExtra("age", 10);

        Bundle bundle = new Bundle();
        bundle.putString("street", "Kerkstraat");
        bundle.putInt("housenr", 32);
        intent.putExtras(bundle);

        sendBroadcast(intent);
    }


}
