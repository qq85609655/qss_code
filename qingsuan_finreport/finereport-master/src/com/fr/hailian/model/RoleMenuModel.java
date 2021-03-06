package com.fr.hailian.model;

import java.io.Serializable;

/**
 * 
 * 角色与菜单对应实体
 *
 */
public class RoleMenuModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6201547131958870064L;
	private String id;
	private String name;
	private String pid;
	private String pname;
	private String reportletpath;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getReportletpath() {
		return reportletpath;
	}
	public void setReportletpath(String reportletpath) {
		this.reportletpath = reportletpath;
	}
	
}
