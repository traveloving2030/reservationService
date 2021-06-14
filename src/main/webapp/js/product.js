// 접근방법
// 상품 2개로 쪼개고, 나머지 2개에는 

var productHTML = [];
var promotionHTML = [];

function slide(ul, cnt) {
    var index=0;
    setInterval(function () {
        ul.style.transition = "0.5s";
        ul.style.transform = "translate3d(-" + 414*(index + 1) +"px , 0px, 0px)";
        index++;
        if (index == cnt - 1) {
            index = -1;
        }
    }, 2000)
}

function makePromotionTemplate(promotion_img){
    var cnt=0;
    var ul = document.querySelector(".visual_img");
    var templatePromotionHTML = document.querySelector("#template-promotion").innerHTML;
    promotion_img.forEach(function(pm){
        cnt++;
       var result = templatePromotionHTML.replace("{promotionImgPath}", pm.save_file_name)
       promotionHTML.push(result);
    })
    ul.innerHTML = promotionHTML;
    slide(ul, cnt);
}

function makeTemplate(productList) {
    var ul1 = document.getElementById("firstItem");

    var ul2 = document.getElementById("secondItem");
    var templateProductHTML = document.querySelector("#itemList").innerHTML;
    var resultHTML = "";
    for(var i=0; i<productList.length; i++){
        var li = document.createElement("li");
        li.className="item"
        resultHTML = templateProductHTML.replace("{id}", productList[i].id).replace("{description}", productList[i].description)
                                        .replace("{itemPath}", productList[i].save_file_name)
                                        .replace("{placeName}", productList[i].place_name)
                                        .replace("{content}", productList[i].content)
        
        li.innerHTML = resultHTML;
        if(i>=2){
            ul2.appendChild(li);
        }else{
            ul1.appendChild(li)
        }    
    }
}

function moreProducts(){
    $.ajax({
        dataType: "json",
        url: "http://localhost:8080/reservationProject/api/products",
        type: "GET",
        success: function(data){
            console.log(data);
        }
    })

}




function sendProductAjax(url) {
    var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function () {
        var jsonobj = JSON.parse(oReq.responseText);
        makeTemplate(jsonobj.productAllList);
    });
    oReq.open("GET", url);
    oReq.send();
}





function sendPromotionAjax(url){
    var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function() {
      var jsonobj = JSON.parse(oReq.responseText);
      makePromotionTemplate(jsonobj.promotionImage);
    });    
    oReq.open("GET", url);
    oReq.send();
}


document.addEventListener("DOMContentLoaded", function () {
    sendPromotionAjax("http://localhost:8080/reservationProject/api/promotions");
    sendProductAjax("http://localhost:8080/reservationProject/api/products");

})