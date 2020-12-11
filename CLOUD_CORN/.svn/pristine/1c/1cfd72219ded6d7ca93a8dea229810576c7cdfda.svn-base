$(document).ready(function() {
	ajaxCallBackJsonPost("/front/myhome/SUB02_LA", {}, function(response) {
		// apply_msg, apply_div
		var bean 	= response.body.bean;
		if (bean == null || !bean.hasOwnProperty('SERVICE_STATUS') || bean.SERVICE_STATUS == null) {
			// 신청한적없다
			$("#apply_msg").html("서비스를 신청하지 않았습니다. <br/>서비스에 대한 자세한 정보가 필요할 경우 저희 컨설팅팀으로 연락주시면 서비스에 대한 자세한 상담을 받아 볼 수 있습니다");
		} else if (bean.SERVICE_STATUS == "A") {
			// 신청상태
			$("#apply_msg").html("서비스 승인 대기중입니다. <br/>승인 완료후 담당자에게 연락이 갑니다");
			$("#apply_div").hide();
			pageContext.radiox.checkedByValue('service_type_pl', bean.SERVICE_TYPE_PL);
			pageContext.checkbox.checkedByValue('service_iot_yn', bean.SERVICE_IOT_YN);
			pageContext.checkbox.checkedByValue('service_block_yn', bean.SERVICE_BLOCK_YN);
		} else if (bean.SERVICE_STATUS == "C") {
			// 신청처리완료 및 서비스 시작 중
			pageContext.radiox.checkedByValue('service_type_pl', bean.SERVICE_TYPE_PL);
			pageContext.checkbox.checkedByValue('service_iot_yn', bean.SERVICE_IOT_YN);
			pageContext.checkbox.checkedByValue('service_block_yn', bean.SERVICE_BLOCK_YN);
			$("#apply_msg").html("서비스 이용이 승인된 상태입니다");
			$("#apply_div").hide();
		}
	}, true, false);
	
	$("#service_apply").on("submit", function(e) {
		event.preventDefault();
		if (pageContext.validBlank(this)) {
			var jsonObj 		= pageContext.getJsonFormData(new FormData(this));
			ajaxCallBackJsonPost("/front/myhome/SUB02_IA", jsonObj, function(response) {
				alert("서비스 신청이 완료됐습니다");
			}, true, false);
		}
	});
});