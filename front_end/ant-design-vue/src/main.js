import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import {
    Layout,
    Icon,
    Menu,
    Breadcrumb,
    Button,
    AutoComplete,
    Select,
    Input,
    Space,
    Table,
    Dropdown,
    Form,
    Card,
    Modal
} from "ant-design-vue";

Vue.config.productionTip = false;
Vue.use(Layout);
Vue.use(Icon);
Vue.use(Menu);
Vue.use(Breadcrumb);
Vue.use(Button);
Vue.use(AutoComplete);
Vue.use(Select);
Vue.use(Input);
Vue.use(Space);
Vue.use(Table);
Vue.use(Dropdown);
Vue.use(Form);
Vue.use(Card);
Vue.use(Modal);
new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount("#app");