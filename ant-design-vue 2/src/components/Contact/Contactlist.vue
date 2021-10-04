<template>
    <div class="global-search-wrapper" style="width: 100%;">
      <FuncDiv 
        ref="FuncDiv" 
        v-on="{
          createclient:createclient,
          deleteclient:deleteclient,
          editclient:editclient,
          checkvalidselection:checkvalidselection,
          }">
      </FuncDiv>
      <a-table
        :columns="columns"
        :data-source="info"
        :pagination="pagination"
        :row-selection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }"
        rowKey = "id"
        @change="handleChange"
      >
        <template slot="name" slot-scope="name"> {{ name.first }} {{ name.last }} </template>
      </a-table>
  </div>
</template>
<script>
const columns = [
  {
    title: 'Name',
    dataIndex: 'name',
    width: '20%',
  },
  {
    title: 'Organization',
    dataIndex: 'organization',
    width: '20%',
  },
  {
    title: 'Email',
    dataIndex: 'email',
    width: '30%'
  },
  {
    title: 'Mobile',
    dataIndex: 'mobile',
    width: '20%'
  },
  {
    title: 'Status',
    dataIndex: 'status',
    filters: [
      {
        text: "Star",
        value: "Star",
      },
      {
        text: "emergency",
        value: "emergency",
      },
      {
        text: "general",
        value: "general",
      },
    ],
    onFilter: (value, record) => record.status.indexOf(value) === 0,
    width: '10%'
  },
];


import {mapState} from 'vuex';
import FuncDiv from './FuncDiv.vue';
export default {
  namespaced: true,
  components:{FuncDiv},
  data() {
    return {
      pagination: {},
      loading: false,
      columns,
      selectedRowKeys:[],
      formLayout: 'horizontal',
      form: this.$form.createForm(this, { name: 'coordinated' }),
    };
  },
  computed: {
    ...mapState({
      info: state => state.contact.record,
    }),
    nextId() {
      return this.$store.state.contact.record[this.$store.state.contact.record.length-1]["id"] + 1;
    }
  },
  methods: {
    handleChange(pagination, filters, sorter) {
      console.log('Various parameters', pagination, filters, sorter);
      this.filteredInfo = filters;
      this.sortedInfo = sorter;
    },
    onSelectChange(selectedRowKeys) {
      console.log('selectedRowKeys changed: ', selectedRowKeys);
      this.selectedRowKeys = selectedRowKeys;
    },
    createclient(record){
      record["id"] = this.nextId;
      this.$store.commit('contact/createContact', record);
    },
    deleteclient(){
      for(let key in this.selectedRowKeys){
        this.$store.commit('contact/deleteContact', this.selectedRowKeys[key]);
      }
      this.selectedRowKeys = []
    },
    editclient(record,id){
      this.$store.commit('contact/deleteContact',id)
      record["id"] = this.nextId;
      this.$store.commit('contact/createContact', record);
      this.selectedRowKeys = []
    },
    checkvalidselection(){
      if(this.selectedRowKeys.length > 1){
        this.$refs.FuncDiv.showAlert(1)
      } else if(this.selectedRowKeys.length < 1){
        this.$refs.FuncDiv.showAlert(2)
      } else{
        for(let i in this.info){
          if(this.info[i]["id"] == this.selectedRowKeys[0]){
            this.$refs.FuncDiv.postContact(this.info[i]);
          }
        }
      }
    }
  },
  created (){
    this.$store.dispatch('contact/getAllContact')
  },
};
</script>
<style>

.global-search-wrapper {
  margin-left: 0%;
  margin-top: 1%;
  margin-bottom: 1%;
}
.global-search {
  width: 100%;
}

.global-search.ant-select-auto-complete .ant-select-selection--single {
  margin-right: -46px;
}

.global-search.ant-select-auto-complete .ant-input-affix-wrapper .ant-input:not(:last-child) {
  padding-right: 62px;
}

.global-search.ant-select-auto-complete .ant-input-affix-wrapper .ant-input-suffix button {
  border-top-left-radius: 0;
  border-bottom-left-radius: 0;
}

.global-search-item {
  display: flex;
}

.global-search-item-desc {
  flex: auto;
  text-overflow: ellipsis;
  overflow: hidden;
}

.global-search-item-count {
  flex: none;
}
.count{
  margin-left: inherit;
}
</style>
