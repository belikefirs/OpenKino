import AXIOS from 'axios';

const state = {
    halldata: null
}

const mutations = {
    showHall(state, data) {
        state.halldata = data
    },
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
    }
}

export default {
    namespaced: true,
    state, mutations, actions
}