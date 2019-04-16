package com.jt.sys.entity;
import java.io.Serializable;
import com.jt.common.entity.BaseEntity;

public class SysDept extends BaseEntity implements Serializable{
	private static final long serialVersionUID = -5259265803332215029L;
	private Integer id;
	private String name;
	private Integer parentId;
	private Integer sort;
	private String note;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "SysDept [id=" + id + ", name=" + name + ", parentId=" + parentId + ", sort=" + sort + ", note=" + note
				+ "]";
	}
}
