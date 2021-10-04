<template>
    <div style="overflow-y:auto">
        <a-form :form="form" :label-col="{ span: 6 }" :wrapper-col="{ span: 12 }">
            <a-form-item label="Name">
            <a-input
                v-decorator="[
                'name', 
                { 
                    rules: [{ required: true, message: 'Please input client name!' }] 
                }
                ]"
            />
            </a-form-item>
            <a-form-item label="Organization">
            <a-input
                v-decorator="[
                'oraganization']
                "
                :value="organization"
            />   
            </a-form-item>
            <a-form-item label="Moile">
            <a-input
                v-decorator="[
                'mobile']"
                :value="mobile"
            />
            </a-form-item>
            <a-form-item label="Email">
            <a-input
                v-decorator="[
                'email']"
                :value="email"
            />
            </a-form-item>
            <a-form-item label="Status">
            <a-select
                v-decorator="[
                'status',
                { 
                    rules: [{ required: true, message: 'Please select client status!' }] 
                },
                ]"
                :value="status"
                placeholder="Select client status"
                @change="handleSelectChange"
            >
                <a-select-option value="Star">
                Star
                </a-select-option>
                <a-select-option value="emergency">
                emergency
                </a-select-option>
                <a-select-option value="general">
                general
                </a-select-option>
            </a-select>
            </a-form-item>
        </a-form>
    </div>   
</template>
<script>
export default {
    namespaced: true,
    data() {
        const value = this.value;
        return {
        name: value.name,
        organization:value.organization,
        mobile:value.mobile,
        email:value.email,
        status:value.status,
        formLayout: 'horizontal',
        form: this.$form.createForm(this, { name: 'coordinated' }),
        };
    },
    computed:{

    },
    methods:{
        handlesubmit() {
            this.form.validateFields((err, values) => {
                if (!err) {
                    console.log(values);
                    this.$emit('getrecord',values);
                }
            });
        },
        handleSelectChange(value) {
            console.log(value);
    /*      this.form.setFieldsValue({
            note: `Hi, ${value === 'male' ? 'man' : 'lady'}!`,
        });
    */
        },
    },
    created(){

    }
}
</script>