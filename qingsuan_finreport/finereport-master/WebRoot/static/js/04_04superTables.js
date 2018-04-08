
var superTable = function (tableId, options) {
/////* Initialize */
    options = options || {};
    this.cssSkin = options.cssSkin || "";
    this.headerRows = parseInt(options.headerRows || "1");
    this.fixedCols = parseInt(options.fixedCols || "0");
    this.colWidths = options.colWidths || [];
    this.initFunc = options.onStart || null;
    this.callbackFunc = options.onFinish || null;
    this.initFunc && this.initFunc();

/////* Create the framework dom */
    this.sBase = document.createElement("DIV");
    this.sFHeader = this.sBase.cloneNode(false);
    this.sHeader = this.sBase.cloneNode(false);
    this.sHeaderInner = this.sBase.cloneNode(false);
    this.sFData = this.sBase.cloneNode(false);
    this.sFDataInner = this.sBase.cloneNode(false);
    this.sData = this.sBase.cloneNode(false);
    this.sColGroup = document.createElement("COLGROUP");

    this.sDataTable = document.getElementById(tableId);
    this.sDataTable.style.margin = "0px"; /* Otherwise looks bad */
    if (this.cssSkin !== "") {
        this.sDataTable.className += " " + this.cssSkin;
    }
    if (this.sDataTable.getElementsByTagName("COLGROUP").length > 0) {
        this.sDataTable.removeChild(this.sDataTable.getElementsByTagName("COLGROUP")[0]); /* Making our own */
    }
    this.sParent = this.sDataTable.parentNode;
    this.sParentHeight = this.sParent.offsetHeight;
    this.sParentWidth = this.sParent.offsetWidth;

/////* Attach the required classNames */
    this.sBase.className = "sBase";
    this.sFHeader.className = "sFHeader";
    this.sHeader.className = "sHeader";
    this.sHeaderInner.className = "sHeaderInner";
    this.sFData.className = "sFData";
    this.sFDataInner.className = "sFDataInner";
    this.sData.className = "sData";

/////* Clone parts of the data table for the new header table */
    var alpha, beta, touched, clean, cleanRow, i, j, k, m, n, p;
    this.sHeaderTable = this.sDataTable.cloneNode(false);
    if (this.sDataTable.tHead) {
        alpha = this.sDataTable.tHead;
        this.sHeaderTable.appendChild(alpha.cloneNode(false));
        beta = this.sHeaderTable.tHead;
    } else {
        alpha = this.sDataTable.tBodies[0];
        this.sHeaderTable.appendChild(alpha.cloneNode(false));
        beta = this.sHeaderTable.tBodies[0];
    }
    alpha = alpha.rows;
    for (i=0; i<this.headerRows; i++) {
        beta.appendChild(alpha[i].cloneNode(true));
    }
    this.sHeaderInner.appendChild(this.sHeaderTable);

    if (this.fixedCols > 0) {
        this.sFHeaderTable = this.sHeaderTable.cloneNode(true);
        this.sFHeader.appendChild(this.sFHeaderTable);
        this.sFDataTable = this.sDataTable.cloneNode(true);
        this.sFDataInner.appendChild(this.sFDataTable);
    }

/////* Set up the colGroup */
    alpha = this.sDataTable.tBodies[0].rows;
    for (i=0, j=alpha.length; i<j; i++) {
        clean = true;
        for (k=0, m=alpha[i].cells.length; k<m; k++) {
            if (alpha[i].cells[k].colSpan !== 1 || alpha[i].cells[k].rowSpan !== 1) {
                i += alpha[i].cells[k].rowSpan - 1;
                clean = false;
                break;
            }
        }
        if (clean === true) break; /* A row with no cells of colSpan > 1 || rowSpan > 1 has been found */
    }
    cleanRow = (clean === true) ? i : 0; /* Use this row index to calculate the column widths */
    try{
        for (i=0, j=alpha[cleanRow].cells.length; i<j; i++) {
            if (i === this.colWidths.length || this.colWidths[i] === -1) {
                this.colWidths[i] = alpha[cleanRow].cells[i].offsetWidth;
            }
        }
    }catch (msg) {

    }


    for (i=0, j=this.colWidths.length; i<j; i++) {
        this.sColGroup.appendChild(document.createElement("COL"));
        this.sColGroup.lastChild.setAttribute("width", this.colWidths[i]);
    }
    this.sDataTable.insertBefore(this.sColGroup.cloneNode(true), this.sDataTable.firstChild);
    this.sHeaderTable.insertBefore(this.sColGroup.cloneNode(true), this.sHeaderTable.firstChild);
    if (this.fixedCols > 0) {
        this.sFDataTable.insertBefore(this.sColGroup.cloneNode(true), this.sFDataTable.firstChild);
        this.sFHeaderTable.insertBefore(this.sColGroup.cloneNode(true), this.sFHeaderTable.firstChild);
    }

/////* Style the tables individually if applicable */
    if (this.cssSkin !== "") {
        this.sDataTable.className += " " + this.cssSkin + "-Main";
        this.sHeaderTable.className += " " + this.cssSkin + "-Headers";
        if (this.fixedCols > 0) {
            this.sFDataTable.className += " " + this.cssSkin + "-Fixed";
            this.sFHeaderTable.className += " " + this.cssSkin + "-FixedHeaders";
        }
    }

/////* Throw everything into sBase */
    if (this.fixedCols > 0) {
        this.sBase.appendChild(this.sFHeader);
    }
    this.sHeader.appendChild(this.sHeaderInner);
    this.sBase.appendChild(this.sHeader);
    if (this.fixedCols > 0) {
        this.sFData.appendChild(this.sFDataInner);
        this.sBase.appendChild(this.sFData);
    }
    this.sBase.appendChild(this.sData);
    this.sParent.insertBefore(this.sBase, this.sDataTable);
    this.sData.appendChild(this.sDataTable);

/////* Align the tables */
    var sDataStyles, sDataTableStyles;
    try {//有数据的时候执行的代码
        this.sHeaderHeight = this.sDataTable.tBodies[0].rows[(this.sDataTable.tHead) ? 0 : this.headerRows].offsetTop;
        $(".fakeContainer").removeClass("my_width");
        sDataStyles += "height: " + (this.sParentHeight-53) + "px;";//更改滚动条的位置
    } catch (e) {//无数据或者无权限的时候执行的代码
        $(".fakeContainer").removeClass("fakeContainer");
        //$(".first_div").addClass("my_width");
        $("#my_div div").removeClass();
        $("#my_div div div:nth-child(1)").remove();
        $("#my_div div div:nth-child(2)").remove();
        $("#my_div div div:nth-child(3)").remove();
        $("#my_div div div:nth-child(4)").remove();
        $("#demoTable th").css("min-width","500px");
        $("#sj").css("display","block");
        $("#my_div").css("overflow-x","scroll");
        $(".page-header").css("display","none");


        $("#qx").css("display","block");
        //$("#qx").addClass("my_width");
        var id = $(".my_table").attr('id');
        console.log(id);
        var width = $("#my_div").width();
        $("#" + id ).css("width",width+"px ");	//加上此处解决ie浏览器查看问题
        sDataStyles += "height: " + (this.sParentHeight+17) + "px;";//更改滚动条的位置
    }
    sDataTableStyles = "margin-top: " + (this.sHeaderHeight * -1) + "px;";
    sDataStyles = "margin-top: " + this.sHeaderHeight + "px;";

    if (this.fixedCols > 0) {
        /* A collapsed table's cell's offsetLeft is calculated differently (w/ or w/out border included) across broswers - adjust: */
        this.sFHeaderWidth = this.sDataTable.tBodies[0].rows[cleanRow].cells[this.fixedCols].offsetLeft;
        if (window.getComputedStyle) {
            alpha = document.defaultView;
            beta = this.sDataTable.tBodies[0].rows[0].cells[0];
            if (navigator.taintEnabled) { /* If not Safari */
                this.sFHeaderWidth += Math.ceil(parseInt(alpha.getComputedStyle(beta, null).getPropertyValue("border-right-width")) / 2);
            } else {
                this.sFHeaderWidth += parseInt(alpha.getComputedStyle(beta, null).getPropertyValue("border-right-width"));
            }
        } else if (/*@cc_on!@*/0) { /* Internet Explorer */
            alpha = this.sDataTable.tBodies[0].rows[0].cells[0];
            beta = [alpha.currentStyle["borderRightWidth"], alpha.currentStyle["borderLeftWidth"]];
            if(/px/i.test(beta[0]) && /px/i.test(beta[1])) {
                beta = [parseInt(beta[0]), parseInt(beta[1])].sort();
                this.sFHeaderWidth += Math.ceil(parseInt(beta[1]) / 2);
            }
        }

        /* Opera 9.5 issue - a sizeable data table may cause the document scrollbars to appear without this: */
        if (window.opera) {
            this.sFData.style.height = this.sParentHeight + "px";
        }

        this.sFHeader.style.width = this.sFHeaderWidth + "px";
        sDataTableStyles += "margin-left: " + (this.sFHeaderWidth * -1) + "px;";
        sDataStyles += "margin-left: " + this.sFHeaderWidth + "px;";
        sDataStyles += "width: " + (this.sParentWidth - this.sFHeaderWidth) + "px;";
    } else {
        sDataStyles += "width: " + this.sParentWidth + "px;";
    }
    this.sData.style.cssText = sDataStyles;
    this.sDataTable.style.cssText = sDataTableStyles;

/////* Set up table scrolling and IE's onunload event for garbage collection */
//    固定列移动
    (function (st) {
        if (st.fixedCols > 0) {
            st.sData.onscroll = function () {
                st.sHeaderInner.style.right = st.sData.scrollLeft + "px";
                st.sFDataInner.style.top = (st.sData.scrollTop * -1) + "px";
            };
        } else {
            st.sData.onscroll = function () {
                st.sHeaderInner.style.right = st.sData.scrollLeft + "px";
            };
        }
        if (/*@cc_on!@*/0) { /* Internet Explorer */
            window.attachEvent("onunload", function () {
                st.sData.onscroll = null;
                st = null;
            });
        }
    })(this);

    this.callbackFunc && this.callbackFunc();
};


/////////////////////////////////////////////////////////////////////////////////////////

// Super Tables Plugin for jQuery - MIT Style License

// Copyright (c) 2009 Jeffrey Lee --- blog2.darkthread.net

//

// A wrapper for Matt Murphy's Super Tables http://www.matts411.com/post/super_tables/

//

// Contributors:

//

/////////////////////////////////////////////////////////////////////////////////////////

////// TO CALL:



// (function($) {
//
//     $.fn.extend(
//
//         {
//
//             toSuperTable: function(options) {
//
//                 var setting = $.extend(
//
//                     {
//
//                         width: "640px", height: "320px",
//
//                         margin: "10px", padding: "0px",
//
//                         overflow: "hidden", colWidths: undefined,
//
//                         fixedCols: 0, headerRows: 1,
//
//                         onStart: function() { },
//
//                         onFinish: function() { },
//
//                         cssSkin: "sSky"
//
//                     }, options);
//
//                 return this.each(function() {
//
//                     var q = $(this);
//
//                     var id = q.attr("id");
//
//                     q.removeAttr("style").wrap("<div id='" + id + "_box'></div>");
//
//
//
//                     var nonCssProps = ["fixedCols", "headerRows", "onStart", "onFinish", "cssSkin", "colWidths"];
//                     var container = $("#" + id + "_box");
//                     for (var p in setting) {
//                         if ($.inArray(p, nonCssProps) == -1) {
//                             container.css(p, setting[p]);
//                             delete setting[p];
//                         }
//                     }
//                     var mySt = new superTable(id, setting);
//
//
//
//                 });
//
//             }
//
//         });
//
//
// })(jQuery);