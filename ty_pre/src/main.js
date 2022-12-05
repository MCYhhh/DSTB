// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router/index'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/global.css';
import axios from 'axios';
import store from '@/store'

//配置请求的根路径
// axios.defaults.baseURL='http://localhost:8082/';
axios.defaults.baseURL = '/api';
Vue.prototype.$axios=axios;

Vue.use(ElementUI);
Vue.use(router);
// Vue.use(store);

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store,
  components: { App },
  template: '<App/>'
})


