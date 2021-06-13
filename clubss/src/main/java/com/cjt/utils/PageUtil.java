package com.cjt.utils;

import lombok.Data;

/**
 * 封装分页类
 *
 * @author cjt
 *
 */
@Data
public class PageUtil {

    // 这两个属性叫这个名字，是为了对应layui的laytable分页参数
    private int page = 1;// 当前页数
    private int limit = 10;// 每页显示多少条
    private int offset;// 偏移量 从哪个下标开始，sql语句limit后的第一个数字

    /*
     * 其实不需要这样设置offset 1.前端layui自己管理分页 2.持久层mybatis plus自己处理偏移量 3.以上两者都只需要页码和条数就行了
     */
    public void setOffset(int page) {
        this.page = page;
        this.offset = (this.page - 1) * this.limit;
    }

}