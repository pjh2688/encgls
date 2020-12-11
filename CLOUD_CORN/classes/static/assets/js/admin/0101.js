$(document).ready(function() {
	ajaxCallBackJsonPost("/admin/01/01AL", {}, function(response) {
		var size 		= (response.body.metrics == null)? 0 : response.body.metrics.length;
		var table 		= $("#tbl_list");
		var length 		= table.find("tbody").children().length;
		
		for (var i = 2; i < length; i++) {
			table.find("tbody").find("tr:nth-child(3)").remove();
		}
		
		if (size > 0) {
			table.find("tbody").find("tr:nth-child(2)").css('visibility','hidden');
			table.find("tbody").find("tr:nth-child(2)").css('display','none');
			for (var i = 0; i < size; i++) {
				var bean 		= response.body.metrics[i];
				var templateRow = table.find("tbody").find("tr:nth-child(1)").clone();
				templateRow.removeAttr("id");
				templateRow.removeAttr("style");
				
				var number 		= i+1;
				var cnt 		= bean.length;
				templateRow.find("td:nth-child(1)").html(number);
				templateRow.find("td:nth-child(2)").html(bean.HOSTNAME);
				templateRow.find("td:nth-child(3)").html("<div class=\"progress\"><div class=\"progress-bar\" role=\"progressbar\" style=\"color: #ffff00; width: " + bean.CPU_PERCENT + "%\" aria-valuenow=\"100\" aria-valuemin=\"0\" aria-valuemax=\"100\">" + bean.CPU_PERCENT + "%</div></div><div>" + bean.CPU_PERCENT + "%</div>");
				templateRow.find("td:nth-child(4)").html("<div class=\"progress\"><div class=\"progress-bar progress-bar-striped\" role=\"progressbar\" style=\"color: #ffff00; width: " + bean.MEMORY_PERCENT + "% background-color:red !important;\" aria-valuenow=\"100\" aria-valuemin=\"0\" aria-valuemax=\"100\">" + bean.MEMORY_PERCENT + "%</div></div><div>" + bytes2Size(bean.MEMORY_USED+"000") + "/" + bytes2Size(bean.MEMORY_TOTAL+"000") + "</div>");
				templateRow.find("td:nth-child(5)").html("<div class=\"progress\"><div class=\"progress-bar\" role=\"progressbar\" style=\"color: #ffff00; width: " + bean.DISK_PERCENT + "%\" aria-valuenow=\"100\" aria-valuemin=\"0\" aria-valuemax=\"100\">" + bean.DISK_PERCENT + "%</div></div><div>" + bytes2Size(bean.DISK_USED+"000") + "/" + bytes2Size(bean.DISK_TOTAL+"000") + "</div>");
				templateRow.find("td:nth-child(6)").html(bytes2Size(bean.NETI.average) + "/sec");
				templateRow.find("td:nth-child(7)").html(bytes2Size(bean.NETO.average) + "/sec");
				table.append(templateRow);
			}
		}
	}, true, false);
	
	/*
	ajaxCallBackJsonPost("/admin/01/01AL", {}, function(response) {
		var size 		= (response.body.metrics == null)? 0 : response.body.metrics.length;
		var table 		= $("#tbl_list");
		var length 		= table.find("tbody").children().length;
		
		for (var i = 2; i < length; i++) {
			table.find("tbody").find("tr:nth-child(3)").remove();
		}
		
		if (size > 0) {
			table.find("tbody").find("tr:nth-child(2)").css('visibility','hidden');
			table.find("tbody").find("tr:nth-child(2)").css('display','none');
			for (var i = 0; i < size; i++) {
				var bean 		= response.body.metrics[i];
				var templateRow = table.find("tbody").find("tr:nth-child(1)").clone();
				templateRow.removeAttr("id");
				templateRow.removeAttr("style");
				
				var number 		= i+1;
				var cnt 		= bean.length;
				templateRow.find("td:nth-child(1)").html(number);
				for (var j = 0; j < cnt; j++) {
					if (j == 0) {
						templateRow.find("td:nth-child(2)").html(bean[j].vmname);
					}
					if (bean[j].metric !== undefined && bean[j].metric.average !== undefined) {
						if (bean[j].type == "CPUU") {
							var html 	= "";
							html += ("<div class=\"progress\">");
							html += ("  <div class=\"progress-bar progress-bar-striped bg-danger\" role=\"progressbar\" style=\"width: " + (percent(bean[j].metric.average)) + "%\" aria-valuenow=\"100\" aria-valuemin=\"0\" aria-valuemax=\"100\">" + (percent(bean[j].metric.average) + "%") + "</div>");
							html += ("</div>");
							templateRow.find("td:nth-child(3)").html(html);
						} else if (bean[j].type == "MEMT") {
							templateRow.find("td:nth-child(4)").html(bytes2Size(bean[j].metric.average));
						} else if (bean[j].type == "DISKR") {
							templateRow.find("td:nth-child(5)").html(bytes2Size(bean[j].metric.average));
						} else if (bean[j].type == "NETI") {
							templateRow.find("td:nth-child(6)").html(bytes2Size(bean[j].metric.average));
						} else if (bean[j].type == "NETO") {
							templateRow.find("td:nth-child(7)").html(bytes2Size(bean[j].metric.average));
						}
					}
				}
				
				table.append(templateRow);
			}
		}
	}, true, false);
	*/
});

function bytes2Size(byteVal){
    var units=["B", "KB", "MB", "GB", "TB"];
    var kounter=0;
    var kb= 1024;
    var div=byteVal/1;
    while(div>=kb){
        kounter++;
        div= div/kb;
    }
    return div.toFixed(1) + " " + units[kounter];
}

function percent(num) {
	return (Math.round(num * 100) / 100);
}