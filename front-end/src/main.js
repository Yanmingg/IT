import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import Antd from "ant-design-vue/es";
import axios from 'axios';
import 'ant-design-vue/dist/antd.css';
import NProgress from "nprogress";

router.beforeEach((to, from, next) => {
    NProgress.start();
    //获取用户登录成功后储存的登录标志
    let getFlag = localStorage.getItem("Flag");
    console.log("getFlag")
    console.log(getFlag)
        //如果登录标志存在且为isLogin，即用户已登录
    if (getFlag === "isLogin") {

        //设置vuex登录状态为已登录
        // store.state.isLogin = true
        store.state.isLogin = true
        next()

        //如果已登录，还想想进入登录注册界面，则定向回首页
        if (!to.meta.isLogin) {
            //iViewUi友好提示

            // next({
            //   path: '/dashboard'
            // })
        }

        //如果登录标志不存在，即未登录
    } else {

        //用户想进入需要登录的页面，则定向回登录界面
        if (to.meta.isLogin) {
            `<a-alert message="Warning text" banner />`
            next({
                path: '/login',
            })

            //iViewUi友好提示

            //用户进入无需登录的界面，则跳转继续
        } else {
            next()
        }

    }

});

router.afterEach(() => {
    NProgress.done();
    window.scroll(0, 0);
});
Vue.config.productionTip = false;
Vue.use(Antd);
Vue.prototype.$axios = axios
new Vue({
    router,
    store,
    axios,
    render: (h) => h(App),
}).$mount("#app");