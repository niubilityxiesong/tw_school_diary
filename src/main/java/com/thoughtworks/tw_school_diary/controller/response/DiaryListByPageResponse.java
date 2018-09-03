package com.thoughtworks.tw_school_diary.controller.response;

import lombok.Data;

import java.util.List;

@Data
public class DiaryListByPageResponse {
    List<DiaryResponse> diaryResponseList;
    long totalDiaries;
    int page;

    public DiaryListByPageResponse(List<DiaryResponse> diaryResponseList, long totalDiaries, int page) {
        this.diaryResponseList = diaryResponseList;
        this.totalDiaries = totalDiaries;
        this.page = page;
    }
}
