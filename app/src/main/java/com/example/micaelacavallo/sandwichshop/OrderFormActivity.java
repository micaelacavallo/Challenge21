package com.example.micaelacavallo.sandwichshop;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;


public class OrderFormActivity extends ActionBarActivity {
    Button mButtonPlaceOrder;
    Button mButtonPlaceOrderLand;
    ArrayList<CheckBox> mCheckBoxSelected;


    private class ButtonListener implements View.OnClickListener{


        @Override
        public void onClick(View v) {
            Intent intent = new Intent(OrderFormActivity.this, OrderConfirmationActivity.class);
            if (v == mButtonPlaceOrder)
            {

            }
            else
            {

            }
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_form);
        mCheckBoxSelected = new ArrayList<>();
        prepareButtonPlaceOrder();
    }

    private void prepareButtonPlaceOrder() {
        ButtonListener listener = new ButtonListener();
        mButtonPlaceOrder = (Button)findViewById(R.id.button_place_order);
        mButtonPlaceOrder.setOnClickListener(listener);
        mButtonPlaceOrderLand = (Button)findViewById(R.id.button_place_order_land);
        mButtonPlaceOrderLand.setOnClickListener(listener);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_order_form, menu);
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
