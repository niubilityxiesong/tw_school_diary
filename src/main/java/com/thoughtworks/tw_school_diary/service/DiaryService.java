package com.thoughtworks.tw_school_diary.service;

import com.thoughtworks.tw_school_diary.controller.response.DiariesListResponse;
import com.thoughtworks.tw_school_diary.entity.Diary;
import com.thoughtworks.tw_school_diary.controller.request.AddDiaryRequest;
import com.thoughtworks.tw_school_diary.exception.DiaryNotFoundException;
import com.thoughtworks.tw_school_diary.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    public int addDiary(AddDiaryRequest addDiaryRequest) {
        Diary diary = new Diary();
        diary.setContent(addDiaryRequest.getContent());
        diary.setDate(addDiaryRequest.getDate());
        return diaryRepository.save(diary).getId();
    }

    public List<DiariesListResponse> getDiary(int page) {
        int pageSize = 2;

        Sort sort = new Sort(Sort.Direction.DESC, "date");
        PageRequest pageRequest = new PageRequest(page, pageSize, sort);
        Page<Diary> pageDiary = diaryRepository.findAll(pageRequest);
        List<Diary> diaries = pageDiary.getContent();
        List<DiariesListResponse> diariesList = new ArrayList<>();
        for (Diary diary : diaries) {
            diariesList.add(
                    new DiariesListResponse(diary.getId(),
                            diary.getDate(),
                            diary.getContent(),
                            "diary-display-block"));
        }

        return diariesList;
    }

    public void deleteDiary(int id) {
        Diary diary = diaryRepository.findById(id).orElseThrow(DiaryNotFoundException::new);
        diaryRepository.delete(diary);
    }


    public void updateDiary(Diary updateDiary, int id) {
        Diary diary = diaryRepository.findById(id).orElseThrow(DiaryNotFoundException::new);
        updateDiary.setId(diary.getId());
        diaryRepository.save(updateDiary);
    }

}
