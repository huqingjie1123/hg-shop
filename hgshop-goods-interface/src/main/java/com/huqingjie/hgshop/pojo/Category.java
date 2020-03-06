package com.huqingjie.hgshop.pojo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @ClassName: Category 
 * @Description: TODO
 * @author: lenovo
 * @date: 2020年3月6日 上午10:58:00
 */
public class Category  implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 132779590146042324L;
	
	private Integer id; // 
	
	private Integer parentId; // 涓婁竴绾у埆鍒嗙被鐨刬d  parent_id
	
	@JsonProperty("text")
	private String name;//鍒嗙被鐨勫悕绉�
	private String path;// 浠庢牴鍒嗙被鍒板綋鍓嶅垎绫荤殑璺緞
	@JsonProperty("nodes")
	private List<Category> children;// 浠庢牴鍒嗙被鍒板綋鍓嶅垎绫荤殑璺緞
	
	
	
	public List<Category> getChildren() {
		return children;
	}
	public void setChildren(List<Category> children) {
		this.children = children;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", parentId=" + parentId + ", name=" + name + ", path=" + path + ", children="
				+ children + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

	

}
