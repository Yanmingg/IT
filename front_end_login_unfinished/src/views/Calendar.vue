
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
          <a-card title="Work" style="width: 1250px">
            <ul v-for="(item, index) in name_list" :key="index">
              <h6 align="right">{{ item.time }}</h6>
              <br />
              <h5 align="left">{{ item.title }}</h5>
              <br />
              <p align="left" style="font-size: 10px">{{ item.location }}</p>
              <p align="right" style="font-size: 10px">{{ item.time }}</p>

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
      name_list: [
        {
          title: "Gi Workshop",
          date: "Aug 31,2021",
          time: "13：30 PM",
          location: "At Zoom, Online",
        },
        {
          title: "Gi Workshop",
          date: "Aug 31,2021",
          time: "13：30 PM",
          location: "At Zoom, Online",
        },
        {
          title: "Gi Workshop",
          date: "Aug 31,2021",
          time: "13：30 PM",
          location: "At Zoom, Online",
        },
        {
          title: "Gi Workshop",
          date: "Aug 31,2021",
          time: "13：30 PM",
          location: "At Zoom, Online",
        },
        {
          title: "Gi Workshop",
          date: "Aug 31,2021",
          time: "13：30 PM",
          location: "At Zoom, Online",
        },
        {
          title: "Gi Workshop",
          date: "Aug 31,2021",
          time: "13：30 PM",
          location: "At Zoom, Online",
        },
      ],
    };
  },
  created() {},
  methods: {
   onPanelChange(value, mode) {
      console.log(value, mode);
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

    // today() {
    //   var date = new Date();

    //   // 获取当前月份
    //   var nowMonth = date.getMonth() + 1;

    //   // 获取当前是几号
    //   var strDate = date.getDate();

    //   // 添加分隔符“-”
    //   var seperator = "-";

    //   // 对月份进行处理，1-9月在前面添加一个“0”
    //   if (nowMonth >= 1 && nowMonth <= 9) {
    //     nowMonth = "0" + nowMonth;
    //   }

    //   // 对月份进行处理，1-9号在前面添加一个“0”
    //   if (strDate >= 0 && strDate <= 9) {
    //     strDate = "0" + strDate;
    //   }

    //   // 最后拼接字符串，得到一个格式为(yyyy-MM-dd)的日期
    //   var nowDate =
    //     date.getFullYear() + seperator + nowMonth + seperator + strDate;

    //   console.log(nowDate)
    // },
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
</style>