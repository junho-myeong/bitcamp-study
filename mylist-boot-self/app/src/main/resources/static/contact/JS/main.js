console.log('hi')
var tbodyTblEl = document.querySelector('#tbodyTbl')
fetch('/contact/list')
.then(function(response){
  return response.json()
}).then(function(arr) {
  for (contact of arr) {
    console.log(contact)
    console.log(contact.split(','))
    var contactArr = contact.split(',')
    var trEl = document.createElement('tr');
    trEl.innerHTML = `<td><a href = "/contact/view.html?email=${contactArr[1]}">${contactArr[0]}</a></td><td>${contactArr[1]}</td><td>${contactArr[2]}</td><td>${contactArr[3]}</td>`
    tbodyTblEl.appendChild(trEl)
  }
})




