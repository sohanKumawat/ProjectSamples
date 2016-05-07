// JavaScript Document
$(document).ready(function(){
// ====================  Caculate window height with main wrapper ================== //
var cardsHeight = $(window).height() - $(".TopHeadSticky").outerHeight(true) - $(".botSpace").height()  + "px";
$(".contentMainArea, #contentMainAreaScroll").height(cardsHeight);

var chatHeight = $(".contentMainArea").height() - $(".testPanelwriteup").outerHeight() + "px";
$(".testPanel,#chatscrollbar").height(chatHeight);
 
});



$(window).resize(function(){
var cardsHeight = $(window).height() - $(".TopHeadSticky").outerHeight(true) - $(".botSpace").height()  + "px";
$(".contentMainArea, #contentMainAreaScroll, .loadingArea").height(cardsHeight);

var chatHeight = $(".contentMainArea").height() - $(".testPanelwriteup").outerHeight() + "px";
$(".testPanel,#chatscrollbar").height(chatHeight);

});




