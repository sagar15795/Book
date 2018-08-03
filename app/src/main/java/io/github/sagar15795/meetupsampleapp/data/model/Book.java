package io.github.sagar15795.meetupsampleapp.data.model;

import com.google.gson.annotations.SerializedName;


public class Book {

    @SerializedName("author_id")
    private String mAuthorId;
    @SerializedName("id")
    private Long mId;
    @SerializedName("title")
    private String mTitle;

    public String getAuthorId() {
        return mAuthorId;
    }

    public void setAuthorId(String authorId) {
        mAuthorId = authorId;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
