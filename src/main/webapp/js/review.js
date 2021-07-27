function sendReviewAjax(url, productId){
	var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function () {
         var jsonobj = JSON.parse(oReq.responseText);
         makeReviewTemplate(jsonobj.comment, jsonobj.comment.length);

    });
    oReq.open("GET", url +productId);
    oReq.send();
}

document.addEventListener("DOMContentLoaded", function () {
	sendReviewAjax("http://localhost:8080/reservationProject/api/detail/comment/", getProductId());
})