import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    n:0,
    count:0,
  },
  mutations: {
    increment(state,n){
      state.count+=n;
    }
  },
  actions: {
    increment({state}){
      setTimeout(()=>{
        state.count++;
      }, 3000)
    }
  },

  //缓存数据
  getters:{
    doubleCount(state){
      return state.count *2;
    }
  },
  modules: {},
});
