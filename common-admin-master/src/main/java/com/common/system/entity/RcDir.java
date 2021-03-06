package com.common.system.entity;

import java.io.Serializable;

public class RcDir implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
    private String editUser;
    private String url;
    private Integer status;
    private String statuStr;
    
    public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEditUser() {
		return editUser;
	}
	public void setEditUser(String editUser) {
		this.editUser = editUser;
	}
	public String getStatuStr() {
		if(status == 1) {
			statuStr = "开启";
		}else if(status == 0) {
			statuStr = "关闭";
		}
		return statuStr;
	}
	public void setStatuStr(String statuStr) {
		this.statuStr = statuStr;
	} 
	@Override
    public String toString() {
        return "Dir{" +
                "id='" + id + '\'' +
                ", editUser='" + editUser + '\'' +
                ", url='" + url + '\'' +                
                ", status=" + status +
                ", statuStr='" + statuStr + 
                '}';
    }
}
