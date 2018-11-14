package com.tangj.web.vo.base;

public class AutoCompleteVO {

	public AutoCompleteVO(){}
	
	private String label;
	
	private String value;
	
	private Object data;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public AutoCompleteVO(String label) {
		super();
		this.label = label;
		this.value = label;
	}

	public AutoCompleteVO(String label, Object data) {
		super();
		this.label = label;
		this.value = label;
		this.data = data;
	}
	
}
