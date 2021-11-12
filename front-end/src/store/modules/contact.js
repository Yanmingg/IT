import { CONTACT } from "../mutation_types";
import axios from "axios";

const state = {
  record: [],
};

const getters = {};
const actions = {
  getAllContact({ commit }, id) {
    //commit是调用mutations的
    axios(`https://frozen-cove-48126.herokuapp.com/contact/finduser/${id}`)
      .then((res) => {
        commit(CONTACT.GET_CONTACT, res.data);
      })
      .catch((error) => {
        console.log(error);
      });
  },
  searchContact({ commit }, contactname) {
    //commit是调用mutations的
    let userid = localStorage.getItem("userid")
    axios(`https://frozen-cove-48126.herokuapp.com/contact/findname/${contactname}/${userid}`)
      .then((res) => {
        commit(CONTACT.GET_CONTACT, res.data);
      })
      .catch((error) => {
        console.log(error);
      });
  },
};

const mutations = {
  [CONTACT.GET_CONTACT](state, contact) {
    state.record = contact;
  },
  [CONTACT.CREATE_CONTACT](state, contact) {
    let userid = localStorage.getItem("userid");
    axios({
      url: `https://frozen-cove-48126.herokuapp.com/contact/save`, //地址
      method: "post",
      data: {
        name: contact.name,
        email: contact.email,
        phone: contact.phone,
        team: contact.team,
        status: contact.status,
        description: contact.description,
        userId: userid,
      },
    });

    setTimeout(() => {
      axios(`https://frozen-cove-48126.herokuapp.com/contact/finduser/${userid}`)
        .then((res) => {
          console.log("jinru");
          console.log(res.data);
          state.record = res.data;
          console.log("jinru");
          console.log(state.record);
        })
        .catch((error) => {
          console.log(error);
        });
      console.log(state.record);
    }, 10);

    //dispatch('getAllContact')
  },
  [CONTACT.DELETE_CONTACT](state, id) {
    console.log(state);
    for (let i in state.record) {
        //console.log('now on key: ', state.record[i]["id"], 'should delete id ', id)
        if (state.record[i]["contactid"] === id) {
            axios({
                url: `https://frozen-cove-48126.herokuapp.com/contact/deleteid/${id}`,
                method: 'delete',
            })
            state.record.splice(i, 1);
        }
    }
},

};
export default {
  namespaced: true,
  state,
  actions,
  getters,
  mutations,
};
//,localStorage.getItem("userid")
