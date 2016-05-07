// JavaScript Document
$(document).ready(function(){
// ====================  Caculate window height with main wrapper ================== //
var nCheight = $('.noConversation').height()/2;
$(".noConversation").css("margin-top", "-" + nCheight + "px");

var cardsHeight = $(window).height() - $(".TopHeadSticky").outerHeight(true) - $(".botSpace").height()  + "px";
$(".contentMainArea, #contentMainAreaScroll").height(cardsHeight);

var loadingHeight = $(window).height() - $(".TopHeadSticky").outerHeight(true) + "px";
$(".loadingArea").height(loadingHeight);

var leftpart = $(".contentMainArea").height() - $(".tabPart").outerHeight() + "px";
$(".chatMembers, #chatMemScrollbar").height(leftpart);


var chatHeight = $(".contentMainArea").height() - $(".upperpart").outerHeight() - $(".chatwriteup").outerHeight() + "px";
$(".chatPart,#chatscrollbar").height(chatHeight);


var rightpart = $(".contentMainArea").height() - $(".blockpart").outerHeight() - $(".tabPartRN").outerHeight() + "px";
$("#rightContainscrollbar").height(rightpart);

var dummyHeightpart = $(".contentMainArea").height() - $(".tabPartRN").outerHeight() + "px";
$(".dummyheightCls").height(dummyHeightpart);


var rightpartB = $(".contentMainArea").height() - $(".blockpartB").outerHeight() - $(".tabPartRN").outerHeight()- 65 + "px";
$(".rightContainscrollbarB").height(rightpartB);
 
//alert($(".accordionHead").outerHeight());

$(".profile").click( function(){
	var rightpart = $(".contentMainArea").height() - $(".blockpart").outerHeight() - $(".tabPartRN").outerHeight() + "px";
	$("#rightContainscrollbar").height(rightpart);
});

$(".cards").click( function(){
	 
	  var rightpartB = $(".contentMainArea").height() - $(".blockpartB").outerHeight() - $(".tabPartRN").outerHeight()- 65 + "px";
	  $(".rightContainscrollbarB").height(rightpartB);
	  });
	  
	  $(".acro1").click( function(){
	  var rightpartB = $(".contentMainArea").height() - $(".blockpartB").outerHeight() - $(".tabPartRN").outerHeight()- 65 + "px";
	  $(".rightContainscrollbarB").height(rightpartB);
	  });
	 
	  $(".acro2").click( function(){
	  var rightpartB = $(".contentMainArea").height() - $(".blockpartB").outerHeight() - $(".tabPartRN").outerHeight()- 65 + "px";
	  $(".rightContainscrollbarB").height(rightpartB);
	  });
	 
	  $(".acro3").click( function(){
	  var rightpartB = $(".contentMainArea").height() - $(".blockpartB").outerHeight() - $(".tabPartRN").outerHeight()- 65 + "px";
	  $(".rightContainscrollbarB").height(rightpartB);
});

 
// ====================  end Script ================== //
// for customized scrollbar
/*$('#contentMainAreaScroll, #chatMemScrollbar, #chatscrollbar, #rightContainscrollbar, .rightContainscrollbarB').enscroll({
    showOnHover: true,
    verticalTrackClass: 'track',
    verticalHandleClass: 'handle',
	scrollIncrement:40,
	addPaddingToPane:false
});*/

//alert($(".chatPart").height());
//alert($(".conversation").height());
//alert($("#chatscrollbar").height());
 
$("#chatscrollbar").animate({ scrollTop: $(".conversation").height() }, "slow");

//alert($(".chatPart").height());
//alert($(".conversation").height());
//alert($("#chatscrollbar").height());
 
});

$(window).resize(function(){
var cardsHeight = $(window).height() - $(".TopHeadSticky").outerHeight(true) - $(".botSpace").height()  + "px";
$(".contentMainArea, #contentMainAreaScroll, .loadingArea").height(cardsHeight);

var loadingHeight = $(window).height() - $(".TopHeadSticky").outerHeight(true) + "px";
$(".loadingArea").height(loadingHeight);

var leftpart = $(".contentMainArea").height() - $(".tabPart").outerHeight() + "px";
$(".chatMembers, #chatMemScrollbar").height(leftpart);

var chatHeight = $(".contentMainArea").height() - $(".upperpart").outerHeight() - $(".chatwriteup").outerHeight() + "px";
$(".chatPart,#chatscrollbar").height(chatHeight);

var rightpart = $(".contentMainArea").height() - $(".blockpart").outerHeight() - $(".tabPartRN").outerHeight() + "px";
$("#rightContainscrollbar").height(rightpart);

var dummyHeightpart = $(".contentMainArea").height() - $(".tabPartRN").outerHeight() + "px";
$(".dummyheightCls").height(dummyHeightpart);

var rightpartB = $(".contentMainArea").height() - $(".blockpartB").outerHeight() - $(".tabPartRN").outerHeight()- 65 + "px";
$(".rightContainscrollbarB").height(rightpartB);

});




