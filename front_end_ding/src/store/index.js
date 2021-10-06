import Vue from "vue";
import Vuex from "vuex";
import contact from "./modules/contact"
import dashboard from "./modules/dashboard"

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        userInfo: {
            email: "123456@qq.com"
        }
    },
    modules: {
        contact,
        dashboard,
    },
});