package com.example.micaelacavallo.sandwichshop;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;


public class OrderConfirmationActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);
        TextView mTextViewSummary = (TextView)findViewById(R.id.text_view_summary);
        ArrayList<Sandwich> orders = getIntent().getExtras().getParcelableArrayList(OrderFormActivity.ORDERS);
        String summary = "";
        int n = 0;
        for (Sandwich s : orders){
            n++;
            String result = "Sandwich " + Integer.toString(n) + ": ";
            result += s.getBread() + " " + (s.getCheese()?"cheese ":"") +
                    (s.getPickles()?"pickles ":"") +
                    (s.getLettuce()?"lettuce ":"") +
                    (s.getTomato()?"tomato ":"") +
                    (s.getBacon()?"bacon":"") +
                    (s.getEgg()?"egg":"") +
                    (s.getOlives()?"olives":"") +
                    (s.getOnion()?"onion": "") + "\n";
            summary += result;
        }

       mTextViewSummary.setText(summary);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_order_confirmation, menu);
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
