<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  data() {
    return {
      closestTask: {},
    };
  },
  computed: {
    ...mapState({
      taskinfo: (state) => state.dashboard.record,
    }),
  },
  methods: {
    getClosetTask() {
      var index = 0;
      var closest = new Date("2200/12/31 23:59:59");

      var time = new Date();
      for (let i in this.taskinfo) {
        if (this.taskinfo[i].completed == 0) {
          if (new Date(this.taskinfo[i].time) - time > 1000 * 60 * 15) {
            if (closest == time) {
              closest = new Date(this.taskinfo[i].time);
              index = i;
            } else if (closest - new Date(this.taskinfo[i].time) > 0) {
              closest = new Date(this.taskinfo[i].time);
              index = i;
            }
          }
        }
      }

      this.closestTask = this.taskinfo[index];
    },
    getCurrentTime() {
      this.getClosetTask();

      let diff = parseInt(
        (new Date(this.closestTask.time) - new Date()) / (1000 * 60)
      );
      if (diff == 15) {
        this.$message.info(
          "Task " + this.closestTask.name + " is going to hold in 15 minutes"
        );
        //发邮件
        this.$axios.post("https://frozen-cove-48126.herokuapp.com/user/sendEmail", {
              address: [localStorage.getItem("name")],
              subject: "remind",
              body: "Task " + this.closestTask.name + " is going to hold in 15 minutes",
              userAddress: "personalcrmofficial@gmail.com",
              userName: "PerCRM",
            })
      }
    },
    checklogin() {
      if (localStorage.getItem("Flag") == "isLogin") {
        this.getCurrentTime();
      }
    },
  },
  created() {
    this.$store.dispatch("dashboard/getAllDshboard",localStorage.getItem("userid"));
    setInterval(this.checklogin, 10000);//60000
  },
};
</script>>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}

/* #nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
} */
</style>
