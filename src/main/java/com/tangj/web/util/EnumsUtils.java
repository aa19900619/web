package com.tangj.web.util;

import java.util.ArrayList;
import java.util.List;

import com.tangj.web.enums.DictionaryEnum;

public class EnumsUtils {

	/**
	 * 字典转集合
	 * @return
	 */
	public static List<KeyValue> getDictionaryEnum(){
		List<KeyValue> list = new ArrayList<KeyValue>();
		DictionaryEnum[] values = DictionaryEnum.values();
		for( int i = 0 ; i < values.length ; i++ ){
			list.add(new KeyValue(values[i].toString(), values[i].getDesc()));
		}
		return list;
	}
	
	/**
	 * 回去编码明文
	 * @param code
	 * @return
	 */
	public static String getDictionaryEnumDesc(String code){
		try {
			return DictionaryEnum.valueOf(code).getDesc();
		} catch (Exception e) {
			return "";
		}
	}
	
	
}
