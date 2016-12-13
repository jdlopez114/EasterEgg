package nyc.c4q.josiel.easteregg;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class BannerViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    View cardView;

    BannerViewHolder(View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.card_view);
        imageView = (ImageView) itemView.findViewById(R.id.banner_view);
    }
}
