package com.tangj.web.enums;

/**
 * 字典类型
 * @author jian.tang
 *
 */
public enum DictionaryEnum {

	GOOD_FL("商品分类"),GOOD_GG("商品规格"),GOOD_PP("商品品牌");
	
	private String desc;
	private DictionaryEnum(String desc){
		this.desc = desc;
	}
	
	public String getDesc(){
		return this.desc;
	}
	
}
