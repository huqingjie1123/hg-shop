package com.huqingjie.hgshop.pojo;

import java.io.Serializable;
/**
 * 
 * @ClassName: Brand 
 * @Description: TODO
 * @author: huqingjie
 * @date: 2020��3��3�� ����9:40:20
 */
public class Brand implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -6875239861206232781L;

	private Integer id;	//id
	private String name; //Ʒ������
	private String firstChar; //Ʒ������ĸ
	private Integer deletedFlag; //αɾ����ʶ
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
	public String getFirstChar() {
		return firstChar;
	}
	public void setFirstChar(String firstChar) {
		this.firstChar = firstChar;
	}
	public Integer getDeletedFlag() {
		return deletedFlag;
	}
	public void setDeletedFlag(Integer deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", firstChar=" + firstChar + ", deletedFlag=" + deletedFlag + "]";
	}
	public Brand() {
		super();
	}
	public Brand(Integer id, String name, String firstChar, Integer deletedFlag) {
		super();
		this.id = id;
		this.name = name;
		this.firstChar = firstChar;
		this.deletedFlag = deletedFlag;
	}
	
	
	
	
}
