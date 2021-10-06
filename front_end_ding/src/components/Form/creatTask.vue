<template>

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



				<a-form-item label="Relevant Personnel">
				<a-select
					mode="multiple"
					style="width: 100%"
					placeholder="Please select"
					@change= "handleChange"
				>
					<a-select-option v-for="(item,index) in localcontactinfo.name" :key="index">
					{{item}}
					</a-select-option>
				</a-select>

            </a-form-item>



				<a-form-item label='Description'>
				<a-input
					type='textarea'
					v-decorator="['description']"
				/>
				</a-form-item>

			</a-form>
</template>
<script>
export default ({
	
  namespaced: true,

  data(){
    return{
		localcontactinfo:{
			name:[],
			team:[],
			id:[],
		},
        form: this.$form.createForm(this, { name: 'coordinated' }),
    }
  },

  methods:{
	getcontact(info){
		// console.log(111111111)
		info.forEach((i)=>{
          this.localcontactinfo.name.push(i.name)
		  this.localcontactinfo.team.push(i.team)
		  this.localcontactinfo.id.push(i.contactid)
        })
		console.log(this.localcontactinfo)
	},
    handleChange(value) {
				console.log(`selected ${value}`);
			},
    handlesubmit(){
      this.form.validateFields((err, values) => {
				
        if (!err) {
			values.completed = 0
			values.time = values['time'].format('YYYY-MM-DD HH:mm:ss')
			this.$store.commit('dashboard/createDashboard', values)
						// this.$axios({
						// 	url: `http://localhost:8081/task/save`,//地址
						// 	method: 'post',
						// 	data: {
						// 		name: values.name,
						// 		contactid: values.contactid,
						// 		time: values['time'].format('YYYY-MM-DD HH:mm:ss'),
						// 		completed: 0,
						// 		description: values.description,
						// 		userId:1,
						// 	}
						// })
				}
			});
    	},  
    }
})
</script>
