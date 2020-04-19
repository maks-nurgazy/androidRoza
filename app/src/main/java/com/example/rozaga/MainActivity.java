package com.example.rozaga;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rozaga.model.Example;
import com.example.rozaga.retrofit.RozaService;
import com.example.rozaga.retrofit.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView code, name, surname, username;
    Button btnUpdateName;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        code = findViewById(R.id.coachCode);
        name = findViewById(R.id.coachName);
        surname = findViewById(R.id.coachSurname);
        username = findViewById(R.id.coachUsername);
        btnUpdateName = findViewById(R.id.btnUpdateName);
        progressBar = findViewById(R.id.progressBar);

        btnUpdateName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                RozaService rozaService =
                        ServiceGenerator.createService(RozaService.class);
                Call<List<Example>> call = rozaService.getUserData();
                call.enqueue(new Callback<List<Example>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Example>> call, @NonNull Response<List<Example>> response) {
                        progressBar.setVisibility(View.GONE);
                        if (response.isSuccessful()) {
                            List<Example> message = response.body();
                            if (message != null) {
                                int r = (int) Math.round(Math.random() * (message.size())) - 1;
                                Example example = message.get(r);
                                code.setText("code: " + example.getCoachKod());
                                name.setText("name: " + example.getCoachName());
                                surname.setText("surname: " + example.getCoachSurname());
                                username.setText("username: " + example.getUserInfo().getUserLogin());
                            }

                        } else {
                            // error response, no access to resource?
                            System.out.println("no access to resource");
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Example>> call, @NonNull Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        // something went completely south (like no internet connection)
                        if (t.getMessage() != null) {
                            System.out.println("Error occurred");
                            Log.d("Error", t.getMessage());
                        }
                    }
                });


            }
        });
    }
}
