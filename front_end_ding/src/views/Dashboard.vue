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
							<div>
							 <a-button type="primary" @click="showModal">
							Create
							</a-button>
							<collection-create-form
							ref="collectionForm"
							:visible="visible"
							@cancel="handleCancel"
							@create="handleCreate"
							/>
						</div>
								
						</a-radio-group>
					</a-col>

				</a-row>
			</template>
		</a-card>

		<!-- User Profile Card -->

		<a-row type="flex" :gutter="24">
			<!-- Platform Settings Column -->
			<!-- span是间距，md是宽 -->
			

			<!-- / Platform Settings Column -->

			<!-- Conversations Column -->
			<a-col :span="24" :md="100" class="mb-24">
				<!-- Conversations Card -->

				<a-card >
				<Cardtodo
					:data="tododata"
					v-on={deleteinlocal:deleteinlocal}
				></Cardtodo>
  				</a-card>
				


				<!-- / Conversations Card -->
			</a-col>

			<a-col :span="24" :md="100" class="mb-24">
				<!-- Platform Settings Card -->
				<a-card >
                <CardConversations
					:data="donedata"
				></CardConversations>
				<!-- <CardPlatformSettings></CardPlatformSettings> -->
				</a-card>

				<!-- / Platform Settings Card -->

			</a-col>
			<!-- / Conversations Column -->
		</a-row>
		

		<!-- / Projects Card -->

	</div>
</template>

<script>
    import Cardtodo from '../components/Cards/todo.vue';
    import CardConversations from '../components/Cards/CardConversations.vue';
	//import CreatTaskForm from '../components/Form/creatTask.vue';
	// Conversation's list data.
	const CollectionCreateForm = {
		props: ['visible'],
		beforeCreate() {
			this.form = this.$form.createForm(this, { name: 'form_in_modal' });
		},
		template: `
			<a-modal
			:visible="visible"
			title='Create a new Task'
			okText='Create'
			@cancel="() => { $emit('cancel') }"
			@ok="() => { $emit('create') }"
			>
			<a-form layout='vertical' :form="form">
				<a-form-item label='Nmae'>
				<a-input
					v-decorator="[
					'name',
					{
						rules: [{ required: true, message: 'Please input the name of task!' }],
					}
					]"
				/>
				</a-form-item>


				<a-form-item label="Due Date">
					<a-date-picker
						v-decorator="['time', {rules: [{ required: true, message: 'Please select time!' }],}]"
						show-time
						format="YYYY-MM-DD HH:mm:ss"
					/>
    			</a-form-item>

				<a-form-item label='Relevant Personnel'>
				<a-input
					v-decorator="[
					'contactid'
					]"
				/>
				</a-form-item>

				<a-form-item label='Description'>
				<a-input
					type='textarea'
					v-decorator="['description']"
				/>
				</a-form-item>


				

			</a-form>
			</a-modal>
		`,
	};

	const donedata = [
		
	] ;
	const tododata = [
	] ;
	const mydata = [
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
			//CreatTaskForm,
			CollectionCreateForm
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
				donedata,
				tododata,
				mydata,
				//CreatTaskForm,
				// Project cards data
				size: 'large',

				visible: false,
                //模态对话框标题
                modelTitle: '模态框标题',
			}
		},
		created() {
			this.getTask()
		},
		methods: {
      		handleSizeChange(e) {
        		this.size = e.target.value;
      		},
			getTask() { 
				this.$axios(`http://localhost:8081/task/findAll`).then(res => {
					this.mydata = res.data
					this.mydata.forEach((i) => {
						if (i.completed === false){
							if (!(i.taskid in tododata)) { tododata.push(i)}
							
						}
						else{
							donedata.push(i)
						}
					})
				})
   			},
			deleteinlocal(id){
				let all=0;
      			let data_index=0;
      			let indexdata = this.tododata
				indexdata.forEach((d)=>{
					if(d.taskid === id){
						data_index=all;
					}
					all++;
        		})
        		//前端实时删除
        		this.tododata.splice(data_index, 1)
			},
			showModal() {
      			this.visible = true;
    		},
			handleCancel() {
				this.visible = false;
			},
    		handleCreate() {
				const form = this.$refs.collectionForm.form;
				console.log(form)
				form.validateFields((err, values) => {
					if (!err) {
						let d = {
								name: values.name,
								contactid: values.contactid,
								time: values['time'].format('YYYY-MM-DD HH:mm:ss'),
								completed: 0,
								description: values.description,
								userId:1,
							}
						tododata.push(d)
						this.$axios({
							url: `http://localhost:8081/task/save`,//地址
							method: 'post',
							data: {
								name: values.name,
								contactid: values.contactid,
								time: values['time'].format('YYYY-MM-DD HH:mm:ss'),
								completed: 0,
								description: values.description,
								userId:1,
							}
						})
					}
					form.resetFields();
					this.visible = false;
				});
    		},  
			// handleSubmit(e) {
			// e.preventDefault();
			// this.form.validateFields((err, fieldsValue) => {
			// 	if (err) {
			// 	return;
			// 	}

			// 	// Should format date value before submit.
			// 	const values = {
			// 	...fieldsValue,
			// 	'date-time-picker': fieldsValue['date-time-picker'].format('YYYY-MM-DD HH:mm:ss'),
			// 	};
			// 	console.log('Received values of form: ', values);
			// });
			// },
    	},
	})

</script>

<style lang="scss">
</style>