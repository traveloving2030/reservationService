var count = 1;

function getProductId(){
	var url = document.location.href.split("?");
	var productId = url[1].substr(10);
	return productId;
}

function nextImage(){
    //다음 이미지 생성하는것부터!
    var imageNodes = document.querySelectorAll(".detailImage");


}

function makeDetailTemplate(productDetail){
	var imgs = [];
	for(var i=0; i<productDetail.length; i++){
		imgs.push(productDetail[i].save_file_name);
	}
	var div = document.querySelector(".detail_swipe");
	var template = document.querySelector("#template-detail").innerText;
	var bindTemplate = Handlebars.compile(template);
	var data = {
		  	"detailImgPath" : imgs,
		    "detailTitle" : productDetail[0].description,
	};
	var resultHTML = bindTemplate(data);
	console.log(data);
	div.innerHTML = resultHTML;
	
}

function sendDetailAjax(url, productId) {
    var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function () {
         var jsonobj = JSON.parse(oReq.responseText);
//         console.log(jsonobj.productDetail[0].content);
         makeDetailTemplate(jsonobj.productDetail);

    });
    oReq.open("GET", url +productId);
    oReq.send();
}

document.addEventListener("DOMContentLoaded", function () {


    sendDetailAjax("http://localhost:8080/reservationProject/api/detail/", getProductId());

})