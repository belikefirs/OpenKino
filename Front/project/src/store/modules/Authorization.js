import AXIOS from 'axios';

const state = {
    flagAuth: false,
}

const actions = {
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
    GET_NAME_USER (content, data) {
        return AXIOS.get(`/KinoUser/?mail=${data.mail}`).then(({data}) => {
            return data;
        })
    }
}

export default {
    namespaced: true,
    actions, state
}