package com.tangj.web.pojo.product;


import java.util.List;

import com.tangj.web.oval.ProductCategoryInfoCheckImpl;
import com.tangj.web.pojo.base.BaseInfo;

import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

/**
 * 商品分类信息
 * @author jian.tang
 *
 */
public class ProductCategoryInfo extends BaseInfo{

	//新增
	public static final String ADD = "ADD";
	
	//修改
	public static final String MODIFY = "MODIFY";
	
	@NotNull(message = "ID不能为空" , profiles = {MODIFY})
	@NotEmpty(message = "ID不能为空" , profiles = {MODIFY})
	private Long id;
	
	@NotNull(message = "分类名称不能为空" , profiles = {MODIFY,ADD})
	@NotEmpty(message = "分类名称不能为空" , profiles = {MODIFY,ADD})
	@MaxLength(value = 50 , message = "分类名称最大长度为50个字符" , profiles = {MODIFY,ADD})
	private String name;
	
	@NotNull(message = "上级ID不能为空" , profiles = {MODIFY,ADD})
	@NotEmpty(message = "上级ID不能为空" , profiles = {MODIFY,ADD})
	@Min(value = 0 , message = "上级ID格式错误" , profiles = {MODIFY,ADD})
	@CheckWith(value = ProductCategoryInfoCheckImpl.class , message = "上级分类不存在" ,profiles = {ADD})
	private Long parentId;
	
	private List<ProductCategoryInfo> children;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public List<ProductCategoryInfo> getChildren() {
		return children;
	}

	public void setChildren(List<ProductCategoryInfo> children) {
		this.children = children;
	}
	
}
