function toggleMenu(){
  document.querySelector(".nav-links").classList.toggle("active");
}

function toggleDarkMode(){
  document.body.classList.toggle("dark");
}


function showToast(){
  let t = document.getElementById("toast");
  t.innerText = "Welcome 🚀";
  t.style.display = "block";
  setTimeout(()=> t.style.display="none",2000);
}

/* FORM */
function validateForm(){
  let name = document.getElementById("name").value;
  let email = document.getElementById("email").value;

  if(name==="" || email===""){
    showToast("Fill all fields ❌");
    return false;
  }
  showToast("Submitted ✅");
  return true;
}

/* API FETCH */
async function loadData(){
  let res = await fetch("https://jsonplaceholder.typicode.com/users");
  let data = await res.json();

  let container = document.getElementById("data");
  container.innerHTML="";

  data.slice(0,5).forEach(user=>{
    container.innerHTML += `<div>${user.name}</div>`;
  });
}