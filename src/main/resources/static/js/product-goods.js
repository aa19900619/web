/**
 * 通用js
 * 
 * 
 * **/
var bgtype = {"0":"借进","1":"借出","2":"对冲借进","3":"对冲借出"};
var bgStatustype = {"0":"正常","-1":"失效","1":"已归还","2":"系统对冲"};
var bgmoneytype = {"0":"现金","1":"微信","2":"银行","3":"其他"};

function isDoubles(obj) {
	var val =$(obj).val().trim();
	val = val.replace(/[^\d.]/g,""); 
	val = val.replace(/^\./g,""); 
	val = val.replace(/\.{2,}/g,"."); 
	val = val.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
	val = val.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3'); 
	$(obj).val(val);
	//$(obj).focus();
}

function isNum(obj) {
	var val =$(obj).val().trim();
	if(isNaN(val)) {
		val = val.replace(/[^\d.-]/g, '');
		val = val.replace(/(^\s*)|(\s*$)/g,'');
		$(obj).val(val);
		$(obj).focus();
		return;
	}
	$(obj).val(val);
	return "";
}