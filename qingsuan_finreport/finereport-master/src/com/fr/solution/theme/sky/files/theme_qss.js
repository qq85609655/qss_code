var topMenuImage=["1.png","2.png","3.png","4.png","5.png"];//菜单对应图标名称 具体文件放到com.fr.solution.theme.sky.files.image包下面
(function ($) {
   FS.THEME = $.extend(true, FS.THEME, {
   			/*config4MenuTree: {
	   			onAfterNodeExpand: function(node, $node, $li){
		   			if(node.level >= 1){
			   			$li.children('ul').css({
				   			'background': 'rgb(45,63,78)'	
			   			});
		   			}
	   			},
	   			onAfterNodeCollapse: function(node, $node, $li){
		   			if(node.level >= 1){
			   			$li.children('ul').css({
				   			'background': 'none'	
			   			});
		   			}
	   			},
	   			onAfterNodeCreate: function(node, $node, $li){
		   			node.level>1&&$node.css({'border-bottom': 'solid 1px rgb(59,79,98)'});
		   			
	   			}
   			},*/
   			
   		 config4MenuTree: {
             onAfterNodeCreate:function(node, $node, $li){
            	 node.level>1&&$node.css({'border-bottom': 'solid 1px rgb(59,79,98)'});
                /* if(node.isModule){*/
                     //console.log($node.html());
                     var icon = !node.nodeicon ? 'leaf' : node.nodeicon;
                     var $icon = $node.find(".fs-menu-icon");
                     $icon.empty();
                     $('<i class="tree-icon" style="width:1.3em;height:1.3em;background:url(${servletURL}?op=resource&resource=/com/fr/solution/theme/sky/files/image/'+topMenuImage[0]+')"/>').appendTo($icon);//.addClass('icon-tree-'+icon);
                /* }*/
                 $node.find('.icon-menu-b').removeClass('fui-fhc');
                 var hasChildren = node.hasChildren && node.ChildNodes && node.ChildNodes.length>0;
                 $node.attr('data-has-children',hasChildren);
                 $node.find('span').not(".fs-menu-icon").not(".menutree-text").css("font-size","15px");
                 if(hasChildren){
                     $node.find('.fs-menu-icon').empty().html('<i class="icon-tree-fork"></i>');
                 }
             },
          
             onAfterInit:function(element){ // add menu collapse button
                 var collapseBtn = $('<div id="fs-menu-collapse-btn" class="fs-menu-hide"/>')
                     .click(function () {
                         FS.CONSTS.Regions["west"].css("width", 0);
                         FS._doResize();
                         $(this).hide();
                         $('#fs-menu-expend-btn').show();
                     }).appendTo(FS.CONSTS.Regions["west"]);
                 var collapseBtn = $('<div id="fs-menu-expend-btn" class="fs-menu-show"/>')
                     .click(function () {
                         FS.CONSTS.Regions["west"].css("width", FS.THEME.config4frame.west.width);
                         FS._doResize();
                         $(this).hide();
                         $('#fs-menu-collapse-btn').show();
                     })
                     .appendTo(FS.CONSTS.Regions["east"]).hide();

                 $('iframe').attr({allowtransparency:true,frameborder:'0',border:'0',marginheight:'0',marginwidth:'0'});
             },
             onAfterNodeExpand : function(node, $node, $li){
                 //console.log("[onAfterNodeExpand]"+$node);
                 if($node){
                     $node.addClass('on');
                     $node.find('.tree-icon').html('');
                     //console.log($node.html());
                 }
                 if(node.level >= 1){
			   			$li.children('ul').css({
				   			'background': 'rgb(45,63,78)'	
			   			});
		   			}
             },
             onAfterNodeCollapse : function(node, $node, $li){
                 //console.log("[onAfterNodeCollapse]"+$node);
                 if($node){
                     $node.find('.tree-icon').html('');
                     $node.removeClass('on');
                     //console.log($node.html());
                 }
                 if(node.level >= 1){
			   			$li.children('ul').css({
				   			'background': 'none'	
			   			});
		   			}
             }
         },
   			
            config4tabPane: {
                style: 'alpha',
                isCollapsible: false,
                hasHomepageBtn: true
            },
            config4navigation: {
            	onAfterInit: function () {
                $("#fs-navi-message").remove();
                $("#fs-frame-search").remove();
                $("#fs-navi-favorite").remove();
                
               
            }
           }
   			
        });
})(jQuery);