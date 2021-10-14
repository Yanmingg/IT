
<template>
<div class="card-profile-head">
<a-row type="flex" :gutter="100">

			<!-- Platform Settings Column -->

			<!-- span是间距，md是宽 -->
      <a-col :span="24" :md="10" class="mb-24">
				<a-calendar @panelChange="onPanelChange" />
			</a-col>

			<a-col :span="24" :md="10" class="mb-24">
        
        <a-col :span="24" :md="24" class="mb-24">
				  <a-card title="Work" style="width: 1250px">
            <ul v-for="(item,index) in name_list" :key="index">
              
              <h6 align="right">{{item.time}}</h6>
              <br>
                 <h5 align="left" > {{item.title}}</h5>
                <br>
                <p align="left" style="font-size: 10px;"> {{item.location}}</p>
                <p align="right" style="font-size: 10px;">{{item.time}}</p>

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
  data(){
    return{
      name_list:[
        {
          title:"Gi Workshop",
          date: "Aug 31,2021",
          time:"13：30 PM",
          location:"At Zoom, Online"
        },
        {
          title:"Gi Workshop",
          date: "Aug 31,2021",
          time:"13：30 PM",
          location:"At Zoom, Online"
        },
        {
          title:"Gi Workshop",
          date: "Aug 31,2021",
          time:"13：30 PM",
          location:"At Zoom, Online"
        },
        {
          title:"Gi Workshop",
          date: "Aug 31,2021",
          time:"13：30 PM",
          location:"At Zoom, Online"
        },
         {
          title:"Gi Workshop",
          date: "Aug 31,2021",
          time:"13：30 PM",
          location:"At Zoom, Online"
        },
         {
          title:"Gi Workshop",
          date: "Aug 31,2021",
          time:"13：30 PM",
          location:"At Zoom, Online"
        },
      ]

    }
  },
  methods: {
    onPanelChange(value, mode) {
      console.log(value, mode);
    },
  },
};
</script>
<style scoped>

p{display: inline-block;}
</style>