import Vue from "vue";
import VueRouter from "vue-router";
// import NProgress from "nprogress";
import "nprogress/nprogress.css";
Vue.use(VueRouter);

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/login",
      name: "Login",
      meta: { icon: "login", title: "Login", isLogin: false },
      component: () => import("../views/Login.vue"),
    },
    {
      path: "/register",
      name: "Register",
      meta: { icon: "Register", title: "Register", isLogin: false },
      component: () => import("../views/Register.vue"),
    },
    {
      path: "/",
      component: () => import("../layouts/BasicLayout.vue"),
      children: [
        {
          path: "/",
          redirect: "/dashboard",
        },
        {
          path: "/dashboard",
          name: "Dashboard",
          meta: { icon: "dashboard", title: "Dashboard", isLogin: false },
          component: () => import("../views/Dashboard.vue"),
        },
        {
          path: "/calendar",
          name: "Calendar",
          meta: { icon: "calendar", title: "Calendar", isLogin: false },
          component: () => import("../views/Calendar.vue"),
        },
        {
          path: "/contact",
          name: "Contact",
          hideChildrenInMenu: true,
          meta: { icon: "contacts", title: "Contact", isLogin: true },
          component: () => import("../views/Contact.vue"),
          children: [
            {
              path: "/contact/{id}",
              name: "Contact Detail",
              meta: { icon: "contacts", title: "ContactDetail", isLogin: true },
              component: () => import("../views/ContactDetail.vue"),
            },
          ],
        },
        {
          path: "/setting",
          name: "Setting",
          meta: { icon: "setting", title: "Setting", isLogin: true },
          hideChildrenInMenu: true,
          component: () => import("../views/Setting.vue"),
          children: [
            {
              path: "/setting/account",
              name: "Account Setting",
              meta: { icon: "contacts", title: "AS", isLogin: true },
              component: () => import("../views/AS.vue"),
            },
            {
              path: "/setting/security",
              name: "Security",
              meta: { icon: "contacts", title: "Security", isLogin: true },
              component: () => import("../views/Security.vue"),
            },
            {
              path: "/setting/email",
              name: "Email",
              meta: { icon: "contacts", title: "Email", isLogin: true },
              component: () => import("../views/Email.vue"),
            },
            {
              path: "/setting/style",
              name: "Style",
              meta: { icon: "contacts", title: "Style", isLogin: true },
              component: () => import("../views/Style.vue"),
            },
          ],
        },
      ],
    },

  ],
});
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location, onResolve, onReject) {
if (onResolve || onReject) return originalPush.call(this, location, onResolve, onReject)
return originalPush.call(this, location).catch(err => err)
}



// router.beforeEach((to, from, next) => {
//   NProgress.start();
//   //获取用户登录成功后储存的登录标志
//   let getFlag = localStorage.getItem("Flag");

//   //如果登录标志存在且为isLogin，即用户已登录
//   if (getFlag === "isLogin") {
//     //设置vuex登录状态为已登录
//     store.state.isLogin = true;
//     next();

//     //如果已登录，还想想进入登录注册界面，则定向回首页
//     if (!to.meta.isLogin) {
//       //iViewUi友好提示
//       //   iView.Message.error("请先退出登录");
//       next({
//         path: "/dashboard",
//       });
//     }

//     //如果登录标志不存在，即未登录
//   } else {
//     //用户想进入需要登录的页面，则定向回登录界面
//     if (to.meta.isLogin) {
//       next({
//         path: "/login",
//       });
//       //iViewUi友好提示
//       //   iView.Message.info("请先登录");
//       //用户进入无需登录的界面，则跳转继续
//     } else {
//       next();
//     }
//   }
// });

// router.afterEach(() => {
//   NProgress.done();
// });
export default router;
