<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>UploadiFive Test</title>
    <script src="js/jquery-1.7.1.js" type="text/javascript"></script>
    <script src="js/jquery.uploadify.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/uploadify.css">
    <style type="text/css">
        body {
            font: 13px Arial, Helvetica, Sans-serif;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            $('#file_upload').uploadify({
                'swf':'swf/uploadify.swf',
                'uploader':'upload?action=bw'
            });
        });
    </script>
</head>

<body>
<div class="bootcamp">
    <h1>Gajaba Image Convection Demo<span>Server Status</span>
    </h1>

    <div class="bootcamp-body">
        <ul>
            <li class="setup">
                <a>
                    <div class="image" id="server1"></div>
                    <div class="desc">
                        <h2>Server</h2>

                        <p></p>
                    </div>
                    <span class="step-number one"></span>
                </a>
            </li>
            <li class="create-a-repo">
                <a>
                    <div class="image"></div>
                    <div class="desc">
                        <h2>Server</h2>

                        <p></p>
                    </div>
                    <span class="step-number two"></span>
                </a>
            </li>
            <li class="fork-a-repo">
                <a>
                    <div class="image"></div>
                    <div class="desc">
                        <h2>Server</h2>

                        <p></p>
                    </div>
                    <span class="step-number three"></span>
                </a>
            </li>
            <li class="be-social">
                <a>
                    <div class="image"></div>
                    <div class="desc">
                        <h2>Server</h2>

                        <p></p>
                    </div>
                    <span class="step-number four"></span>
                </a>
            </li>
        </ul>
    </div>
    <!-- /bootcamp-body -->
</div>
<!-- /bootcamp -->
<form style="width:1201px;margin: auto ">
    <div id="queue"></div>
    <div style="float: left;">
        <input id="file_upload" name="file_upload" type="file" multiple="true">
    </div>
</form>

<script>
    function refreshDiv() {
        $('#server1').load('status/server1');
        setTimeout(refreshDiv, 1000);
    }
    refreshDiv();
</script>

</body>
</html>

