
<template>
  <div class="card-profile-head">
    <a-row type="flex" :gutter="100">
      <!-- Platform Settings Column -->

      <!-- span是间距，md是宽 -->
      <a-col :span="24" :md="10" class="mb-24">
        <a-calendar @select="onSelect" @panelChange="onPanelChange" />
      </a-col>

      <a-col :span="24" :md="10" class="mb-24">
        <a-col :span="24" :md="24" class="mb-24">
          <a-alert :message="`You selected date: ${selectedValue}`" />
          <a-card style="width: 1250px; hight: 1500px">
            <ul v-for="(item, index) in name_list" :key="index">
              <h6
                align="right"
                style="
                  position: relative;
                  top: 50px;
                  left: -50px;
                  font-size: 25px;
                "
              >
                {{ item.time }}
              </h6>
              <h6 align="left" style="position: relative; top: 10px; left: 0px;font-size: 25px">
                {{ item.name }}
              </h6>
              <p align="left" style="font-size: 25px">{{ item.description }}</p>
              <a-divider></a-divider>
            </ul>
          </a-card>
        </a-col>
      </a-col>
    </a-row>
  </div>
</template>


<script>
export default {
  data() {
    return {
      selectedValue: "",
      name_list: [],
    };
  },
  created() {
    this.today();
    this.getdata();
  },
  methods: {
    onPanelChange(value, mode) {
      console.log(value, mode);
    },
    onSelect(value) {
      this.selectedValue = value.format("YYYY-MM-DD");
      this.getdata();
    },
    compare(property) {
      return function (a, b) {
        var value1 = a[property].substring(1, 3);
        var value2 = b[property].substring(1, 3);
        if (value1 == value2) {
          var value3 = a[property].substring(4, 6);
          var value4 = b[property].substring(4, 6);
          console.log(value3)
          return value3 - value4;
        } else {
          return value1 - value2;
        }
      };
    },
    getdata() {
      let userid = localStorage.getItem("userid")
      this.$axios(`https://frozen-cove-48126.herokuapp.com/task/finduser/${userid}`).then((res) => {
        this.name_list = res.data;
        console.log(this.name_list[1]);

        for (let index = 0; index < this.name_list.length; index++) {
          const element = this.name_list[index];
          if (element.time.substring(0, 10) == this.selectedValue) {
            this.name_list[index].time = element.time.substring(10, 16);
          }
          //不等于
          else {
            //从xx中删除
            this.name_list.splice(index, 1);
            index--;
          }
        }
        console.log(this.name_list);
        this.name_list.sort(this.compare("time"));

        //   this.name_list.forEach((i) => {

        //     //如果等于选中天
        //     if(i.time.substring(0,10) == this.selectedValue){
        //       this.name_list[n].time = i.time.substring(10,16);
        //     }
        //     //不等于
        //     else{
        //       //从xx中删除
        //       this.name_list.splice(n,1)
        //       n--;
        //     }

        //     //console.log(this.selectedValue)

        //     //console.log(i.time.substring(0,10))
        //     n++
        // });
        //console.log(this.name_list)
      });
    },
    // getListData(value) {
    //   //for一遍这个月的task的数据
    //     //if 这个数据在value中
    //       // switch (value.date()) {
    //       //   case 8:
    //       //     listData = [
    //       //       { type: "warning", content: "This is warning event." },
    //       //       { type: "success", content: "This is usual event." },
    //       //     ];
    //       //     break;
    //       // }
    //   //只显示这个月的日程
    //   //让done和todo 对标type
    //   //title 对标 content
    //   //console.log(value);
    //   //console.log(value.month());
    //   let listData;
    //   switch (value.date()) {
    //     case 8:
    //       listData = [
    //         { type: "warning", content: "This is warning event." },
    //         { type: "success", content: "This is usual event." },
    //       ];
    //       break;
    //     case 10:
    //       listData = [
    //         { type: "warning", content: "This is warning event." },
    //         { type: "success", content: "This is usual event." },
    //         { type: "error", content: "This is error event." },
    //       ];
    //       break;
    //     case 15:
    //       listData = [
    //         { type: "warning", content: "This is warning event" },
    //         {
    //           type: "success",
    //           content: "This is very long usual event。。....",
    //         },
    //         { type: "error", content: "This is error event 1." },
    //         { type: "error", content: "This is error event 2." },
    //         { type: "error", content: "This is error event 3." },
    //         { type: "error", content: "This is error event 4." },
    //       ];
    //       break;
    //     default:
    //   }
    //   return listData || [];
    // },

    today() {
      var date = new Date();

      // 获取当前月份
      var nowMonth = date.getMonth() + 1;

      // 获取当前是几号
      var strDate = date.getDate();

      // 添加分隔符“-”
      var seperator = "-";

      // 对月份进行处理，1-9月在前面添加一个“0”
      if (nowMonth >= 1 && nowMonth <= 9) {
        nowMonth = "0" + nowMonth;
      }

      // 对月份进行处理，1-9号在前面添加一个“0”
      if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
      }

      // 最后拼接字符串，得到一个格式为(yyyy-MM-dd)的日期
      var nowDate =
        date.getFullYear() + seperator + nowMonth + seperator + strDate;
      this.selectedValue = nowDate;
      console.log(nowDate);
    },
  },
};
</script>
<style scoped>
.events {
  list-style: none;
  margin: 0;
  padding: 0;
}
.events .ant-badge-status {
  overflow: hidden;
  white-space: nowrap;
  width: 100%;
  text-overflow: ellipsis;
  font-size: 12px;
}
.notes-month {
  text-align: center;
  font-size: 28px;
}
.notes-month section {
  font-size: 28px;
}
.ant-card-body ul {
  height: 150px;
}
</style>