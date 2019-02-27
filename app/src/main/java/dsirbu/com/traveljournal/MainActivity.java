package dsirbu.com.traveljournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import dsirbu.com.traveljournal.login.LoginActivity;
import dsirbu.com.traveljournal.travel.trip.ManageTripActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   public void btnLoginOnClick(View view) {
       startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

    public void btnTravelOnClick(View view) {
        startActivity(new Intent(MainActivity.this, ManageTripActivity.class));
    }
}
