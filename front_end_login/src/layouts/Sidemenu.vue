<template>
<div>
      <div>
        <img src="../assets/logo.png" style="width: 160px; height: 110px;">
      </div>
  <a-menu 
    :selectedKeys="selectedKeys"
    :openKeys.sync="openKeys"
    mode="inline"
    :theme="theme"
  >
  <template v-for="item in menuData">
    <a-menu-item 
      v-if="!item.children" 
      style="margin-top: 50px"
      :key="item.path" 
      @click="()=>$router.push({path:item.path})"
    >
    <a-icon style=" fontSize: 250%; position: relative;
  top: px;
  left: -5px;" v-if="item.meta.icon" :type="item.meta.icon"/>
        <!-- <a-icon style="color: rgba(0, 0, 0, 1); fontSize: 250%; position: relative;
  top: px;
  left: -5px;" v-if="item.meta.icon" :type="item.meta.icon"/> -->
        <span style="fontSize: 120%">{{item.meta.title}}</span>
        
    </a-menu-item>
    <sub-menu v-else :menu-info="item" :key="item.path"  @click="click"/>

  </template>
  <a-icon type="close" style=" fontSize: 250%; position: relative;
  top: px;
  left: -5px;" @click="logout" />
  </a-menu>
</div>
</template>
<script>
import Submenu from "./Submenu.vue";
export default {
  props: {
    theme:{
      type: String,
      default: "dark"
    },
    collapsed:{
      type:Boolean,
      default:false
    }
  },
  components: {
    "sub-menu":Submenu
  },
  watch: {
    '$route.path' : function(val){
      this.selectedKeys = this.selectedKeysMap[val];
      this.openKeys = this.collapsed ? []:this.openKeysMap[val];
    }
  },
  data(){
    this.selectedKeysMap = {}
    this.openKeysMap = {}
    const menuData = this.getMenuData(this.$router.options.routes);
    return {
      menuData,
      selectedKeys: this.selectedKeysMap[this.$route.path],
      openKeys: this.collapsed ? [] : this.openKeysMap[this.$route.path]
    }
  },
  methods:{
    click(){
      console.log(22222222)
    },
    logout(){
      localStorage.setItem("Flag",null);
      localStorage.setItem("userid",null);
      this.$router.push("/login");
    },
    getMenuData(routes = [], parentKeys = [], selectedKey){
      const menuData = [];
      routes.forEach(item =>{
        if(item.name && !item.hideInMenu){
          this.openKeysMap[item.path] = parentKeys;
          this.selectedKeysMap[item.path] = [item.path || selectedKey];
          const newItem = {...item};
          delete newItem.children;
          if(item.collapsed && !item.hideChildrenInMenu) {
            newItem.children = this.getMenuData(item.children, 
            [...parentKeys, 
            item.path]);
          } else{
            this.getMenuData(
              item.children, 
              selectedKey? parentKeys:[...parentKeys, item.path],
              selectedKey||item.path);
          }
          menuData.push(newItem);
        } else if(
          !item.hideInMenu && 
          !item.hideChildrenInMenu && 
          item.children
        ){
          menuData.push(
            ...this.getMenuData(item.children, [...parentKeys, item.path])
          );
        }
      })
      return menuData;
    }
  }
}
</script>
<style>
/* 
.ant-layout-sider-children {
    height: 100%;
    margin-top: -0.1px;
    padding-top: 0.1px;
    background-color: rgb(255, 255, 255);
}
.ant-menu {
  background-color: rgb(255, 255, 255);

}
.ant-menu-item span{
  color: #000;

} */
.ant-menu-item-selected span{
  color: rgb(255, 0, 0);
}
.ant-layout-content{
  background-color: #F9FAFF;
}
.a-icon {

}
</style>