var count = 0;
var detailArray = [];
var reviewArray = [];

function getProductId(){
	var url = document.location.href.split("?");
	var productId = url[1].substr(10);
	return productId;
}

function nextImage(){
	count++;
	var ul = document.querySelector(".detail_swipe");
	if(count == detailArray.length){
		count = 0;
	}
	ul.innerHTML = detailArray[count];
	
}

function unfold(){
	var close = document.querySelector(".close3");
	var unfold = document.querySelector("._open");
	var fold = document.querySelector("._close");
	close.className = "store_details";
	unfold.style.display = 'none';
	fold.style.display = 'block';
}

function fold(){
	var close = document.querySelector(".store_details");
	var unfold = document.querySelector("._open");
	var fold = document.querySelector("._close");
	close.className = "store_details close3";
	unfold.style.display = 'block';
	fold.style.display = 'none';
}



function prevImage(){
	count--;
	var ul = document.querySelector(".detail_swipe");
	if(count < 0){
		count = detailArray.length - 1;
	}
	ul.innerHTML = detailArray[count];
	
}


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
		detailArray.push(resultHTML);
	})
	var ul = document.querySelector(".detail_swipe");
	ul.innerHTML = detailArray;
	
}

function makeReviewTemplate(comment){
	var template = document.querySelector("#template-review").innerText;
	console.log(template);
	var bindTemplate = Handlebars.compile(template);

	var data = [];
	for(var i=0; i<comment.length; i++){
		// 객체생성
		var review = {};
		review.reviewImage = comment[i].save_file_name;
		review.comment = comment[i].comment;
		review.score = comment[i].score;
		review.email = comment[i].reservation_email;
		review.date = comment[i].modify_date;
		data.push(review);
	}

	data.forEach(function(v){
		var resultHTML = bindTemplate(v);
		reviewArray.push(resultHTML);
	})
	var ul = document.querySelector(".list_short_review");
	ul.innerHTML = reviewArray;

}

function sendDetailAjax(url, productId) {
    var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function () {
         var jsonobj = JSON.parse(oReq.responseText);
         makeDetailTemplate(jsonobj.productDetail);

    });
    oReq.open("GET", url +productId);
    oReq.send();
}

function sendReviewAjax(url, productId){
	var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function () {
         var jsonobj = JSON.parse(oReq.responseText);
         makeReviewTemplate(jsonobj.comment);

    });
    oReq.open("GET", url +productId);
    oReq.send();
}


document.addEventListener("DOMContentLoaded", function () {
    sendDetailAjax("http://localhost:8080/reservationProject/api/detail/", getProductId());
	sendReviewAjax("http://localhost:8080/reservationProject/api/detail/comment/", getProductId());

})