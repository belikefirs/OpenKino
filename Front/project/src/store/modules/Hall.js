import AXIOS from 'axios';

const state = {
    halls: []
}

const getters = {
    HALLS: state => {
    return state.halls;
    }
}
const mutations = {
    SET_LIST_HALLS: (state, data) => {
        state.halls = data
    },
}

const actions = {
    // GET_HALL (context) {
    //     return AXIOS.get('/hall/get/6').then(({data}) => {
    //         return data;
    //     })
    // },
    GET_LIST_HALLS: async (context, data) =>{
        let {temp} = await AXIOS.get('/hall/all')
            context.commit('SET_LIST_HALLS', temp)
    }
}

export default {
    namespaced: true,
    state, mutations, actions, getters
}