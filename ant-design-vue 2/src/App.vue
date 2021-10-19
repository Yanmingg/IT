<template>
  <div id = "app">
    <router-view />
  </div>
    
</template>

<script>
import dashboard from "./api/dashboard"
export default {
  data(){
    return{
      closestTask:{}
    }
    
  },
  methods: {
    getTask(task){
      this.closestTask = task
    },
    getCurrentTime() {
      let diff = parseInt((new Date(this.closestTask.time) - new Date()) / (1000 * 60))
      if(diff == 15){
        this.$message.info("Task"+ this.closestTask.name + "is going to hold in 15 minutes");
      }
      this.$message.info("Task "+ this.closestTask.name + " is not going to hold in 15 minutes");
      //let diff = this.difference(time,)
      //console.log(diff)
    },
  },
  created(){
    dashboard.getClosetTask(task => this.getTask(task))
    setInterval(this.getCurrentTime,10000)
  }            
}
</script>

<style lang="less">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
