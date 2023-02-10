const numInputId = document.querySelector("#num-input");
const reverseId = document.querySelector("#reverse");
const showResultId = document.querySelector("#show-result");
const todoInputId = document.querySelector("#todo-input");
const todos = [];
reverseId.addEventListener('click',()=>{
       let num = getInputValue();
       let temp = num;
       let rev = 0;
       while(num != 0){
            let r = num % 10;
            rev = rev * 10 + r;
            num = Number.parseInt(num/10);
       } 
       showResult(`<br/><strong>Reverse of ${temp} is ${rev}</strong>`);
})

todoInputId.addEventListener('keyup',(event)=>{
    if(event.keyCode == 13 && event.target.value!==""){
        let todo = event.target.value;
        todos.push(todo);
        showTodos();
        event.target.value = "";
    }
})

function showTodos(){
        let str = "No todos are added yet, please add to see...";
        if(todos.length>0){
        str = "";
        for(let i=0;i<todos.length;i++){
            let todo = todos[i];
            str += `<div class="card">
                    <div class="card-body">${todo}
                    <i class="fa fa-trash" style='float:right' onclick="removeTodo(${i})"></i>
                    </div>
                   
                    </div>`;
        }
        str += '</ul>';
        }
        document.querySelector("#todo-result").innerHTML = str;

}

function removeTodo(index){
        console.log(index);
}

function showResult(res){
    showResultId.innerHTML = res;
}

function getInputValue(){
    let numStr = numInputId.value;
    if(numStr !== ""){
        return Number.parseInt(numStr);
    }
}

