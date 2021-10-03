<template>
  <div>
    <FuncDiv></FuncDiv>
    <ContactList></ContactList>
  </div>
</template>
<script>
import FuncDiv from '../components/Contact/FuncDiv.vue';
import ContactList from '../components/Contact/Contactlist.vue';
export default {
  components: { 
    ContactList,
    FuncDiv,
    },
  data() {
    return {
      dataSource: [],
    };
  },
  methods: {
  },
};
</script>

<style>
</style>
