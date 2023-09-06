package org.example.postgis;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("plot_data_test")
public class PlotData {

    @TableId
    private String id;

    @TableField(typeHandler = WKTPointTypeHandler.class)
    private WKTPointType centerPoint;

    private Double plotArea;

    private String plotName;

    private String geohashColumn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public WKTPointType getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(WKTPointType centerPoint) {
        this.centerPoint = centerPoint;
    }

    public Double getPlotArea() {
        return plotArea;
    }

    public void setPlotArea(Double plotArea) {
        this.plotArea = plotArea;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public String getGeohashColumn() {
        return geohashColumn;
    }

    public void setGeohashColumn(String geohashColumn) {
        this.geohashColumn = geohashColumn;
    }
}
