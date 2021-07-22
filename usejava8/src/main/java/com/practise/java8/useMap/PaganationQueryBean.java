package com.practise.java8.useMap;

import java.util.HashMap;
import java.util.Map;

public class PaganationQueryBean {

	private int pageIndex = 0;
	private int pageSize = 10;
	private String name;
	private String userId;
	private Map<String,String> condition = new HashMap<String,String>();

	public PaganationQueryBean() {
	}

	public Map<String, String> getCondition() {
		return condition;
	}


	public void setCondition(Map<String, String> condition) {
		this.condition = condition;
	}
	
	

	public int getPageIndex() {
		return pageIndex;
	}


	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}

    @Override
    public String toString() {
        return "PaganationQueryBean{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", condition=" + condition +
                '}';
    }
}
