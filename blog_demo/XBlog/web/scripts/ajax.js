function getMessages(){
    
    new Ajax.Request('http://twitter.com/statuses/public_timeline.json', {
	method: 'get',
	onSuccess: function(transport) {
	    var googleObject = eval('(' + transport.responseText + ')');	

  	    var html = "<a href="
			+ googleObject.responseData.results[0].unescapedUrl
			+ " target=_gSearch>"
			+ googleObject.responseData.results[0].titleNoFormatting
			+ "</a><br/>"
			+ googleObject.responseData.results[0].content
			+ "<hr size=1 noshade color=#CFCFCF>";

	    document.getElementById("post_box").innerHTML = html;
	}
    });

}
