<#if titleOne == "/" ><script>window.location.href = "/error"</script></#if>
	<div class="content ac">
	    <BackTop></BackTop>
	    <div class="logo"><a href="/">JavaLite</a></div>
	    <div class="topNav">
	      <ul>
	        <li style="margin-left: 0px">
	        	<a href="/"<#if titleOne =="Home" > class="aci"</#if>>Home</a>
	        </li>
	        <li>
				<div class="cent" style="width:70px">&nbsp;</div>
				<a class="menu_two<#if titleOne =="product" > aci</#if>">PRODUCT</a>
	        	<div class="subnav">
			        <ul>
			            <div style="height:20px">&nbsp;</div>
					    <#list oneList as one>
			                <li>
			                    <a href="#" <#if "One" == one.content > class="aci"</#if>>${one.content}</a>
			                    <span style="margin-left: 42px;">&nbsp;</span>
			                </li>
						</#list>
			            <div style="height:38px">&nbsp;</div>
			            <span id="ts"></span>
			        </ul>
			    </div>
	        </li>
	        <li>
		        <div class="cent" style="width:70px">&nbsp;</div>
		        <a class="menu_two<#if titleOne =="about" > aci</#if>">ABOUT</a>
	        	<div class="subnav">
			        <ul>
			            <div style="height:20px">&nbsp;</div>
			                <li>
			                    <a href="/">HISTORY</a>
			                    <span style="margin-left: 42px;">&nbsp;</span>
			                </li>
			            <div style="height:38px">&nbsp;</div>
			            <span id="ts"></span>
			        </ul>
			    </div>
	        </li>
	        <li>
		        <div class="cent" style="width:70px">&nbsp;</div>
		        <a class="menu_two<#if titleOne =="contact" > aci</#if>">CONTACT</a>
	        	<div class="subnav">
			        <ul>
			            <div style="height:20px">&nbsp;</div>
			                <li>
			                    <a href="/find">FIND US</a>
			                    <span style="margin-left: 42px;">&nbsp;</span>
			                </li>
			                <li>
			                    <a href="/contact">CONTACT US</a>
			                    <span style="margin-left: 42px;">&nbsp;</span>
			                </li>
			                <li>
			                    <a href="/dis">DISCLAIMER & PRIVACY POLICY</a>
			                    <span style="margin-left: 42px;">&nbsp;</span>
			                </li>
			            <div style="height:38px">&nbsp;</div>
			            <span id="ts"></span>
			        </ul>
			    </div>
	        </li>
	      </ul>
	    </div>
	</div>
	
	<script>
		
		$(".menu_two").hover(
			function(){
				$(this).parent().find(".subnav").show()
				$(this).parent().hover(
					function(){
						$(this).show()
					},function(){
						$(this).find(".subnav").hide()
					}
				)
			}
		)
		
	</script>