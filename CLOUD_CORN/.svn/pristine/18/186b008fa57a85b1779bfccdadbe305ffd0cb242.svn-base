$(document).ready(function() {
	
	$("#form_write").on("submit", function(event) {
		event.preventDefault();
		
		if (pageContext.validBlank(this)) {
			var jsonObj 	= pageContext.getJsonFormData("form_write");
			if (jsonObj.password_new != jsonObj.password_new_re) {
				pageContext.focusAndAlert(document.form_write.password_new, "새로운 비밀번호가 일치하지 않습니다.");
			} else {
				ajaxCallBackJsonPost("/admin/04/01PA", jsonObj, function(response) {
    				alert("새로운 비밀번호가 일치합니다");
    			}, true, false);
			}
		}location.href 	= '/admin/04/01';
	 })
	
});
