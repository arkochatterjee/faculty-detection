package org.arkochatterjee.facde;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    Button button,button1,signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);


        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        ((TextView) findViewById(R.id.name)).setText("Hi! "+user.getDisplayName().toString());
        //name.setText(user.getDisplayName().toString());

        button = (Button) findViewById(R.id.t1abutton);
        button1 = (Button) findViewById(R.id.t2button);
        signOut = (Button) findViewById(R.id.signout);

        // Capture button clicks
        signOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
               SignOut();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        TimeTable.class);
                startActivity(myIntent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        TimeTable.class);
                startActivity(myIntent);
            }
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child("Rfid").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int t1=0;
                int t2=0;
                int t11=0;
                int t22=0;
                if(dataSnapshot.exists())
                {
                    Log.i("Messages", dataSnapshot.toString());
                    String data=dataSnapshot.toString();
                    //((TextView)findViewById(R.id.teacher1)).setText(data);

                    String teacher1="5900D5029A14";
                    String tea1="5900�5029�14";
                    String teacher2="5900D4FCC1B0";
                    String tea2="5900�4���1�0";

                    t1=stringOccurance(data,teacher1);
                    t11=stringOccurance(data,tea1);
                    t2=stringOccurance(data,teacher2);
                    t22=stringOccurance(data,tea2);


                    if(t11%2==0) {
                        ((Button) findViewById(R.id.btntecher1)).setText("Unavailable");
                        ((Button) findViewById(R.id.btntecher1)).setBackgroundColor(Color.RED);
                    }
                    else {
                        ((Button) findViewById(R.id.btntecher1)).setText("Available");
                        ((Button) findViewById(R.id.btntecher1)).setBackgroundColor(Color.GREEN);
                    }
                        //((TextView)findViewById(R.id.teacher1)).setText("Teacher 1 is in the University!");

                    if(t22%2==0) {
                        ((Button) findViewById(R.id.t2avbutton)).setText("Unavailable");
                        ((Button) findViewById(R.id.t2avbutton)).setBackgroundColor(Color.RED);
                    }
                        //((TextView)findViewById(R.id.teacher2)).setText("Teacher 2 has left!");
                    else {
                        ((Button) findViewById(R.id.t2avbutton)).setText("Available");
                        ((Button) findViewById(R.id.t2avbutton)).setBackgroundColor(Color.GREEN);
                    }
                        //((TextView)findViewById(R.id.teacher2)).setText("Teacher 2 is in the University!");


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

    void SignOut()
    {

        GoogleSignInClient mGoogleSignInClient ;
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(getBaseContext(), gso);
        mGoogleSignInClient.signOut().addOnCompleteListener(MainActivity.this,
                new OnCompleteListener<Void>() {  //signout Google
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        FirebaseAuth.getInstance().signOut(); //signout firebase
                        //Intent setupIntent = new Intent(getBaseContext(), /*To ur activity calss*/);
                        Toast.makeText(getBaseContext(), "Logged Out", Toast.LENGTH_LONG).show(); //if u want to show some text
                        // setupIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        //startActivity(setupIntent);
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        finish();
                    }
                });

    }

}

