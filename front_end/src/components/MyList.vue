<template>
<div>
    <ul class="todoList">
      <!-- data are comes from local storage -->
      <MyItem v-for="todoObj in todos" 
      :key="todoObj.id" 
      :todo="todoObj" 
      :checkTodo="checkTodo"
      :deleteTodo="deleteTodo"
      />
    </ul>
</div>
</template>

<script>
import MyItem from './MyItem.vue'
export default {
    name:"MyList",
    components:{MyItem},
    props:['todos','checkTodo','deleteTodo'],
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

.todoList li:hover .icon {
  right: 0px;
}
</style>