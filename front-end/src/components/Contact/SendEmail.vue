<template>
  <div style="overflow-y: auto">
    <a-form :form="form" :label-col="{ span: 4 }" :wrapper-col="{ span: 18 }">
      <a-form-item label="Recevier">
        <a-input
          v-decorator="[
            'recevier',
            {
              rules: [{ required: true, message: 'Please input client name!' }],
            },
          ]"
        />
      </a-form-item>
      <a-form-item label="Title">
        <a-input v-decorator="['title']" />
      </a-form-item>
      <a-form-item label="Content">
        <a-mentions v-decorator="['content']" rows="10" />
      </a-form-item>
    </a-form>
  </div>
</template>
<script>
export default {
  namespaced: true,
  data() {
    return {
      form: this.$form.createForm(this, { name: "coordinated" }),
      id: 0,
    };
  },
  methods: {
    getContact(contact) {
      this.form.setFieldsValue({
        name: contact.name,
        mobile: contact.mobile,
        email: contact.email,
        organization: contact.organization,
        status: contact.status,
      });
      this.id = contact.id;
    },
    handlesubmit() {
      this.form.validateFields((err, values) => {
        if (!err) {
          this.$emit("setModal4Visible", false);
          console.log(
            "Received values of form: ",
            values.userName,
            values.password
          );

          this.$axios
            .post("https://frozen-cove-48126.herokuapp.com/user/sendEmail", {
              address: [values.recevier],
              subject: values.title,
              body: values.content,
              userAddress: localStorage.getItem("email"),
              userName: localStorage.getItem("name"),
            })
            .then((data) => {
              console.log(data);
            });
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