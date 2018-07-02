package com.droid.filip.activitylifecycleandsimplegui.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.droid.filip.activitylifecycleandsimplegui.R;
import com.droid.filip.activitylifecycleandsimplegui.stakes.ListItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CustomTextAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    //
    List<ListItem> items;
    static class ViewHolder {
        TextView editTextText;
        TextView dateCreatedText;
    }

    public CustomTextAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        items = new ArrayList<ListItem>();
    }

    public void insertItem(ListItem listItem) {
        items.add(listItem);
        notifyDataSetChanged();
    }

    public void removeListItem(int index) {
        items.remove(index);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.text_list_item, null);
            holder = new ViewHolder();
            holder.editTextText = (TextView)view.findViewById(R.id.text_textEntered);
            holder.dateCreatedText = (TextView)view.findViewById(R.id.text_dateCreated);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        holder.editTextText.setText(items.get(i).getText(), TextView.BufferType.SPANNABLE);
        Spannable textSpannable = (Spannable)holder.editTextText.getText();
        textSpannable.setSpan(new StyleSpan(Typeface.BOLD), 0, textSpannable.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textSpannable.setSpan(new AbsoluteSizeSpan(36, true), 0, textSpannable.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - HH:mm:ss");
        holder.dateCreatedText.setText(dateFormat.format(items.get(i).getDateCreated()));
        return view;
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }
}
