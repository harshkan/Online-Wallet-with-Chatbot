package info.androidhive.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddMoneyActivity extends AppCompatActivity {

    private static final String TAG ="test" ;
    private TextView balance;
    private Button add;
    private EditText amount ;
    private FirebaseAuth auth;
    private FirebaseDatabase database ;
    private DatabaseReference myRef ;
    private  String currentbal;
    private int adding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money);
        balance =(TextView) findViewById(R.id.balance);
        add= (Button)findViewById(R.id.add);
        amount = (EditText)findViewById(R.id.add_amount);
        auth=FirebaseAuth.getInstance();
        FirebaseUser user=auth.getCurrentUser();
         String uidi=user.getEmail();
        final String uid=uidi.replace(".",",");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Users");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                currentbal= (String) dataSnapshot.child(uid).child("Balance").getValue();
                FirebaseDatabase database = FirebaseDatabase.getInstance();


                balance.setText("Current Balance :"+currentbal);


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child(uid).child("Balance").setValue(currentbal);
                balance.setText("Current Balance :"+currentbal);
                final int val=Integer.parseInt(String.valueOf(amount.getText()));
                adding=val+Integer.parseInt(currentbal);
                currentbal=adding+"";
                myRef.child(uid).child("Balance").setValue(currentbal);
                balance.setText("Current Balance :"+currentbal);



            }
        });
    }




}
