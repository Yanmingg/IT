import { DASHBOARD } from "../mutation_types"
import axios from 'axios'

const state = {
    record: []
}

const getters = {
}
const actions = {
    getAllDshboard({ commit }) { //commit是调用mutations的
        axios(`http://localhost:8081/task/findAll`)
        .then(res => {
            commit(DASHBOARD.GET_DASHBOARD,res.data);
        })
        .catch((error) => {
            console.log(error)
        })
    },
    
}



const mutations = {
    [DASHBOARD.GET_DASHBOARD](state, dashboard) {
        state.record = dashboard
    },

    [DASHBOARD.CREATE_DASHBOARD](state, dashboard) {

        axios({
            url: `http://localhost:8081/task/save`,//地址
            method: 'post',
            data: {
                name: dashboard.name,
                contactid: dashboard.contactid,
                time: dashboard.time,
                completed: dashboard.completed,
                description: dashboard.description,
                userId:1,
            }
          })
          setTimeout(() => {
              axios(`http://localhost:8081/task/findAll`)
            .then(res => {
                state.record = res.data
                //commit(DASHBOARD.GET_DASHBOARD,res.data);
            })
            .catch((error) => {
                console.log(error)
            })
          }, 10);
        
    },
    
    [DASHBOARD.DELETE_DASHBOARD](state, id) {
        console.log(state);
        for (let i in state.record) {
            //console.log('now on key: ', state.record[i]["id"], 'should delete id ', id)
            if (state.record[i]["taskid"] === id) {
                axios({
                    url: `http://localhost:8081/task/deleteid/${id}`,
                    method: 'delete',
                })
                state.record.splice(i, 1);
            }
        }
    },
    [DASHBOARD.EDIT_C_DASHBOARD](state, dashboard) {
        axios({
            url: `http://localhost:8081/task/update`,
            method: 'put',
            data: {
				name: dashboard.name,
				taskid: dashboard.taskid,
				time: dashboard.time,
				completed: dashboard.completed,
				description: dashboard.description,
				userId:1,
			}
        })
        for (let i in state.record) {
            if (state.record[i]["taskid"] === dashboard.taskid) {
                state.record[i]["completed"]=1
            }
        }
        // state.record.push(dashboard)
    },
    [DASHBOARD.EDIT_DASHBOARD](state, dashboard) {
        console.log("jinru"
        )
        axios({
            url: `http://localhost:8081/task/update`,
            method: 'put',
            data: {
				name: dashboard.name,
				taskid: dashboard.taskid,
				time: dashboard.time,
				completed: dashboard.completed,
				description: dashboard.description,
				userId:1,
			}
        })
        setTimeout(() => {
            axios(`http://localhost:8081/task/findAll`)
          .then(res => {
              state.record = res.data
              //commit(DASHBOARD.GET_DASHBOARD,res.data);
          })
          .catch((error) => {
              console.log(error)
          })
        }, 10);
        // state.record.push(dashboard)
    }
}
export default {
    namespaced: true,
    state,
    actions,
    getters,
    mutations
}