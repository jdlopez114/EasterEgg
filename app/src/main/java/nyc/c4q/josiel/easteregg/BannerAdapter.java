package nyc.c4q.josiel.easteregg;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerViewHolder> {

    List<BannerData> list = Collections.emptyList();
    Context context;

    public BannerAdapter(List<BannerData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public BannerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        BannerViewHolder holder = new BannerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(BannerViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).imageID);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
