package org.chinalbs.systemtool.bean;

import java.util.List;

/*
Create by jiangyun on 2018/2/12
*/
public class TopAll implements BasicReturn{
    private Top top;
    private List<TopInfo> topInfobeans;


    public TopAll() {
    }

    public TopAll(Top top, List<TopInfo> topInfobeans) {
        this.top = top;
        this.topInfobeans = topInfobeans;
    }

    public Top getTop() {
        return top;
    }

    public void setTop(Top top) {
        this.top = top;
    }

    public List<TopInfo> getTopInfobeans() {
        return topInfobeans;
    }

    public void setTopInfobeans(List<TopInfo> topInfobeans) {
        this.topInfobeans = topInfobeans;
    }

    @Override
    public String toString() {
        return "TopAll{" +
                "top=" + top +
                ", topInfobeans=" + topInfobeans +
                '}';
    }
}
