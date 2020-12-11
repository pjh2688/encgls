var oEditors = [];

$(document).ready(function() {
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: "doc_body_long",
		sSkinURI: "/editor/SmartEditor2Skin.html",	
		htParams : {bUseToolbar : true,
			fOnBeforeUnload : function(){
				//alert("아싸!");	
			}
		}, //boolean
		fOnAppLoad : function(){
			//예제 코드
			//oEditors.getById["ir1"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
		},
		fCreator: "createSEditor2"
	});
	
	$("#form_write").on("submit", function(event) {
		event.preventDefault();
		oEditors.getById["doc_body_long"].exec("UPDATE_CONTENTS_FIELD", []);
		if (pageContext.validBlank(this)) {
			var formData 	= pageContext.getFormData("form_write");
			ajaxCallBackFile("/admin/02/01AW", formData, function(response) {
				document.form_write.reset();
				alert("공지사항 등록이 완료되었습니다");
				location.href 	= '/admin/02/01';
			}, true, false);
		}
    });
	
});

function changeFileName(obj) {
	$("#file_text").text(obj.value);
}