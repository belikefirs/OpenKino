import AXIOS from 'axios';

const state = {

}

const mutation = {
    
}

const action = {
    AUTHORIZATION_LOGIN (context, data) {
        return AXIOS.post('/auth', data).then((response) => {
            //context.commit('putLogin', data);
            console.log(response);
            var str = response.headers.authorization;
            localStorage.setItem('token', str.substring(7));
        });
    },
    AUTHORIZATION_REG (context, data) {
        return AXIOS.post('KinoUser/save', data).then((response) => {
            console.log(response);
        });
    },
}

export default {
    namespaced: true,
    state, mutations, actions
}