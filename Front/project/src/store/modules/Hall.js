import AXIOS from 'axios';

const state = {
    halldata: null
}

const mutation = {
    showHall(state, data) {
        state.halldata = data
    },
}

const action = {
    GET_HALL (context) {
        return AXIOS.get('/hall/get/6').then(({data}) => {
            return data;
        })
    },
}

export default {
    namespaced: true,
    state, mutations, actions
}