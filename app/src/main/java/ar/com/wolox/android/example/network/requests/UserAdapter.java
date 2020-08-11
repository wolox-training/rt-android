package ar.com.wolox.android.example.network.requests;

import ar.com.wolox.android.example.network.services.UserService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * User Adapter
 */
public class UserAdapter {

    private static UserService userService;
    private static final String BASE_URL = "https://android-training.herokuapp.com/";

    public UserService getApiUserService() {
        if (userService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            userService = retrofit.create(UserService.class);
        }
        return userService;
    }
}
