package com.tangj.web.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5
 * @author jian.tang
 *
 */
public class MD5Utils {

	public static String MD5(String val) {
		try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(val.getBytes());
            StringBuffer buffer = new StringBuffer();
            for (byte b : result) {
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
	}
	
}
