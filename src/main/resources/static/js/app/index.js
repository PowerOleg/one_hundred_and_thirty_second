function ChangeColor(Element) {
if (Element.style.color == 'green') Element.style.color = 'blue';
	else Element.style.color = 'green';
	return false;
}








const func1 = (Element) => {
 if (Element.style.color == 'green') Element.style.color = 'blue';
 	else Element.style.color = 'green';
	return false;


//не работает
//var link = document.createElement('link');
//link.textContent = 'Link Title';
//link.href = 'http://localhost:8080/new';
//document.getElementById('save').appendChild(link);



//	const name = document.getElementById("name").value;
//    console.log(`Name: ${name}\n`)
//    th:href="@{/new}
}



//th:onclick="'javascript:return ChangeColor(this);'"


//эта штука работает, но на первый клик переназначает адрес, а на второй только по новому адресу переносит
//const func1 = (Element) => {
// document.getElementById('button1').href = 'http://localhost:8080/new';
// }