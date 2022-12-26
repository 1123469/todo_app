<template>
<div class="footer" v-show="total">
  <label>
    <!-- <input type="checkbox" :checked="isAll" @change="checkAll"> -->
    <input type="checkbox" v-model="isAll">
  </label>
  <span>{{undoneTotal}}<span class="pendingTasks"></span> pending tasks, {{total}} in total</span>
  <button @click="clearAll">Clear All</button>
</div>
</template>

<script>
export default {
    name:"MyFooter",
    props:['todos','checkAllTodo','clearAllTodo'],
    computed:{
      total(){
         return this.todos.length
      },
      undoneTotal(){
        // let i = 0
        // this.todos.forEach((todo) => {
        //   if(!todo.done){
        //     i++
        //   }     
        // });
        // return i
        return this.todos.reduce(
          (pre,current)=>{
            return pre+(current.done?0:1)
          },0)
      },
      isAll:{
        get(){
           return this.undoneTotal===0 && this.total>0
        },
        set(value){
          this.checkAllTodo(value)
        }
        
      }
    },
    methods:{
      checkAll(e){
        this.checkAllTodo(e.target.checked)
      },
      clearAll(){
        if(confirm('"Are you sure to clear all completed items?"')){
           this.clearAllTodo()
        }
      }
    }
}
</script>

<style scoped>
.footer {
  display: flex;
  width: 100%;
  margin-top: 20px;
  align-items: center;
  justify-content: space-between;
}

.footer button {
  padding: 6px 10px;
  border-radius: 3px;
  border: none;
  outline: none;
  color: #fff;
  font-weight: 400;
  font-size: 16px;
  margin-left: 5px;
  background: #8E49E8;
  cursor: pointer;
  user-select: none;
  opacity: 0.6;
  /* pointer-events: none; */
  transition: all 0.3s ease;
}

.footer button.active {
  opacity: 1;
  pointer-events: auto;
}
</style>