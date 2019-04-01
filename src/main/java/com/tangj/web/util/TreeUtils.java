package com.tangj.web.util;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TreeUtils {

	public static JSONArray createTree(List<ZTreeInfo> list, List<Long> val){
		List<ZTreeInfo> data = createTree(list, val,true);
		JSONArray parseArray = JSONArray.parseArray(JSONArray.toJSONString(data));
		
		for( int i = 0 ; i < parseArray.size() ; i++ ){
			JSONObject json = parseArray.getJSONObject(i);
			if( json.getJSONArray("children").isEmpty() ){
				json.remove("children");
			}else{
				clearChildren(json);
			}
		}
		return parseArray;
	}
	
	private static void clearChildren(JSONObject json){
		if( json.getJSONArray("children").isEmpty() ){
			json.remove("children");
		}else{
			JSONArray jsonArray = json.getJSONArray("children");
			for( int i = 0 ; i < jsonArray.size() ; i++ ){
				clearChildren(jsonArray.getJSONObject(i));
			}
		}
	}
	
	
	private static List<ZTreeInfo> createTree(List<ZTreeInfo> list,List<Long> val,boolean bool) {
		List<ZTreeInfo> children = new ArrayList<ZTreeInfo>();
    	for (ZTreeInfo node : list) {
    		if ( node.getPid() == null || node.getPid() == 0 ) {
    			initChildren(node, list , val);
    			if( val.contains(node.getId()) ){
    				node.setChecked("true");
    			}
             	children.add(node);
         	}
     	}
    	return children;
    }
	
	/**
	 * 创建子集
	 * @param treeNode
	 * @param list
	 * @param val
	 */
    private static void initChildren(ZTreeInfo treeNode, List<ZTreeInfo> list,List<Long> val) {
    	List<ZTreeInfo> children = new ArrayList<ZTreeInfo>();
     	for (ZTreeInfo node : list) {
     		Long id = treeNode.getId();
     		if ( id.longValue() == node.getPid().longValue() ){
            	initChildren(node, list , val);
            	if( val.contains(node.getId()) ){
    				node.setChecked("true");
    			}
            	children.add(node);
        	}
     	}
     	treeNode.setChildren(children);
    }
	
}
