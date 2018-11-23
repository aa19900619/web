package com.tangj.web.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

public class WebUtils {

	/**
	 * 文件大小格式化
	 * @param v
	 * @return
	 */
	public static String fileSize(long v){
		
		BigDecimal nv = BigDecimal.valueOf(v);
		BigDecimal size = BigDecimal.valueOf(1024);
		
		String val = "";
		int scale = 3;
		int randinigModel = BigDecimal.ROUND_HALF_UP;
		if( nv.compareTo(size) == -1 ){
			val = nv + "B";
		}
		else if( nv.compareTo(size) != -1 
				&& nv.compareTo(size.multiply(size)) == -1 ){
			val = nv.divide(size).setScale(scale, randinigModel) + "KB";
		}
		else if( nv.compareTo(size.multiply(size)) != -1  &&  
				 nv.compareTo(size.multiply(size).multiply(size)) == -1   ){
			val = nv.divide(size.multiply(size)).setScale(scale, randinigModel) + "MB";
		}
		else if( nv.compareTo(size.multiply(size).multiply(size)) != -1 && 
				 nv.compareTo(size.multiply(size).multiply(size).multiply(size)) == -1 ){
			val = nv.divide(size.multiply(size).multiply(size)).setScale(scale, randinigModel) + "GB";
		}
		else if( nv.compareTo(size.multiply(size).multiply(size).multiply(size)) != -1 ){
			val = nv.divide(size.multiply(size).multiply(size).multiply(size)).setScale(scale, randinigModel) + "TB";
		}
		return val;
	}
	
	
	public static void copy(InputStream fi , FileOutputStream fo) {
		int temp = 0;
		try {
			while( ( temp = fi.read() ) != -1 ){
				fo.write(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				fi.close();
				fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
