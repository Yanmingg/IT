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
		taskid:0,
		completed:0,
		userId:1,
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
    getolddata(item){
		let date =new Date(item.time)
		console.log(date)
		this.form.setFieldsValue({
          	name: item.name,
			contactid:item.contactid,
          	description: item.description,
        });
		this.taskid=item.taskid;
		this.completed=item.completed;
		this.userId=item.userId;
    },
    handleChange(value) {
		console.log(`selected ${value}`);
	},
    handlesubmit(){
		console.log(222222222222222)
		setTimeout(()=>{
			this.form.validateFields((err, values) => {	
        	if (!err) {
				this.$emit('setvisible',false);
				values.taskid = this.taskid
				values.completed = this.completed
				values.userId = this.userId
				values.time = values['time'].format('YYYY-MM-DD HH:mm:ss')
				console.log(values)
				this.$store.commit('dashboard/editDashboard', values,localStorage.getItem("userid"))

			}

		});
        },10)

    },  

}
})
</script>
