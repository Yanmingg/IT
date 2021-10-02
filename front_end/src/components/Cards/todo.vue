<template>

  <a-list
    class="demo-loadmore-list"
    item-layout="horizontal"
    :data-source="data"
  > <div slot="header"><h5>ToDo</h5></div>

    <!-- <div
      v-if="showLoadingMore"
      slot="loadMore"
      :style="{ textAlign: 'center', marginTop: '12px', height: '32px', lineHeight: '32px' }"
    >
      <a-spin v-if="loadingMore" />
      <a-button v-else @click="onLoadMore">
        loading more
      </a-button>
    </div> -->
    
    <a-list-item slot="renderItem" slot-scope="item">
      <a slot="actions">edit</a>
      <a slot="actions">delete</a>

      <!-- 描述 -->
      <a-list-item-meta style="text-align: left"
					:title="item.title"
					:description="item.code"
				>

      <!-- title -->
        <a slot="title" >111</a>



        <!-- 头像，改成选项 -->
        <!-- <a-avatar
          slot="avatar"
          src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
        /> -->

      <!-- 时间 -->
      </a-list-item-meta >
      <div>{{item.date}}    </div>
       <div>      </div>
        <div>{{item.time}}</div>
    </a-list-item>

  </a-list>
</template>
<script>
//import reqwest from 'reqwest';

//const fakeDataUrl = 'https://randomuser.me/api/?results=5&inc=name,gender,email,nat&noinfo';

export default {
  props: {
			data: {
				type: Array,
				default: () => [],
			},
		},
  data() {
    return {
      loading: true,
      loadingMore: false,
      showLoadingMore: true,

    };
  },
  // mounted() {
  //   this.getData(res => {
  //     this.loading = false;
  //     this.data = res.results;
  //   });
  // },
  methods: {
    // getData(callback) {
    //   reqwest({
    //     url: fakeDataUrl,
    //     type: 'json',
    //     method: 'get',
    //     contentType: 'application/json',
    //     success: res => {
    //       callback(res);
    //     },
    //   });
    // },
    // onLoadMore() {
    //   this.loadingMore = true;
    //   this.getData(res => {
    //     this.data = this.data.concat(res.results);
    //     this.loadingMore = false;
    //     this.$nextTick(() => {
    //       window.dispatchEvent(new Event('resize'));
    //     });
    //   });
    // },
  },
};
</script>
<style>
.demo-loadmore-list {
  min-height: 350px;
}
</style>
