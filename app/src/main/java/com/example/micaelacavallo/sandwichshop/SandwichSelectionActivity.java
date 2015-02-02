package com.example.micaelacavallo.sandwichshop;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class SandwichSelectionActivity extends ActionBarActivity {
    Button mButtonContinue;
    EditText mEditTextSelection;
    int count;
    public static final String TOTAL_ORDERS = "TOTAL_ORDERS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwich_selection);
        prepareEditTextSelection();
        prepareButtonContinue();
    }

    private void prepareEditTextSelection() {
        mEditTextSelection = (EditText)findViewById(R.id.editText);
        mEditTextSelection.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s))
                {
                    count = Integer.parseInt(mEditTextSelection.getText().toString());
                    if (count<6 && count>0)
                    {
                        mButtonContinue.setEnabled(true);
                    }
                    else
                    {
                        mButtonContinue.setEnabled(false);
                    }
                }
                else
                {
                    mButtonContinue.setEnabled(false);
                }
            }
        });
    }

    private void prepareButtonContinue() {
        mButtonContinue = (Button)findViewById(R.id.button_continue);
        mButtonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(SandwichSelectionActivity.this, OrderFormActivity.class);
                    intent.putExtra(TOTAL_ORDERS, count);
                    startActivity(intent);
                }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sandwich_count_selection, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
