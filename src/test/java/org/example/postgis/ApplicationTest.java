package org.example.postgis;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;
import java.util.List;

@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private PlotDataDao plotDataDao;

    @Test
    public void test() {
        PlotData plotData = plotDataDao.selectById("17eb44e03568471490f9ee9ab136f049");
        System.out.println(plotData);
        long start = System.currentTimeMillis();
        PlotData plotData1 = plotDataDao.selectById("792f0a44923b4e3396d45ca1b4dd66f1");
        System.out.println(plotData1.getCenterPoint().getWkt());
        System.out.println(plotData1.getGeohashColumn());

//        PlotData plotData2 = new PlotData();
//        plotData2.setId("792f0a44923b4e3396d45ca1b4dd66f1");
//        plotData2.setCenterPoint(new WKTPoint("POINT (120.4194077 30.3119454)"));
//        plotData2.setPlotArea(19.18);
//        plotData2.setPlotName("test");
//        plotDataDao.insert(plotData2);

        PlotData plotData3 = new PlotData();
        plotData3.setId("792f0a44923b4e3396d45ca1b4dd66f1");
        plotData3.setCenterPoint(new WKTPointType("POINT (120.4189428 30.3111598)"));
        plotDataDao.updateById(plotData3);

        PlotData plotData4 = plotDataDao.selectById("792f0a44923b4e3396d45ca1b4dd66f1");
        System.out.println(plotData4.getCenterPoint().getWkt());
        System.out.println(plotData4.getGeohashColumn());
    }


    @Autowired
    private TimeTestDao timeTestDao;

    @Test
    public void test1() {
//        List<TimeTest> timeTests = timeTestDao.selectList(Wrappers.emptyWrapper());
//        for (TimeTest timeTest : timeTests) {
//            OffsetDateTime timeZone = timeTest.getTimeZone();
//            System.out.println(timeZone);
//            long epoch = timeZone.toInstant().toEpochMilli();
//            System.out.println(epoch);
//        }
        String ts = "2024-09-21T11:00:00+08:00";
        OffsetDateTime start = OffsetDateTime.parse(ts);
        List<TimeTest> timeTests1 = timeTestDao.selectList(Wrappers.lambdaQuery(TimeTest.class).gt(TimeTest::getTimeZone, start));
        for (TimeTest timeTest : timeTests1) {
            OffsetDateTime timeZone = timeTest.getTimeZone();
            System.out.println(timeZone);
            long epoch = timeZone.toInstant().toEpochMilli();
            System.out.println(epoch);
        }
    }
}
