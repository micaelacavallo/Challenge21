package com.example.micaelacavallo.sandwichshop;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;


public class OrderFormActivity extends ActionBarActivity {
    Button mButtonPlaceOrder;

    RadioButton mRadioButtonWheat;
    RadioButton mRadioButtonWhite;
    RadioButton mRadioButtonRye;

    CheckBox mCheckBoxTomato;
    CheckBox mCheckBoxLettuce;
    CheckBox mCheckBoxCheese;
    CheckBox mCheckBoxBacon;
    CheckBox mCheckBoxEgg;
    CheckBox mCheckBoxOlives;
    CheckBox mCheckBoxPickles;
    CheckBox mCheckBoxOnion;
    int num_total_orders;
    ArrayList<Sandwich> mOrders;
    public static final String TOTAL_ORDERS = "TOTAL_ORDERS";
    public static final String ORDERS = "ORDERS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_form);
        prepareRadioButtons();
        prepareCheckBoxs();
        prepareButtonPlaceOrder();
        num_total_orders = Integer.parseInt(getIntent().getExtras().get(TOTAL_ORDERS).toString());
        if (savedInstanceState!=null){
            mOrders = savedInstanceState.getParcelableArrayList(ORDERS);
        } else {
            mOrders = new ArrayList<>();
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(ORDERS, mOrders);
    }


    private void prepareCheckBoxs() {
        mCheckBoxTomato = (CheckBox)findViewById(R.id.check_box_tomato);
        mCheckBoxLettuce= (CheckBox)findViewById(R.id.check_box_lettuce);
        mCheckBoxCheese= (CheckBox)findViewById(R.id.check_box_cheese);
        mCheckBoxBacon= (CheckBox)findViewById(R.id.check_box_bacon);
        mCheckBoxEgg= (CheckBox)findViewById(R.id.check_box_egg);
        mCheckBoxOlives= (CheckBox)findViewById(R.id.check_box_olives);
        mCheckBoxPickles= (CheckBox)findViewById(R.id.check_box_pickles);
        mCheckBoxOnion= (CheckBox)findViewById(R.id.check_box_onion);
    }

    private void prepareRadioButtons() {
        mRadioButtonWheat = (RadioButton)findViewById(R.id.radio_button_wheat);
        mRadioButtonWhite = (RadioButton)findViewById(R.id.radio_button_white);
        mRadioButtonRye = (RadioButton)findViewById(R.id.radio_button_rye);
    }

    private void prepareButtonPlaceOrder() {
        ButtonListener listener = new ButtonListener();
        mButtonPlaceOrder = (Button)findViewById(R.id.button_place_order);
        mButtonPlaceOrder.setOnClickListener(listener);
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Sandwich sandwich = getOrder();
            mOrders.add(sandwich);

            if (num_total_orders == mOrders.size()) {
                Intent intent = new Intent(OrderFormActivity.this, OrderConfirmationActivity.class);
                Bundle extrasBundle = new Bundle();
                extrasBundle.putParcelableArrayList(ORDERS, mOrders);
                intent.putExtras(extrasBundle);
                startActivity(intent);
            } else
            {
                    reset();
            }
            Toast.makeText( getBaseContext(),"The sandwich has been added to the order", Toast.LENGTH_SHORT).show();
        }
    }

    private Sandwich getOrder() {
        Sandwich sand = new Sandwich();

        if (mRadioButtonRye.isChecked()) {
            sand.setBread("Rye");
        }
        else {
            if (mRadioButtonWheat.isChecked()) {
                sand.setBread("Wheat");
            }
            else {
                sand.setBread("White");
            }
        }
        if (mCheckBoxBacon.isChecked()) {
            sand.setBacon(true);
        }
        if (mCheckBoxCheese.isChecked()) {
            sand.setCheese(true);
        }
        if (mCheckBoxEgg.isChecked()) {
            sand.setEgg(true);
        }
        if (mCheckBoxTomato.isChecked()) {
            sand.setTomato(true);
        }
        if (mCheckBoxLettuce.isChecked()) {
            sand.setLettuce(true);
        }
        if (mCheckBoxOlives.isChecked()) {
            sand.setOlives(true);
        }
        if (mCheckBoxOnion.isChecked()) {
            sand.setOnion(true);
        }
        if (mCheckBoxPickles.isChecked()) {
            sand.setPickles(true);
        }
        return sand;
    }


    private void reset(){
        mRadioButtonWheat.setChecked(true);
        mCheckBoxBacon.setChecked(false);
        mCheckBoxCheese.setChecked(false);
        mCheckBoxLettuce.setChecked(false);
        mCheckBoxOlives.setChecked(false);
        mCheckBoxOnion.setChecked(false);
        mCheckBoxPickles.setChecked(false);
        mCheckBoxEgg.setChecked(false);
        mCheckBoxTomato.setChecked(false);
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
