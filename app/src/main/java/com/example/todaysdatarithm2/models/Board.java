package com.example.todaysdatarithm2.models;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class Board {
    private String documentId;
    private String title;
    private String contents;
    private String nickname;
    @ServerTimestamp
    private Date date;
    public Board() {}

    public Board(String documentId, String nickname, String title, String contents) {
        this.documentId = documentId;
        this.nickname = nickname;
        this.title = title;
        this.contents = contents;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Board{" +
                "documentId='" + documentId + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", nickname='" + nickname + '\'' +
                ", date=" + date +
                '}';
    }
}
