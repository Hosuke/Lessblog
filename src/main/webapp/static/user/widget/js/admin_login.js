//js配置
require.config( {
	baseUrl : "",
	paths : {
		"jquery" : "widget/js/jquery-1.8.0",
		"jquery.md5" : "widget/js/jquery.md5",
		"admin.login" : "bestick/admin.login"
	}
});
//登录验证
require( [ "jquery", "admin.login" ], function($, login) {
	$("#form1 button").live("click", login.submit);
});