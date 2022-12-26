<template>
    <div class="inputField">
      <input type="text" placeholder="Add your new todo" v-model="title" @keyup.enter="add"/>
      <!-- <button><i class="fas fa-plus"></i></button> -->
    </div>
</template>

<script>
// import {nanoid} from 'nanoid'
export default {
    name:"MyInput",
    props:['addTodo'],
    data(){
      return {
        title:''
      }
    },
    methods:{
      add(){
        // wrap user input
        if(!this.title.trim())
            return
        const todoObj = {
          // id:nanoid(),
          title:this.title
        }
        this.addTodo(todoObj)
        this.title=''
      }
    }
}
</script>

<style scoped>
.inputField {
  margin: 20px 0;
  width: 100%;
  display: flex;
  height: 45px;
}

.inputField input {
  /* width: 85%; */
  width: 100%;
  height: 100%;
  outline: none;
  border-radius: 3px;
  border: 1px solid #ccc;
  font-size: 17px;
  padding-left: 15px;
  transition: all 0.3s ease;
}

.inputField input:focus {
  border-color: #8E49E8;
}

.inputField button {
  width: 50px;
  height: 100%;
  border: none;
  color: #fff;
  margin-left: 5px;
  font-size: 21px;
  outline: none;
  background: #8E49E8;
  cursor: pointer;
  border-radius: 3px;
  opacity: 0.6;
  pointer-events: none;
  transition: all 0.3s ease;
}

.inputField button:hover,
.footer button:hover {
  background: #721ce3;
}

.inputField button.active {
  opacity: 1;
  pointer-events: auto;
}
</style>