package com.example.jsonpasing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private String key = "USZ276Nnnc3S%2F%2FYFZfYpS%2BJPtkmp8u42NTbiTvPUFEJYPAKSmvGAvJMkcd3vaXQxOreSh2bpVhz6tZ4Nn3v7uQ%3D%3D";
    private String address = "http://api.data.go.kr/openapi/tn_pubr_public_trrsrt_api";
    private String pageNo = "0";
    private String numOfRows = "100";
    private String type = "json";
    private ListView listView;
    private Button btnData;
    ArrayAdapter adapter;

    // 관광명소 이름 을 담을 ArrayList 변수(travel) 선언
    ArrayList<String> travel = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView1);
        // adapter 스타일 선언 및 travel 적용
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, travel);
        // listView에 adapter 적용
        listView.setAdapter(adapter);
        btnData = (Button) findViewById(R.id.btnData);

        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        travel.clear();
                        String urlAddress = address + "?serviceKey=" + key + "&pageNo=" + pageNo + "&numOfRows=" + numOfRows + "&type=" + type;

                        try {
                            URL url = new URL(urlAddress);

                            InputStream is = url.openStream();
                            InputStreamReader isr = new InputStreamReader(is);
                            BufferedReader reader = new BufferedReader(isr);

                            StringBuffer buffer = new StringBuffer();
                            String line = reader.readLine();
                            while (line != null) {
                                buffer.append(line + "\n");
                                line = reader.readLine();
                            }

                            String jsonData = buffer.toString();

                            // jsonData를 먼저 JSONObject 형태로 바꾼다.
                            JSONObject obj = new JSONObject(jsonData);
                            // obj의 "response"의 JSONObject를 추출
                            JSONObject response = (JSONObject) obj.get("response");
                            // response의 JSONObject에서 "body"의 JSONObject 추출
                            JSONObject body = (JSONObject) response.get("body");
                            // body의 JSONObject에서 "items"의 JSONArray 추출
                            JSONArray items = (JSONArray) body.get("items");

                            for (int i = 0; i < items.length(); i++) {

                                JSONObject temp = items.getJSONObject(i);

                                String trrsrtNm = temp.getString("trrsrtNm");

                                travel.add(trrsrtNm);
                            }

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    adapter.notifyDataSetChanged();
                                }
                            });

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
            }
        });

    }
}