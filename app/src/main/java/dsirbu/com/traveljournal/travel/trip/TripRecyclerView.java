package dsirbu.com.traveljournal.travel.trip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dsirbu.com.traveljournal.R;
import dsirbu.com.traveljournal.travel.RecyclerTouchListener;

public class TripRecyclerView extends AppCompatActivity {


    private RecyclerView mRecyclerViewTrips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_recycler_view);

        initView();
    }

    private void initView() {

        mRecyclerViewTrips = findViewById(R.id.recycler_view_trips);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerViewTrips.setLayoutManager(layoutManager);

        TripAdapter tripAdapter = new TripAdapter(getTrips(), this);
        mRecyclerViewTrips.setAdapter(tripAdapter);

        mRecyclerViewTrips.addOnItemTouchListener(new RecyclerTouchListener(this,
                mRecyclerViewTrips, new TripClickListener() {
            @Override
            public void onClick(View view, final int position) {
                Toast.makeText(TripRecyclerView.this, getString(R.string.single_click) + position,
                        Toast.LENGTH_SHORT).show();

                final ImageButton button = view.findViewById(R.id.button_click);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // implement button click
                        Toast.makeText(TripRecyclerView.this, getString(R.string.button_item) + position,
                                Toast.LENGTH_SHORT).show();
                        button.setImageResource(R.drawable.baseline_bookmark_black_18dp);
                    }
                });
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(TripRecyclerView.this, getString(R.string.long_click) + position,
                        Toast.LENGTH_LONG).show();
            }
        }));
    }

    private List<Trip> getTrips() {
        List<Trip> trips = new ArrayList<>();
        Trip trip;
        for (int i = 0; i < 5; i++) {
            trip = new Trip();
            trip.setName("Android Name " + i);
            trip.setLocation("Address " + i);
            trip.setRating("R " + i);
            trip.setPicture("https://cdn.guidingtech.com/media/assets/WordPress-Import/2012" +
                    "/10/Smiley-Thumbnail.png");
            trips.add(trip);
        }
        return trips;
    }
}
