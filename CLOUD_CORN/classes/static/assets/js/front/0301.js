$(document).ready(function() {
	pageContext.setMainPageId('article');
	
	$("#btn_write").on({
			//mouseover: function(event) {
			//	$("#btn_write").css("cursor", "pointer");
			//}, 
		click: function() {
			location.href = "/front/03/01PW";
		}
	});
	
	gotoPage(1);
});

function showArticle(articleUid) {
	var json 			= new Object();
	json.bbs_noticeuid 	= articleUid;
	pageContext.setMainPage('/front/03/01PA', json);
}

function downloadFile(path, original) {
	var json 			= new Object();
	json.filepath 		= path;
	json.original 		= original;
	ajax_download("/front/03/01FD", json);
}

function gotoPage(page, form) {
	if (typeof form == "undefined" || form == null) {
		form 			= document.form_find;
	}
	
	form.cpage.value 	= page;
	var jsonObj 		= pageContext.getJsonFormData(new FormData(form));
	ajaxCallBackJsonPost("/front/03/01AL", jsonObj, function(response) {
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
				templateRow.find("td:nth-child(2)").html("<a href='javascript:showArticle(" + rowData.BBS_NOTICEUID + ");'>" + rowData.TITLE + "</a>");
				templateRow.find("td:nth-child(3)").html(rowData.ADMINID);
				templateRow.find("td:nth-child(4)").html(rowData.REGDT); 		// 작성일
				templateRow.find("td:nth-child(5)").html(rowData.HIT_VIEWER); 	// 조회수
				
				table.append(templateRow);
			}
		}
		
		makePaging('page', response.body.iTotalRecords, response.body.pageSize, response.body.cpage);
	}, true, false);
}
