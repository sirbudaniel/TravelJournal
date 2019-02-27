package dsirbu.com.traveljournal.travel.trip;

public class Trip {
    private String mLocation;
    private String mName;
    private String mRating;
    private String mPicture;

    public Trip() {}

    public Trip(String mLocation, String mName, String mRating, String mPicture) {
        this.mLocation = mLocation;
        this.mName = mName;
        this.mRating = mRating;
        this.mPicture = mPicture;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getName() {
        return mName;
    }

    public String getRating() {
        return mRating;
    }

    public String getPicture() {
        return mPicture;
    }

    public void setLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public void setRating(String mRating) {
        this.mRating = mRating;
    }

    public void setPicture(String picture) {
        mPicture = picture;
    }

}


