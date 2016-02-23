var pagesize = 30;
$(document).ready(function(){
	window.onresize=resizeWindow;
	resizeWindow();
	removeToRecycle();
	picPlay();
}); 

var RECYCLEOBJ = null;
function removeToRecycle()
{
	$("#content .pics span p.reduction").click(function(){
		RECYCLEOBJ = $(this);
		var file = encodeURIComponent(RECYCLEOBJ.attr('data'));
		$.getJSON('/recycle/',{a:'recycle','f':file}, function(json){
			if(0==json.status){
				RECYCLEOBJ.parent().remove();
			}
		});
	});
	$("#content .pics span p.recycle").click(function(){
		RECYCLEOBJ = $(this);
		var file = encodeURIComponent(RECYCLEOBJ.attr('data'));
		$.getJSON('/recycle/',{a:'reduction','f':file}, function(json){
			if(0==json.status){
				RECYCLEOBJ.parent().remove();
			}
		});
	});
}

function getCategory()
{
	if(''!=CATE) return false;
	$.getJSON('',{ajax:1,type:'getCategory'},function(json){
		var data='';
		if(0==json.status){
			var jd=json.data;
			for(var i=0; i<jd.length; i++){
				data += '<a href="?c='+jd[i]+'">'+jd[i]+'</a>';
			}
		}else{
			data = "No data.";
		}
		$("#indexcontent").html(data);
	});
}

function getPagesCount()
{
	if(''==CATE) return false;
	$.getJSON('',{c:CATE,ajax:1,type:'getPagesCount',size:pagesize},function(json){
		var data='';
		if(0==json.status){
			var jd=json.data;
			var page = jd.page;
			for(var i=1; i<=page; i++){
				data += '<li><a href="javascript:getPagePic('+i+')">'+i+'</a></li>';
			}
			data += '<li><a href="##">All '+jd.count+'</a></li>';
		}else{
			data = '<li><a href="javascript:getPagePic(1)">1</a></li>';
		}
		$("#paged ul").html(data);
	});
}

function getPagePic(page)
{
	if(''==CATE) return false;
	$.getJSON('',{c:CATE,ajax:1,type:'getPagePic',page:page,size:pagesize,first:1},function(json){
		var data='';
		if(0==json.status){
			var jd=json.data;
			for(var i=0; i<jd.length; i++){
				data += '<div class="imgbox"><a href="/pic/?c='+CATE+'&p='+jd[i]+'" target="_blank"><img src="/image/?c='+CATE+'&p='+jd[i]+'&first=1" /></a><p>'+jd[i]+'</p></div>';
			}
		}else{
			data = 'No data.';
		}
		$("#content").html(data);
	});
}

function scrollTop()
{
	return $("html, body").animate({scrollTop:0},"slow"),!1;
}

//---------------
function chksearch(){
	if($("#search_keyword").val().length < 1) return false;
	$("#search_form").attr('action',$("#search_form").attr('action')+"?keyword="+$("#search_keyword").val());
	return true;
}

//-------------- pic play
var PICPLAY=new Array(), PICPREV=0, PICNEXT=0, PICALL=0;
function picPlay()
{
	$("#content .pics span a").each(function(i){
		PICPLAY[i] = $(this).attr('data');
		PICALL++;
	});
	$("#content .pics span a").click(function(){
		var data = $(this).attr('data');
		for(var i=0; i<PICPLAY.length; i++){
			if(data==PICPLAY[i]){
				PICNEXT = i+1;
				PICPREV = i-1;
				if(PICNEXT >= PICALL) PICNEXT=PICALL-1;
				if(PICPREV < 0) PICPREV=0;
			}
		}
		$('#bgMask').show();
		$('#bgTransparent').show();
		$('#bgTransparent').html('<a href="javascript:closePlayer(1);" class="close"></a><a href="javascript:picPlayer('+PICPREV+');" class="prev"></a><img src="'+data+'" /><a href="javascript:picPlayer('+PICNEXT+');" class="next"></a>');
	});
	closePlayer(0);
}
function picPlayer(i)
{
	if(i >= PICALL) i=PICALL-1;
	if(i < 0) i=0;
	
	PICNEXT = i+1;
	PICPREV = i-1;
	if(PICNEXT >= PICALL) PICNEXT=PICALL-1;
	if(PICPREV < 0) PICPREV=0;
	
	var data = PICPLAY[i];
	$('#bgTransparent').html('<a href="javascript:closePlayer(1);" class="close"></a><a href="javascript:picPlayer('+PICPREV+');" class="prev"></a><img src="'+data+'" /><a href="javascript:picPlayer('+PICNEXT+');" class="next"></a>');
}
function closePlayer(n)
{
	if(0==n){
		$('#bgMask').click(function(){
			$('#bgMask').hide();
			$('#bgTransparent').hide();
		});
	}else{
		$('#bgMask').hide();
		$('#bgTransparent').hide();
	}
}
