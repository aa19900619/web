package com.tangj.web.Exception;

/**
 * 自定义错误信息
 * @author jian.tang
 *
 */
public class BaseException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseException(String msg){
		super(msg);
	}
	
}
