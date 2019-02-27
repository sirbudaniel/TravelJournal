package dsirbu.com.traveljournal.travel.trip;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import dsirbu.com.traveljournal.R;

public class TripAdapter extends RecyclerView.Adapter<TripViewHolder> {

    private List<Trip> mTrips;
    private Context mContext;

    public TripAdapter(List<Trip> trips, Context context) {

        mTrips = trips;
        mContext = context;
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View tripView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.trip_item, viewGroup, false);
        return new TripViewHolder(tripView);
    }

    @Override
    public void onBindViewHolder(@NonNull TripViewHolder tripViewHolder, int i) {
        Trip trip = mTrips.get(i);
        tripViewHolder.getmTextViewName().setText(trip.getName());
        tripViewHolder.getmTextViewLocation().setText(trip.getLocation());
        tripViewHolder.getmTextViewRating().setText(trip.getRating());
        Picasso.get().load(trip.getPicture())
                .into(tripViewHolder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mTrips.size();
    }
}
