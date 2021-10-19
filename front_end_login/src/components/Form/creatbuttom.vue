<template>
    <a-button type="primary" @click="showModal" icon="plus-circle" fill = "">
		Create
	</a-button>
</template>
<script>

export default ({
    data() {
        return{

        }
    },
    methods:{
        showModal() {
		//在store里调用getAllContact函数  dispatch是调用acction的
            this.$emit("setvisible",true);
            this.$emit("sendtocreattask");
		},
    }
})
</script>
