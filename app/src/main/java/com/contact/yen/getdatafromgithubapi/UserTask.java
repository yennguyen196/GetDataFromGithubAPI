package com.contact.yen.getdatafromgithubapi;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UserTask extends AsyncTask<String, Void, List<User>> {
    private static final String REQUEST_METHOD = "GET";
    private static final String ID = "id";
    private static final String NODE_ID  ="node_id";
    private static final String NAME  ="name";
    private static final String FULLNAME  ="fullname";

    private onLoadDataFinishedListener mListener;

     UserTask(onLoadDataFinishedListener listener) {
        this.mListener = listener;
    }


    @Override
    protected List<User> doInBackground(String... strings) {
        StringBuilder response = new StringBuilder();
        String apiEndPoint = strings[0];
        try {
            //mo ket noi
            URL url = new URL(apiEndPoint);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(REQUEST_METHOD);
            // de luu du lieu
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                response.append(inputLine);
            }
            bufferedReader.close();
            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.e("tag",response.toString());
        List<User> users = getDataFromResponse(response.toString());
        Log.e("tag",users.size()+"");
        return users;
    }

    private List<User> getDataFromResponse(String s) {
        List<User> listUser = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(s);
            for(int i = 0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt(ID);
                String nodeID = jsonObject.getString(NODE_ID);
                String name = jsonObject.getString(NAME);
                String fullName = jsonObject.getString(FULLNAME);

                User user = new User(id, nodeID, name,fullName);
                listUser.add(user);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listUser;
    }

    @Override
    protected void onPostExecute(List<User> users) {
        super.onPostExecute(users);
        mListener.onLoadDataFinished(users);
    }

    interface onLoadDataFinishedListener {
        void onLoadDataFinished(List<User> users);
    }
}
