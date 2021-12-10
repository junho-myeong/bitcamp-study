const addEl = document.querySelector('form #x-add-btn')
const cancelEl = document.querySelector('form #x-cancel-btn')
var xName = document.querySelector('#x-name')
var xEmail = document.querySelector('#x-email')
var xTel = document.querySelector('#x-tel')
var xCompany = document.querySelector('#x-company')

addEl.addEventListener('click', function() {
  console.log(xName.value)
  console.log(xEmail.value)
  console.log(xTel.value)
  console.log(xCompany.value)

  fetch(`/contact/add?name=${xName.value}&email=${xEmail.value}&tel=${xTel.value}&company=${xCompany.value}`)
    .then(function(response) {
      return response.text() //서버에서 보낸 데이터를 그냥 그대로 텍스트로 리턴해줘!, json 문자열로 처리하지마!!
    })
    .then(function(result) {
      console.log(result)
      // window.location.href = 'index.html' 밑에 코드와 같은 말이다.
      location.href = 'index.html'
    });
})

cancelEl.addEventListener('click', function() {
  window.location.href = 'index.html' //window는 웹브라우저를 말한다.
})