package com.rashem8432.experience;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class directions_retriever extends Service {
    public directions_retriever() {

    }

@Override
public void onCreate(){
    super.onCreate();
}
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Double my_lat = intent.getDoubleExtra("my_lat",0.0);
        Double my_long = intent.getDoubleExtra("my_long",0.0);
        Double target_lat = intent.getDoubleExtra("target_lat",0.0);
        Double target_long = intent.getDoubleExtra("target_long",0.0);
        try {


            //------------------>>
            String orig=Double.toString(my_lat)+","+Double.toString(my_long);
            String dest=Double.toString(target_lat)+","+Double.toString(target_long);

            String url="https://maps.googleapis.com/maps/api/directions/json?origin="+orig+"&destination="+dest+"&key="+getResources().getString(R.string.maps_api_key);
            HttpGet httppost = new HttpGet(url);
            HttpClient httpclient = new DefaultHttpClient();

            HttpResponse response = httpclient.execute(httppost);

            // StatusLine stat = response.getStatusLine();
            int status = response.getStatusLine().getStatusCode();

            if (status == 200) {
                HttpEntity entity = response.getEntity();
                String data = EntityUtils.toString(entity);


                asdf.jsono = new JSONObject(data);
                asdf.test =asdf.jsono;

                return 1;
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {

            e.printStackTrace();
        }catch (Exception e){

        }
        return 0;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
