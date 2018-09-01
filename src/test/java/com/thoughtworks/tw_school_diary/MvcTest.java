package com.thoughtworks.tw_school_diary;

import com.thoughtworks.tw_school_diary.controller.DiaryController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

@SpringBootTest(classes = TwSchoolDiaryApplication.class)
@RunWith(SpringRunner.class)
public abstract class MvcTest {

    @Autowired
    private DiaryController diaryController;
    @Before
    public void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(diaryController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }

}
