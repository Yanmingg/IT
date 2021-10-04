<template>
    <div style="overflow-y:auto">
        <a-form :form="form" :label-col="{ span: 6 }" :wrapper-col="{ span: 12 }">
            <a-form-item label="Name">
            <a-input
                
                v-decorator="[
                'name', { 
                  rules: [{ required: true, message: 'Please input client name!' }] 
                  }]"
            />
            </a-form-item>
            <a-form-item label="Organization">
            <a-input
                v-decorator="[
                'team']"
            />
            </a-form-item>
            <a-form-item label="Moile">
            <a-input
                v-decorator="[
                'phone']"
            />
            </a-form-item>
            <a-form-item label="Email">
            <a-input
                v-decorator="[
                'email']"
            />
            </a-form-item>
            <a-form-item label="Description">
            <a-input
                v-decorator="[
                'description']"
            />
            </a-form-item>
            <a-form-item label="Status">
            <a-select
                v-decorator="[
                'status',
                { rules: [{ required: true, message: 'Please select client status!' }] },
                ]"
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
    return {
      form: this.$form.createForm(this, { name: 'coordinated' }),
      id: 0,
    };
  },
  methods: {
    getContact(contact){
      this.form.setFieldsValue(
        {
          name: contact.name,
          email: contact.email,
          phone: contact.phone,
          team: contact.team,
          status: contact.status,
          description: contact.description,
          userId:1,
        }
      );
      this.id = contact.contactid
    },
    handlesubmit() {
        this.form.validateFields((err, values) => {
            if (!err) {
              this.$emit('setModal3Visible',false);
              this.$emit('editRecord',values,this.id);
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
};
</script>