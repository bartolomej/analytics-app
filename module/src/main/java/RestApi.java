import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestApi {
    @POST("users/{user}/repos")
    String listRepos(@Path("user") String user);
}
