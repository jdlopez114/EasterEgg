package nyc.c4q.josiel.easteregg;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.josiel.easteregg.notifications.MyAlarmReceiver;
import nyc.c4q.josiel.easteregg.notifications.MyNotificationService;

import static android.widget.LinearLayout.HORIZONTAL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launchTestService();
        scheduleAlarm();

        List<BannerData> data = fillData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        BannerAdapter adapter = new BannerAdapter(data, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, HORIZONTAL, false));
    }

    private List<BannerData> fillData() {

        List<BannerData> data = new ArrayList<>();

        data.add(new BannerData(R.drawable.banner_arryn));
        data.add(new BannerData(R.drawable.banner_baratheon));
        data.add(new BannerData(R.drawable.banner_greyjoy));
        data.add(new BannerData(R.drawable.banner_lannister));
        data.add(new BannerData(R.drawable.banner_martell));
        data.add(new BannerData(R.drawable.banner_stark));
        data.add(new BannerData(R.drawable.banner_targaryen));
        data.add(new BannerData(R.drawable.banner_tully));
        data.add(new BannerData(R.drawable.banner_tyrell));

        return data;
    }

    public void launchTestService() {
        Intent i = new Intent(this, MyNotificationService.class);
        startService(i);
    }

    public void scheduleAlarm() {

        // Construct an intent that will execute the AlarmReceiver
        Intent intent = new Intent(getApplicationContext(), MyAlarmReceiver.class);

        // Create a PendingIntent to be triggered when the alarm goes off
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(this, MyAlarmReceiver.REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        long firstMillis = System.currentTimeMillis(); // alarm is set right away

        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);

        // First parameter is the type: ELAPSED_REALTIME, ELAPSED_REALTIME_WAKEUP, RTC_WAKEUP
        // Interval can be INTERVAL_FIFTEEN_MINUTES, INTERVAL_HALF_HOUR, INTERVAL_HOUR, INTERVAL_DAY
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis, AlarmManager.INTERVAL_FIFTEEN_MINUTES / 3, pendingIntent);
    }
}
