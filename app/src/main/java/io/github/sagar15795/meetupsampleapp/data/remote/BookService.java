package io.github.sagar15795.meetupsampleapp.data.remote;

import java.util.List;

import io.github.sagar15795.meetupsampleapp.data.model.Book;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface BookService {

    @GET("/book")
    Call<List<Book>> getBook();

    @POST("/book")
    @Headers("Content-Type: application/json")
    Call<ResponseBody> addBook(@Body Book book);
}
