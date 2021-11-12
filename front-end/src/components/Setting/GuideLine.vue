<template>
  <div>
    <a-menu v-model="current" mode="horizontal">
      <a-menu-item key="AS"> <a-icon type="mail" />Account Setting </a-menu-item>
      <a-menu-item key="Security"> <a-icon type="appstore" />Security </a-menu-item>
      <a-menu-item key="Email"> <a-icon type="mail" />Email </a-menu-item>
      <a-menu-item key="Style"> <a-icon type="bulb" />Style </a-menu-item>
    </a-menu>
  </div>
</template>
<script>
export default {
  data() {
    return {
      current: ['mail'],
    };
  },
};
</script>
