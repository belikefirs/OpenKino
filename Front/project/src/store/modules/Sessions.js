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
		data.start = "2019-08-25T" + data.start.substring(0, 2) + ":" + data.start.substring(2);
		// console.log(data.start);
        return AXIOS.post("/session/save", data);
    },
    GET_SESSION_LIST (context, data) {
		let id = data.id;
        return AXIOS.get('/session/' + id).then(({data}) => {
			data.forEach(item => {
				item.film = {id: id};
			});
            context.commit('setSessionList', data);
        });
    },
    CHANGE_SESSION(context, data){
        return AXIOS.put('/session/update', data);
    },
    DELETE_SESSION(context, data){
        return AXIOS.delete('/session/delete/' + data.id);
    },
}

export default {
    namespaced: true,
    state, mutations, actions
}

/*
Доб. сеанса по фильму и залу
http://localhost:8089/session/save

{
	"start": "2019-08-25T16:30",
	"hall": {
		"id": 17
	},
	"film": {
		"id": 6
	}
}

-----------------------------------------
Удал. сеанса по его id
http://localhost:8089/session/delete/{id}

-------------------------------------------
Получ. всех сеансов по id фильма
http://localhost:8089/session/{id}

{ 
	"id": 1, 
	"start": "1994-04-15T11:30", 
	"end": "1994-04-15T13:10", 
	"hall": { 
	"id": 100, 
	"width": 100, 
	"height": 100, 
	"places": [ 
		{ 
			"id": 122, 
			"number": null, 
			"y": null, 
			"x": null, 
			"price": null, 
			"reservation": null, 
			"buy": null 
		}, 
	],
}

------------------------------------------
Обнов. сеансов
http://localhost:8089/session/?name={название фильма}

{
	"id": 20,
	"start": "1994-04-15T11:30",
	"hall": {
		"id": 17
	},
	"film": {
		"id": 6
	}
}
*/