<!-- 
	This is the user profile page, it uses the dashboard layout in: 
	"./layouts/Dashboard.vue" .
 -->

<template>
	<div>
        <!-- <p>测试vuex</p>
        {{count}}
        <br>
        {{$store.getters.doubleCount}}
         <a-button type="primary" :size="size" @click="$store.commit('increment',2)">mutations++</a-button>
          <a-button type="primary" :size="size" @click="$store.dispatch('increment')">actions++延时</a-button> -->
		<!-- Header Background Image -->

		<!-- / Header Background Image -->

		<!-- User Profile Card -->
		<a-card :bordered="false" class="card-profile-head" :bodyStyle="{padding: 0,}">
			<template #title>
				<a-row type="flex" align="middle">
					
					<a-col :span="24" :md="12" class="col-info">
						<div class="avatar-info">
							<h4 class="font-semibold m-0">Welcome Back, Ling! </h4>
							<span><p>you have 5 tasks to complete</p></span>

						</div>
					</a-col>
					
					<a-col :span="24" :md="12" style="display: flex; align-items: center; justify-content: flex-end">
						 <a-radio-group :value="size" @change="handleSizeChange"> 
							 <a-button type="primary" @click="showModal">Create</a-button>
								<a-modal
									ref="collectionForm"
									:visible="visible"
									@cancel="handleCancel"
									@create="handleCreate"
									>
									    <CreatTaskForm
											:data="conversationsData"
										></CreatTaskForm>
								</a-modal>
						</a-radio-group>
					</a-col>

				</a-row>
			</template>
		</a-card>

		<!-- User Profile Card -->

		<a-row type="flex" :gutter="24">
			<!-- Platform Settings Column -->
			<!-- span是间距，md是宽 -->
			<a-col :span="24" :md="100" class="mb-24">
				<!-- Platform Settings Card -->

                <CardConversations
					:data="conversationsData"
				></CardConversations>
				<!-- <CardPlatformSettings></CardPlatformSettings> -->


				<!-- / Platform Settings Card -->

			</a-col>

			<!-- / Platform Settings Column -->

			<!-- Conversations Column -->
			<a-col :span="24" :md="100" class="mb-24">
				<!-- Conversations Card -->

				<a-card >
				<Cardtodo
					:data="tododata"
				></Cardtodo>
  				</a-card>
				


				<!-- / Conversations Card -->
			</a-col>
			<!-- / Conversations Column -->
		</a-row>
		

		<!-- / Projects Card -->

	</div>
</template>

<script>
    import Cardtodo from '../components/Cards/todo.vue';
    import CardConversations from '../components/Cards/CardConversations.vue';
	import CreatTaskForm from '../components/Form/creatTask.vue';
	// Conversation's list data.
	const conversationsData = [
		{
			id: "1",
			title: "Meeting",
			code: "with it project group",
            time:"19:00",
            date:"seq 18",
			//avatar: "images/face-3.jpg",
		},
		{
			id: "2",
			title: "Meeting",
			code: "with it project group",
            time:"19:00",
            date:"seq 18",
			//avatar: "images/face-4.jpg",
		},
		{
			id: "3",
			title: "Meeting",
			code: "with it project group",
            time:"19:00",
            date:"seq 18",
			//avatar: "images/face-5.jpeg",
		},
		{
			id: "4",
			title: "Meeting",
			code: "with it project group",
            time:"19:00",
            date:"seq 18",
			//avatar: "images/face-6.jpeg",
		},
		{
			id: "5",
			title: "Meeting",
			code: "with it project group",
            time:"19:00",
            date:"seq 18",
			//avatar: "images/face-2.jpg",
		},
	] ;
	const tododata = [
		{
			id: "1",
			title: "Meeting",
			code: "with it project group",
            time:"19:00",
            date:"seq 18",
			description: "asdsadsadsadsad",
			content:"sadasdsa",
			//avatar: "images/face-3.jpg",
		},
		{
			id: "2",
			title: "Meeting",
			code: "with it project group",
            time:"19:00",
            date:"seq 18",
			description: "asdsadsadsadsad",
			content:"sadasdsa",
			//avatar: "images/face-4.jpg",
		},
	] ;

	// Project cards data

	export default ({
		 beforeCreate() {
            //创建表单
            this.form = this.$form.createForm(this, { name: 'form_in_modal' });
        },
		components: {
            //CardPlatformSettings,
            CardConversations,
			Cardtodo,
			CreatTaskForm,
		},
        computed:{
            count(){
                return this.$store.state.count
            }
        },
		data() {
			return {
				// Active button for the "User Profile" card's radio button group.
				profileHeaderBtns: 'overview',

				// Associating Conversation's list data with its corresponding property.
				conversationsData,
				tododata,
				CreatTaskForm,
				// Project cards data
				size: 'large',

				visible: false,
                //模态对话框标题
                modelTitle: '模态框标题',
			}
		},
		methods: {
      		handleSizeChange(e) {
        		this.size = e.target.value;
      		},
			  showModal() {
      this.visible = true;
    },
    handleCancel() {
      this.visible = false;
    },
    handleCreate() {
      const form = this.$refs.collectionForm.form;
      form.validateFields((err, values) => {
        if (err) {
          return;
        }
        console.log('Received values of form: ', values);
        form.resetFields();
        this.visible = false;
      });
    },
    	},

	})

</script>

<style lang="scss">
</style>