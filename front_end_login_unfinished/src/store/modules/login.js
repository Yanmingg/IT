import { LOGIN } from "../mutation_types";

const state= {
  isLogin: false,
};
const getters= {
  //获取登录状态
  isLogin: state => state.isLogin,
};

const actions= {
  //获取登录状态
  userLogin({commit}, flag) {
    commit(LOGIN.USER_STATUS, flag)
  },
};

const mutations= {
  //保存登录状态
  [LOGIN.USER_STATUS](state, flag) {
    state.isLogin = flag
  },
};

export default {
  namespaced: true,
  state,
  actions,
  mutations,
  getters,
};
