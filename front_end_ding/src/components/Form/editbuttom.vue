<template>
    <a-button slot="actions" type="primary" icon= "edit" @click="showEdit()" >
	 edit
	</a-button>
</template>
<script>
// import { defineComponent } from '@vue/composition-api'

export default ({
    data() {
        return{

        }
    },
    methods:{
        showEdit(){
            this.$emit("setvisible",true);
            this.$emit("sendtocreattask");
        },
    }
})
</script>
