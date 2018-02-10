package proyectodam.pady.com.finderplaces;

import model.NearByApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Usuario on 08/10/2017.
 */

public interface ApiInterface {




    @GET("api/place/nearbysearch/json?sensor=true&key=AIzaSyCz7dZnnPd7Hfde0zQa1HBvaXNaCygmgTI")
    Call<NearByApiResponse> getPlaces(@Query("type") String type, @Query("location") String location, @Query("radius") int radius);


}


