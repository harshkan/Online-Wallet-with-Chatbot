package info.androidhive.firebase;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Harsh on 05-11-2017.
 */

public class FirebaseApp extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}