<template>
  <div style="width:30%; position:relative; margin-left:30%">
    <a-alert
        banner
        v-if="visible1"
        message="you should select only 1 client"
        closable
        :after-close="handleClose1"
    >
    </a-alert>
    <a-alert
        banner
        v-if="visible2"
        message="you should select a client"
        closable
        :after-close="handleClose2"
    >
    </a-alert>
  </div>
</template>
<script>
export default {
  data() {
    return {
      visible1: false,
      visible2: false,
      msg: "",
    };
  },
  methods: {
    handleClose1() {
        this.visible1 = false;
    },
    handleClose2() {
        this.visible2 = false;
    },
    handleOpen(msg) {
        if(msg == 1){
            this.visible1 = true;
        } else if (msg == 2){
            this.visible2 = true;
        }
    }
  },
};
</script>