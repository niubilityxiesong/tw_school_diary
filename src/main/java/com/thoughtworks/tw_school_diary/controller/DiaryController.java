package com.thoughtworks.tw_school_diary.controller;

import com.thoughtworks.tw_school_diary.controller.response.DiariesListResponse;
import com.thoughtworks.tw_school_diary.entity.Diary;
import com.thoughtworks.tw_school_diary.controller.request.AddDiaryRequest;
import com.thoughtworks.tw_school_diary.exception.DiaryNotFoundException;
import com.thoughtworks.tw_school_diary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RequestMapping("/diaries")
@RestController
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    @PostMapping
    public ResponseEntity add(@RequestBody AddDiaryRequest addDiaryRequest) {
        int id = diaryService.add(addDiaryRequest);
        return ResponseEntity.created(URI.create("/diaries" + id)).build();
    }

    @GetMapping
    public ResponseEntity<List<DiariesListResponse>> get(@RequestParam int page) {
        return diaryService.get(page);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        diaryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Diary updateDiaryRequest, @PathVariable int id) {
        diaryService.update(updateDiaryRequest, id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void DiaryNotFoundException(DiaryNotFoundException ex){}
}
