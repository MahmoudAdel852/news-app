package ui;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import data.APIClient;
import pojo.MyModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewModel extends ViewModel {
    //...........................................
    // make extends from viewModel
    // mutable live data
    // change this data and use observer to end your job
    //...........................................

  MutableLiveData<MyModel> mutableLiveData = new MutableLiveData();

    void getData( ) {
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
