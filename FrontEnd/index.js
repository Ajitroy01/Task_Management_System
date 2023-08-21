const resultDiv = document.getElementById("result");

async function fetchData(url){
    const response = await fetch(`http://localhost:8080${url}`);
    const data = await response.json();
    return JSON.stringify(data, null, 2);
}

async function filterByPriority(){
    const priority = document.getElementById("priority").value;
    resultDiv.innerHTML = await fetchData(`/api/tasks/filter-by-priority?priority=${priority}`);
}
async function filterByDueDate(){
    const dueDate = document.getElementById("dueDate").value;
    resultDiv.innerHTML = await fetchData(`/api/tasks/filter-by-due-date?dueDate=${dueDate}`);
}
async function filterByCompleted(){
    const completed = document.getElementById("completed").checked;
    resultDiv.innerHTML = await fetchData(`/api/tasks/filter-by-completed?completed=${completed}`);
}

async function getAllTasks(){
    resultDiv.innerHTML = await fetchData(`api/tasks`);
}

async function addTask(){
    const taskTitle = document.getElementById("taskTitle").value;
    const taskPriority = document.getElementById("taskPriority").value;
    const taskDueDate = document.getElementById("taskDueDate").value;

    const newTask = {
        title: taskTitle,
        priority: taskPriority,
        dueDate:taskDueDate
    };

    await postData(`/api/tasks`, newTask);
    getAllTasks();
}

async function updateTask(){
    const taskId = document.getElementById("taskId").value;
    const taskTitle = document.getElementById("updatetaskTitle").value;
    const taskPriority = document.getElementById("updatetaskPriority").value;
    const taskDueDate = document.getElementById("updatetaskDueDate").value;

    const updateTask = {
        title: taskTitle,
        priority: taskPriority,
        dueDate:taskDueDate
    };

    await putData(`/api/tasks/${taskId}`, updateTask);
    getAllTasks();
}


async function postData(url, data){
    await fetch(`http://localhost:8080${url}`,{
    method:"POST",
    headers:{
        "Content-Type" : "application/json"
    },
    body : JSON.stringify(data)
    });
}

async function putData(url, data){
    await fetch(`http://localhost:8080${url}`,{
    method:"PUT",
    headers:{
        "Content-Type" : "application/json"
    },
    body : JSON.stringify(data)
    });
}

async function markTaskAsCompleted(){
    const taskId = document.getElementById("completedtaskId").value
    await putData(`/api/tasks/${taskId}/complete`);
    getAllTasks();
}

