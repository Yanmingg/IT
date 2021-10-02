<template>
  <div class="global-search-wrapper" style="width: 100%;">
    <a-space>
      <a-auto-complete
        class="global-search"
        size="large"
        style="width: 100%"
        placeholder="input here"
        option-label-prop="title"
        @select="onSelect"
        @search="handleSearch"
      >
        <template slot="dataSource">
          <a-select-option v-for="item in dataSource" :key="item.category" :title="item.category">
            Found {{ item.query }} on
            <a
              :href="`https://s.taobao.com/search?q=${item.query}`"
              target="_blank"
              rel="noopener noreferrer"
            >
              {{ item.category }}
            </a>
            <span className="global-search-item-count">{{ item.count }} results</span>
          </a-select-option>
        </template>
        <a-input>
          <a-button
            slot="suffix"
            style="margin-right: -12px"
            class="search-btn"
            size="large"
            type="link"
          >
            <a-icon type="search" />
          </a-button>
        </a-input>
      </a-auto-complete>
      <a-dropdown :trigger="['click']" style="margin-left: 1000px">
        <a class="ant-dropdown-link" @click="e => e.preventDefault()">
          <a-icon type="appstore" theme="filled" style="fontSize:32px"/>
        </a>
        <a-menu slot="overlay">
          <a-menu-item key="0" @click="() => setModal1Visible(true)">
            <a>Create Client</a>
          </a-menu-item>
          <a-menu-item key="2">
            <a href="http://www.taobao.com/">Delete Client</a>
          </a-menu-item>
          <a-menu-divider />
          <a-menu-item key="3">
            <a href="http://www.taobao.com/">Import Client</a>
          </a-menu-item>
          <a-menu-item key="4">
            <a href="http://www.taobao.com/">Export Client</a>
          </a-menu-item>
          <a-menu-divider />
          <a-menu-item key="5">
            <a href="http://www.taobao.com/">Create Task</a>
          </a-menu-item>
          <a-menu-item key="6">
            <a href="http://www.taobao.com/">Add in Task</a>
          </a-menu-item>
          <a-menu-divider />  
          <a-menu-item key="7">
            <a href="http://www.taobao.com/">Send Email</a>
          </a-menu-item>
        </a-menu>
      </a-dropdown>
    </a-space>
    <a-modal
      title="Create Client"
      :dialog-style="{ top: '20px' }"
      :visible="modal1Visible"
      centered
      @ok="() => setModal1Visible(false)"
      @cancel="() => setModal1Visible(false)"
    >
    <div style="overflow-y:auto">
      <InputForm></InputForm>
    </div>
      
    </a-modal>
  </div>
</template>
<script>
import InputForm from './InputForm.vue';
export default {
  components: { InputForm },
  data() {
    return {
      dataSource: [],
      modal1Visible: false,
    };
  },
  methods: {
    setModal1Visible(modal1Visible) {
      this.modal1Visible = modal1Visible;
    },
    onSelect(value) {
      console.log('onSelect', value);
    },

    handleSearch(value) {
      this.dataSource = value ? this.searchResult(value) : [];
    },

    handleChange(value) {
      console.log(`selected ${value}`);
    },

    getRandomInt(max, min = 0) {
      return Math.floor(Math.random() * (max - min + 1)) + min;
    },

    searchResult(query) {
      return new Array(this.getRandomInt(5))
        .join('.')
        .split('.')
        .map((item, idx) => ({
          query,
          category: `${query}${idx}`,
          count: this.getRandomInt(200, 100),
        }));
    },
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
</style>
