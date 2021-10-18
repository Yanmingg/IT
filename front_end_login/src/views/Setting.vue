<template>
  <div>
    <GuideLine></GuideLine>
  </div>
</template>
<script>
import GuideLine from '../components/Setting/GuideLine.vue';
export default {
  components: { GuideLine },
  data() {
    return {
      collapsed: false,
    };
  },
};
</script>

<style>
</style>
