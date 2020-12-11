$(document).ready(function() {
	pageContext.setMainPageId('article');
	
	$("#btn_write").on({
			//mouseover: function(event) {
			//	$("#btn_write").css("cursor", "pointer");
			//}, 
		click: function() {
			location.href = "/admin/02/02PW";
		}
	});
	
	gotoPage(1);
});

function showArticle(articleUid) {
	var json 			= new Object();
	json.bbs_faquid 	= articleUid;
	pageContext.setMainPage('/admin/02/02PA', json);
}

function downloadFile(path, original) {
	var json 			= new Object();
	json.filepath 		= path;
	json.original 		= original;
	ajax_download("/admin/02/02FD", json);
}

function gotoPage(page, form) {
	if (typeof form == "undefined" || form == null) {
		form 			= document.form_find;
	}
	
	form.cpage.value 	= page;
	var jsonObj 		= pageContext.getJsonFormData(new FormData(form));
	ajaxCallBackJsonPost("/admin/02/02AL", jsonObj, function(response) {
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
				templateRow.find("td:nth-child(2)").html("<a href='javascript:showArticle(" + rowData.BBS_FAQUID + ");'>" + rowData.FAQ_QUESTION + "</a>");
				templateRow.find("td:nth-child(3)").html(rowData.ADMINID);
				templateRow.find("td:nth-child(4)").html(rowData.REGDT); 		// 작성일
				
				table.append(templateRow);
			}
		}
		
		makePaging('page', response.body.iTotalRecords, response.body.pageSize, response.body.cpage);
	}, true, false);
}

function editArticle(articleUid) {
	location.href = "/admin/02/02PE?bbs_faquid=" + articleUid;
}

function deleteArticle(articleUid) {
	if (confirm("해당글을 삭제할까요?")) {
		var json 			= new Object();
		json.bbs_faquid 	= articleUid;
		
		ajaxCallBackJsonPost("/admin/02/02AD", json, function(response) {
			alert("요청하신글을 삭제하였습니다");
			location.href = "/admin/02/02";
		}, true, false);
	}
}
