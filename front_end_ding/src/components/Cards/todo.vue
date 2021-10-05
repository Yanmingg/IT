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

       <a-button slot="actions" type="primary" >
							edit
							</a-button>
              <a-button slot="actions" type="primary" @click="delsId(item)">
							delete
							</a-button>
              <a-button slot="actions" type="primary" @click="editcomp(item)">
							complete
							</a-button>

      <!-- 描述 -->
      <a-list-item-meta style="text-align: left"
					:title="item.name"
					:description="item.description"
				>

      <!-- title -->




        <!-- 头像，改成选项 -->
        <!-- <a-avatar
          slot="avatar"
          src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
        /> -->

      <!-- 时间 -->
      </a-list-item-meta >
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
    delsId(item){
      this.$axios({
            url: `http://localhost:8081/task/deleteid/${item.taskid}`,
            method: 'delete',
        })
      this.$emit('deleteinlocal',item.taskid);

    },
     editcomp(item){
      this.$axios({
            url: `http://localhost:8081/task/update`,
            method: 'put',
            data: {
								name: item.name,
								taskid: item.taskid,
								time: item.time,
								completed: 1,
								description: item.description,
								userId:1,
							}
        })
      this.$emit('editlocal',item);

    },
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
