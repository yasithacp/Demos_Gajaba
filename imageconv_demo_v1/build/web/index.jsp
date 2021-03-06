<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>UploadiFive Test</title>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script src="/gajaba_app/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="/gajaba_app/uploadify/uploadify.css">
        <style type="text/css">
            body {
                font: 13px Arial, Helvetica, Sans-serif;
            }
        </style>
        <script type="text/javascript">
            $(function() {
                $('#file_upload').uploadify({
                    'swf'      : '/gajaba_app//uploadify/uploadify.swf',
                    'uploader' : '/gajaba_app/Upload'
                });
            });
        </script>
    </head>

    <body>
        <h1>Uploadify Demo</h1>
        <div class="bootcamp">
            <h1>Gajaba <span>Server Status</span>                
            </h1>
            <div class="bootcamp-body">
                <ul>
                    <li class="setup">
                        <a>
                            <div class="image"></div>
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
            </div> <!-- /bootcamp-body -->
        </div> <!-- /bootcamp -->
        <form>
            <div id="queue"></div>
            <input id="file_upload" name="file_upload" type="file" multiple="true">
        </form>
    </body>
</html>
