package com.thoughtworks.tw_school_diary.controller.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddDiaryRequest {
    private String content;
    private LocalDate date;
}
