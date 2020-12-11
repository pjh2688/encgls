function makePaging(pagenationId, totalcount, pagesize, cpage) {
	if (typeof totalcount == "undefined" || totalcount == null) { totalcount 	= 0; }
	if (typeof pagesize == "undefined" || pagesize == null) 	{pagesize 		= 15; }
	if (typeof cpage == "undefined" || cpage == null) 			{ cpage 		= 1; }
	
	var pagecount			= parseInt((totalcount-1)/pagesize) + 1;
	var startpage			= parseInt((cpage-1)/10)*10 +1;
	var endpage				= (parseInt((pagecount-1)/10) == parseInt((cpage-1)/10))? pagecount : parseInt((cpage-1)/10)*10+10;
	//var endpage				= startpage + pagesize-1;
	
	var pageHtml 			= "";
	//pageHtml += "			<ol class=\"page\" style=\"\">";

    if (startpage != 1) {
		pageHtml += "                   <li><a href=\"javascript:gotoPage(" + (startpage-1) + ");\"><i class=\"icofont-rounded-left\"></i></a></li>";
    } else {
		pageHtml += "                   <li class=\"disabled\"><a href=\"javascript:gotoPage(" + (startpage-1) + ");\"><i class=\"icofont-rounded-left\"></i></a></li>";
    }
	
    for (var i = startpage; i < cpage; i++) {
    	pageHtml += "           <li><a href=\"javascript:gotoPage(" + i + ");\">" + i + "</a></li>";
	}
    pageHtml += "               <li class=\"active\"><a href=\"javascript:gotoPage(" + cpage + ");\">" + cpage + "</a></li>";
	for (var i = (cpage+1); i <= endpage ; i++) {
		pageHtml += "           <li><a href=\"javascript:gotoPage(" + i + ");\">" + i + "</a></li>";
	}
	
	
    if (endpage != pagecount) {
		pageHtml += "               <li><a href=\"javascript:gotoPage(" + (endpage+1) + ");\"><i class=\"icofont-rounded-right\"></i></a></li>";
    } else {
		pageHtml += "               <li class=\"disabled\"><a href=\"javascript:gotoPage(" + pagecount + ");\"><i class=\"icofont-rounded-right\"></i></a></li>";
    }
    
	//pageHtml += "             </ol>";
	
	$("#" + pagenationId).html(pageHtml);
}