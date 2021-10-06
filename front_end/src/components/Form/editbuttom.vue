<template>
    <a-button slot="actions" type="primary" icon= "edit" >
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
        edit(item){
            this.$emit("setvisible",true);
            this.$emit("sendtocreattask");
            this.$emit("sendtoedittask",item);
        },
    }
})
</script>
