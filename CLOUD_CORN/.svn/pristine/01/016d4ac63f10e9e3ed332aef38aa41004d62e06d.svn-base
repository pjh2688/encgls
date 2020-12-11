$(document).ready(function() {
	pageContext.setMainPageId('article');
		
	gotoPage(1);
});


function gotoPage(page, form) {
	if (typeof form == "undefined" || form == null) {
		form 			= document.form_find;
	}
	
	form.cpage.value 	= page;
	var jsonObj 		= pageContext.getJsonFormData(new FormData(form));
	ajaxCallBackJsonPost("/admin/03/01AL", jsonObj, function(response) {
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
				
				templateRow.find("td:nth-child(1)").html(number); 	//번호
				templateRow.find("td:nth-child(2)").html("<a href=\"/admin/03/01PA/" + rowData.USERID + ";\"rel=modal:open>" + rowData.COMP_NAME + "</a>")   //업체명
		/*		templateRow.find("td:nth-child(3)").html("<a href=\"/admin/03/01PS/" + rowData.USERID + ";\"rel=modal:open>" + rowData.SERVICE_STATUS + "</a>")   //서비스_상태
*/
				templateRow.find("td:nth-child(3)").html("<a href='javascript:openModal('" + rowData.USERID + ");'>" + rowData.SERVICE_STATUS + "</a>");
				
			
	            
				
				
				
				
				templateRow.find("td:nth-child(4)").html(rowData.KTCLOUDID);	//클라우드 ID
				templateRow.find("td:nth-child(5)").html(rowData.HPHONE);		// 담당자전화
				templateRow.find("td:nth-child(6)").html(rowData.STATUSCD); 	// 승인상태
				templateRow.find("td:nth-child(7)").html(rowData.REGDT); 	// 등록일
				
				table.append(templateRow);
			}
		}
		
		makePaging('page', response.body.iTotalRecords, response.body.pageSize, response.body.cpage);
	}, true, false);
}









function toggle(){
    let body = document.getElementsByTagName('body')[0];
    body.classList.toggle("not-scroll");
    popup();
}

function openModal(userid){
	alert(userid);
	
    let body = document.getElementsByTagName('body')[0];
    let modalHtml = `
     <div id="layerbox" class="layerpop" style="width:600px;height:750px;overflow:auto;">
        <article class="layerpop_area">
        <div class="title">사용자_상태</div>
        <a href="javascript:popupClose();" class="layerpop_close" id="layerbox_close">X</a> <br>
        <div class="content">

 

       <div id="layerbox">
       		<article>   
			<table align="center">
			<colgroup>
				<col style="width: 50%">
				<col style="width: 50%">
			</colgroup>
			
			<tbody>
				<!-- 아이디 -->
				<tr>
					<th scope="row">
						<label for="userid" class="d-flex align-items-center">아이디</label>
					</th>
					<td class="input" id="userid" name="userid" style="width:50%;" th:text="${bean.USERID}">
					</td>
				</tr>
				
				<!-- 서비스_상태 -->
				<tr>
					<th scope="row">
						<label for="ktcloudid" class="d-flex align-items-center">서비스_상태</label>
					</th>
					<td class="input" id="ktcloudid" name="ktcloudid" style="width:50%;" th:text="${bean.SERVICE_STATUS}">
					</td>
				</tr>
				
				<!-- 서비스_종류 -->
				<tr>
					<th scope="row">
						<label for="usernm">서비스 종류</label>
					</th>
					<td class="input" id="usernm" name="usernm" style="width:50%;" th:text="${bean.SERVICE_TYPE_PL}">
					</td>
				</tr>
				<!-- 서비스_IOT_사용여부 -->
				<tr>
					<th scope="row">
						<label for="hphone">서비스 IOT 사용여부</label>
					</th>
					<td class="input" id="hphone" name="hphone" style="width:50%;" th:text="${bean.SERVICE_IOT_YN}">
					</td>
				</tr>
				<!-- 서비스_블록체인_사용여부 -->
				<tr>
					<th scope="row">
						<label for="email">서비스 블록체인 사용여부</label>
					</th>
					<td class="input" id="email" name="email" style="width:50%;" th:text="${bean.SERVICE_BLOCK_YN}">
					</td>
				</tr>
			
				<!-- 등록날짜 -->
				<tr>
					<th scope="row">
						<label for="email">등록날짜</label>
					</th>
					<td class="input" id="email" name="email" style="width:50%;" th:text="${bean.REGDT}">
					</td>
				</tr>
				
				<!-- 수정날짜 -->
				<tr>
					<th scope="row">
						<label for="email">수정날짜</label>
					</th>
					<td class="input" id="email" name="email" style="width:50%;" th:text="${bean.MODIFYDT}">
					</td>
				</tr>
			
			</tbody>
		</table>
		<!-- table 1 // -->
		<br/>
		<hr><br/>
		
		<!-- // table 2 -->
		<table class="entry-meta" align="center">
			<colgroup>
				<col style="width: 50%">
				<col style="width: 50%;">
			</colgroup>
			
			<tbody>
				<!-- 클라우드_VM그룹이름 -->
				<tr>
					<th scope="row">
						<label for="comp_name">클라우드 VM그룹이름</label>
					</th>
					<td class="input" id="comp_name" name="comp_name" style="width:50%;" th:text="${bean.CLOUD_VMGRP}">
					</td>
				</tr>
				
				<!-- 클라우드_L4외부고정IP -->
				<tr>
					<th scope="row">
						<label for="ceonm">클라우드 L4외부고정IP</label>
					</th>
					<td class="input" id="ceonm" name="ceonm" style="width:50%;" th:text="${bean.CLOUD_L4_PUBLIC_IP}">
					</td>
				</tr>
				
				<!-- 클라우드_L4내부IP -->
				<tr>
					<th scope="row">
						<label for="biznum">클라우드 L4내부IP</label>
					</th>
					<td class="input" id="biznum" name="biznum" style="width:50%;" th:text="${bean.CLOUD_L4_VMIP}">
					</td>
				</tr>
				
				<!-- 클라우드_DB내부VMIP -->
				<tr>
					<th scope="row">
						<label for="comp_addr">클라우드 DB내부VMIP</label>
					</th>
					<td class="input" id="comp_addr" name="comp_addr" style="width:80%;" th:text="${bean.CLOUD_L4_VMIP}">
					</td>
				</tr>
				
				<!-- 클라우드_DBVM_HOST_이름 -->
				<tr>
					<th scope="row">
						<label for="comp_addr">클라우드 DBVM HOST 이름</label>
					</th>
					<td class="input" id="comp_addr" name="comp_addr" style="width:80%;" th:text="${bean.CLOUD_DBVM_HOST_NAME}">
					</td>
				</tr>
				
				<!-- 클라우드_오토스케일_그룹이름 -->
				<tr>
					<th scope="row">
						<label for="comp_addr">클라우드 오토스케일 그룹이름</label>
					</th>
					<td class="input" id="comp_addr" name="comp_addr" style="width:80%;" th:text="${bean.CLOUD_AUTOSCALE_GRPNM}">
					</td>
				</tr>
				
				<!-- 클라우드_오토스케일_정책이름 -->
				<tr>
					<th scope="row">
						<label for="comp_addr">클라우드 오토스케일 정책이름</label>
					</th>
					<td class="input" id="comp_addr" name="comp_addr" style="width:80%;" th:text="${bean.CLOUD_AUTOSCALE_POLICY}">
					</td>
				</tr>
				
				<!-- 클라우드_WAS디폴트VMIP -->
				<tr>
					<th scope="row">
						<label for="comp_addr">클라우드 WAS디폴트VMIP</label>
					</th>
					<td class="input" id="comp_addr" name="comp_addr" style="width:80%;" th:text="${bean.CLOUD_WASVM_DEFAULT_VMIP}">
					</td>
				</tr>
				
				<!-- 클라우드_WASVM_HOST_이름 -->
				<tr>
					<th scope="row">
						<label for="comp_addr">클라우드 WASVM HOST 이름</label>
					</th>
					<td class="input" id="comp_addr" name="comp_addr" style="width:80%;" th:text="${bean.CLOUD_WASVM_HOST_NAME}">
					</td>
				</tr>
				
				
			</tbody>
		</table>
          </article><!-- End blog entry -->
		  </div>
	</div>
        </article>
    </div> 
    `
    body.classList.add("not-scroll");
    body.insertAdjacentHTML('afterend',modalHtml);
}

function closeModal(){
    let body = document.getElementsByTagName('body')[0];
    let modal = document.getElementById('modal');

    body.classList.remove("not-scroll");
    modal.remove();
}

function openCheck(){
    let body = document.getElementsByTagName('body')[0];
    let modalHtml = `
    <div id="check" class="container level">
        <div class="wrapModal">
            <div class="modal">
                정말 실행하시겠습니까?
                <button onclick="closeCheck()">닫기</button>
            </div>
        </div>
    </div>
    `
    body.classList.add("not-scroll");
    body.insertAdjacentHTML('afterend',modalHtml);
}

function closeCheck(){
    let check = document.getElementById('check');
     check.remove();
}




























/*
function wrapWindowByMask() {
    //화면의 높이와 너비를 구한다.
    var maskHeight = $(document).height(); 
    var maskWidth = $(window).width();

    //문서영역의 크기 
    console.log( "document 사이즈:"+ $(document).width() + "*" + $(document).height()); 
    //브라우저에서 문서가 보여지는 영역의 크기
    console.log( "window 사이즈:"+ $(window).width() + "*" + $(window).height());        

    //마스크의 높이와 너비를 화면 것으로 만들어 전체 화면을 채운다.
    $('#mask').css({
        'width' : maskWidth,
        'height' : maskHeight
    });

    //애니메이션 효과
    //$('#mask').fadeIn(1000);
    $('#mask').fadeTo("slow", 0.5);
}


function popupOpen() {
    $('.layerpop').css("position", "absolute");
    //영역 가운에데 레이어를 뛰우기 위해 위치 계산 
    $('.layerpop').css("top",(($(window).height() - $('.layerpop').outerHeight()) / 2) + $(window).scrollTop());
    $('.layerpop').css("left",(($(window).width() - $('.layerpop').outerWidth()) / 2) + $(window).scrollLeft());
    $('.layerpop').draggable();
    $('#layerbox').show();
}


function popupClose() {
    $('#layerbox').close();
    $('#mask').hide();
}

*/
