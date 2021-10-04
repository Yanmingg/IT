<template>
  <div>
    <ContactList></ContactList>
  </div>
</template>
<script>
import ContactList from '../components/Contact/Contactlist.vue';
export default {
  components: { 
    ContactList,
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
