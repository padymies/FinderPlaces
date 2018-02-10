package proyectodam.pady.com.finderplaces;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Usuario on 13/10/2017.
 */

public class Controladora extends Application{
    ApiInterface nearByApi = null;
    public static String PLACE_API_BASE_URL = "https://maps.googleapis.com/maps/";
    static Controladora app;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public ApiInterface getApiService() {
        if (nearByApi == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().retryOnConnectionFailure(true).readTimeout(80, TimeUnit.SECONDS).connectTimeout(80, TimeUnit.SECONDS).addInterceptor(interceptor).build();

            Retrofit retrofit = new Retrofit.Builder().baseUrl(PLACE_API_BASE_URL).addConverterFactory(getApiConvertorFactory()).client(client).build();

            nearByApi = retrofit.create(ApiInterface.class);
            return nearByApi;
        } else {
            return nearByApi;
        }
    }

    private static GsonConverterFactory getApiConvertorFactory() {
        return GsonConverterFactory.create();
    }

    public static Controladora getApp() {
        return app;
    }
}



