<@content for="title">Home</@content>
<@content for="description">Home</@>
<@content for="keywords">Home</@>
<@content for="titleOne">Home</@>
    <script src="/js/vue.min.js"></script>
    <script src="/js/iview.min.js"></script>

	<div id="home">
		<Carousel dots="none">
	        <Carousel-item>
	            <div class="demo-carousel">
	              <img src="/images/index/2.jpg" />
	            </div>
	        </Carousel-item>
	        <Carousel-item>
	            <div class="demo-carousel">
	              <img src="/images/index/3.jpg" />
	            </div>
	        </Carousel-item>
	        <Carousel-item>
	            <div class="demo-carousel">
	              <img src="/images/index/1.jpg" />
	            </div>
	        </Carousel-item>
	    </Carousel>
	</div>
	<style>
		::-webkit-scrollbar {display:none}
	</style>
	<script>
	    new Vue({
	        el: '#home'
	    })
	</script>