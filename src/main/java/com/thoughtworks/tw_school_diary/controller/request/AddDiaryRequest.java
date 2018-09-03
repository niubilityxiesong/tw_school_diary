package com.thoughtworks.tw_school_diary.controller.request;

import lombok.Data;

@Data
public class AddDiaryRequest {
    private String content;
    private String date;
}
