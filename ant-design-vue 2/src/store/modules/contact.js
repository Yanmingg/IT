import { CONTACT } from "../mutation_types"
import contacts from "../../api/contacts"
const state = {
    record: []
}

const getters = {

}
const actions = {
    getAllContact({ commit }) {
        contacts.getContacts(contact => {
            commit(CONTACT.GET_CONTACT, contact)
        })
    }
}

const mutations = {
    [CONTACT.GET_CONTACT](state, contact) {
        state.record = contact
    },
    [CONTACT.CREATE_CONTACT](state, contact) {
        state.record.push(contact)
    },
    [CONTACT.DELETE_CONTACT](state, id) {
        for (let i in state.record) {
            //console.log('now on key: ', state.record[i]["id"], 'should delete id ', id)
            if (state.record[i]["id"] === id) {
                state.record.splice(i, 1);
            }
        }
    },
}
export default {
    namespaced: true,
    state,
    actions,
    getters,
    mutations
}