<template>
  <a-layout id="components-layout-demo-side" style="min-height: 100vh">
    <a-layout-sider v-model="collapsed" collapsible>
      <div class="logo">
        <img src="../assets/logo.png" style="    width: 160px;
    height: 110px;">
      </div>
      <Sidemenu/>
    </a-layout-sider>
    <a-layout>
      <a-layout-content style="margin: 0 16px">
        <router-view></router-view>
      </a-layout-content>
      <a-layout-footer style="text-align: center">
        <Footer/>
      </a-layout-footer>
    </a-layout>
  </a-layout>
</template>
<script>
import Footer from '../layouts/Footer.vue';
import Sidemenu from '../layouts/Sidemenu.vue';
export default {
  components: { 
    Footer,
    Sidemenu},
  data() {
    return {
      collapsed: false,
    };
  },
};
</script>

<style>
#components-layout-demo-side .logo {

  height: 100px;
  margin: 16px;
}
</style>
