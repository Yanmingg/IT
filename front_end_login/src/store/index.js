import Vue from "vue";
import Vuex from "vuex";
import contact from "./modules/contact";
import dashboard from "./modules/dashboard";
import login from "./modules/login";
Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user: window.sessionStorage.getItem("user"),
  },
  modules: {
    contact,
    dashboard,
    login,
  },
});
