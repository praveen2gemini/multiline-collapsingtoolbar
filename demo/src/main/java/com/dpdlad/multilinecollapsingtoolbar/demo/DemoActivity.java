package com.dpdlad.multilinecollapsingtoolbar.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DemoActivity extends AppCompatActivity {

    TextView spannedTextView;
    SpannableStringBuilder spannableContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        spannedTextView = findViewById(R.id.spanned_textview);
        String title = getString(R.string.title);
        String subTitle = getString(R.string.sub_title);
        String content = subTitle + "\n" + title;
        int totalSpanLength = content.length();
        spannableContent = new SpannableStringBuilder(content);
        spannableContent.setSpan(new RelativeSizeSpan(1.25f), 0, subTitle.length() + 1, 0);
        spannableContent.setSpan(new RelativeSizeSpan(2f), subTitle.length() + 1, totalSpanLength, 0);
        spannedTextView.setText(spannableContent);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
