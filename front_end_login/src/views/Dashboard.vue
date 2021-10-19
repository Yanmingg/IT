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

    <a-button type="primary" @click="check">logout</a-button>
    <a-card
      :bordered="false"
      class="card-profile-head"
      :bodyStyle="{ padding: 0 }"
    >
      <template #title>
        <a-row type="flex" align="middle">
          <a-col :span="24" :md="12" class="col-info">
            <div class="avatar-info">
              <h4 class="font-semibold m-0">Welcome Back, {{ user.name }}</h4>
              <span><p>you have {{ user.num }} tasks to complete</p></span>
            </div>
          </a-col>

          <a-col
            :span="24"
            :md="12"
            style="
              display: flex;
              align-items: center;
              justify-content: flex-end;
            "
          >
            <a-radio-group :value="size" @change="handleSizeChange">
              <div>
                <Creatbuttom
                  ref="erzi"
                  v-on="{
                    setvisible: setvisible,
                    sendtocreattask: sendtocreattask,
                  }"
                ></Creatbuttom>
                <a-modal
                  :visible="visible"
                  @cancel="handleCancel"
                  @ok="handleCreate"
                >
                  <CreatTask
                    ref="collectionForm"
                    v-on="{
                      handleCancel: handleCancel,
                      handleCreate: handleCreate,
                      setvisible: setvisible,
                    }"
                  ></CreatTask>
                </a-modal>
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

        <a-card>
          <Cardtodo
            :data="tododata"
            v-on="{ deleteinlocal: deleteinlocal, editlocal: editlocal }"
          ></Cardtodo>
        </a-card>

        <!-- / Conversations Card -->
      </a-col>

      <a-col :span="24" :md="100" class="mb-24">
        <!-- Platform Settings Card -->
        <a-card>
          <CardConversations :data="donedata"></CardConversations>
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
import Cardtodo from "../components/Cards/todo.vue";
import CardConversations from "../components/Cards/CardConversations.vue";
import CreatTask from "../components/Form/creatTask.vue";
import Creatbuttom from "../components/Form/creatbuttom.vue";
import { mapState } from "vuex";
// const donedata = [

// ] ;
// const tododata = [
// ] ;
// const mydata = [
// ] ;

// Project cards data

export default {
  beforeCreate() {
    //创建表单
    this.form = this.$form.createForm(this, { name: "form_in_modal" });
  },
  components: {
    //CardPlatformSettings,
    CardConversations,
    Cardtodo,
    //CreatTaskForm,
    CreatTask,
    Creatbuttom,
  },
  data() {
    return {
      // Active button for the "User Profile" card's radio button group.
      profileHeaderBtns: "overview",

      // Associating Conversation's list data with its corresponding property.
      // donedata,
      // tododata,
      // mydata,
      //CreatTaskForm,
      // Project cards data
      user: {
        name: localStorage.getItem("name"),
        num:0,
      },
      size: "large",
      visible: false,
      //模态对话框标题
      modelTitle: "模态框标题",
    };
  },
  created() {

    this.$store.dispatch("dashboard/getAllDshboard",localStorage.getItem("userid"));
    this.$store.dispatch("contact/getAllContact",localStorage.getItem("userid")); //在store里调用getAllContact函数  dispatch是调用acction的
  },
  computed: {
    ...mapState({
      info: (state) => state.contact.record,
      taskinfo: (state) => state.dashboard.record,
    }),
    tododata() {
      let tdata = [];
      this.$store.state.dashboard.record.forEach((i) => {
        if (i.completed == 0) {
          tdata.push(i);
          
        }
        this.user.num = tdata.length;
      });
      return tdata;
    },
    donedata() {
      let ddata = [];
      this.$store.state.dashboard.record.forEach((i) => {
        if (i.completed == 1) {
          ddata.push(i);
        }
      });
      return ddata;
    },

    showRecord() {
      return this.$store.getters.showRecord;
    },
  },
  methods: {
    check() {
      localStorage.setItem("Flag",null);
      localStorage.setItem("userid",null);
    },
    // creatuser() {
    //   console.log(localStorage.getItem("userid"))
    // },
    handleSizeChange(e) {
      this.size = e.target.value;
    },
    // getTask() {
    // 	this.$axios(`http://localhost:8081/task/findAll`).then(res => {
    // 		this.mydata = res.data
    // 		this.mydata.forEach((i) => {
    // 			if (i.completed === false){
    // 				if (!(i.taskid in tododata)) { tododata.push(i)}

    // 			}
    // 			else{
    // 				donedata.push(i)
    // 			}
    // 		})
    // 	})
    // },
    deleteinlocal(id) {
      let all = 0;
      let data_index = 0;
      let indexdata = this.tododata;
      indexdata.forEach((d) => {
        if (d.taskid === id) {
          data_index = all;
        }
        all++;
      });
      //前端实时删除
      this.tododata.splice(data_index, 1);
    },
    editlocal(item) {
      let d = {
        name: item.name,
        taskid: item.taskid,
        time: item.time,
        completed: 1,
        description: item.description,
        userId: 1,
      };
      donedata.push(d);
      let all = 0;
      let data_index = 0;
      let indexdata = this.tododata;
      indexdata.forEach((d) => {
        if (d.taskid === item.taskid) {
          data_index = all;
        }
        all++;
      });
      //前端实时删除
      this.tododata.splice(data_index, 1);
      //deleteinlocal(item.taskid)
    },
    // showModal() {
    // 	//在store里调用getAllContact函数  dispatch是调用acction的
    // 	setTimeout(()=>{
    //     this.visible = true;
    // 	console.log(this.$refs.collectionForm)
    // 	this.$refs.collectionForm.getcontact(this.info)
    // 	},10)

    // 	//console.log(this.info)
    // },
    handleCancel() {
      this.visible = false;
    },
    handleCreate() {
      this.$refs.collectionForm.handlesubmit();
    },
    setvisible(op) {
      this.visible = op;
    },
    sendtocreattask() {
      setTimeout(() => {
        this.$refs.collectionForm.getcontact(this.info);
      }, 10);
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
};
</script>

<style lang="scss">
</style>