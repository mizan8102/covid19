package com.bangladesh.covid19bd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button stat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        stat = findViewById(R.id.stat);
        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, CountryInfo.class);
                startActivity(i);

            }
        });


    }

    public void call(View view) {
        String m="16263".toString();
        Uri u = Uri.parse("tel:" +m);
        Intent i = new Intent(Intent.ACTION_DIAL,u);
        try
        {
            // Launch the Phone app's dialer with a phone
            // number to dial a call.
            startActivity(i);
        }
        catch (SecurityException s)
        {
            // show() method display the toast with
            // exception message.
            Toast.makeText(this, s.toString(), Toast.LENGTH_LONG)
                    .show();
        }
    }

    public void web(View view) {
        Intent intent=new Intent(MainActivity.this,Govt_web.class);
        startActivity(intent);

    }
}