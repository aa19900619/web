var Jq = {

	MessageBox : {
		
		//1、成功  2、错误  3、询问  4、锁   5、不开心	6、开心	  7、警告

		//普通提示
		alert:function(msg,fn){
			parent.layer.alert(msg,function(index){
				parent.layer.close(index);
				if( fn ){	fn();	}
			});
		},
		
		//成功提示
		success : function(msg,fn){
			parent.layer.alert(msg,{icon:1},function(index){
				parent.layer.close(index);
				if( fn ){	fn();	}
			});
		},
		
		//错误提示
		error : function(msg,fn){
			parent.layer.alert(msg,{icon:2},function(index){
				parent.layer.close(index);
				if( fn ){	fn();	}
			});
		},
		
		//警告提示
		warning : function(msg , fn){
			parent.layer.alert(msg,{icon:7},function(index){
				parent.layer.close(index);
				if( fn ){	fn();	}
			});
		},
		
		//确认信息
		confirm : function(msg,fn){
			var button = ["确定","取消"];
			var msgText = "";
			if( typeof msg == "string" ){
				msgText = msg;
			}
			if( typeof msg == "object" ){
				button = msg["buttonText"];
				msgText = msg["msg"];
			}
			parent.layer.confirm(msgText, {icon: 3, title:'提示信息',btn:button}, function(index){
				parent.layer.close(index);
				if( fn ){
					fn();
				}
			});
		}

	},

	msg : {
		
		success : function(msg){
			parent.layer.msg(msg,{icon: 6 , time : 3000});
		},

		error : function(msg){
			parent.layer.msg(msg,{icon: 5, time : 3000});
		},

		warning : function(msg){
			parent.layer.msg(msg,{icon: 7, time : 3000});
		}

	},

	loading : function(){
		return parent.layer.load(2); //换了种风格
	},

	closeLoading : function(index){
		parent.layer.close(index);
	},

	open : function(obj,data,fn){
		toAjaxHtml(obj["url"],data,function(result){
			var param = {};
			param["type"] = 1;
			param["title"] = ( obj["title"] ? obj["title"] : "");
			var width = ( obj["width"] ? obj["width"] : "800px" );
			var height = ( obj["height"] ? obj["height"] : "600px");
			param["area"] = [width , height];
			var btn_save = ( obj["btn_save"] ? obj["btn_save"] : "保存" );
			var btn_icon = ( obj["btn_icon"] ? obj["btn_icon"] : "Hui-iconfont-save" );
			param["btn"] = ["<i class='Hui-iconfont " + btn_icon + "'></i>" + btn_save , "<i class='Hui-iconfont Hui-iconfont-close'></i>关闭"];
			param["content"] = result;
			param["yes"] = function(index){
				fn&&fn(index);
			};
			parent.layer.open(param);
		});
	},
	
	content : function(obj,context,fn){
		var param = {};
		param["type"] = 1;
		param["title"] = ( obj["title"] ? obj["title"] : "");
		var width = ( obj["width"] ? obj["width"] : "800px" );
		var height = ( obj["height"] ? obj["height"] : "600px");
		param["area"] = [width , height];
		param["btn"] = ["<i class='Hui-iconfont Hui-iconfont-save'></i>保存" , "<i class='Hui-iconfont Hui-iconfont-close'></i>关闭"];
		param["content"] = context;
		param["yes"] = function(index){
			fn&&fn(index);
		};
		parent.layer.open(param);
	},
	
	view : function(obj,data,fn){
		toAjaxHtml(obj["url"],data,function(result){
			var param = {};
			param["type"] = 1;
			param["title"] = ( obj["title"] ? obj["title"] : "");
			var width = ( obj["width"] ? obj["width"] : "800px" );
			var height = ( obj["height"] ? obj["height"] : "600px");
			param["area"] = [width , height];
			param["btn"] = ["<i class='Hui-iconfont Hui-iconfont-close'></i>关闭"];
			param["content"] = result;
			param["yes"] = function(index){
				fn&&fn(index);
			};
			parent.layer.open(param);
		});
	},
	
	photos : function(arr){
		var obj = {};
		obj["data"] = arr;
		parent.layer.photos({
			photos:obj
		});
	},
	
	photo : function(obj){
		var arr = new Array();
		arr.push({src:$(obj).attr("src")});
		parent.Jq.photos(arr);
	}
	
};

function toAjaxHtml(uri, ajaxdata, callback, panelName){
	//因为搜索后，翻页链接中，可能会加入_packageCode#packageName包含#的字段名，所以特殊转换下字符
	uri = uri.replace(/#/g,"%23");
	jQuery.ajax({
        type: "get",
        cache:false,
        dataType: 'html', 
        url: uri,
        data: ajaxdata,
        success: function(data, textStatus) {
	    	 try{
				data = jQuery.parseJSON(data);
				if (data && !data.success){
					if (callback != null) {
						if (panelName != null && panelName != "")
							callback(data.message, panelName);
						else 
							callback(data.message);
					}
				} else {
					if (callback != null) {
						if (panelName != null && panelName != "")
							callback(data, panelName);
						else 
							callback(data);
		            }
				}
			}catch(e) {
				data = data.replace(/td>\s+<td/g, 'td><td');
				if (callback != null) {
					if (panelName != null && panelName != "")
						callback(data, panelName);
					else 
						callback(data);
	            }
			}		
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            if(XMLHttpRequest.status == 403){
            	location.reload();
            }
        }
    });
}

//同步ajax返回json
function queryData(url,param,callBack)
{
	var index = parent.Jq.loading();
	$.ajax({
		type : "post",
		"async" : true,
		"url" : url,
		"data" : param,  
		"dataType" :"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		success :function(result) {
			parent.Jq.closeLoading(index);
			callBack && callBack(result);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown){
			parent.Jq.closeLoading(index);
        	errorMsg(XMLHttpRequest);
		}
	});
};


function toGet(url, para, callback, errcallback) {
    url = url.replace(/#/g,"%23");
    var index = parent.Jq.loading();
	$.ajax({
        type: "get",
        url: url,
        data: para,
        cache:false,
        dataType: 'json',
        success: function (data, textStatus) {
        	parent.Jq.closeLoading(index);
            if (callback != null) {
                callback(data);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	parent.Jq.closeLoading(index);
        	errorMsg(XMLHttpRequest);
        }
    });
}

function errorMsg(XMLHttpRequest){
	/*if( 403 == XMLHttpRequest.status ){
		Jq.MessageBox.error("无操作权限");
	}else if( 404 == XMLHttpRequest.status ){
		Jq.MessageBox.error("请求地址错误");
	}else if( 405 == XMLHttpRequest.status ){
		Jq.MessageBox.error("请求方式错误");
	}else if( 500 == XMLHttpRequest.status ){
		Jq.MessageBox.error("后台操作，请联系管理员");
	}else{
		Jq.MessageBox.error("返回结果错误");
	}*/
	var result = eval("(" + XMLHttpRequest.responseText + ")");
	Jq.MessageBox.error(result.msg);
}


//异步ajax返回json
function queryDataAsync(url,param)
{ 
	var data = {};
	jQuery.support.cors = true;
	$.ajax({
		async : false,
		url : url,
		data : param,
		dataType :"json",
		type : "post",
		crossDomain:true, 
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		success :function(result) {
			data = result;
		},
		error : function(XMLHttpRequest, textStatus, errorThrown){
        	errorMsg(XMLHttpRequest);
		}
	});
	return data;
} 


function toSaved(url, para, callback, errcallback) {
    url = url.replace(/#/g,"%23");
    var index = parent.Jq.loading();
	$.ajax({
        type: "post",
        url: url,
        data: para,
        cache:false,
        dataType: 'json',
        success: function (data, textStatus) {
        	parent.Jq.closeLoading(index);
            if (callback != null) {
                callback(data);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	parent.Jq.closeLoading(index);
            if (errcallback != null) {
            	var result = eval("(" + XMLHttpRequest.responseText + ")");
                errcallback(result);
            }else{
            	errorMsg(XMLHttpRequest);
            }
        }
    });
}

function toJson(url, para, callback, errcallback) {
    url = url.replace(/#/g,"%23");
    var index = parent.Jq.loading();
    para = JSON.stringify(para);
	$.ajax({
        type: "post",
        url: url,
        data: para,
        cache:false,
        dataType: 'json',
        contentType:"application/json",
        success: function (data, textStatus) {
        	parent.Jq.closeLoading(index);
            if (callback != null) {
                callback(data);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	parent.Jq.closeLoading(index);
            if (errcallback != null) {
            	var result = eval("(" + XMLHttpRequest.responseText + ")");
                errcallback(result);
            }else{
            	errorMsg(XMLHttpRequest);
            }
        }
    });
}


/**
 * 注册template格式化日期数据
 */
$(function(){
	
	template.helper('dateFormat', function (date, format) {
		date = new Date(date);

		var map = {
			"M": date.getMonth() + 1, //月份
			"d": date.getDate(), //日
			"h": date.getHours(), //小时
			"m": date.getMinutes(), //分
			"s": date.getSeconds(), //秒
			"q": Math.floor((date.getMonth() + 3) / 3), //季度
			"S": date.getMilliseconds() //毫秒
		};

		format = format.replace(/([yMdhmsqS])+/g, function(all, t){
			var v = map[t];
			if(v !== undefined){
				if(all.length > 1){
					v = '0' + v;
					v = v.substr(v.length-2);
				}
				return v;
			}

			else if(t === 'y'){
				return (date.getFullYear() + '').substr(4 - all.length);
			}
			return all;
		});
		return format;
	});
	
	
	template.helper('numberFormat', function (val,fixed) {
		return parseFloat(val).toFixed(fixed);
	});
	
	
});

/**
 * form装JsonObject Ps:不支持多个name相同，否则后面的值会覆盖前面的值
 */
$.fn.serializeObject = function()    
{    
   var o = {};    
   var a = this.serializeArray();    
   $.each(a, function() {    
       if (o[this.name]) {    
           if (!o[this.name].push) {    
               o[this.name] = [o[this.name]];    
           }    
           o[this.name].push(this.value || '');    
       } else {    
           o[this.name] = this.value || '';    
       }    
   });    
   return o;    
};


/**
 * ztree
 */
var ztree = {
	init:function(id,setting,zNodes){
		return $.fn.zTree.init($("#"+id),setting,zNodes);
	},
	get:function(id){
		return $.fn.zTree.getZTreeObj(id);
	},
	checked:function(id){		//获取勾选的
		return this.get(id).getCheckedNodes(true);
	},
	nchecked:function(id){		//获取未勾选的
		return this.get(id).getCheckedNodes(false);
	},
	changeChecked:function(id){	//被修改过的checked的值
		return this.get(id).getChangeCheckedNodes();
	},
	getData:function(id){
		var nodes = this.get(id).getSelectedNodes();
		if( nodes.length == 0 ){	return undefined;	}
		return nodes[0];
	}
};

/**
 * jquery.validation使用正则表达式使用
 * 例子：/^[a-zA-Z]$/ 传入的值为: ^[a-zA-Z]$
 */
$.validator.addMethod("reg",function(value,elemtn,params){
	var exp = new RegExp(params,"g");
	return exp.test(value);
},"内容格式输入错误");