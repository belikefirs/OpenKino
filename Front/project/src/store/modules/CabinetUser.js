import AXIOS from 'axios';

const state = {

}

const mutation = {
    
}

const action = {
    BALANCE_UP (context, data) {
        const authHeader = localStorage.getItem('token')
        return AXIOS.post('/card', data, { headers: {
            Authorization: 'Bearer ' + authHeader
        }}).then((response) => {

        })
    },
    GET_LIST_CARDS (context, data) {
        return AXIOS.get('/card/allByKInoUser', data).then((response) => {
                
        })
    }
}

export default {
    namespaced: true,
    state, mutations, actions
}