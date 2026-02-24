let courses = [];
let editIndex = null;

function showSection(id){
    document.querySelectorAll('.section')
        .forEach(s => s.classList.remove('active'));
    document.getElementById(id).classList.add('active');
}

function addCourse(e){
    e.preventDefault();
    courses.push({
        name: name.value,
        desc: desc.value,
        hours: hours.value
    });
    render();
    e.target.reset();
}

function render(){
    const tbody = document.querySelector('#courseTable tbody');
    tbody.innerHTML = '';
    courseSelect.innerHTML = '';

    courses.forEach((c,i)=>{
        tbody.innerHTML += `
      <tr>
        <td>${c.name}</td>
        <td>${c.desc}</td>
        <td>${c.hours}</td>
        <td>
          <button onclick="editCourse(${i})">Edit</button>
          <button onclick="deleteCourse(${i})">Delete</button>
        </td>
      </tr>`;
        courseSelect.innerHTML += `<option>${c.name}</option>`;
    });

    courseCount.textContent = courses.length;
}

function deleteCourse(i){
    courses.splice(i,1);
    render();
}

function editCourse(i){
    editIndex = i;
    modal.style.display = 'flex';
    editName.value = courses[i].name;
    editDesc.value = courses[i].desc;
    editHours.value = courses[i].hours;
}

function saveEdit(){
    courses[editIndex] = {
        name: editName.value,
        desc: editDesc.value,
        hours: editHours.value
    };
    closeModal();
    render();
}

function closeModal(){
    modal.style.display = 'none';
}

function toggleMode(){
    document.body.classList.toggle('dark');
}

function updateTime(){
    document.getElementById('datetime')
        .textContent = new Date().toLocaleString();
}

setInterval(updateTime,1000);
updateTime();

function logout(){
    // later you can change to: window.location.href = "logoutServlet";
    window.location.href = "login.html";
}
