package io.github.sagar15795.meetupsampleapp.data.remote;

import java.util.List;

import io.github.sagar15795.meetupsampleapp.data.model.Book;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BookService {

    @GET("/book")
    Call<List<Book>> getBook();

}
