<template>
<div class="todoList">
    <li>
      <label>
        <input type="checkbox" :checked="todo.done" @change="handleCheck(todo.id)">
      <span>{{todo.title}}</span>
      </label>
      <button class="btn btn-danger" @click="handleDelete(todo.id)">delete</button>
      <!-- <a>-</a> -->
    </li>
</div>
</template>

<script>
export default {
    name:"MyItem",
    props:['todo','checkTodo','deleteTodo'],
    methods:{
      handleCheck(id){
        this.checkTodo(id)
      },
      handleDelete(id){
        if(confirm('Are you sure to delete this item?')){
          this.deleteTodo(id)
        }
      }
    }
}
</script>

<style scoped>
.todoList {
  max-height: 250px;
  overflow-y: auto;
}

.todoList li {
  position: relative;
  list-style: none;
  margin-bottom: 8px;
  background: #f2f2f2;
  border-radius: 3px;
  padding: 10px 15px;
  cursor: default;
  overflow: hidden;
  word-wrap: break-word;
}

.todoList li .icon {
  position: absolute;
  right: -45px;
  top: 50%;
  transform: translateY(-50%);
  background: #e74c3c;
  width: 45px;
  text-align: center;
  color: #fff;
  padding: 10px 15px;
  border-radius: 0 3px 3px 0;
  cursor: pointer;
  transition: all 0.2s ease;
}

.todoList li button{
  float: right;
  display: none;
  margin-top: 3px;
}

.todoList li:hover .icon {
  right: 0px;
  background-color: aquamarine;
}

.todoList li:hover button {
  padding: 6px 10px;
  border-radius: 3px;
  border: none;
  outline: none;
  color: #fff;
  font-weight: 400;
  font-size: 10px;
  margin-left: 5px;
  background: #8E49E8;
  cursor: pointer;
  user-select: none;
  opacity: 0.6;
  /* pointer-events: none; */
  transition: all 0.3s ease;
  display: block;
}

/* .content ol li{
    cursor: move;
    height: 32px;
    background-color: #FFF;
    position: relative;
    margin-bottom: 10px;
    padding: 0 45px;
    border-radius: 3px;
    border-left: 5px solid #55BB8E;
} */

/* .content ol li input{
    cursor: pointer;
    width: 22px;
    height: 22px;
    position: absolute;
    top: 2px;
    left: 10px;
}

.content ol li p{
    margin: 0;
    padding: 5px;
    text-align: left;

}

.content ol li a{
    display: inline-block;
    position: absolute;
    top: 2px;
    right: 5px;
    width: 14px;
    height: 12px;
    border-radius: 14px;
    background-color: #CCC;
    line-height: 14px;
    border: 6px double #FFF;
    text-align: center;
    color: #FFF;
    font-size: 14px;
    cursor: pointer;
} */

</style>