package com.droid.filip.activitylifecycleandsimplegui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.droid.filip.activitylifecycleandsimplegui.adapters.CustomTextAdapter;
import com.droid.filip.activitylifecycleandsimplegui.listeners.InsertTextListener;

public class SecondaryActivity extends Activity {

    private static final String TAG = "SECONDARY_ACTIVITY";
    //
    private Button starterFirst;
    private EditText editText;
    private Button permit;
    private ListView textList;
    private Button insert;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondary_activity);
        Toast.makeText(this, TAG + " - onCreate", Toast.LENGTH_SHORT);
        //
        starterFirst = (Button)findViewById(R.id.btn_starter_first);
        starterFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SecondaryActivity.this, PrimaryActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
            }
        });
        //
        editText = (EditText)findViewById(R.id.edit_text);
        editText.setEnabled(false);
        //
        permit = (Button)findViewById(R.id.btn_permit);
        permit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setEnabled(true);
            }
        });
        //
        textList = (ListView)findViewById(R.id.list_view);
        textList.setAdapter(new CustomTextAdapter(this));
        textList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CustomTextAdapter customTextAdapter = (CustomTextAdapter)adapterView.getAdapter();
                customTextAdapter.removeListItem(i);
            }
        });
        //
        insert = (Button)findViewById(R.id.btn_insert);
        insert.setOnClickListener(new InsertTextListener(this));
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
