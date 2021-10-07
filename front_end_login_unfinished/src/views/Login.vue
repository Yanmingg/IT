<template>
<div>
<div>
    <!-- client list -->
    <span>{{ContactTest}}</span>
    <span>111111111111</span>
    <div>
    <a-button @click="delsId">删除</a-button>
    <a-button @click="postdata">测试Post</a-button>

    <a-table
      :columns="columns"
      :data-source="data"
      :row-selection="{
        selectedRowKeys: selectedRowKeys,
        onChange: onSelectChange,
      }"
      rowKey="contactid"
    >

    </a-table>

  </div>


    <!-- form -->
<a-form-model
    ref="ruleForm"
    :model="form"
    :rules="rules"
    :label-col="labelCol"
    :wrapper-col="wrapperCol"
  >
    <a-form-model-item ref="name" label="Activity name" prop="name">
      <a-input
        v-model="form.name"
        @blur="
          () => {
            $refs.name.onFieldBlur();
          }
        "
      />
    </a-form-model-item>
    
    <a-form-model-item ref="email" label="Activity email" prop="email">
      <a-input
        v-model="form.email"
        @blur="
          () => {
            $refs.email.onFieldBlur();
          }
        "
      />
    </a-form-model-item>
    <a-form-model-item ref="team" label="Activity team" prop="team">
      <a-input
        v-model="form.team"
        @blur="
          () => {
            $refs.team.onFieldBlur();
          }
        "
      />
    </a-form-model-item>
    <a-form-model-item ref="status" label="Activity status" prop="status">
      <a-input
        v-model="form.status"
        @blur="
          () => {
            $refs.status.onFieldBlur();
          }
        "
      />
    </a-form-model-item>
     <a-form-model-item ref="phone" label="Activity phone" prop="phone">
      <a-input
        v-model="form.phone"
        @blur="
          () => {
            $refs.phone.onFieldBlur();
          }
        "
      />
    </a-form-model-item>
    <a-form-model-item ref="description" label="Activity description" prop="description">
      <a-input
        v-model="form.description"
        @blur="
          () => {
            $refs.description.onFieldBlur();
          }
        "
      />
    </a-form-model-item>
    <a-form-model-item :wrapper-col="{ span: 14, offset: 4 }">
      <a-button type="primary" @click="onSubmit">
        Create
      </a-button>
      <a-button style="margin-left: 10px;" @click="resetForm">
        Reset
      </a-button>
    </a-form-model-item>
  </a-form-model>

</div>


</div>
</template>
<script>

import infiniteScroll from 'vue-infinite-scroll';

const data = [];

export default {
  directives: { infiniteScroll },
  name:"ContactTest",
  data() {
    return {

      ContactTest:'',
       columns : [
      {
        title: 'Name',
        dataIndex: 'name',
        
      },
      {
        title: 'Email',
        dataIndex: 'email',
      },
      {
        title: 'Phone',
        dataIndex: 'phone',

      },
      {
        title: 'Team',
        dataIndex: 'team',
      },
     ],

      data,
      selectedRowKeys: [],


      labelCol: { span: 4 },
      wrapperCol: { span: 14 },
      other: '',
      form: {
        name: '',
        email: '',
        phone:'',
        team:'',
        status:'',
        description:'',
        userId:1,
      },

      rules: {
        name: [
          { required: true, message: 'Please input Activity name', trigger: 'blur' },
          { min: 3, max: 5, message: 'Length should be 3 to 5', trigger: 'blur' },
        ],
        region: [{ required: true, message: 'Please select Activity zone', trigger: 'change' }],
        date1: [{ required: true, message: 'Please pick a date', trigger: 'change' }],
        type: [
          {
            type: 'array',
            required: true,
            message: 'Please select at least one activity type',
            trigger: 'change',
          },
        ],
        resource: [
          { required: true, message: 'Please select activity resource', trigger: 'change' },
        ],
        desc: [{ required: true, message: 'Please input activity form', trigger: 'blur' }],
      },
    };
  },
    created() {

    this.getContact()
    this.testMethod()
  },
  
  methods: {
    postdata(){
      this.$axios.post('http://localhost:8081/customer/register',{
        username:'jack'
      }).then(res=>{
        console.log(res.data)
      })
    },
    testMethod(){
      this.$axios.get("http://localhost:8081/contact/findAll").then(
        response=>(
          this.ContactTest=response.data
        )
      )
    },
    delsId(){
      let arr1 = this.selectedRowKeys.sort(); 
      let all=0;
      let data_index=0;
      let indexdata = this.data
      arr1.forEach((i) => {

        //找index
        indexdata.forEach((d)=>{
          if(d.contactid === i){
            data_index=all;
          }
          all++;
        })
        //前端实时删除
        this.data.splice(data_index, 1)

        // /后端delete删除
        this.$axios({
            url: `http://localhost:8081/contact/deleteid/${i}`,
            method: 'delete',
        })
      })
      this.selectedRowKeys = [];
    },
    onSelectChange(selectedRowKeys) {
      this.selectedRowKeys = selectedRowKeys; 
    },

    // // 单个删除
    // del(name) {
    //   const dataSource = [...this.data];
    //   this.data = dataSource.filter((item) => item.name !== name);
    // },

    // deleteClient(id) {
    //     this.$axios({
    //       url: `http://localhost:8081/contact/${id}`,
    //       method: 'delete',
    //     }).then(res => {
    //       console.log(id);
    //       this.getContact()
    //     })
    // },
    // 批量删除
    

     getContact() { //分页查询所有试卷信息
      this.$axios(`http://localhost:8081/contact/findAll`).then(res => {
        this.data = res.data
      })
    },
    //点submit后
    onSubmit() {
      this.$refs.loginForm.validate(valid => {
    if (valid) {
      axios.post('/login', {
        user: this.loginForm.user,
        pass: this.loginForm.pass
      })
        .then((response) => {
          if (response.status === 200) {
            this.$store.commit('SET_TOKEN', response.data.token)
            this.$store.commit('GET_USER', response.data.user)
            this.$message({
              message: '登陆成功',
              type: 'success'
            })
            this.$router.push({name: 'activity'})
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    } else {
      console.log('error submit!!')
      return false
    }
  })
},
    resetForm() {
      this.$refs.ruleForm.resetFields();
    },
    onChange(e,title) {
      console.log(`checked = ${e.target.checked}`);
      console.log(title);
    },

  },
};
</script>
<style>
.demo-infinite-container {
  border: 1px solid #e8e8e8;
  border-radius: 4px;
  overflow: auto;
  padding: 8px 24px;
  height: 300px;
}
.demo-loading-container {
  position: absolute;
  bottom: 40px;
  width: 100%;
  text-align: center;
}
</style>

