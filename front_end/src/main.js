import Vue from 'vue'
import App from './App.vue'
import axios from 'axios'
axios.defaults.baseURL="http://localhost:8088/"

Vue.config.productionTip = false
Vue.prototype.$http = axios

new Vue({
  render: h => h(App),
}).$mount('#app')
