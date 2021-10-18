<template>
  <div>
    <a-row>
      <a-col :span="12">
        <div class="logo">
          <img src="../assets/logo.png" style="width: 75px; height: 75px" />
          <br />
          <br />

          <div class="title">
            <h1 style="font-size: 400%">Create An Account</h1>
          </div>
        </div>

        <div class="loginform">
          <a-form :form="form" @submit="handleSubmit">
            <a-form-item v-bind="formItemLayout" label="Name">
              <a-input
                v-decorator="[
                  'name',
                  {
                    rules: [
                      {
                        required: true,
                        message: 'Please input your Name!',
                      },
                    ],
                  },
                ]"
              />
            </a-form-item>
            <a-form-item v-bind="formItemLayout" label="E-mail">
              <a-input
                v-decorator="[
                  'email',
                  {
                    rules: [
                      {
                        type: 'email',
                        message: 'The input is not valid E-mail!',
                      },
                      {
                        required: true,
                        message: 'Please input your E-mail!',
                      },
                    ],
                  },
                ]"
              />
            </a-form-item>
            <a-form-item v-bind="formItemLayout" label="Password" has-feedback>
              <a-input
                v-decorator="[
                  'password',
                  {
                    rules: [
                      {
                        required: true,
                        message: 'Please input your password!',
                      },
                      {
                        validator: validateToNextPassword,
                      },
                    ],
                  },
                ]"
                type="password"
              />
            </a-form-item>
            <a-form-item
              v-bind="formItemLayout"
              label="Confirm Password"
              has-feedback
            >
              <a-input
                v-decorator="[
                  'confirm',
                  {
                    rules: [
                      {
                        required: true,
                        message: 'Please confirm your password!',
                      },
                      {
                        validator: compareToFirstPassword,
                      },
                    ],
                  },
                ]"
                type="password"
                @blur="handleConfirmBlur"
              />
            </a-form-item>

            <a-form-item v-bind="formItemLayout" label="Phone Number">
              <a-input
                v-decorator="[
                  'phone',
                  {
                    rules: [
                      {
                        required: true,
                        message: 'Please input your phone number!',
                      },
                    ],
                  },
                ]"
                style="width: 100%"
              >
                <a-select
                  slot="addonBefore"
                  v-decorator="['prefix', { initialValue: '86' }]"
                  style="width: 70px"
                >
                  <a-select-option value="86"> +61 </a-select-option>
                  <a-select-option value="87"> +86 </a-select-option>
                </a-select>
              </a-input>
            </a-form-item>

            <a-form-item
              v-bind="formItemLayout"
              label="Captcha"
              extra="We must make sure that your are a human."
            >
              <a-row :gutter="8">
                <a-col :span="12">
                  <a-input
                    v-decorator="[
                      'captcha',
                      {
                        rules: [
                          {
                            required: true,
                            message: 'Please input the captcha you got!',
                          },
                        ],
                      },
                    ]"
                  />
                </a-col>
                <a-col :span="12">
                  <a-button>Get captcha</a-button>
                </a-col>
              </a-row>
            </a-form-item>
            <a-form-item v-bind="tailFormItemLayout">
              <a-button
                class="registerButton"
                shape="round"
                type="primary"
                html-type="submit"
              >
                Register
              </a-button>
              <br />
              Already have an account?
              <a href="/login"> Sign in </a>
            </a-form-item>
          </a-form>
        </div>
      </a-col>
      <a-col :span="12">
        <img src="../assets/login1.png" style="width: 1280px; height: 1241px" />
      </a-col>
    </a-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      confirmDirty: false,
      formItemLayout: {
        labelCol: {
          xs: { span: 24 },
          sm: { span: 8 },
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 },
        },
      },
      tailFormItemLayout: {
        wrapperCol: {
          xs: {
            span: 24,
            offset: 0,
          },
          sm: {
            span: 16,
            offset: 8,
          },
        },
      },
    };
  },
  beforeCreate() {
    this.form = this.$form.createForm(this, { name: "register" });
  },
  methods: {
    handleSubmit(e) {
      e.preventDefault();
      this.form.validateFieldsAndScroll((err, values) => {
        if (!err) {
          this.$axios
            .post("/user/register", {
              user: values.userName,
              password: values.password,
            })
            .then(() => {
              this.$router.push("/login");
            });
          console.log("Received values of form: ", values);
        }
      });
    },
    handleConfirmBlur(e) {
      const value = e.target.value;
      this.confirmDirty = this.confirmDirty || !!value;
    },
    compareToFirstPassword(rule, value, callback) {
      const form = this.form;
      if (value && value !== form.getFieldValue("password")) {
        callback("Two passwords that you enter is inconsistent!");
      } else {
        callback();
      }
    },
    validateToNextPassword(rule, value, callback) {
      const form = this.form;
      if (value && this.confirmDirty) {
        form.validateFields(["confirm"], { force: true });
      }
      callback();
    },
  },
};
</script>
<style>
.loginform {
  position: relative;
  top: 100px;
  left: -170px;

}
.registerButton {
  color: rgb(255, 255, 255);
  background-color: #000;
  height: 80px;
  width: 100%;
}
.h1 {
  font-size: 500%;
}
.logo {
  position: relative;
  top: 50px;
  left: 300px;
  height: 200px;
  width: 50%;
}
</style>