import AXIOS from 'axios';

const state = {
    sessionList: [],
}

const mutations = {
    setSessionList(state, data){
        state.sessionList = data;
    },
}

const actions = {
    ADD_SESSION (context, data) {
        return AXIOS.post("/session/save", data);
    },
    GET_SESSION_LIST (context) {
        return AXIOS.get('/session').then(({data}) => {
            context.commit('setSessionList', data);
        });
    },
}

export default {
    namespaced: true,
    state, mutations, actions
}