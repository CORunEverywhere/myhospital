package org.hospital.entity;

import java.util.List;

public class DepotKeeperPage {
    private int currentPage;
    private int pageSize;
    private int totalCount;
    private int totalPage;
    private List<DepotKeeper> DepotKeepers;
    public DepotKeeperPage() {

    }
    public DepotKeeperPage(int currentPage, int pageSize, int totalCount, int totalPage, List<DepotKeeper> DepotKeepers) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.DepotKeepers = DepotKeepers;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage() {
        this.totalPage = this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;
    }
    public List<DepotKeeper> getDepotKeepers() {
        return DepotKeepers;
    }
    public void setDepotKeepers(List<DepotKeeper> depotKeepers) {
        this.DepotKeepers = depotKeepers;
    }
}
