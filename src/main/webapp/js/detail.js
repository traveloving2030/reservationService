var count = 0;
var newArray = [];

function getProductId(){
	var url = document.location.href.split("?");
	var productId = url[1].substr(10);
	return productId;
}

function nextImage(){
	count++;
	var ul = document.querySelector(".detail_swipe");
	if(count == newArray.length){
		count = 0;
	}
	ul.innerHTML = newArray[count];
	
}

function prevImage(){
	count--;
	var ul = document.querySelector(".detail_swipe");
	if(count < 0){
		count = newArray.length - 1;
	}
	ul.innerHTML = newArray[count];
	
}

/* function makeDetailTemplate(productDetail){
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
	console.log(resultHTML);
	div.innerHTML = resultHTML;
	
}
 */



function makeDetailTemplate(productDetail){
	var template = document.querySelector("#template-detail").innerText;
	var bindTemplate = Handlebars.compile(template);

	var data = [];
	for(var i=0; i<productDetail.length; i++){
		// 객체생성
		var details = {};
		details.detailImgPath = productDetail[i].save_file_name;
		details.detailTitle = productDetail[i].description;
		data.push(details);
	}

	data.forEach(function(v){
		var resultHTML = bindTemplate(v);
		newArray.push(resultHTML);
	})
	var ul = document.querySelector(".detail_swipe");
	ul.innerHTML = newArray;
	
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