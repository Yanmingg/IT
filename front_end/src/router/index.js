import Vue from "vue";
import VueRouter from "vue-router";
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'

Vue.use(VueRouter);

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes: [{
        path: "/",
        component: () =>
            import ("../layouts/BasicLayout.vue"),
        children: [{
                path: "/",
                redirect: "/dashboard",
            },
            {
                path: "/dashboard",
                name: "Dashboard",
                meta: { icon: 'dashboard', title: "Dashboard" },
                component: () =>
                    import ("../views/Dashboard.vue"),
            },
            {
                path: "/calendar",
                name: "Calendar",
                meta: { icon: 'calendar', title: "Calendar" },
                component: () =>
                    import ("../views/Calendar.vue"),
            },
            {
                path: "/contact",
                name: "Contact",
                hideChildrenInMenu: true,
                meta: { icon: 'contacts', title: "Contact" },
                component: () =>
                    import ("../views/Contact.vue"),
                children: [{
                    path: "/contact/{id}",
                    name: "Contact Detail",
                    meta: { icon: 'contacts', title: "ContactDetail" },
                    component: () =>
                        import ("../views/ContactDetail.vue"),
                }, ]
            },
            {
                path: "/setting",
                name: "Setting",
                meta: { icon: 'setting', title: "Setting" },
                hideChildrenInMenu: true,
                component: () =>
                    import ("../views/Setting.vue"),
                children: [{
                        path: "/setting/account",
                        name: "Account Setting",
                        meta: { icon: 'contacts', title: "AS" },
                        component: () =>
                            import ("../views/AS.vue"),
                    },
                    {
                        path: "/setting/security",
                        name: "Security",
                        meta: { icon: 'contacts', title: "Security" },
                        component: () =>
                            import ("../views/Security.vue"),
                    },
                    {
                        path: "/setting/email",
                        name: "Email",
                        meta: { icon: 'contacts', title: "Email" },
                        component: () =>
                            import ("../views/Email.vue"),
                    },
                    {
                        path: "/setting/style",
                        name: "Style",
                        meta: { icon: 'contacts', title: "Style" },
                        component: () =>
                            import ("../views/Style.vue"),
                    },
                ]
            },
        ]
    }, ]
});
router.beforeEach((to, from, next) => {
    NProgress.start();
    next();

})

router.afterEach(() => {
    NProgress.done();

});
export default router;