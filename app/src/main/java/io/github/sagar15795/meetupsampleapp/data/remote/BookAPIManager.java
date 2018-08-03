package io.github.sagar15795.meetupsampleapp.data.remote;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author lusifer
 */
public class BookAPIManager {
    public static final String SERVER_END_POINT = "http://206.189.137.189:8080";
    private BookService bookService;

    private <T> T createJsonApi(Class<T> clazz, String ENDPOINT) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(new BookOkHttpClient().getBookOkHttpClient())
                .build();

        return retrofit.create(clazz);
    }

    public BookService getBookApi() {
        if(bookService==null) {
            bookService = createJsonApi(BookService.class, SERVER_END_POINT);
        }
        return bookService;
    }
}
