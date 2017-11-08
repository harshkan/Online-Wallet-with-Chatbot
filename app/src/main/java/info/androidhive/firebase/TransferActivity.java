package info.androidhive.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TransferActivity extends AppCompatActivity {

    private static final String TAG = "test";
    private Button transfer;
    private EditText transfer_amount;
    private EditText remail;
    private FirebaseAuth auth;
    private FirebaseDatabase database ;
    private DatabaseReference myRef ;
    private String currentbal;
    private  int nrbal;
    private  TextView currentbalance;
    private int amount;
    private  String rem;
    private String revbal;
    private CheckBox sure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        transfer = (Button) findViewById(R.id.transfer);
        transfer_amount = (EditText) findViewById(R.id.transfer_amount);
        remail= (EditText) findViewById(R.id.remail);
        sure=(CheckBox)findViewById(R.id.sure);
        currentbalance=(TextView)findViewById(R.id.currentbalance);
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
                currentbal = (String) dataSnapshot.child(uid).child("Balance").getValue();

                currentbalance.setText("Current Balance :"+currentbal);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        sure.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.


                        String em = String.valueOf(remail.getText());

                        rem = em.replace(".", ",");
                        revbal = (String) dataSnapshot.child(rem).child("Balance").getValue();
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });



            }
        });



        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Integer.parseInt(currentbal)>=amount)
                {
                    amount=Integer.parseInt(String.valueOf(transfer_amount.getText()));

                    nrbal=Integer.parseInt(revbal)+amount;

                    myRef.child(rem).child("Balance").setValue(nrbal+"");

                    int cur=Integer.parseInt(currentbal)-amount;
                    currentbal=cur+"";
                    currentbalance.setText("Current Balance :"+currentbal);
                    myRef.child(uid).child("Balance").setValue(currentbal);


                }else {
                    Toast.makeText(TransferActivity.this, "Not sufficient amount.",
                            Toast.LENGTH_SHORT).show();
                }



            }



        });


    }










}
