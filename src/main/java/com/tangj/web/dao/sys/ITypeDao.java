package com.tangj.web.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tangj.web.pojo.sys.TypeInfo;
import com.tangj.web.util.TableConstanst;

public interface ITypeDao {

	@Select(value = "select * from " + TableConstanst.TB_TYPE + " where type = #{type} order by seq")
	public List<TypeInfo> getListByType(@Param("type")Integer type);

}
