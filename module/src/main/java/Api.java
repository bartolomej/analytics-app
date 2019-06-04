import retrofit2.Retrofit;

public class Api {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .build();

    RestApi service = retrofit.create(RestApi.class);
}
