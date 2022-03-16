// var btn = document.getElementById("closeBtn");
// var btn = $('#closeBtn'); 위에 꺼랑 같은 뜻이다, jquery는 언어가 아니고 js의 라이브러리일 뿐이다. $는 그저 함수일 뿐이다.
// btn.addEventListener('click', function() {
//   var adDiv = document.getElementById("ad");
//   adDiv.style.display = "none";
// });

$("#closeBtn").click(function() {
  $("#ad").css("display", "none")
})
