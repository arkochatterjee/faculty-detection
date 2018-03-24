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
        setContentView(R.layout.activitymain);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child("Rfid").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int t1=0;
                int t2=0;
                if(dataSnapshot.exists())
                {
                    Log.i("Messages", dataSnapshot.toString());
                    String data=dataSnapshot.toString();
                    String teacher1="5029";
                    String teacher2="5900�4���1�0";

                    t1=stringOccurance(data,teacher1);
                    t2=stringOccurance(data,teacher2);

                    if(t1%2==0)
                        ((TextView)findViewById(R.id.teacher1)).setText("Teacher 1 has left!");
                    else
                        ((TextView)findViewById(R.id.teacher1)).setText("Teacher 1 is in the University!");

                    if(t2%2==0)
                        ((TextView)findViewById(R.id.teacher2)).setText("Teacher 2 has left!");
                    else
                        ((TextView)findViewById(R.id.teacher2)).setText("Teacher 2 is in the University!");


                    //((TextView)findViewById(R.id.textView1)).setText(dataSnapshot.toString());
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

    int stringOccurance(String str,String findStr)
    {
        int lastIndex = 0;
        int count = 0;

        while(lastIndex != -1){

            lastIndex = str.indexOf(findStr,lastIndex);

            if(lastIndex != -1){
                count ++;
                lastIndex += findStr.length();
            }
        }
        return count;
    }
}
