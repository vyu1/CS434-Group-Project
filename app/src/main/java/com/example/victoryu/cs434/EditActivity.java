package com.example.victoryu.cs434;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by victoryu on 12/7/15.
 */
public class EditActivity extends Activity {
    private String locationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent i = getIntent();
        locationName = i.getStringExtra("name");
        EditText name = (EditText) findViewById(R.id.locationName);
        name.setText(locationName);
    }

    public void saveInformation(View saveButton) {
        onBackPressed();
    }
}
