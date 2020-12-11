$(document).ready(function() {
	$("#password_old").focus();
	$("#pw_modify").on("submit", function(e) {
		event.preventDefault();
		if (pageContext.validBlank(this)) {
			if ($("#password").val() != $("#password_re").val()) {
				pageContext.focusAndAlert($("#password"), "변경할 패스워드가 동일하지 않습니다");
			} else {
				var jsonObj 		= pageContext.getJsonFormData(new FormData(this));
				ajaxCallBackJsonPost("/front/myhome/SUB06_UA", jsonObj, function(response) {
					alert("패스워드 변경이 완료됐습니다");
				}, true, false);
			}
		}
	});
});