import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import Antd from "ant-design-vue/es";
import axios from 'axios';
import 'ant-design-vue/dist/antd.css';


Vue.config.productionTip = false;
Vue.use(Antd);
Vue.prototype.$axios = axios
new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount("#app");