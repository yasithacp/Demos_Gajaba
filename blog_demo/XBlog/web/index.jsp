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
    </head>
    
    <body>
        <div id="header">
            <div id="site_title"> <a href="#">Microblogging for the Future</a> </div>
            <div id="header_right">
                <div id="newsletter_box">
                    
                </div>
            </div>
            <div class="cleaner"></div>
        </div>
        <!-- end of header -->
        <div id="menu_wrapper">
            <div id="menu">
                <ul>
                    <li><a href="#" class="current"><span></span>Log In</a></li>
                </ul>
            </div>
        </div>
        <!-- end of menu -->
        
        
        <div id="main"> <span class="tm_bottom"></span>
            <div id="content">   
                <form action="scripts/login.jsp" method="post">
                    <font color="red"><%= session.getAttribute("ws_response") == null ? "" : session.getAttribute("ws_response")+"<br/><br/>" %></font>
                    Username: <br/>
                    <input type="text" id="user" name="name" class="newsletter_email" onfocus="clearText(this)" onblur="clearText(this)" /><br/><br/>
                    Password: <br/>
                    <input type="password" id="user" name="password" class="newsletter_email" onfocus="clearText(this)" onblur="clearText(this)" /><br/><br/>
                    <input style="font-weight: bold;" type="submit" name="submit" id="submit" value="Login"/> <br/><br/>New User? <a href="signup.jsp">Sign Up</a>
                </form>
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
