var oEditors = [];

$(document).ready(function() {
	pageContext.setMainPageId('article');
	
	$("#btn_write").on({
			//mouseover: function(event) {
			//	$("#btn_write").css("cursor", "pointer");
			//}, 
		click: function() {
			location.href = "/admin/02/03PW";
		}
	});
	
	gotoPage(1);
});

function showArticle(articleUid) {
	var json 			= new Object();
	json.bbs_qnauid 	= articleUid;
	//pageContext.setMainPage('/admin/02/03PA', json);
	ajaxCallBackHtml('/admin/02/03PA', json, function(response) {
		if (response.toLowerCase().startsWith("<script language")) {
			var altMessageDiv = $('<div id="altMessageDivMain"></div>');
			altMessageDiv.html(response);
			altMessageDiv.appendTo('body');
			altMessageDiv.remove();
		} else {
			$("#article").html(response);
			$( 'html, body' ).animate( { scrollTop : 0 }, 100 );
			//$("#" + me.mainPageId).hide().html(html).fadeIn('slow');
			viewArticleTailJob();
			
			pageContext.setSubPage('/admin/02/03PR', "repl_container", json);
		}
	}, false, false);
}

function downloadFile(path, original) {
	var json 			= new Object();
	json.filepath 		= path;
	json.original 		= original;
	ajax_download("/admin/02/03FD", json);
}

function gotoPage(page, form) {
	if (typeof form == "undefined" || form == null) {
		form 			= document.form_find;
	}
	
	form.cpage.value 	= page;
	var jsonObj 		= pageContext.getJsonFormData(new FormData(form));
	ajaxCallBackJsonPost("/admin/02/03AL", jsonObj, function(response) {
		var size 		= (response.body.aaData == null)? 0 : response.body.aaData.length;
		var table 		= $("#tbl_list");
		var length 		= table.find("tbody").children().length;
		
		for (var i = 2; i < length; i++) {
			table.find("tbody").find("tr:nth-child(3)").remove();
		}
		
		if (size > 0) {
			table.find("tbody").find("tr:nth-child(2)").css('visibility','hidden');
			table.find("tbody").find("tr:nth-child(2)").css('display','none');
			for (var i = 0; i < size; i++) {
				var templateRow = table.find("tbody").find("tr:nth-child(1)").clone();
				templateRow.removeAttr("id");
				templateRow.removeAttr("style");
				
				var rowData 	= response.body.aaData[i];
				var number 		= response.body.iTotalRecords-(((response.body.cpage-1)*response.body.pageSize)+i);
				
				templateRow.find("td:nth-child(1)").html(number);
				templateRow.find("td:nth-child(2)").html("<a href='javascript:showArticle(" + rowData.BBS_QNAUID + ");'>" + rowData.TITLE + "</a>");
				templateRow.find("td:nth-child(3)").html(rowData.REPLCNT);
				templateRow.find("td:nth-child(4)").html(rowData.WRITER_NM);
				templateRow.find("td:nth-child(5)").html(rowData.REGDT); 		// 작성일
				templateRow.find("td:nth-child(6)").html(rowData.HIT_VIEWER); 	// 조회수
				
				table.append(templateRow);
			}
		}
		
		makePaging('page', response.body.iTotalRecords, response.body.pageSize, response.body.cpage);
	}, true, false);
}

function editArticle(bbs_qnauid) {
	location.href = "/admin/02/03PE?bbs_qnauid=" + bbs_qnauid;
}

function deleteArticle(bbs_qnauid) {
	if (confirm("해당글을 삭제할까요?")) {
		var json 			= new Object();
		json.bbs_qnauid 	= bbs_qnauid;
		
		ajaxCallBackJsonPost("/admin/02/03AD", json, function(response) {
			alert("요청하신글을 삭제하였습니다");
			location.href = "/admin/02/03";
		}, true, false);
	}
}

function viewArticleTailJob() {
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: "doc_body_long",
		sSkinURI: "/editor/SmartEditor2Skin.html",	
		htParams : {bUseToolbar : true,
			fOnBeforeUnload : function(){
				
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
			ajaxCallBackFile("/admin/02/03AR", formData, function(response) {
				document.form_write.reset();
				alert("답변 등록이 완료되었습니다");
				//location.href 	= '/admin/02/03';
			}, true, false);
		}
    });
}

function changeFileName(obj) {
	$("#file_text").text(obj.value);
}

function deleteArticleRepl(bbs_qnauid, bbs_qna_repluid) {
	if (confirm("해당글을 삭제할까요?")) {
		var json 				= new Object();
		json.bbs_qnauid 		= bbs_qnauid;
		json.bbs_qna_repluid 	= bbs_qna_repluid;
		
		ajaxCallBackJsonPost("/admin/02/03ARD", json, function(response) {
			alert("요청하신 답글을 삭제하였습니다");
			delete json.bbs_qna_repluid;
			pageContext.setSubPage('/admin/02/03PR', "repl_container", json);
		}, true, false);
	}
}