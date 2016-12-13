package nyc.c4q.josiel.easteregg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.widget.LinearLayout.HORIZONTAL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

}
