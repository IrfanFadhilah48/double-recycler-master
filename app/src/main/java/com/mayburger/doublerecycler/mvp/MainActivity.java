package com.mayburger.doublerecycler.mvp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.mayburger.doublerecycler.R;
import com.mayburger.doublerecycler.adapter.ScholarshipAdapter;
import com.mayburger.doublerecycler.api.ApiClient;
import com.mayburger.doublerecycler.api.ApiInterface;
import com.mayburger.doublerecycler.model.Data;
import com.mayburger.doublerecycler.model.Scholarship;
import com.mayburger.doublerecycler.model.ScholarshipData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements HomeView{

    @BindView(R.id.recycler_open)
    RecyclerView recycler_open;
    @BindView(R.id.recycler_recommended)
    RecyclerView recycler_recommended;
    @BindView(R.id.recycler_awardee)
    RecyclerView recycler_awardee;

    private ScholarshipAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        ApiInterface service = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<Data> call = service.getDataInfo();

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                loadData(response.body().getData());

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
    }

    private void loadData(List<ScholarshipData> data) {
        adapter = new ScholarshipAdapter(this, data);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_open.setLayoutManager(layoutManager);
        recycler_open.setAdapter(adapter);
        Log.e("data", data.toString());
    }

    @Override
    public void onGetOpen(List<Scholarship> data) {

    }

    @Override
    public void onGetRecommended(List<Scholarship> data) {

    }

    @Override
    public void onGetAwardee(List<Scholarship> data) {

    }
}
