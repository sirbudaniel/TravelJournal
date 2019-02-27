package dsirbu.com.traveljournal.travel.trip;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import dsirbu.com.traveljournal.R;

public class TripViewHolder extends RecyclerView.ViewHolder {

    public ImageView mImageView;
    public TextView mTextViewName;
    public TextView mTextViewLocation;
    public TextView mTextViewRating;

    public TripViewHolder(@NonNull View itemView) {
        super(itemView);

        mImageView = itemView.findViewById(R.id.imageview_picture);
        mTextViewName = itemView.findViewById(R.id.textview_name);
        mTextViewLocation = itemView.findViewById(R.id.textview_name);
        mTextViewRating = itemView.findViewById(R.id.textview_rating);
    }

    public ImageView getmImageView() {
        return mImageView;
    }

    public void setmImageView(ImageView mImageView) {
        this.mImageView = mImageView;
    }

    public TextView getmTextViewName() {
        return mTextViewName;
    }

    public void setmTextViewName(TextView mTextViewName) {
        this.mTextViewName = mTextViewName;
    }

    public TextView getmTextViewLocation() {
        return mTextViewLocation;
    }

    public void setmTextViewLocation(TextView mTextViewLocation) {
        this.mTextViewLocation = mTextViewLocation;
    }

    public TextView getmTextViewRating() {
        return mTextViewRating;
    }

    public void setmTextViewRating(TextView mTextViewRating) {
        this.mTextViewRating = mTextViewRating;
    }
}
