package com.thoughtworks.tw_school_diary.controller.response;

import lombok.Data;

@Data
public class DiariesListResponse {
    int id;
    String date;
    String content;
    String changeDiary;

    public DiariesListResponse(int id, String date, String content, String changeDiary) {
        this.id = id;
        this.date = date;
        this.content = content;
        this.changeDiary = changeDiary;
    }
}
