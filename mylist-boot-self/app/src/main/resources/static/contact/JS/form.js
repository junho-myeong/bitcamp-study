var xName = document.querySelector('#x-contact-name')
var xEmail = document.querySelector('#x-contact-email')
var xTel = document.querySelector('#x-contact-tel')
var xCompany = document.querySelector('#x-contact-company')
var addBtn = document.querySelector('#x-contact-add')
var cancelBtn = document.querySelector('#x-contact-cancel')

addBtn.addEventListener('click', function() {
  console.log(xName.value)
  console.log(xEmail.value)
  console.log(xTel.value)
  console.log(xCompany.value)

  fetch(`/contact/add?name=${xName.value}&email=${xEmail.value}&tel=${xTel.value}&company=${xCompany.value}`)
  .then(function(response) {
    return response.text()
  }).then(function(result) {
    console.log(result)
    location.href = 'index.html'
  })
})

cancelBtn.addEventListener('click', function() {
  window.location.href = 'index.html'
})



