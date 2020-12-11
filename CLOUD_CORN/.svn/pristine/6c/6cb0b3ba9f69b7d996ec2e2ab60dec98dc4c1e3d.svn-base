$(document).ready(function() {
	document.form_login.adminid.focus();
    $("#form_login").on("submit", function(event) {
    	event.preventDefault();
    	if (pageContext.validBlank(this)) {
			var jsonObj 		= pageContext.getJsonFormData(new FormData(this));
			ajaxCallBackJsonPost("/admin/do_login", jsonObj, function(response) {
				location.href 	= response.body.url;
			}, true, false);
    	}
    });	
});
