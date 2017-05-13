package com.example.asus.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    EditText nama;
    Button min , plus , order;
    TextView blank , total;

    int harga=0;
    int qty=0;

    Spinner spinner;
    List<String> ListMenu = new ArrayList<>();
    RadioGroup radiogroup;
    RadioButton oreoku , vanillaku , berryku;
    Context kontek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        kontek=getApplicationContext();
        setContentView(R.layout.activity_main2);
        total = (TextView) findViewById(R.id.total);
        nama = (EditText) findViewById(R.id.nama);
        order = (Button) findViewById(R.id.order);
        blank = (TextView) findViewById(R.id.blank);
        min = (Button) findViewById(R.id.min);
        plus = (Button) findViewById(R.id.plus);
        radiogroup = (RadioGroup) findViewById(R.id.radiogrup);
        oreoku = (RadioButton) findViewById(R.id.oreo);
        vanillaku = (RadioButton) findViewById(R.id.vanilla);
        berryku = (RadioButton) findViewById(R.id.berry);

        oreoku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(kontek, "Item 1 di klik", Toast.LENGTH_SHORT).show();
            }
        });

        vanillaku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(kontek, "Item 2 di klik", Toast.LENGTH_SHORT).show();
            }
        });

        berryku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(kontek, "Item 3 di klik", Toast.LENGTH_SHORT).show();
            }
        });

        spinner = (Spinner) findViewById(R.id.spinner);
        ListMenu.add("             ");
        ListMenu.add("Original");
        ListMenu.add("Chocolate");
        ListMenu.add("Red Velvet");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ListMenu);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    public void onClickOrder(View view) {
        Intent emailintent = new Intent(Intent.ACTION_SEND);
        emailintent.setData(Uri.parse("mailto :"));
        emailintent.setType("text/plain");
        emailintent.putExtra(Intent.EXTRA_EMAIL, "arieridwansyah@gmail.com");
        emailintent.putExtra(Intent.EXTRA_SUBJECT, nama.getText());
        emailintent.putExtra(Intent.EXTRA_TEXT,
                "Saya  "
                        + nama.getText()
                        + "  Pesan  "
                        + spinner.getSelectedItem()
                        + "  Sebanyak  "
                        + blank.getText()
                        + "  Seharga  "
                        + total.getText());
        try {
            startActivity(Intent.createChooser(emailintent, "send mail ....."));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, " There is no email client installed", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickPlus(View view) {
        harga = harga + 3;
        qty = qty + 1;
        blank.setText(qty + "");
        total.setText("$" + harga);
    }

    public void onClickMin(View v) {
        if (harga != 0) {
            harga = harga - 3;
            qty = qty - 1;
            blank.setText(qty + "");
            total.setText("$" + harga);
        } else {
            harga = 0;
            qty = 0;
            blank.setText(qty + "");
            total.setText("$" + harga);
        }
    }

    public void onClickReset(View view) {
        harga = 0;
        qty = 0;
        nama.setText("");
        total.setText("$" + harga);
        blank.setText(qty + "");

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
