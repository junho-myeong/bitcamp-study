const updateEl = document.querySelector('form #x-update-btn')
const cancelEl = document.querySelector('form #x-cancel-btn')
var xName = document.querySelector('#x-name')
var xEmail = document.querySelector('#x-email')
var xTel = document.querySelector('#x-tel')
var xCompany = document.querySelector('#x-company')

// 쿼리스트링에서 이메일 값을 추출한다.
console.log(location.href.indexOf('?'))
// 요청 유효성 검사
if (location.href.indexOf('?') == -1) {
  window.alert('요청이 올바르지 않습니다.')
  location.href = 'index.html'
}

// url에서 쿼리스트링을 추출하여 파리미터의 이름과 값을 분리한다.
console.log(location.href.split('?')[1])

// 쿼리스트링에서 이메일 값을 추출한다.
var params =new URLSearchParams(location.href.split('?')[1])
console.log(params.get('email'))
var email = params.get('email')
if (email == null) {
  window.alert('이메일이 없습니다.')
  location.href = 'index.html'
}

// 이메일 가지고 연락처 상세 정보를 가져와서 입력 폼에 넣는다.
fetch(`/contact/get?email=${email}`)
  .then(function(response) {
    return response.text()
  })
  .then(function(result) {
    if (result == "") {
      window.alert('해당연락처를 가져올수 없습니다.')
      location.href = 'index.html'
    }
    var contact = result.split(',')
    xName.value = contact[0]
    xEmail.value = contact[1]
    xTel.value = contact[2]
    xCompany.value = contact[3]
})






updateEl.addEventListener('click', function() {
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