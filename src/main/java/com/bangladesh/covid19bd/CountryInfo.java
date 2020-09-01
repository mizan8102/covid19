package com.bangladesh.covid19bd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CountryInfo extends AppCompatActivity {

    TextView cases,death,recover,active,serious,today,total;
    ImageView back;

    Button btncountry,global;
    private ProgressDialog pDialog;

    String link="https://disease.sh/v3/covid-19/countries/Bangladesh?yesterday=false&twoDaysAgo=false&allowNull=0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_info);
        getSupportActionBar().hide();

        back = findViewById(R.id.imageView);
        btncountry=(Button)findViewById(R.id.button3);
        global=(Button)findViewById(R.id.button4);
        cases=(TextView)findViewById(R.id.textView12);
        death=(TextView)findViewById(R.id.textView14);
        recover=(TextView)findViewById(R.id.textView18);
        active=(TextView)findViewById(R.id.textView16);
        serious=(TextView)findViewById(R.id.textView20);
        today=(TextView)findViewById(R.id.textView9);
        total=(TextView)findViewById(R.id.textView8) ;
        countryData();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(CountryInfo.this, MainActivity.class);
                startActivity(i);
                finish();


            }
        });
    }

    public void global(View view) {

       global.setBackground(this.getResources().getDrawable(R.drawable.spinner_bg));
       global.setTextColor(this.getResources().getColor(R.color.black));
        btncountry.setBackground(this.getResources().getDrawable(R.drawable.statistic_button));
        btncountry.setTextColor(this.getResources().getColor(R.color.white));
        total.setTextColor(getResources().getColor(R.color.white));
        today.setTextColor(getResources().getColor(R.color.optoday));
        //Code Start Here
        link="https://corona.lmao.ninja/v2/all/";
        fetchData();


    }

    public void country(View view) {

        btncountry.setBackground(this.getResources().getDrawable(R.drawable.spinner_bg));
        btncountry.setTextColor(this.getResources().getColor(R.color.black));
       global.setBackground(this.getResources().getDrawable(R.drawable.statistic_button));
       global.setTextColor(this.getResources().getColor(R.color.white));
        total.setTextColor(getResources().getColor(R.color.white));
        today.setTextColor(getResources().getColor(R.color.optoday));
       //Code Start Here
        String link="https://disease.sh/v3/covid-19/countries/Bangladesh?yesterday=false&twoDaysAgo=false&allowNull=0";
        countryData();

    }
    private void fetchData() {

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Please wait...");
        pDialog.show();
        String url  = "https://corona.lmao.ninja/v2/all/";



        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            hidePDialog();
                            cases.setText(jsonObject.getString("cases"));
                            recover.setText(jsonObject.getString("recovered"));
                            serious.setText(jsonObject.getString("critical"));
                            active.setText(jsonObject.getString("active"));
                            death.setText(jsonObject.getString("deaths"));

                        } catch (JSONException e) {
                            e.printStackTrace();


                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                hidePDialog();
                startActivity(new Intent(CountryInfo.this,NetworkErrorActivity.class));
                finish();
                Toast.makeText(CountryInfo.this,"your internet is slow", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }
    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }


    // Find country
    private void countryData(){
        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Please wait...");
        pDialog.show();
        String url  = "https://disease.sh/v3/covid-19/countries/Bangladesh?yesterday=false&twoDaysAgo=false&allowNull=0";

        link="https://disease.sh/v3/covid-19/countries/Bangladesh?yesterday=false&twoDaysAgo=false&allowNull=0";

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            hidePDialog();
                            cases.setText(jsonObject.getString("cases"));
                            recover.setText(jsonObject.getString("recovered"));
                            serious.setText(jsonObject.getString("critical"));
                            active.setText(jsonObject.getString("active"));
                            death.setText(jsonObject.getString("deaths"));

                        } catch (JSONException e) {
                            e.printStackTrace();


                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                hidePDialog();
                startActivity(new Intent(CountryInfo.this,NetworkErrorActivity.class));
                Toast.makeText(CountryInfo.this, "your connection is weak", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }


    public void today(View view) {
        today.setTextColor(getResources().getColor(R.color.white));
        total.setTextColor(getResources().getColor(R.color.optoday));
            todayData(link);

    }

    private  void todayData(String url){

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Please wait...");
        pDialog.show();



        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            hidePDialog();
                            cases.setText(jsonObject.getString("todayCases"));
                            recover.setText(jsonObject.getString("todayRecovered"));
                            serious.setText(jsonObject.getString("critical"));
                            active.setText(jsonObject.getString("active"));
                            death.setText(jsonObject.getString("todayDeaths"));

                        } catch (JSONException e) {
                            e.printStackTrace();


                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                hidePDialog();
                startActivity(new Intent(CountryInfo.this,NetworkErrorActivity.class));
                Toast.makeText(CountryInfo.this, "your connection is weak", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);



    }

    public void total(View view) {


    }
}


