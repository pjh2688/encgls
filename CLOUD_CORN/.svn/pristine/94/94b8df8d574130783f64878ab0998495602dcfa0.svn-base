$(document).ready(function() {
	var ssuniq_sheet = document.createElement('style');
	ssuniq_sheet.innerHTML += ".ssuniqwrap-loading{";
	ssuniq_sheet.innerHTML += "    position: fixed;";
	ssuniq_sheet.innerHTML += "    left:0;";
	ssuniq_sheet.innerHTML += "    right:0;";
	ssuniq_sheet.innerHTML += "    top:0;";
	ssuniq_sheet.innerHTML += "    bottom:0;";
	ssuniq_sheet.innerHTML += "    background: rgba(0,0,0,0.2);";
	ssuniq_sheet.innerHTML += "    filter: progid:DXImageTransform.Microsoft.Gradient(startColorstr='#20000000', endColorstr='#20000000');";
	ssuniq_sheet.innerHTML += "}";
	ssuniq_sheet.innerHTML += "";
	ssuniq_sheet.innerHTML += ".ssuniqwrap-loading div{";
	ssuniq_sheet.innerHTML += "     position: fixed;";
	ssuniq_sheet.innerHTML += "     top:50%;";
	ssuniq_sheet.innerHTML += "     left:50%;";
	ssuniq_sheet.innerHTML += "     margin-left: -21px;";
	ssuniq_sheet.innerHTML += "     margin-top: -21px;";
	ssuniq_sheet.innerHTML += "}";
	ssuniq_sheet.innerHTML += "";
	ssuniq_sheet.innerHTML += ".ssuniqdisplay-none{";
	ssuniq_sheet.innerHTML += "    display:none;";
	ssuniq_sheet.innerHTML += "}";
	document.body.appendChild(ssuniq_sheet);
});

/**
 * ajax 통신시 사용될 기본 로딩 이미지 설정
 * 
 * @returns
 */
function getLoadingBase64Image() {
	return "data:image/gif;base64,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";
}

/**
 * ajax를 통한 서버로부터의 파일 다운로드
 * 
 * @param url
 * @param formData
 * @param type
 * @returns
 */
function ajax_download(url, validObj) {
    var $iframe,
        iframe_doc,
        iframe_html;
    
    var divRandomId 	= Math.floor(Math.random() * 1000000) + 1;
    //$('body').append("<div id=\"ssuniqwrap-loading\" class=\"ssuniqwrap-loading\"><div><img src=\"" + getLoadingBase64Image() + "\" /></div></div>");
    if (($iframe = $('#download_iframe' + divRandomId)).length === 0) {
        $iframe = $("<iframe id='download_iframe" + divRandomId + "'" +
                    " style='display: none' src='about:blank'></iframe>"
                   ).appendTo("body");
    }

    iframe_doc = $iframe[0].contentWindow || $iframe[0].contentDocument;
    if (iframe_doc.document) {
        iframe_doc = iframe_doc.document;
    }

    iframe_html = "<html><head></head><body><form method='POST' action='" + url +"'>";
    if (typeof validObj == "undefined" || validObj == null) {
    	
    } else if (typeof validObj == "object") {
    	$.each(validObj, function(key, value) {
    		if (Array.isArray(value)) {
    			for (var i = 0; i < value.length; i++) {
    				iframe_html += "<input type='hidden' name='"+key+"' value='"+value[i]+"'>";
    			}
    		} else {
    			iframe_html += "<input type='hidden' name='"+key+"' value='"+value+"'>";
    		}
    	});
    }

    iframe_html +="</form></body></html>";
    
    iframe_doc.open();
    iframe_doc.write(iframe_html);
    
	//document.cookie = "check_excel_loading="+escape("false")+";path=/";
	//commonCheckAjaxDownload();
    $(iframe_doc).find('form').submit();
    //pageBlock();
    
    //if ($("#ssuniqwrap-loading").length > 0) $("#ssuniqwrap-loading").remove();
}

/**
 * ajax 요청
 * 
 * @param isAsynch
 * @param isShowLoadingBar
 * @param address
 * @param data
 * @param callBack
 * @returns
 */
function ajaxCallBack(isMultipart, address, reqType, dataObj, callBack, resDataType, isAsynch, isShowLoadingBar) {
	var contentType;
	var enctype;
	var data;
	
	if (typeof isAsynch == "undefined" || isAsynch == null) {
		isAsynch 			= true;
	}
	if (typeof isShowLoadingBar == "undefined" || isShowLoadingBar == null) {
		isShowLoadingBar 	= false;
	}
	if (isMultipart) {
		contentType 		= false;
		enctype 			= 'multipart/form-data';
		data 				= dataObj
	} else {
		contentType 		= "application/json; charset=UTF-8";
		enctype 			= false;
		data 				= (pageContext.string.equalsIgnoreCase(reqType, "GET"))? (dataObj == null)? {} : dataObj      :      (dataObj == null)? JSON.stringify({}) : JSON.stringify(dataObj);
	}
	
	$.ajax({
       type 		: reqType,
       url 			: address,
       dataType 	: resDataType,
       data 		: data,
       contentType 	: contentType, 
       enctype 		: enctype, 
       async		: isAsynch,
       processData 	: false,
       cache 		: false,
       success 		: function(response) {
    	   //console.log("response:" + response);
    	   if (resDataType == "html") {
    		   callBack(response);
    	   } else {
               var status 		= response.status;
               if (pageContext.string.equalsIgnoreCase(status, "success")) {
             	  callBack(response);
               } else {
            	   if (!(typeof response.type == "undefined" || response.type == null) && response.type.indexOf("text/html") != -1) {
            		   $('body').append(response.message);
                   } else {
                	   alert(response.message);
                   }
               }
    	   }
       },
       beforeSend 	:function() {
    	   if (isShowLoadingBar) {
    		   $('body').append("<div id=\"ssuniqwrap-loading\" class=\"ssuniqwrap-loading\"><div><img src=\"" + getLoadingBase64Image() + "\" /></div></div>");
    	   }
       },
       complete 	:function() {
    	   if ($("#ssuniqwrap-loading").length > 0) $("#ssuniqwrap-loading").remove();
       },
       error 		:function(request, status, error) {
    	   if ($("#ssuniqwrap-loading").length > 0) $("#ssuniqwrap-loading").remove();
    	   console.log(JSON.stringify(request) + "/" + status + "/" + error);
           alert("서버와의 통신이 올바르지 않습니다. 다시 시도하세요");
       }
    });
}

function ajaxCallBackFile(address, formData, callBack, isAsynch, isShowLoadingBar) {
	if (typeof isAsynch == "undefined" || isAsynch == null) {
		isAsynch 			= false;
	}
	if (typeof isShowLoadingBar == "undefined" || isShowLoadingBar == null) {
		isShowLoadingBar 	= true;
	}
	ajaxCallBack(true, address, "POST", formData, callBack, "json", isAsynch, isShowLoadingBar);
	/*
    $.ajax({
        type 		: 'POST',
        url 		: address,
        dataType 	: 'json',
        data 		: formData,
        enctype 		: 'multipart/form-data',
        contentType 	: false,
        async		: true,
        processData : false,
        cache 		: false,
        success 	: function(response) {
     	   if ($("#ssuniqwrap-loading").length > 0) $("#ssuniqwrap-loading").remove();
            var status 	= response.status;
            if (status == "success") {
            	  callBack(response);
            } else {
            	  alert(response.message);
            }
        },
        beforeSend:function() {
     	   if (!(typeof isShowLoading == "undefined" || isShowLoading == null) && (typeof isShowLoading == "boolean" && isShowLoading)) {
     		   $('body').append("<div id=\"ssuniqwrap-loading\" class=\"ssuniqwrap-loading\"><div><img src=\"" + getLoadingBase64Image() + "\" /></div></div>");
     		}
        },
        complete:function() {
     	   if ($("#ssuniqwrap-loading").length > 0) $("#ssuniqwrap-loading").remove();
        },
        error: function(request, status, error) {
     	   if ($("#ssuniqwrap-loading").length > 0) $("#ssuniqwrap-loading").remove();
            console.log(JSON.stringify(request) + "/" + status + "/" + error);
            alert("서버와의 통신이 올바르지 않습니다. 다시 시도하세요");
        }
     });
     */
}

/**
 * 서버에 json 요청
 * 
 * @param address
 * @param data
 * @param callBack
 * @param isAsynch
 * @param isShowLoadingBar
 * @returns
 */
function ajaxCallBackJsonGet(address, data, callBack, isAsynch, isShowLoadingBar) {
	//ajaxCallBack(address, "GET", data, callBack, "json", isAsynch, isShowLoadingBar);
	
	// get 방식은 body가 없으니 json을 query형태의 parameter로 전송하고 서버측에서 query를 json으로 변환하여 사용한다
	if (isShowLoadingBar) {
		$('body').append("<div id=\"ssuniqwrap-loading\" class=\"ssuniqwrap-loading\"><div><img src=\"" + getLoadingBase64Image() + "\" /></div></div>");
	}
	$.get(address, data).done(function(response) {
		callBack(response);
	})
	.fail(
			function() {
				if ($("#ssuniqwrap-loading").length > 0) $("#ssuniqwrap-loading").remove();
				alert("서버와의 통신이 올바르지 않습니다. 다시 시도하세요");
			}
	)
	.always(
			function() {
				if ($("#ssuniqwrap-loading").length > 0) $("#ssuniqwrap-loading").remove();
			}
	);
}

function ajaxCallBackJsonPost(address, data, callBack, isAsynch, isShowLoadingBar) {
	ajaxCallBack(false, address, "POST", data, callBack, "json", isAsynch, isShowLoadingBar);
}

function ajaxCallBackJsonPut(address, data, callBack, isAsynch, isShowLoadingBar) {
	ajaxCallBack(false, address, "PUT", data, callBack, "json", isAsynch, isShowLoadingBar);
}

function ajaxCallBackJsonDelete(address, data, callBack, isAsynch, isShowLoadingBar) {
	ajaxCallBack(false, address, "DELETE", data, callBack, "json", isAsynch, isShowLoadingBar);
}

/**
 * 서버에 HTML 요청
 * 
 * @param address
 * @param data
 * @param callBack
 * @param isAsynch
 * @param isShowLoadingBar
 * @returns
 */
function ajaxCallBackHtml(address, data, callBack, isAsynch, isShowLoadingBar) {
	ajaxCallBack(false, address, "POST", data, callBack, "html", isAsynch, isShowLoadingBar);
}



/**
 * 페이지 관련 클래스
 * 
 * @param mainPageId
 * @returns
 */
function clzPageContext(mainPageId) {
	var me 					= this;
	
	this.string 			= new clzString();
	this.validate 			= new clzValidation();
	this.checkbox 			= new clzCheckBoxRadio("checkbox");
	this.radiobox 			= new clzCheckBoxRadio("radio");
	this.selector 			= new clzSelector();
	this.cookie 			= new clzCookie();
	this.popup 				= new clzPopup();
	this.tree 				= new clzTree();
	
	this.lastPage 			= null;
	this.subPage 			= null;
	this.mainPageId 		= (typeof mainPageId === 'undefined' || mainPageId == null)? "" : mainPageId;
	this.subPageId 			= null;
	this.parameter 			= null;
	
	/**
	 * 메인페이지 요청
	 * 
	 */
	this.setMainPage 		= function(address, jsonObj) {
		me.lastPage 		= address;
		me.parameter 		= (typeof jsonObj === 'undefined' || jsonObj == null)? {} : jsonObj;
		ajaxCallBackHtml(me.lastPage, me.parameter, function(html) {
			if (html.toLowerCase().startsWith("<script language")) {
				var altMessageDiv = $('<div id="altMessageDivMain"></div>');
				altMessageDiv.html(html);
				altMessageDiv.appendTo('body');
				altMessageDiv.remove();
			} else {
				$("#" + me.mainPageId).html(html);
				$( 'html, body' ).animate( { scrollTop : 0 }, 100 );
				//$("#" + me.mainPageId).hide().html(html).fadeIn('slow');
			}
		}, true, false);
	};
	
	/**
	 * 서브페이지 요청
	 * 
	 */
	this.setSubPage 		= function(address, targetId, jsonObj) {
		me.subPage 			= (typeof address === 'undefined' || address == null)? me.subPage : address;
		me.subPageId 		= (typeof targetId === 'undefined' || targetId == null)? me.subPageId : targetId;
		me.subparameter 	= (typeof jsonObj === 'undefined' || jsonObj == null)? new Object() : jsonObj;
		ajaxCallBackHtml(me.subPage, me.subparameter, function(html) {
			if (html.toLowerCase().startsWith("<script language")) {
				var altMessageDiv = $('<div id="altMessageDivMain"></div>');
				altMessageDiv.html(html);
				altMessageDiv.appendTo('body');
				altMessageDiv.remove();
			} else {
				$("#" + me.subPageId).html(html);
			}
		}, true, false);
	};
	
	/**
	 * 메인페이지 ID의 반환
	 * 
	 */
	this.setMainPageId 		= function(id) {
		me.mainPageId 		= id;
	};
	
	/**
	 * 요청한 마지막 메인 페이지의 파라미터 반환
	 * 
	 */
	this.getPageParameter = function() {
		return me.parameter;
	};
	
	/**
	 * 요청한 마지막 메인페이지 반환
	 * 
	 */
	this.getLastPage 		= function() {
		return me.lastPage;
	}
	
	/**
	 * 메인페이지 갱신
	 * 
	 */
	this.refershMainPage 	= function() {
		if (me.mainPageId != null && me.mainPageId != "") {
			me.setMainPage(me.lastPage, me.parameter);
		}
	}
	
	/**
	 * 서브페이지 갱신
	 * 
	 */
	this.refershSubPage 	= function() {
		if (me.subPageId != null && me.subPageId != "" && me.subPage != null && me.subPage != "") {
			me.setSubPage(me.subPage, me.subPageId, me.subparameter);
		}
	}
	
	/*
	document.onkeydown 	= function() {
		switch (event.keyCode){
			case 116 : //F5 button
				event.returnValue = false;
				event.keyCode = 0;
				me.refershMainPage();
				
				return false;
		}
	}
	*/
	
	
	/**
	 * 스크립트 로드
	 * 
	 */
	this.loadScript 		= function(scriptSrc) {
		var script= document.createElement('script');
		script.type= 'text/javascript';
		script.src= scriptSrc;			
		document.head.appendChild(script);
	}
	
	this.focusAndAlert 		= function(obj, msg) {
		obj.focus();
		alert(msg);
	}
	
	this.moveScroll 		= function(id) {
		var offset = $("#" + id).offset();
        $('html, body').animate({scrollTop : offset.top}, 400);
	}
	
	this.validBlank 		= function(formId) {
		var isValid 		= true;
		var form;
		if (typeof formId == "string") {
			form = $("#" + formId);
		} else {
			form = formId;
		}
		$.each($('input, select ,textarea', form),function() {
			var trimVal 	= ($(this).val() == null)? "" : $.trim($(this).val());
			var tagName 	= $(this).prop('tagName');
			
			if (tagName.toLowerCase() == "select") {
				if ($(this)[0].hasAttribute('PSS_BLANK') && trimVal == "") {
					me.focusAndAlert($(this), me.string.josa.r($(this).attr('placeholder'),'을/를') +" 선택하세요");
					isValid = false;
					return isValid;
				}
			} else {
				if ($(this)[0].hasAttribute('PSS_BLANK') && trimVal == "") {
					me.focusAndAlert($(this), me.string.josa.r($(this).prop('placeholder'),'을/를') +" 작성하세요");
					isValid = false;
					return isValid;
				} else if ($(this)[0].hasAttribute('PSS_USERID') && (trimVal == "" || !me.validate.isUserIDWithChars(trimVal))) {
					me.focusAndAlert($(this), me.string.josa.r($(this).prop('placeholder'),'은/는') +" -_0123456789abcdefghijklmnopqrstuvwxyz 문자만 사용 할 수 있습니다");
					isValid = false;
					return isValid;
				} else if ($(this)[0].hasAttribute('PSS_USERID') && (trimVal == 'admin' || trimVal == 'root')) {
					me.focusAndAlert($(this), me.string.josa.r($(this).prop('placeholder'),'은/는') +" admin, root, webmaster 라는 계정을 사용 할 수 없습니다");
					isValid = false;
					return isValid;
				} else if ($(this)[0].hasAttribute('PSS_EMAIL') && (trimVal == "" || !me.validate.validateEmail(trimVal))) {
					me.focusAndAlert($(this), me.string.josa.r($(this).prop('placeholder'),'은/는') +" 올바른 이메일 주소가 아닙니다");
					isValid = false;
					return isValid;
				} else if ($(this)[0].hasAttribute('PSS_NUMBER') && (trimVal == "" || !me.validate.isNumberWithChars(trimVal))) {
					me.focusAndAlert($(this), me.string.josa.r($(this).prop('placeholder'),'은/는') +" 0123456789 까지의 숫자만 작성할 수 있습니다");
					isValid = false;
					return isValid;
				} else if ($(this)[0].hasAttribute('PSS_ENGLISH_NUMBER') && (trimVal == "" || !me.validate.isEngNumberWithChars(trimVal))) {
					me.focusAndAlert($(this), me.string.josa.r($(this).prop('placeholder'),'은/는') +" 영문자와 숫자만 사용할 수 있습니다");
					isValid = false;
					return isValid;
				} else if ($(this)[0].hasAttribute('PSS_PASSWD_MIX') && (trimVal == "" || !me.validate.isEngNumberSpecialMixWithChars(trimVal))) {
					me.focusAndAlert($(this), me.string.josa.r($(this).prop('placeholder'),'은/는') +" 영문자와 숫자, 특수문자를 조합하여 사용해야 합니다");
					isValid = false;
					return isValid;
				} else if ($(this)[0].hasAttribute('PSS_DIGIT') && (trimVal == "" || !me.validate.isDigitWithChars(trimVal))) {
					me.focusAndAlert($(this), me.string.josa.r($(this).prop('placeholder'),'은/는') +" -.0123456789 까지의 DIGIT 문자만 사용할 수 있습니다");
					isValid = false;
					return isValid;
				} else if ($(this)[0].hasAttribute('min')) {
					var minValue 	= Number($(this).attr("min"));
					var txtLength 	= trimVal.length;
					if (txtLength < minValue) {
						me.focusAndAlert($(this), me.string.josa.r($(this).prop('placeholder'),'은/는') + " " + minValue + "글자 이상 작성해야합니다");
						isValid = false;
						return isValid;
					}
				}
			}
			
		});
		
		return isValid;
	}
	
	this.getJsonFormData = function(formId, changeNumberIds) {
		//console.log(typeof formId);
		if (typeof changeNumberIds == "undefined" || changeNumberIds == null || changeNumberIds == "") {
			changeNumberIds 			= null;
		}
		if (formId instanceof FormData) {
			return this.formDataToJSON(formId, changeNumberIds);
		//} else if (formId instanceof Form) { 	// this로 넘어올때
		//	return formDataToJSON(getFormData(formId));
		} else {
			if (typeof formId == "string") {
				var imsiForm 		= $("#" + formId);
				var imsiChangeNumberIds = [];
				$.each($('input, select ,textarea', imsiForm),function() {
					if ($(this)[0].hasAttribute('PSS_NUMBER') || $(this)[0].hasAttribute('PSS_DIGIT')) {
						imsiChangeNumberIds.push($(this).attr('id'));
					}
				});
				
				return $("#" + formId).serializeObject((changeNumberIds != null)? changeNumberIds: imsiChangeNumberIds);
			} else {
				$.each(formId, function(key, value) {
		    		if (Array.isArray(value)) {
		    			if (changeNumberIds != null && changeNumberIds.includes(key)) {
		    				for (var i = 0; i < value.length; i++) {
			    				formId[key][i] 	= Number($.trim(value[i]));
			    			}
		    			}
		    		} else {
		    			if (changeNumberIds != null && changeNumberIds.includes(key)) {
		    				formId[key] 	= Number($.trim(value));
		    			} else {
		    				formId[key] 	= $.trim(value);
		    			}
		    		}
		    	});
		    	return formId;
			}
			
			
		}
	}
	
	/**
	 * FormData로 부터 json 변환
	 * 
	 * @param formElement
	 * @returns
	 */
	this.formDataToJSON 	= function(formData, changeNumberIds) {
		if (typeof changeNumberIds == "undefined" || changeNumberIds == null || changeNumberIds == "") {
			changeNumberIds 	= new Array();
		} else if (typeof changeNumberIds == "string") {
			changeNumberIds 	= new Array(changeNumberIds);
		}
		
		var o = {};
		
	    formData.forEach(function(value, key) {
			if (o[key]) {
				if (!o[key].push) {
					o[key] = [o[key]];
				}
				o[key].push(changeNumberIds.includes(key)? Number(value) : $.trim(value) || '');
			} else {
				o[key] = changeNumberIds.includes(key)? Number(value) : $.trim(value) || '';
			}
	    });

		return o;
	}
	
	
	/**
	 * form에 있는 모든 데이터를 FormData형태로 반환
	 * 파일 전송에 쓰기 위함이다
	 * 
	 * @returns
	 */
	this.getFormData 	= function(formObj) {
		var form;
		if (typeof formObj == "string") {
			form 		= eval("document." + formObj);
		} else {
			form 		= formObj;
		}
		
		var formData 	= new FormData();
		
	    for (var i = 0; i < form.elements.length; i++) {
	    	if (form.elements[i].type == 'file') {
	    		formData.append(form.elements[i].name, form.elements[i].files[0]);
	    	} else if (form.elements[i].type == 'checkbox' || form.elements[i].type == 'radio') {
	    		if (form.elements[i].checked) {
	    			//if (form.elements[i].hasAttribute('PSS_NUMBER')) {
		    		//	formData.append(form.elements[i].name, Number($.trim(form.elements[i].value)));
	    			//} else {
	    				formData.append(form.elements[i].name, $.trim(form.elements[i].value));
	    			//}
	    		}
	    	} else if (!(form.elements[i].name == null || form.elements[i].name == "")) {
	    		//if (form.elements[i].hasAttribute('PSS_NUMBER')) {
	    		//	formData.append(form.elements[i].name, Number($.trim(form.elements[i].value)));
    			//} else {
    				formData.append(form.elements[i].name, $.trim(form.elements[i].value));
    			//}
	    	}
	    }
	    
	    return formData;
	}
	
	this.setJsonToFormValues 		= function(formId, json) {
		var form;
		if (typeof formId == "string") {
			form = $("#" + formId);
		} else {
			form = formId;
		}
		var name;
		var value;
		$.each($('input, select ,textarea', form),function(index, el){
			name = new String($(this).attr('name')).toUpperCase();
			value = json[name];
			if (typeof value === 'undefined'){
				name = new String($(this).attr('name'));
				value = json[name];
				if (typeof value === 'undefined'){
					value = "";
				}
			}
			if ($(this).prop("tagName") == "INPUT" && ($(this).attr('type') == "radio" || $(this).attr('type') == "checkbox")) {
				if (Array.isArray(value)) {
					if (value.includes($(this).val())) {
						$(this).prop('checked', true);
					}
				} else {
					if ($(this).val() == value) {
						$(this).prop('checked', true);
					}
				}
			} else if ($(this).prop("tagName") == "INPUT" && $(this).attr('type') == "file") {
				// 무시할것
			} else {
				$(this).val(value);
			}
		});
	}
	
}


function clzValidation() {
	var me 						= this;
	this.validateEmail 			= function(email) {
		var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	
		return re.test(email);
	}
	
	this.isDatetime 			= function(d) {
		var ra = /[0-9]{4}. (0[1-9]|1[0-2]). (0[1-9]|[1-2][0-9]|3[0-1])/;
		
	    var rb = /[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])/;
	    //         yyyy -       MM      -       dd
	    var rc = /[0-9]{4}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])/;
	    //         yyyy         MM              dd
	    return ra.test(d) || rb.test(d) || rc.test(d);
	}
	
	/**
	 * 요청값이 숫자인지 여부 반환
	 * 
	 * @param value 텍스트
	 * @returns
	 */
	this.isNumberWithChars 		= function(value) {  
	    var chars = "0123456789";     
	    return this.isContainsCharsOnly(value, chars);
	}
	
	/**
	 * 요청값이 영문과 숫자만인지 여부 반환
	 * 
	 * @param value 텍스트
	 * @returns
	 */
	this.isEngNumberWithChars 	= function(value) {
		var chars = "0123456789abcdefghijklmnopqrstuvwxyz";     
	    return this.isContainsCharsOnly(value.toLowerCase(), chars);
	}
	
	/**
	 * 패스워드 같은 필드에서 영문, 숫자, 특수문자의 조합으로 사용했는지 여부 반환
	 */
	this.isEngNumberSpecialMixWithChars = function(value) {
		var chars_1 = "0123456789";
		var chars_2 = "abcdefghijklmnopqrstuvwxyz";
		var chars_3 = "!@#$%^&*()_+|-=\[]{};:<>?/";
		
		var cnt_1 	= 0;
		var cnt_2 	= 0;
		var cnt_3 	= 0;
		
		for (var inx = 0; inx < value.length; inx++) {
			if (chars_1.indexOf(value.charAt(inx)) != -1) {
				++cnt_1;
			}
			if (chars_2.indexOf(value.charAt(inx)) != -1) {
				++cnt_2;
			}
			if (chars_3.indexOf(value.charAt(inx)) != -1) {
				++cnt_3;
			}
		}
		
		return cnt_1 > 0 && cnt_2 > 0 && cnt_3 > 0;
	}
	
	/**
	 * 요청값이 digit인지 여부 반환
	 * 
	 * @param value
	 * @returns
	 */
	this.isDigitWithChars 		= function(value) {  
	    var chars = "-.0123456789";     
	    return this.isContainsCharsOnly(value, chars);      
	}
	
	this.isUserIDWithChars 		= function(value) {
		var chars = "-_0123456789abcdefghijklmnopqrstuvwxyz";
		return this.isContainsCharsOnly(value, chars); 
	}

	/**
	 * value가 chars의 사용된 문자만으로 구성됐는지 여부 반환
	 * 
	 * @param value
	 * @param chars
	 * @returns
	 */
	this.isContainsCharsOnly 	= function(value,chars) {
		for (var inx = 0; inx < value.length; inx++) {
			if (chars.indexOf(value.charAt(inx)) == -1)
				return false;
		}
		
		return true;      
	}
}

function clzCheckBoxRadio(clzType) {
	var me 						= this;
	
	/**
	 * 라디오버튼 선택 여부 반환
	 *
	 */
	this.isChecked 			= function(id) {
		return $("input:" + clzType + "[id='" + id + "']").is(":checked");
	}
	
	/**
	 * 체크박스 선택여부 개수 반환
	 *
	 */
	this.statusCnt 		= function(id, checked) {
		if (checked) {
			return $("input[id=" + id + "]:" + clzType + ":checked").length;
		} else {
			return $('input:' + clzType + ':not(":checked")').length;
		}
	}
	
	/**
	 * 전체 선택/해제
	 *
	 */
	this.changeStatusAll 			= function(id, checked) {
		$("input[id=" + id + "]").prop("checked", checked);
	}
	
	/**
	 * 값으로 체크
	 * 
	 */
	this.checkedByValue 		= function(id, value) {
		var cnt = $('input:' + clzType + '[id=' + id + ']').length; 		// 총개수
		if (cnt == 0) {
			
		} else if (cnt == 1) {
			$("input:" + clzType + "[id=" + id + "]").prop("checked", true);
		} else {
			$("input:" + clzType + "[id=" + id + "]").each(function(index, el){
				var $el = $(el);
				var optionValue = $el.attr("value");
				if (optionValue == value) {
					$el.prop('checked', true);
				}
			});
		}
	}
	
	/**
	 * 선택된 체크박스의 이름과 값을 반환한다
	 *
	 */
	this.checkedFirstObject 	= function(id) {
		var obj 				= new Object();
		obj.text 				= this.checkedFirstText(id);
		obj.value 				= this.checkedFirstValue(id);
		
		return obj;
	}
	
	/**
	 * 첫번째 선택된 텍스트 반환
	 * 
	 */
	this.checkedFirstText 	= function(id) {
		var cnt = this.statusCnt(id, true);		// 총개수
		if (cnt == 0) {
			return "";
		} else {
			return $('input:' + clzType + '[id=' + id + ']:' + clzType + ':checked').first().next('label').text();
		}
	}
	
	/**
	 * 첫번째 선택된 값 반환
	 * 
	 */
	this.checkedFirstValue 	= function(id) {
		var cnt = this.statusCnt(id, true);
		if (cnt == 0) {
			return "";
		} else {
			return $('input:' + clzType + '[id=' + id + ']:' + clzType + ':checked').first().val();
		}
	}
	
	/**
	 * value 값이 선택됐는지 여부 반환
	 * 
	 */
	this.isCheckedByValue 		= function(id, value) {
		var result 		= false;
		$('input:' + clzType + '[id=' + id + ']:' + clzType + ':checked').each(function(index, el){
			var $el = $(el);
			var optionValue = $el.attr("value");
			if (optionValue == value) {
				result 		= true;
				return;
			}
		});
		return result;
	}
	
	/**
	 * 체크박스의 disable 변경
	 *
	 */
	this.changeDisableStatus 	= function(id, status) {
		$('input:' + clzType + '[id=' + id + ']').each(function() {
		    $(this).prop('disabled', status);
		});
	}
	
	this.appendItem 			= function(divID, id, text, value, prefix, sufix) {
		var html 				= "";
		
		if (typeof prefix != 'undefined' && prefix != null) html += prefix;
		html += "<input type=\"" + clzType + "\" id=\"" + id + "\" name=\"" + id + "\" value=\"" + value + "\" /><label for=\"pre-payment\">" + text + "</label>";
		if (typeof sufix != 'undefined' && sufix != null) html += sufix;
		$("#" + divID).append(html);
	}
}

/**
 * 셀렉터 관련 클래스
 * 
 * @returns
 */
function clzSelector() {
	this.append 				= function(formid, id, text, value, isSelected) {
		if (formid != null) {
			$('#' + formid + ' #' + id).append("<option value='" + value + "'" + (isSelected? " selected" : "") + ">" + text +"</option>");
		} else {
			$('#' + id).append("<option value='" + value + "'" + (isSelected? " selected" : "") + ">" + text +"</option>");
		}
	}
	
	this.appendArray 			= function(formid, id, array) {
		var size 				= (typeof array == "undefined" || array == null)? 0 : array.length;
		for (var i = 0; i < size; i++) {
			var row 			= array[i];
			if (typeof row == null) {
				
			} else if (typeof row == "string") {
				this.append(formid, id, row, row, false);
			} else {
				this.append(formid, id, row[0], row[1], false);
			}
		}
	}
	
	this.getTextByValue 		= function(formid, id, value) {
		var options 			= $('#' + formid + ' #' + id + ' option');
		var size 				= options.length;
		for (var i = 0; i < size; i++) {
			if ($('#' + formid + ' #' + id + ' option:eq(' + i + ')').val() == value) {
				return $('#' + formid + ' #' + id + ' option:eq(' + i + ')').text();
			}
		}
		
		return "";
	}
}

function clzCookie() {
	this.setCookie 			= function(cookieName, value, exdays) {
		var exdate 		= new Date();
		exdate.setDate(exdate.getDate() + exdays);
		var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
		document.cookie = cookieName + "=" + cookieValue;
	}
	
	this.deleteCookie 		= function(cookieName){
	    var expireDate 	= new Date();
	    expireDate.setDate(expireDate.getDate() - 1);
	    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
	}
	 
	this.getCookie 			= function(cookieName) {
	    cookieName 		= cookieName + '=';
	    var cookieData 	= document.cookie;
	    var start 		= cookieData.indexOf(cookieName);
	    var cookieValue = '';
	    if(start != -1){
	        start += cookieName.length;
	        var end = cookieData.indexOf(';', start);
	        if(end == -1)end = cookieData.length;
	        cookieValue = cookieData.substring(start, end);
	    }
	    
	    return unescape(cookieValue);
	}
}


/**
 * 텍스트 관련 크래스
 * 
 * @param mainPageId
 * @returns
 */
function clzString() {
	var me 					= this;
	this.josa 				= new clzJosa();
	
	/**
	 * 파일 용량 단위
	 * 
	 */
	this.humanFileSize 		= function(bytes, si) {
		var thresh = si ? 1000 : 1024;
	    if(Math.abs(bytes) < thresh) {
	        return bytes + 'Byte';
	    }
	    var units = si
	        ? ['KB','MB','GB','TB','PB','EB','ZB','YB']
	        : ['KiB','MiB','GiB','TiB','PiB','EiB','ZiB','YiB'];
	    var u = -1;
	    do {
	        bytes /= thresh;
	        ++u;
	    } while(Math.abs(bytes) >= thresh && u < units.length - 1);
	    return bytes.toFixed(1)+''+units[u];
	};
	
	/**
	 * 대소문자를 무시하고 동일한 문자인지 반환
	 * 
	 */
	this.equalsIgnoreCase 	= function(a, b) {
	    return typeof a === 'string' && typeof b === 'string'
	        ? a.localeCompare(b, undefined, { sensitivity: 'accent' }) === 0
	        : a === b;
	}
	
	/**
	 * 
	 * 
	 */
	this.startsWith 		= function(text, compare) {
		return text != undefined && text.indexOf(compare) == 0;
	}
	
	/**
	 * 숫자에 천단위로 ,를 찍는다
	 * 
	 * @param value
	 * @returns
	 */
	this.numberWithComma 	= function(value) {
	    return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}
	
	this.fillZero 			= function(num, leng) {
		var txt 	= '0000000000000000' + num;
		return txt.substring(txt.length-leng);
	}
	
	this.newLineToBr 		= function(text) {
		return text.replace(/(\n|\r\n)/g, '<br/>');
	}
	
	/**
	 * 요청한 텍스트를 모두 치환
	 * 
	 * @param str
	 * @param searchStr
	 * @param replaceStr
	 * @returns
	 */
	this.replaceAll 		= function(str, searchStr, replaceStr) {
		return str.split(searchStr).join(replaceStr);
	}
	
	this.nvl 				= function(str, other) {
		if (str == null || str.length <= 0) {
			return other;
		} else return str;
	}

	/**
	 * HTML 특수문자 금지
	 * 
	 * @param str
	 * @returns
	 */
	this.convertSpecialHtml = function(str) {
		str = str.replace(/</g,"&lt;");
		str = str.replace(/>/g,"&gt;");
		str = str.replace(/\"/g,"&quot;");
		str = str.replace(/\'/g,"&#39;");
		//str = str.replace(/\n/g,"<br />");
		
		return str;
	}
}

/**
 * Tree 관련 클래스
 * 
 * @param treeID
 * @param data
 * @param check_callback
 * @returns
 */
function clzTree() {
	var me 					= this;
	this.TYPES_EXPLORE 		= {
		"#" : {
			"valid_children" : ["root"]
		},
		"root" : {
			"icon" : "far fa-folder-open",
			"valid_children" : ["folder","file"]
		},
		"folder" : {
			"icon" : "far fa-folder",
			//"icon" : "img/1397751666_folder.png", 
			"valid_children" : ["folder","file"]
		},
		"file" : {
			"icon" : "far fa-file",
			"valid_children" : []
		}
	};
	
	this.TYPES_GROUP 		= {
		"#" : {
			"valid_children" : ["root"]
		},
		"root" : {
			"icon" : "far fa-folder-open",
			"valid_children" : ["folder"]
		},
		"folder" : {
			"icon" : "far fa-folder",
			"valid_children" : ["file"]
		},
		"file" : {
			"icon" : "far fa-file",
			"valid_children" : []
		}
	};
	
	this.makeInstance 		= function(treeID, isOpenAll, data, check_callback, selectNodeEvent, types) {
		if (typeof types == "undefined" || types == null) {
			types 			= me.TYPES_EXPLORE;
		}
		
		var resultTree 		=  $('#' + treeID).jstree({
			"core" : {
				"multiple" : false,
				"animation" : 0,
				"check_callback"	: check_callback,
				"data" : data, 
				"error" : function(error) {
		            console.error('treeCtrl: error from js tree - ' + JSON.stringify(error));
		        },
			},
			"types" : types,
			"plugins" : [
				"contextmenu", "dnd", "types"
				//"dnd", "types"
			]
		});
		
		resultTree.bind("select_node.jstree", selectNodeEvent);
		
		if (isOpenAll) {
			resultTree.bind('loaded.jstree', function() {
				resultTree.jstree('open_all');
			});
		}
		
		return resultTree;
	}
	
	this.addFolder 		= function(jsTree, dirName) {
		if (typeof dirName == "undefined" || dirName == null) {
			dirName 	= "새그룹";
		}
		
		var nodes = jsTree.jstree('get_selected', true);
		var node 	= null;
		if (nodes != null && nodes.length > 0 && (node = nodes[0]) != null && node.original.type != "file") {
			jsTree.jstree("create_node", node.id, { "id" : -1, "parent" : node.id, "text" : dirName, "type" : "folder"}, "last", function (newNode) {
				this.edit(newNode);
		    });
		} else {
			Swal.fire(
			  '알림',
			  '새로운 그룹이 위치할 상위 그룹을 선택하세요',
			  'info' 		// warning, error, success, info, question
			);
		}
	}
	
	this.addFile 	= function(jsTree, fileId, fileName) {
		if (typeof fileName == "undefined" || fileName == null) {
			fileName 			= "새로추가된파일";
		}
		var nodes 	= jsTree.jstree('get_selected', true);
		var node 	= null;
		if (nodes != null && nodes.length > 0 && (node = nodes[0]) != null && (node.original.type == "root" || node.original.type == "folder")) {
			var jsonData 		= new Object();
			jsonData.map_grp_pno = node.id;
			jsTree.jstree("create_node", node.id, { "id" : "123456789A", "parent" : node.id, "text" : fileName, "type" : "file"}, "last", function (newNode) {
				this.edit(newNode);
				// 바로 열까? 하지마~~~
		    });
		} else {
			Swal.fire(
			  '알림',
			  '파일이 위치할 폴더를 선택하세요',
			  'info' 		// warning, error, success, info, question
			);
			
		}
	}
	
	this.remove 	= function(jsTree) {
		var nodes = jsTree.jstree('get_selected', true);
		if (nodes != null && nodes.length > 0) {
			if (confirm("삭제하겠습니까?")) {
				var node = nodes[0];
				var nodeId = node.id;
				if (nodeId == "0") {
					Swal.fire(
					  '알림',
					  '최상위 그룹은 삭제 할 수 없습니다',
					  'info' 		// warning, error, success, info, question
					);
				} else {
					jsTree.jstree().delete_node( $("#"+ nodeId) );
				}
			}
		} else {
			Swal.fire(
			  '알림',
			  '삭제할 그룹을 선택하세요',
			  'info' 		// warning, error, success, info, question
			);
		}
	}
	
	this.edit 	= function(jsTree) {
		var nodes = jsTree.jstree('get_selected', true);
		if (nodes != null && nodes.length > 0) {
			var node = nodes[0];
			jsTree.jstree().edit(node);
		} else {
			Swal.fire(
			  '알림',
			  '수정할 그룹을 선택하세요',
			  'info' 		// warning, error, success, info, question
			);
		}
	}
	
	this.getJsTree 	= function() {
		return jsTree;
	};
}

/**
 * 텍스트 관련 크래스
 * 
 * @param mainPageId
 * @returns
 */
function clzPopup() {
	var me 					= this;
	
	this.popupYootube 		= function(clzId, isClzId) {
		$(((isClzId)? '.' : '#') + clzId).magnificPopup({
    		disableOn: 700,
    		type: 'iframe',
    		removalDelay: 160,
    		preloader: false,
    		fixedContentPos: false
    	});
	};
	this.popupYootubeByClz 	= function(clzId) {
		this.popupYootube(clzId, true);
	};
	this.popupYootubeById 	= function(clzId) {
		this.popupYootube(clzId, false);
	};
	
	this.popupImage 		= function(clzId, isClzId) {
		$(((isClzId)? '.' : '#') + clzId).magnificPopup({
			type: 'image', 
			callbacks: {
				elementParse: function(item) {
					//console.log(item);
				}
			}
		});
	};
	this.popupImageByClz 	= function(clzId) {
		this.popupImage(clzId, true);
	};
	this.popupImageById 	= function(clzId) {
		this.popupImage(clzId, false);
	};
	
	this.popupLinkHtml 		= function(clzId, isClzId) {
		$(((isClzId)? '.' : '#') + clzId).magnificPopup({
    		type:'inline',
    		midClick: true
    	});
	}
	this.popupLinkHtmlByClz = function(clzId) {
		this.popupLinkHtml(clzId, true);
	};
	this.popupLinkHtmlById 	= function(clzId) {
		this.popupLinkHtml(clzId, false);
	};
	
	this.popupPostHtml 		= function(address, jsonObj, showDivId, writeDivId) {
		if (typeof showDivId == "undefined" || showDivId == null) {
			if ($("#idPSS_POPUP_HTML") <= 0) {
				// POPUP
				var ssuniq_popup = document.createElement('div');
				ssuniq_popup.innerHTML += "<div id=\"PSS_POPUP_HTML\" class=\"mfp-hide\" style=\"position: relative; padding: 0px; width: auto; max-width: 700px; margin: 20px auto;\"><div class=\"row\"><div class=\"col-md-12\"><div class=\"card-body\" id=\"PSS_POPUP_HTML_BODY\"></div></div></div></div>";
				document.body.appendChild(ssuniq_popup);
			}
			
			showDivId 	= "PSS_POPUP_HTML";
		}
		if (typeof writeDivId == "undefined" || writeDivId == null) {
			writeDivId 	= "PSS_POPUP_HTML_BODY";
		}
		event.preventDefault();
		$("#" + writeDivId).html("");
		ajaxCallBackHtml(address, jsonObj, function(response) {
			$("#" + writeDivId).html(response);
			$.magnificPopup.open({
				items: {
					src: '#' + showDivId,
					//src: response,
					type: 'inline'
				}
			});
		}, true, false);
	}
	
	this.alert 				= function(message, title, type) {
		if (typeof title == "undefined" || title == null) {
			title 			= "알림";
		}
		if (typeof type == "undefined" || type == null) {
			type 			= "info";
		}
		Swal.fire (
			title,
			message,
			type 		// warning, error, success, info, question
		);
	}
	
}

/**
 * 조사관련 클래스
 * 
 * @returns
 */
function clzJosa() {
	var me = this;
	var	_f	= [
		function(string) { //을/를 구분
			return _hasJong(string) ? '을' : '를';
		},
		function(string){ //은/는 구분
			return _hasJong(string) ? '은' : '는';
		},
		function(string){ //이/가 구분
			return _hasJong(string) ? '이' : '가';
		},
		function(string){ //와/과 구분
			return _hasJong(string) ? '과' : '와';
		}
    ],
	
    _formats = {
		'을/를' : _f[0],
		'을' : _f[0],
		'를' : _f[0],
		'을를' : _f[0],
		'은/는' : _f[1],
		'은' : _f[1],
		'는' : _f[1],
		'은는' : _f[1],
		'이/가' : _f[2],
		'이' : _f[2],
		'가' : _f[2],
		'이가' : _f[2],
		'와/과' : _f[3],
		'와' : _f[3],
		'과' : _f[3],
		'와과' : _f[3]
	};
	
	function _hasJong(string){ //string의 마지막 글자가 받침을 가지는지 확인
		string = string.charCodeAt(string.length - 1);
		return (string - 0xac00) % 28 > 0;
	}
	
	this.c 	= function(word, format){
		if (typeof _formats[format] === 'undefined') throw 'Invalid format!';
		return _formats[format](word);
	}
	
	this.r 	= function(word, format) {
		return word + me.c(word, format);
	}
	
	/*
	if (typeof define == 'function' && define.amd) {
		define(function(){
			return josa;
		});
	} else if (typeof module !== 'undefined') {
		module.exports = josa;
	} else {
		window.Josa = josa;
	}
	*/
}


/**
 * 사용법
 * 
 * 2011년 09월 11일 오후 03시 45분 42초
 * console.log(new Date().format("yyyy년 MM월 dd일 a/p hh시 mm분 ss초"));
 * 
 * 2011-09-11
 * console.log(new Date().format("yyyy-MM-dd"));
 * 
 * '11 09.11
 * console.log(new Date().format("'yy MM.dd"));
 * 
 * 2011-09-11 일요일
 * console.log(new Date().format("yyyy-MM-dd E"));
 * 
 * 현재년도 : 2011
 * console.log("현재년도 : " + new Date().format("yyyy"));
 * 
 */
Date.prototype.format = function(f) {
    if (!this.valueOf()) return " ";
 
    var weekName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
    var d = this;
     
    return f.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, function($1) {
        switch ($1) {
            case "yyyy": return d.getFullYear();
            case "yy": return (d.getFullYear() % 1000).zf(2);
            case "MM": return (d.getMonth() + 1).zf(2);
            case "dd": return d.getDate().zf(2);
            case "E": return weekName[d.getDay()];
            case "HH": return d.getHours().zf(2);
            case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2);
            case "mm": return d.getMinutes().zf(2);
            case "ss": return d.getSeconds().zf(2);
            case "a/p": return d.getHours() < 12 ? "오전" : "오후";
            default: return $1;
        }
    });
};

$.fn.serializeObject = function(changeNumberIds) {
	if (typeof changeNumberIds == "undefined" || changeNumberIds == null || changeNumberIds == "") {
		changeNumberIds 	= new Array();
	} else if (typeof changeNumberIds == "string") {
		changeNumberIds 	= new Array(changeNumberIds);
	}
	
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [o[this.name]];
			}
			o[this.name].push(changeNumberIds.includes(this.name)? Number(this.value) : $.trim(this.value) || '');
		} else {
			o[this.name] = changeNumberIds.includes(this.name)? Number(this.value) : $.trim(this.value) || '';
		}
	});

	return o;
};




/**
 * 페이지 컨텍스트 선언 및 윈도우에 함수 삽입
 * 
 */
(function() {
	var pageContext 	= new clzPageContext("typhoon_main");
	if (typeof define == 'function' && define.amd) {
		define(function(){
			return pageContext;
		});
	} else if (typeof module !== 'undefined') {
		module.exports = pageContext;
	} else {
		window.pageContext = pageContext;
	}
})();

