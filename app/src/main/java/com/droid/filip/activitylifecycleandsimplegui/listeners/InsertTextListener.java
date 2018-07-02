package com.droid.filip.activitylifecycleandsimplegui.listeners;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.droid.filip.activitylifecycleandsimplegui.R;
import com.droid.filip.activitylifecycleandsimplegui.adapters.CustomTextAdapter;
import com.droid.filip.activitylifecycleandsimplegui.stakes.ListItem;

import java.util.Date;

public class InsertTextListener implements View.OnClickListener {

    private Activity activity;

    public InsertTextListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        EditText editText = (EditText)activity.findViewById(R.id.edit_text);
        ListView listView = (ListView)activity.findViewById(R.id.list_view);
        String text = editText.getText() != null ? editText.getText().toString().trim() : "";
        if (text != null && text.length() > 0) {
            CustomTextAdapter customTextAdapter = (CustomTextAdapter)listView.getAdapter();
            customTextAdapter.insertItem(new ListItem(text, new Date()));
            editText.setText("");
        }
    }
}
