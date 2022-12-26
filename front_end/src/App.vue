<template>
   <div class="wrapper">
    <MyHeader/>
    <MyInput :addTodo="addTodo"/>
    <MyList :todos="todos" :checkTodo="checkTodo" :deleteTodo="deleteTodo"/>
    <MyFooter :todos="todos" :checkAllTodo="checkAllTodo" :clearAllTodo="clearAllTodo"/>
  </div>
</template>

<script>
import MyHeader from './components/MyHeader.vue'
import MyInput from './components/MyInput.vue'
import MyList from './components/MyList.vue'
import MyFooter from './components/MyFooter.vue'



export default {
  name: 'App',
  components: {
    MyHeader,MyInput,MyList,MyFooter
  },
  created:function(){
    // console.log('App组件被创建了')
    this.$http.get('/getAllTodos').then(
     (response)=>{
      this.todos = response.data
     }
    )

  },
  data(){
      return {
        todos:[
          // {id:"001",title:"学习",done:true},
          // {id:"002",title:"休息",done:true},
          // {id:"003",title:"工作",done:false},
          // {id:"004",title:"工作",done:true},
        ]
      }
    },
  methods:{
    addTodo(todoObj){
      // this.todos.unshift(todoObj)
      this.$http.post('/addTodos',todoObj
      )
      this.$http.get('/getAllTodos').then(
     (response)=>{
      this.todos = response.data
     }
    )
      location.reload()

    },
    checkTodo(id){
      // this.todos.forEach((todo) => {
      //   if(todo.id===id) todo.done = !todo.done
      // });
      let data = {"id":id}
      this.$http.post('/updateTodos',data)
      this.$http.get('/getAllTodos').then(
     (response)=>{
      this.todos = response.data
     }
    )
      location.reload()

    },
    deleteTodo(id){
      // this.todos = this.todos.filter(
      //   // (todo) =>{
      //   //   return todo.id!==id
      //   // }
      //   todo => todo.id!==id
      // )
      let data = {"id":id}
      this.$http.post('/deleteTodos',data)
      this.$http.get('/getAllTodos').then(
     (response)=>{
      this.todos = response.data
     }
    )
      location.reload()
    },
    checkAllTodo(done){
      // this.todos.forEach(todo => {
      //   todo.done = done    
      // });
      let data = {"done":done}
      this.$http.post('/updateAllTodos',data)
      this.$http.get('/getAllTodos').then(
     (response)=>{
      this.todos = response.data
     }
    )
      location.reload()
    },
    clearAllTodo(){
        // this.todos = this.todos.filter((todo)=>{
        //   return !todo.done
        // })
      this.$http.get('/deleteAllDoneTodos')
      this.$http.get('/getAllTodos').then(
     (response)=>{
      this.todos = response.data
     }
    )
      location.reload()
      }
  }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
}

::selection {
  color: #ffff;
  background: rgb(142, 73, 232);
}

body {
  width: 100%;
  height: 100vh;
  /* overflow: hidden; */
  padding: 10px;
  background: linear-gradient(to bottom, #68EACC 0%, #497BE8 100%);
}

.wrapper {
  background: #fff;
  max-width: 400px;
  width: 100%;
  margin: 120px auto;
  padding: 25px;
  border-radius: 5px;
  box-shadow: 0px 10px 15px rgba(0, 0, 0, 0.1);
}

</style>
