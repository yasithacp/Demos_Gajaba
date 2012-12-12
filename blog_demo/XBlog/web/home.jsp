<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<title>XBlog</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" type="text/javascript">
	function clearText(field) {
	    if (field.defaultValue == field.value) field.value = '';
	    else if (field.value == '') field.value = field.defaultValue;
	}
	</script>
	<script type="text/javascript" src="scripts/jquery-1.8.2.min.js"></script>
	<script type="text/javascript">
        $(document).ready(function() {
         
        var name = $('#username').val();
        
        $.ajax({
        type: 'GET',
        dataType: 'xml',
        dataType: "text",
        url: '/axis2/services/SampleService/getAllXMLForUser?name='+name,
        
        success:function(data){

        console.log( data.toString())
        
        var input = data.toString();
        var lines = input.split('>');
    
        output = lines[4].split('&');
        count = parseInt(output[0]);
        
        console.log(count);
        
        msgIndex = 9;
        var user = "";
        var aboutme = "";

        for(var i=0; i<count; i++){
            
            output = lines[msgIndex].split('&');
            content = output[0];
            
            msgIndex += 5;
            output = lines[msgIndex].split('&');
            user = output[0];
            
            output = lines[msgIndex + 4].split('&');
            aboutme = output[0];
            
            var post = content.split('~');
            
            //generateMessages(i, user, content);
            generateMessages(i, post[0], post[1]);
            
            msgIndex += 11;         
        }
        
        generateSidebar(user, aboutme);

        },
        error:function(){
        // failed request; give feedback to user
        alert("error")
        }
        });
        });
        
        function generateMessages(index, title, content){
            var ni = document.getElementById('content');

            var newdiv = document.createElement('div');
            var divIdName = 'post_box';
            newdiv.setAttribute('class',divIdName);
            
            startString = '<div class="header"><h2 id="head_';
            middleString = '"></h2><div class="pb_right"></br><p id="content_';
            endString = '"></p></br></div><div class="cleaner"></div></div>';
            
            newdiv.innerHTML = startString.concat(index, middleString, index, endString);
            ni.appendChild(newdiv);
            
            
            headString = '#head_'.concat(index);
            contentString = '#content_'.concat(index);
            
            $( headString ).text(title);
            $( contentString ).text(content);
        }
        
        function generateSidebar(name, aboutme){
            
            var ni = document.getElementById('side_bar');
            
            var newdiv = document.createElement('div');
            var divIdName = 'sidebar';
            newdiv.setAttribute('id',divIdName);
            
            startString = '<div class="sidebar_box"><h6>';
            middleString = '</h6><div class="sb_content"><ul class="sidebar_menu"><li><b>About me:</b></li><li>';
            endString = '</li></ul></div></div>';
            
            newdiv.innerHTML = startString.concat(name, middleString, aboutme, endString);
            
            ni.appendChild(newdiv);
    }

    </script>
</head>

<body>
<input id="username" type="hidden" name="name" value="${sessionScope.name}" />
<div id="header">
  <div id="site_title"> <a href="#">Microblogging for the Future</a> </div>
  <div id="header_right">
    <div id="newsletter_box">
      <form action="#" method="get">
        <input type="text" id="user" name="search" class="newsletter_email" value="Enter search term."  onfocus="clearText(this)" onblur="clearText(this)" />
        <input style="font-weight: bold;" type="button" name="submit" id="submit" value="" onClick="getMessages();"/>
      </form>
    </div>
  </div>
  <div class="cleaner"></div>
</div>
<!-- end of header -->
<div id="menu_wrapper">
  <div id="menu">
    <ul>
      <li><a href="#" class="current"><span></span>Home</a></li>
      <li><a href="newpost.jsp"><span></span>New Post</a></li>
      <li><a href="index.jsp"><span></span>Log Out</a></li>
    </ul>
  </div>
</div>
<!-- end of menu -->


<div id="main"> <span class="tm_bottom"></span>
    <div id="content">   

    </div>
    
    <div id="side_bar">

    </div>
</div>


<!-- end of main -->
<div id="bottom">
  <div class="bottom_box">
    <h5><span>Sed Necest</span> Suspendisse a nibh</h5>
    <p>Duis vitae velit sed dui malesuada dignissim. Donec mollis aliquet ligula. Maecenas adipiscing elementum ipsum.</p>
    <a href="#" class="continue">more info</a> </div>
  <div class="bottom_box">
    <h5><span>Lorem ipsum</span> dolor sit amet</h5>
    <p>Vestibulum eleifend, enim ut molestie pulvinar, purus est fringilla augue, ut tristique nunc neque a libero.</p>
    <a href="#" class="continue">more info</a> </div>
  <div class="bottom_box">
    <h5><span>Recent</span> Blog Post</h5>
    <ul class="bottom_box_list">
      <li><a href="#">Duis vitae velit sed lesuada dignissim.</a></li>
      <li><a href="#">Donec mollis aliquet ligula.</a></li>
      <li><a href="#">Maecenas adipiscing elementum ipsum.</a></li>
    </ul>
  </div>
</div>
<!-- end of bottom -->
<div id="footer">
  <ul class="footer_menu">
    <li class="first"><a href="#">Home</a></li>
    <li><a href="#">Web 2.0</a></li>
    <li><a href="#">Wordpress</a></li>
    <li><a href="#">Graphics</a></li>
    <li><a href="#">Inspirations</a></li>
    <li><a href="#">Freebies</a></li>
  </ul>
  Copyright &copy; 2048 <a href="#">Your Company Name</a> | Designed by <a href="http://www.templatemo.com/">Free CSS Templates</a></div>
</body>
</html>
