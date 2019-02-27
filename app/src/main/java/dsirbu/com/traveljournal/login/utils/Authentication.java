package dsirbu.com.traveljournal.login.utils;

// POJO class used to map the content of the login screen to an object
public class Authentication {

    private String mEmail;
    private String mPhone;
    private String mPassword;
    private boolean mIsAccepted;

    public String getPassword() {
        return mPassword;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public boolean isAccepted() {
        return mIsAccepted;
    }

    public void setAccepted(boolean accepted) {
        mIsAccepted = accepted;
    }

    @Override
    public String toString() {
        return "Authentication{" +
                "mEmail='" + mEmail + '\'' +
                ", mPhone='" + mPhone + '\'' +
                ", mIsAccepted=" + mIsAccepted +
                '}';
    }
}
