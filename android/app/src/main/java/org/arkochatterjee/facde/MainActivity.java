package org.arkochatterjee.facde;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child("Rfid").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    Log.i("Messages", dataSnapshot.toString());
                    String data=dataSnapshot.toString();
                    String teacher1="5029";
                    if(data.)
                    ((TextView)findViewById(R.id.textView1)).setText(dataSnapshot.toString());
                    /*for(DataSnapshot postSnapShot:dataSnapshot.getChildren())
                    {
                        MotionDetect user=postSnapShot.getValue(MotionDetect.class);
                        String ShowDataString =user.getName()+"\n"+user.getText()+"\n\n";
                        ((TextView)findViewById(R.id.textView1)).setText(ShowDataString);

                    }*/
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                //hideProgressDialog();
            }
        });
    }
}
