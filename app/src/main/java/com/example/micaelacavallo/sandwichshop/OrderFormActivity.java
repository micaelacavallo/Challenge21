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


    private class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
           String toppingOptions = "";
           Intent intent = new Intent(OrderFormActivity.this, OrderConfirmationActivity.class);
                if (mRadioButtonRye.isChecked()) {
                    toppingOptions += mRadioButtonRye.getText().toString() + " bread \n";
                }
                else {
                    if (mRadioButtonWheat.isChecked()) {
                        toppingOptions += mRadioButtonWheat.getText().toString() + " bread \n";
                    }
                    else {
                        toppingOptions += mRadioButtonWhite.getText().toString() + " bread \n";
                    }
                }
                if (mCheckBoxBacon.isChecked()) {
                        toppingOptions += mCheckBoxBacon.getText().toString() + "\n";
                }
                if (mCheckBoxCheese.isChecked()) {
                    toppingOptions += mCheckBoxCheese.getText().toString() + "\n";
                }
                if (mCheckBoxEgg.isChecked()) {
                    toppingOptions += mCheckBoxEgg.getText().toString() + "\n";
                }
                if (mCheckBoxTomato.isChecked()) {
                    toppingOptions += mCheckBoxTomato.getText().toString() + "\n";
                }
                if (mCheckBoxLettuce.isChecked()) {
                    toppingOptions += mCheckBoxLettuce.getText().toString() + "\n";
                }
                if (mCheckBoxOlives.isChecked()) {
                    toppingOptions += mCheckBoxOlives.getText().toString() + "\n";
                }
                if (mCheckBoxOnion.isChecked()) {
                    toppingOptions += mCheckBoxOnion.getText().toString() + "\n";
                }
                if (mCheckBoxPickles.isChecked()) {
                    toppingOptions += mCheckBoxPickles.getText().toString();
                }
           intent.putExtra(Intent.EXTRA_TEXT, toppingOptions);
           startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_form);
        prepareRadioButtons();
        prepareCheckBoxs();
        prepareButtonPlaceOrder();
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
