import AXIOS from 'axios';

const actions = {
    ADD_CARD (context, data) {
        const authHeader = localStorage.getItem('token')
        return AXIOS.post('/card', data, { headers: {
            Authorization: 'Bearer ' + authHeader
        }}).then((response) => {

        })
    },
    GET_LIST_CARDS (context, data) {
        return AXIOS.get('/card/allByKinoUser/2').then(({data}) => {
            return data;
        })
    },
    DONATE_CART (context, data) {
        return AXIOS.put('/card/add' + data.id + data.money);
        
    }

}

export default {
    namespaced: true,
    actions
}