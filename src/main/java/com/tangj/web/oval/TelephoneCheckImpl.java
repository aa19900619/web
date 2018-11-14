package com.tangj.web.oval;

import java.util.regex.Pattern;

import com.tangj.web.util.Constanst;
import com.tangj.web.util.StringUtils;

import net.sf.oval.constraint.CheckWithCheck.SimpleCheck;

/**
 * 手机号码验证
 * @author jian.tang
 *
 */
public class TelephoneCheckImpl implements SimpleCheck{

	private static final long serialVersionUID = 1L;

	@Override
	public boolean isSatisfied(Object validatedObject, Object value) {
		if( value instanceof String){
			if( !StringUtils.isEmpty((String)value) ){
				return Pattern.matches(Constanst.TELEPHONE_REG, (CharSequence) value);
			}
		}
		return true;
	}

	
	
	
}
