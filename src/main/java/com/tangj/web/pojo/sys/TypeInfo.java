package com.tangj.web.pojo.sys;

/**
 *	类型表（1货物单位1，2货物单位2，3支付类型）
 * @author sisimiemie
 *
 */
public class TypeInfo{
	private Long id;
	
	private String type;
	
	private String name;
	
	private Integer seq;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	
	
}
