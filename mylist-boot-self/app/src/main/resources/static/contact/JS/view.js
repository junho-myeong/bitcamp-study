var xName = document.querySelector('#x-contact-name')
var xEmail = document.querySelector('#x-contact-email')
var xTel = document.querySelector('#x-contact-tel')
var xCompany = document.querySelector('#x-contact-company')
var updateBtn = document.querySelector('#x-contact-update')
var cancelBtn = document.querySelector('#x-contact-cancel')


console.log(location.href.indexOf('?'))

if (location.href.indexOf('?')==-1) {
  window.alert('요청이 올바르지 않습니다!')
  location.href = 'index.html'
}

console.log(location.href.split('?')[1])

var params =  new URLSearchParams(location.href.split('?')[1]);
console.log(params.get('email'))
var email = params.get('email')

if (email == null) {
  window.alert('이메일이 없습니다.')
  location.href = 'index.html'
}

fetch(`/contact/get?email=${email}`)
.then(function(response) {
  return response.text()
})
.then(function(result) {
  if(result == "") {
    window.alert('해당 이메일을 찾을수 없습니다.')
    location.href ='index.html'
  }
  var contact = result.split(',')
  xName.value = contact[0]
  xEmail.value = contact[1]
  xTel.value = contact[2]
  xCompany.value = contact[3]
})

updateBtn.addEventListener('click', function() {
  
  fetch(`/contact/update?name=${xName.value}&email=${xEmail.value}&tel=${xTel.value}&company=${xCompany.value}`)
  .then(function(response) {
    return response.text()
  })
  .then(function(result) {
    console.log(result)
    window.location.href = 'index.html'
  })
})  

cancelBtn.addEventListener('click', function() {
  window.location.href = 'index.html' //window는 웹브라우저를 말한다.
})