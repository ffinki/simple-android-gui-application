package com.droid.filip.activitylifecycleandsimplegui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PrimaryActivity extends Activity{

    private static final String TAG = "PRIMARY_ACTIVITY";
    //
    Button starter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primary_activity);
        Toast.makeText(this, TAG + " - onCreate", Toast.LENGTH_SHORT);
        //
        starter = (Button)findViewById(R.id.btn_starter_secondary);
        starter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrimaryActivity.this, SecondaryActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, TAG + " - onStart", Toast.LENGTH_SHORT);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, TAG + " - onResume", Toast.LENGTH_SHORT);
    }

    @Override
    protected void onPause() {
        Toast.makeText(this, TAG + " - onPause", Toast.LENGTH_SHORT);
        super.onPause();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, TAG + " - onStop", Toast.LENGTH_SHORT);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, TAG + " - onDestroy", Toast.LENGTH_SHORT);
        super.onDestroy();
    }


}
