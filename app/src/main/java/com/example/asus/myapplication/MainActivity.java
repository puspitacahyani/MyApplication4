package com.example.asus.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBuy(View view) {
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(i);
    }

    public void onClickKatalog(View view) {
        Intent i = new Intent(MainActivity.this, Main4Activity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater Inflater = getMenuInflater();
        Inflater.inflate(R.menu.option ,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent about = new Intent(this, Main3Activity.class);
                startActivity(about);

                break;
            case R.id.buy:
                Intent buy = new Intent(this, Main2Activity.class);
                startActivity(buy);

                break;
            case R.id.quit:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Anda Yakin Ingin keluar?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        finish();

                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();


                    }
                });
                AlertDialog quit = builder.create();
                quit.show();

                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
