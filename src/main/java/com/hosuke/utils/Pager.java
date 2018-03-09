package com.hosuke.utils;

/**
 * @Author Hosuke
 */
public class Pager {
    private int pageSize;//每页显示数据条数
    private int currentPage;//当前页面
    private int totalRecord;//总数据条数
    private int totalPage;//总页面数

    public int getTotalPage() {
        return totalPage;
    }

    //首页
    private int firstPage;
    //末页
    private int lastPage;
    //上一页
    private int prePage;
    //下一页
    private int nextPage;

    public Pager() {
    }

    public Pager(int currentPage, int pageSize, int totalRecord) {
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        this.totalPage = calculateTotalPage();
        //负责计算 传入的 页面索引 是否超出最大页面数值 超出就设置为最大页面索引
        this.currentPage = currentPage > totalPage ? totalPage : currentPage;
    }

    private int calculateTotalPage() {
        this.totalPage = this.totalRecord / this.pageSize;
        if (totalRecord % pageSize != 0) {
            this.totalPage = this.totalPage + 1;
        }
        return totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getFirstPage() {
        this.firstPage = 1;
        return this.firstPage;
    }

    public int getLastPage() {
        this.lastPage = totalPage;
        return lastPage;
    }

    public int getPrePage() {
        if (this.currentPage <= 1) {
            this.prePage = -1;
        }else {
            this.prePage = this.currentPage - 1;
        }
        return this.prePage;
    }

    public int getNextPage(){
        if(this.currentPage >= totalPage){
            this.nextPage = -1;
        }else {
            this.nextPage = this.currentPage + 1;
        }
        return this.nextPage;
    }

    public int getStartIndex(){
        return (currentPage-1)*pageSize;
    }
}
