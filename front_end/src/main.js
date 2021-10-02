import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import axios from 'axios';
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';


import './scss/app.scss';

Vue.use(Antd);

Vue.config.productionTip = false
Vue.prototype.$axios = axios

new Vue({
    router,
    store,
    axios,
    render: (h) => h(App),
}).$mount("#app");