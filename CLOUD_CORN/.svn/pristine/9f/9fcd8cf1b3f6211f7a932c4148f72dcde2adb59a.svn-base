$(document).ready(function() {
	document.form_login.userid.focus();
    $("#form_login").on("submit", function(event) {
    	event.preventDefault();
    	if (pageContext.validBlank(this)) {
			var jsonObj 		= pageContext.getJsonFormData(new FormData(this));
			ajaxCallBackJsonPost("/front/member/login", jsonObj, function(response) {
				location.href 	= response.body.url;
			}, true, false);
    	}
    });	
});
