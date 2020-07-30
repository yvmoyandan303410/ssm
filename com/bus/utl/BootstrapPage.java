package com.bus.utl;

import java.util.List;

//这个类  类似于我们自己写的page类
public class BootstrapPage<T> {

    //用BootsStrap的table组件分页  需要这个帮助类
    private int total;      //总记录数
    private List<T> rows;   //查到的数据

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
