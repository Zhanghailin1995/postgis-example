package org.example.postgis;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
