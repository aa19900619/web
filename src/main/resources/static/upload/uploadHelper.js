function upload(id,fn,accept,type){
	var _this = $("#"+id);
	var val = _this.val();
	if(val == null || val == ""){
		return;
	}
	
	if( accept != "" ){
		var split = accept.split(",");	//分组
		bool = false;
		for( var i = 0 ; i < split.length ; i++ ){
			var _o = split[i].toLowerCase();
			var _obj = val.toLowerCase().substring(val.lastIndexOf(_o),val.length);
			if( _o == _obj )bool = true;
		}
		if( !bool ){
			_this.val("");
			Jq.MessageBox.error("上传的文件类型错误，只能上传" + accept + "类型的文件");
			return;
		}
	}
	
	var index = Jq.loading();	//弹出加载
	var address = base + "upload/upload";
	$.ajaxFileUpload({
        url: address, 
        type: 'post',
        secureuri: false, 			//一般设置为false
        fileElementId: id, 			// 上传文件的id、name属性名
        dataType: 'json', 			//返回值类型，一般设置为json、application/json
        elementIds: '', 			//传递参数到服务器
        businessType:type,
        success: function(data, status){
        	Jq.closeLoading(index);
        	//data["buttonId"] = id;
        	if( data.code == 0 ){
        		fn(data["data"]);
        	}else{
        		Jq.MessageBox.error("上传失败，失败原因：" + data["msg"]);
        	}
        },
        error: function(data, status, e){
        	Jq.closeLoading(index);
            Jq.MessageBox.error("上传失败");
        }
    });
	
}