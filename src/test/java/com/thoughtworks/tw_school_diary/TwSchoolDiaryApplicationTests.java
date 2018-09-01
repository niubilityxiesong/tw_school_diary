package com.thoughtworks.tw_school_diary;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DBRider
@DBUnit(caseSensitiveTableNames = true)
@DataSet("diary.yml")
public class TwSchoolDiaryApplicationTests {

	@Test
	public void contextLoads() {
	}

}
