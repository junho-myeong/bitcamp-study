var tbody = document.querySelector('#x-contact-tbl tbody')


fetch('/contact/list').then(function(response){
  return response.json()
}).then(function(arr){
  for (var str of arr) {
    console.log(str.split(',')) // 쪼개면 return 하는게 배열이다.
    console.log(str) // "홍길동11, hong@test.com, 010-1111-2222, 비트캠프"
    var contact = str.split(',')
    var tr = document.createElement("tr")
    tr.innerHTML = `<td><a href ="view.html?email=${contact[1]}">${contact[0]}</a></td>
    <td>${contact[1]}</td>
    <td>${contact[2]}</td>
    <td>${contact[3]}</td>`
    tbody.appendChild(tr)
  }
})









