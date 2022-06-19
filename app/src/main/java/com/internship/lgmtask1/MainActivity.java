package com.internship.lgmtask1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.internship.lgmtask1.model.City;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Button btnSearch;
    String state="";
    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<City> arrayList = new ArrayList<City>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("LGM Task1");

        spinner = findViewById(R.id.spinner);
        btnSearch = findViewById(R.id.btnSearch);
        recyclerView = findViewById(R.id.recyclerView);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.state_list, android.R.layout.simple_spinner_item);
        spinner.setAdapter(arrayAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(arrayList);
        recyclerView.setAdapter(adapter);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = spinner.getSelectedItem().toString();

                String url = "https://data.covid19india.org/state_district_wise.json";
                JsonObjectRequest
                        jsonObjectRequest
                        = new JsonObjectRequest(
                        Request.Method.GET,
                        url,
                        null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            arrayList.clear();
                            JSONObject jsonObject = response.getJSONObject(state).getJSONObject("districtData");
                            Iterator it = jsonObject.keys();
                            while(it.hasNext()){
                                String name = it.next().toString();
                                City city = new City(name, jsonObject.getJSONObject(name).getString("active")
                                , jsonObject.getJSONObject(name).getString("confirmed"), jsonObject.getJSONObject(name).getString("recovered"));
                                arrayList.add(city);
                            }
                            adapter.dataChange(arrayList);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Not able to fetch data", Toast.LENGTH_SHORT).show();
                    }
                });
                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                requestQueue.add(jsonObjectRequest);
            }
        });

    }
}