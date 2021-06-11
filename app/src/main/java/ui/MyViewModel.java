package ui;

import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import data.APIClient;
import data.DataApiInterface;
import pojo.MyModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyViewModel extends ViewModel {

    private String country = "us";
    private String category = "business";
    private String apiKey = "a9cdae3302144365887e252c47bb0b4b";


    MutableLiveData<MyModel> mutableLiveData = new MutableLiveData();

    void getData( ) {

//        Retrofit retrofit = new Retrofit.Builder().baseUrl( "" ).addConverterFactory( GsonConverterFactory.create() ).build();
//        DataApiInterface dataApiInterface = retrofit.create( DataApiInterface.class );
//        Call<MyModel> call = dataApiInterface.call(country, category,apiKey );
//        call.enqueue( new Callback<MyModel>() {
//            @Override
//            public void onResponse(Call<MyModel> call, Response<MyModel> response) {
//                mutableLiveData.setValue( response.body() );
//            }
//
//            @Override
//            public void onFailure(Call<MyModel> call, Throwable t) {
//
//
//            }
//        } );


        APIClient.getApiClient().getCall().enqueue( new Callback<MyModel>() {
            @Override
            public void onResponse(Call<MyModel> call, Response<MyModel> response) {
                mutableLiveData.setValue( response.body() );
            }

            @Override
            public void onFailure(Call<MyModel> call, Throwable t) {

            }
        } );
    }



}
