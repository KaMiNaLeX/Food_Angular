//==============================================
    //Front Slider Init Callback
//==============================================

function mycarousel_initCallback(carousel)
  {
      // Disable autoscrolling if the user clicks the prev or next button.
      carousel.buttonNext.bind('click', function() {
          carousel.startAuto(0);
      });
  
      carousel.buttonPrev.bind('click', function() {
          carousel.startAuto(0);
      });
  
      // Pause autoscrolling if the user moves with the cursor over the clip.
      $('#mycarousel .description').mouseenter(function() {
          carousel.stopAuto();
      });
      $('#mycarousel .description').mouseleave(function() {
          carousel.startAuto();
      });
  };

//==============================================
    // DOCUMENT READY
//==============================================
$(document).ready(function() {

//==============================================
    //Check is it mobile and change the function of menu
//==============================================

if(/Android|webOS|iPhone|iPad|iPod|BlackBerry/i.test(navigator.userAgent)) {
 //==============================================
    //Main Menu
//==============================================
    $('header .top-nav  ul  li').click(function(){
		//close lava submenu
		$('.main-menu ul li ul').stop(true, true).css('display','none');    
		$('.main-menu > ul > li').removeClass('open-lava');		
		
        if($(this).find('ul').length && !$(this).is('.open')) { 
           $(this).find('ul').first().stop(true, true).fadeIn();
           $(this).siblings().find('ul').css('display','none');
		   $(this).addClass('open');
		   return false;
        }else {
			return true;
		}
    });
    $('body, .wrapper').click(function(){
        $('header .top-nav  ul li.open ul').fadeOut('fast');
		$('header .top-nav  ul  li').removeClass('open');
    });
	
	
//==============================================
	//Lava Menu
//==============================================
		  var style = 'easeOutElastic';
		  // Main Menu hover and current functionality
		  if($('.main-menu li.current').length){
        currentCheck = 1; //check if there is current 1== yes 0 == no
			  default_left = Math.round($('.main-menu li.current').offset().left - $('.main-menu').offset().left - 5);
			  default_top = Math.round($('.main-menu li.current').offset().top - $('.main-menu').offset().top);
			  default_width = $('.main-menu li.current').width();
			  default_height = $('.main-menu li.current').height();
		  } else {
        currentCheck = 0; //check if there is current
			  default_left = 0;
			  default_top = 0;
			  default_width = 0;
			  default_height = 47;
        $('.main-menu li#lava-elm').css('opacity','0');
		  }
		  
		  $('.main-menu li#lava-elm').stop(false, true).animate({top: default_top, left: default_left, width: default_width, height: default_height},{duration:10});
		  
		  
		  //============================ Events ==============================
		  $('.main-menu > ul > li').click(function (){
		  
			//close Top Menu				
			$('header .top-nav  ul li.open ul').fadeOut('fast');
			$('header .top-nav  ul  li').removeClass('open');
			
			if (!$(this).is('#lava-elm')) {
			  elemTop = Math.round($(this).offset().top - $('.main-menu').offset().top);
			  elemLeft = Math.round($(this).offset().left - $('.main-menu').offset().left - 5);
			  width = $(this).width();
			  height = $(this).height();
			  
			  $('#lava-elm').stop(false, false).animate({top: elemTop, left: elemLeft, width:width, height:height},{duration:700,easing: style});
        if (currentCheck == 0) {
            $('.main-menu li#lava-elm').css('opacity','100');
        }
        //SUB MENU
			$(this).siblings().find('ul').css('display','none');
			if($(this).find('ul').length && !$(this).is('.open-lava')) { 
				$('.main-menu > ul > li').removeClass('open-lava');
			   $('ul',this).stop(true, true).slideDown(500);
			   $(this).addClass('open-lava');
				return false;
			}else {
				return true;
				alert('');
			}
      }
		  });
		  
		 $('body, .wrapper').click(function () {
			  //Set the floating bar position, width and transition
				if (currentCheck == 0) {
					$('.main-menu li#lava-elm').css('opacity','0');
				}
				$('.main-menu ul li ul').stop(true, true).css('display','none');
				$('.main-menu li#lava-elm').stop(false, true).animate({top: default_top, left: default_left, width: default_width,height: default_height},{duration:100});      
				$('.main-menu > ul > li').removeClass('open-lava');		
		  });

	
	
	
	
}else {  
//==============================================
    //Main Menu
//==============================================
    $('header .top-nav  ul  li').mouseenter(function(){
        if($(this).find('ul').length) { 
           $(this).find('ul').first().stop(true, true).fadeIn();
           $(this).siblings().find('ul').css('display','none');
        }
    });
    $('header .top-nav  ul  li').mouseleave(function(){
        if($(this).find('ul').length) {
           $(this).find('ul').first().stop(true, true).delay(500).fadeOut('fast');
        }
    });
//==============================================
    //Lava Menu
//==============================================
		  var style = 'easeOutElastic';
		  // Main Menu hover and current functionality
		  if($('.main-menu li.current').length){
        currentCheck = 1; //check if there is current 1== yes 0 == no
			  default_left = Math.round($('.main-menu li.current').offset().left - $('.main-menu').offset().left - 5);
			  default_top = Math.round($('.main-menu li.current').offset().top - $('.main-menu').offset().top);
			  default_width = $('.main-menu li.current').width();
			  default_height = $('.main-menu li.current').height();
		  } else {
        currentCheck = 0; //check if there is current
			  default_left = 0;
			  default_top = 0;
			  default_width = 0;
			  default_height = 47;
        $('.main-menu li#lava-elm').css('opacity','0');
		  }
		  
		  $('.main-menu li#lava-elm').stop(false, true).animate({top: default_top, left: default_left, width: default_width, height: default_height},{duration:10});
		  
		  $('.main-menu > ul > li').mouseenter(function (){
			if (!$(this).is('#lava-elm')) {
			  elemTop = Math.round($(this).offset().top - $('.main-menu').offset().top);
			  elemLeft = Math.round($(this).offset().left - $('.main-menu').offset().left - 5);
			  width = $(this).width();
			  height = $(this).height();
			  
			  $('#lava-elm').stop(false, false).animate({top: elemTop, left: elemLeft, width:width, height:height},{duration:700,easing: style});
        if (currentCheck == 0) {
            $('.main-menu li#lava-elm').css('opacity','100');
        }
        //SUB MENU
        if($(this).find('ul').length) { 
           $('ul',this).stop(true, true).slideDown(500);
        }
        $(this).siblings().find('ul').css('display','none');
      }
		  });
		  
		   $('.main-menu').mouseleave(function () {
			  //Set the floating bar position, width and transition
			  if (currentCheck == 0) {
            $('.main-menu li#lava-elm').css('opacity','0');
        }
        
        $('.main-menu ul li ul').stop(true, true).delay(500).css('display','none');
        $('.main-menu li#lava-elm').stop(false, true).animate({top: default_top, left: default_left, width: default_width,height: default_height},{duration:100});       
		  });
}


//==============================================
    //Meals Carousel Starter
//==============================================


	$('#meals-of-the-day ul').jcarousel({
		wrap : 'both'
		,itemFallbackDimension : 400
	});

	$('.featured-meals ul').jcarousel({
		wrap : 'both'
		,scroll : 1
		,itemFallbackDimension : 215
	});
		
//==============================================
    //Pop Up
//==============================================
	$("#login-btn").click(function () {
		$("#popup-overlay").css('display','block');
		$("#popup-login").fadeIn();
	});
	$(".register-btn").click(function () {
		$('.popup').css('display','none');
		$("#popup-overlay").css('display','block');
		$("#popup-register").fadeIn();
	});
	$("#popup-overlay, .popup a.close").click(function () {
		$('.popup, #popup-overlay').css('display','none');
	});
  
});

//==============================================
    //Meals Carousel Starter
//==============================================
$('#payment-methods ul li').click(function () {
    $('#payment-methods ul li .form-controls.checked').removeClass('checked');
    $('#payment-methods ul li input').attr('checked',false);
    $('.form-controls',this).addClass('checked');
    $('input', this).attr('checked',true);    
});

  
