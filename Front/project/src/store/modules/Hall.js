import AXIOS from 'axios';

const state = {
    halldata: null,
    hallList: [],
}

const mutations = {
    showHall(state, data) {
        state.halldata = data
    },
    setAllHalls(state, data){
        state.hallList = data;
    }
}

const actions = {
    GET_HALL (context) {
        return AXIOS.get('/hall/get/6').then(({data}) => {
            return data;
        })
    },
    CREATE_HALLS(context, data) {
        return AXIOS.get('/hall/saveall').then(({data}) => {
            return data;
        })
    },
    GET_ALL_HALLS(context){
        return AXIOS.get('/hall/all').then(({data}) => {
            context.commit('setAllHalls', data);
        });
    },
}

export default {
    namespaced: true,
    state, mutations, actions
}