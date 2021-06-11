package data;

import pojo.MyModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
   public static APIClient apiClient;
    final String baseURL = "https://newsapi.org/v2/";
    DataApiInterface dataApiInterface;
    private String country = "us";
    private String category = "business";
    private String apiKey = "a9cdae3302144365887e252c47bb0b4b";



   public APIClient(){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl( baseURL )
                    .addConverterFactory( GsonConverterFactory.create() )
                    .build();
             dataApiInterface = retrofit.create( DataApiInterface.class );

        }

    public static APIClient getApiClient() {
            if (apiClient==null){
                apiClient= new APIClient();
            }
        return apiClient;
    }

    public Call<MyModel> getCall (){
            return dataApiInterface.call(country,category,apiKey ) ;
    }
}
