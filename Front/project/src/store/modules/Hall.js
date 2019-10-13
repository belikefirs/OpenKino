import AXIOS from 'axios';

const state = {
    hallList: [],
}

const mutations = {

    setAllHalls(state, data){
        state.hallList = data;
    }
}

const actions = {
    SET_HALL(context, data){
        return AXIOS.post('/hall', data).then(() => {
            context.dispatch('GET_ALL_HALLS');
        });
    },
    GET_ALL_HALLS (context){
        return AXIOS.get('/hall/all').then(({data}) => {
            context.commit('setAllHalls', data);
        });
    },
    GET_PLACES (context, data) {
        return AXIOS.get('/hall/bySession/' + data.idP).then(({data}) => {
            return data;
        })
    },
    CHANGE_HALL(context, data){
        return AXIOS.put('/hall/update', data);
    },
    DELETE_HALL(context, data){
        return AXIOS.delete('/hall', data.id);
    }
}

export default {
    namespaced: true,
    state, mutations, actions
}

// Формат JSON
/*
{
    "id": 34,
    "y": 1,
    "x": 1,
    "price": 300.00,
    "status": "IsFree",
    "reservation": null,
    "buy": null
},
{
    "id": 35,
    "y": 1,
    "x": 2,
    "price": 300.00,
    "status": "IsFree",
    "reservation": null,
    "buy": null
},
*/