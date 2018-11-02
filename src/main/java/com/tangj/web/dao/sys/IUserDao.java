package com.tangj.web.dao.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tangj.web.pojo.sys.UserInfo;
import com.tangj.web.util.TableConstanst;

public interface IUserDao {

	@Select(value = "select * from " + TableConstanst.TB_USER + " where login_name = #{username} and pass_word = #{password}")
	public UserInfo login(@Param("username")String username,@Param("password") String password);
	
	@Select(value = "select id,user_name from " + TableConstanst.TB_USER)
	public List<UserInfo> queryUsers(Map<String, Object> param);
	
}
