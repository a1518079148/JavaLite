<!DOCTYPE html>
<!--[if IE 6]><html class="ie lt-ie8"><![endif]-->
<!--[if IE 7]><html class="ie lt-ie8"><![endif]-->
<!--[if IE 8]><html class="ie ie8"><![endif]-->
<!--[if IE 9]><html class="ie ie9"><![endif]-->
<!--[if !IE]><!--> <html> <!--<![endif]-->

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">

		<!-- Start of Baidu Transcode -->
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<meta http-equiv="Cache-Control" content="no-transform" />
		<meta name="applicable-device" content="pc,mobile">
		<meta name="MobileOptimized" content="width"/>
		<meta name="HandheldFriendly" content="true"/>
		<meta name="mobile-agent" content="format=html5;url=https://www.346e.com">
		<!-- End of Baidu Transcode -->

		<meta name="description"  content="${description}">
		<meta name="keywords"  content="${keywords}">

        <meta name="application-name" content="JavaLite">
        
        <title>JavaLite - <@yield to="title"/></title>
        <link rel="shortcut icon" type="image/x-icon" href="/favicon.ico"/>
    	
		<link rel="stylesheet" href="/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/iview.css">
		<link rel="stylesheet" href="/css/main.css">
		<script src="/js/jquery.min.js"></script>
		<script src="/js/bootstrap.min.js"></script>
		
    </head>
    
	<body class="font-fz">
	
	<div style="min-height:100vh">
		&nbsp;
		<div id="home_h" style="margin-top:9999px">
		
			<@render partial="header"/>
			
			${page_content}
			
			<@render partial="footer"/>
		
		</div>
	
	</div>
	
	</body>
	<script>
	
		$(".aci").css({
			"color":"inherit"
		})
		
		changeTop()
		
		window.onresize = ()=>{
			changeTop()
		}
		
		function changeTop(){
			let woh = window.outerHeight
			let hh = document.getElementById("home_h").scrollHeight
			let mt = woh/2 - hh/2
			if(mt<0)
				mt = 50+"px"
			else 
				mt = mt+"px"
			document.getElementById("home_h").style.marginTop = mt
		}
	</script>
	
</html>