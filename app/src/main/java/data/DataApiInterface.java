package data;


import java.util.List;

import pojo.MyModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

//........................................................................
//=> get retrofit dependencies
//=> use inter face to get data from json
// @Query to get id from many ids
//........................................................................
public interface DataApiInterface  {

    @GET("top-headlines")
    public Call<MyModel> call(

            @Query( "country" ) String country,
            @Query("category"  ) String category,
            @Query("apiKey") String apiKey

    );
}
