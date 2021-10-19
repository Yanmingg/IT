<template>
  <!-- <div class="login">

    <div class="logo">
      <img
        src="../assets/logo1.png"
        class="logo1"
        style="width: 500px; height: 180px"
      />
      <h2 class="logoh2">
        THERE'S A LOT MORE <br />TO CRM THAN <br />
        YOU THINK!
      </h2>
      <img
        src="../assets/tubiao.png"
        class="logo2"
        style="width: 700px; height: 180px"
      />
    </div>

    <div class="loginform">
      <a-card :bordered="false" class="loginformcard">
        <div class="title">
          <h1 style="font-size: 400%; color: rgb(255, 255, 255)">Login</h1>
        </div>
        <a-form
          id="components-form-demo-normal-login"
          :form="form"
          class="login-form"
          @submit="handleSubmit"
        >
          <a-form-item>
            <a-input
              class="username"
              size="large"
              v-decorator="[
                'userName',
                {
                  rules: [
                    {
                      required: true,
                      message: 'Please input your username!',
                    },
                  ],
                },
              ]"
              placeholder="Username"
            >
              <a-icon
                slot="prefix"
                type="user"
                style="color: rgba(0, 0, 0, 0.25)"
              />
            </a-input>
          </a-form-item>
          <a-form-item class="item">
            <a-input
              class="passowrd"
              size="large"
              v-decorator="[
                'password',
                {
                  rules: [
                    {
                      required: true,
                      message: 'Please input your Password!',
                    },
                  ],
                },
              ]"
              type="password"
              placeholder="Password"
            >
              <a-icon
                slot="prefix"
                type="lock"
                style="color: rgba(0, 0, 0, 0.25)"
              />
            </a-input>
          </a-form-item>
          <a-form-item>
            <a-checkbox
              style="color: rgb(255, 255, 255)"
              class="checkbox"
              v-decorator="[
                'remember',
                {
                  valuePropName: 'checked',
                  initialValue: true,
                },
              ]"
            >
              Remember me
            </a-checkbox>

            <a-button
              shape="round"
              html-type="submit"
              class="login-form-button"
            >
              Log in
            </a-button>
            <br />
            <span style="color: rgb(255, 255, 255)">Not registered yet?</span>
            <a href="/register" style="color: #f19e38"> Create an account </a>
          </a-form-item>
        </a-form>
      </a-card>
    </div>

    <img src="../assets/Login2.jpg" style="height: 1300px; width: 2600px" />
  </div> -->
  <div>
    <a-row>
      <a-col :span="12">
        <div class="logo">
          <img src="../assets/logo.png" style="width: 75px; height: 75px" />
          <br />
          <br />

          <div class="title"><h1 style="font-size: 400%">Login</h1></div>
        </div>

        <div class="loginform">
          <a-form
            id="components-form-demo-normal-login"
            :form="form"
            class="login-form"
            @submit="handleSubmit"
          >
            <a-form-item>
              <a-input
                class="username"
                size="large"
                v-decorator="[
                  'userName',
                  {
                    rules: [
                      {
                        required: true,
                        message: 'Please input your username!',
                      },
                    ],
                  },
                ]"
                placeholder="Username"
              >
                <a-icon
                  slot="prefix"
                  type="user"
                  style="color: rgba(0, 0, 0, 0.25)"
                />
              </a-input>
            </a-form-item>
            <a-form-item class="item">
              <a-input
                class="passowrd"
                size="large"
                v-decorator="[
                  'password',
                  {
                    rules: [
                      {
                        required: true,
                        message: 'Please input your Password!',
                      },
                    ],
                  },
                ]"
                type="password"
                placeholder="Password"
              >
                <a-icon
                  slot="prefix"
                  type="lock"
                  style="color: rgba(0, 0, 0, 0.25)"
                />
              </a-input>
            </a-form-item>
            <a-form-item>
              <a-checkbox
                class="checkbox"
                v-decorator="[
                  'remember',
                  {
                    valuePropName: 'checked',
                    initialValue: true,
                  },
                ]"
              >
                Remember me
              </a-checkbox>
              <a class="login-form-forgot" href=""> Forgot password </a>
              <a-button
                shape="round"
                type="primary"
                html-type="submit"
                class="login-form-button"
              >
                Log in
              </a-button>
              <br />
              Not registered yet?
              <a href="/register"> Create an account </a>
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
  beforeCreate() {
    this.form = this.$form.createForm(this, { name: "normal_login" });
  },
  methods: {
    handleSubmit(e) {
      e.preventDefault();
      this.form.validateFields((err, values) => {
        if (!err) {
          console.log(
            "Received values of form: ",
            values.userName,
            values.password
          );
          this.$axios
            .post("http://localhost:8081/user/login", {
              useraccount: values.userName,
              password: values.password,
            })
            .then((data) => {
              //登录失败,先不讨论
              console.log(1111111111111111);
              console.log(data);
              if (data.data == -1) {
                //iViewUi的友好提示
                //this.$router.push("/dashboard");
                //登录成功
                this.$notification.open({
                  message: "Incorrect account or password",
                  icon: <a-icon type="close-circle" style="color: red" />,
                });
              } else if (data.data == -2) {
                this.$notification.open({
                  message: "Incorrect account or password",
                  // description:
                  //   "账号没找到",
                  icon: <a-icon type="close-circle" style="color: red" />,
                });
              } else {
                //设置Vuex登录标志为true，默认userLogin为false
                this.$store.dispatch("login/userLogin", true);
                //Vuex在用户刷新的时候userLogin会回到默认值false，所以我们需要用到HTML5储存
                //我们设置一个名为Flag，值为isLogin的字段，作用是如果Flag有值且为isLogin的时候，证明用户已经登录了。
                localStorage.setItem("Flag", "isLogin");
                localStorage.setItem("userid", data.data);
                let id=data.data
                console.log(id)
                this.$axios(`http://localhost:8081/user/findid/${id}`).then(
                  (res) => {
                    localStorage.setItem("name", res.data.name);
                  }
                );
                //iViewUi的友好提示
                //登录成功后跳转到指定页面
                this.$router.push("/dashboard");
              }
            });
        }
      });
    },
  },
};
</script>
<style>
/* .logo1 {
  position: absolute;
  top: 200px;
  left: -100px;
}
.logo2 {
  position: absolute;
  top: 680px;
  left: -120px;
}
.logoh2 {
  font-size: 500%;
  color: rgb(255, 255, 255);
  position: absolute;
  top: 350px;
  left: -73px;
}
.ant-input {
  background-color: rgb(84, 84, 84);
}
.ant-btn:hover,
.ant-btn:focus,
.ant-btn:active,
.ant-btn.active {
  text-decoration: none;
  background: #f1b03b;
}
.loginformcard {
  background-color: rgb(67, 67, 67);
}
.loginform {
  position: absolute;
  top: 300px;
  left: 1500px;
  height: 200px;
  width: 700px;
}
.login-form-button {
  color: rgb(255, 255, 255);
  background-color: #f19e38;
  height: 80px;
  width: 50%;
}
.h1 {
  font-size: 500%;
}
.logo {
  position: absolute;
  top: 50px;
  left: 300px;
  height: 200px;
  width: 50%;
}
.button,
button::after {
  border: none;
  margin: 0;
  padding: none;
}
.item {
  height: 200%;
  width: 100%;
}

.ant-checkbox-wrapper:hover .ant-checkbox-inner,
.ant-checkbox:hover .ant-checkbox-inner,
.ant-checkbox-input:focus + .ant-checkbox-inner {
  border: 1px solid #f19e38;
}

.ant-checkbox-checked .ant-checkbox-inner,
.ant-checkbox-indeterminate .ant-checkbox-inner {
  background-color: #f19e38;
  border: 1px solid #ffffff;
}

#components-form-demo-normal-login .login-form {
  max-width: 300px;
}
#components-form-demo-normal-login .login-form-forgot {
  float: right;
}
#components-form-demo-normal-login .login-form-button {
  width: 100%;
} */
.ant-input {
  border-radius: 16px;
}
.ant-input {
  border-radius: 10px;
}
.ant-input-affix-wrapper {
  border-radius: 2px;
}
.ant-input-affix-wrapper-lg {
  border-radius: 10px;
}
.username,
.ant-input-affix-wrapper,
.ant-input-affix-wrapper-lg {
  border-radius: 2px;
}
.loginform {
  position: absolute;
  top: 300px;
  left: 300px;
  height: 200px;
  width: 50%;
}
.login-form-button {
  color: rgb(255, 255, 255);
  background-color: #000;
  height: 80px;
  width: 50%;
}
.h1 {
  font-size: 500%;
}
.logo {
  position: absolute;
  top: 50px;
  left: 300px;
  height: 200px;
  width: 50%;
}
.ant-input {
  border-radius: 2px;
}
.item {
  height: 200%;
  width: 100%;
}
#components-form-demo-normal-login .login-form {
  max-width: 300px;
}
#components-form-demo-normal-login .login-form-forgot {
  float: right;
}
#components-form-demo-normal-login .login-form-button {
  width: 100%;
}
</style>