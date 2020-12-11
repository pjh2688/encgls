$(document).ready(function() {
	ajaxCallBackJsonPost("/front/myhome/SUB05_LA", {}, function(response) {
		var user 	= response.body.user;
		$("#userid").text(user.USERID);
		$("#ktcloudid").text(user.KTCLOUDID);
		$("#usernm").val(user.USERNM);
		$("#hphone").val(user.HPHONE);
		$("#email").val(user.EMAIL);
		$("#comp_name").val(user.COMP_NAME);
		$("#ceonm").val(user.CEONM);
		$("#biznum").val(user.BIZNUM);
		$("#comp_addr").val(user.COMP_ADDR);
		$("#comp_fax").val(user.COMP_FAX);
	}, true, false);
	
	$("#form_modify").on("submit", function(e) {
		event.preventDefault();
		if (pageContext.validBlank(this)) {
			var jsonObj 		= pageContext.getJsonFormData(new FormData(this));
			ajaxCallBackJsonPost("/front/myhome/SUB05_UA", jsonObj, function(response) {
				alert("정보 수정이 완료됐습니다");
			}, true, false);
		}
	});
});