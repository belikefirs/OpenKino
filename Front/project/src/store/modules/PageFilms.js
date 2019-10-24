import AXIOS from 'axios';

const state = {

}

const getters = {

}

const mutations = {

}

const actions = {
    GET_FILMS_SEARCH (context, data) {
        return AXIOS.get('/Film/?name=').then(({data}) => {
            return data;
        })
    },
    GET_SESSIONS (context, data) {
        return AXIOS.get('/session/' + data.idF).then(({data}) => {
            return data;
        })
    },
    CHANGE_STATUS (context, data) {
        return AXIOS.put(`/hall/changeStatus?id=${data.id}&status=${3}`).then(({data}) => {
            return data;
        })
    },
    RESERVATION_FROM_USER (context, data) {
        const authHeader = localStorage.getItem('token')
        return AXIOS.post('/reser', data, { headers: {
            Authorization: 'Bearer ' + authHeader
        }}).then((response) => {

        })
    },
    BUY_RESERVATION_FROM_USER (context, data) {
        const authHeader = localStorage.getItem('token')
        return AXIOS.post('/buy/save', data, { headers: {
            Authorization: 'Bearer ' + authHeader
        }}).then((response) => {

        })
    }
}

export default {
    namespaced: true,
    state, getters, mutations, actions
}

// JSON Films
// {
//         "id": 170,
//         "name": "dffdfd",
//         "lenght": 13320,
//         "limitAge": {
//             "id": 171,
//             "age": 21
//         },
//         "rating": {
//             "id": 169,
//             "rating": 9.0,
//             "colUser": null,
//             "sumRating": null
//         },
//         "typeFilm": {
//             "id": 172,
//             "name": "2D"
//         },
//         "genre": {
//             "id": 173,
//             "name": "Экшен"
//         },
//         "image": null
// },

// JSON Sessions
// [
//     {
//         "id": 206,
//         "start": "2019-08-25T13:30",
//         "end": "2019-09-03T19:30",
//         "hall": {
//             "id": 33,
//             "number": 3,
//             "width": 15,
//             "height": 10,
//             "places": [
//                 {
//                     "id": 34,
//                     "y": 1,
//                     "x": 1,
//                     "price": 300.00,
//                     "status": "IsFree",
//                     "reservation": null,
//                     "buy": null
//                 },
//                 {
//                     "id": 35,
//                     "y": 1,
//                     "x": 2,
//                     "price": 300.00,
//                     "status": "IsFree",
//                     "reservation": null,
//                     "buy": null
//                 },

// JSON RESERVATION
// { 
//     "id": 68, 
//     "start": { 
//     "dayOfMonth": 31, 
//     "dayOfWeek": "SATURDAY", 
//     "month": "AUGUST", 
//     "year": 2019, 
//     "dayOfYear": 243, 
//     "second": 51, 
//     "monthValue": 8, 
//     "hour": 22, 
//     "minute": 51, 
//     "nano": 53000000, 
//     "chronology": { 
//     "id": "ISO", 
//     "calendarType": "iso8601" 
//     } 
//     }, 
//     "end": { 
//     "dayOfMonth": 15, 
//     "dayOfWeek": "FRIDAY", 
//     "month": "APRIL", 
//     "year": 1994, 
//     "dayOfYear": 105, 
//     "second": 0, 
//     "monthValue": 4, 
//     "hour": 10, 
//     "minute": 30, 
//     "nano": 0, 
//     "chronology": { 
//     "id": "ISO", 
//     "calendarType": "iso8601" 
//     } 
//     }, 
//     "status": null, 
//     "price": 0.00, 
//     "kinoUser": { 
//     "id": 67, 
//     "fName": null, 
//     "name": "Ivan", 
//     "password": "$2a$10$Gb5ykxRLyf6YDOTrbDL6iuMbOkTU1iVvyFFmVQz4yVojecSnLcxFC", 
//     "age": 20, 
//     "phone": "+74953434345", 
//     "mail": null, 
//     "action": null, 
//     "enabled": true, 
//     "username": null, 
//     "accountNonLocked": true, 
//     "accountNonExpired": true, 
//     "credentialsNonExpired": true, 
//     "authorities": [ 
//     { 
//     "authority": "User" 
//     } 
//     ] 
//     }, 
//     "discount": { 
//     "id": 63, 
//     "name": "AfterTen", 
//     "percent": 0.05 
//     }, 
//     "places": [ 
//     { 
//     "id": 41, 
//     "y": 1, 
//     "x": 1, 
//     "price": 324.00, 
//     "status": "IsReservation", 
//     "buy": null 
//     }, 
//     { 
//     "id": 42, 
//     "y": 1, 
//     "x": 2, 
//     "price": 324.00, 
//     "status": "IsReservation", 
//     "buy": null 
//     }, 
//     { 
//     "id": 43, 
//     "y": 1, 
//     "x": 3, 
//     "price": 324.00, 
//     "status": "IsReservation", 
//     "buy": null 
//     } 
//     ], 
//     "buy": null 
//     }

// JSON Hall
// {
//     "id": 33,
//     "number": 3,
//     "width": 15,
//     "height": 10,
//     "places": [
//     {
//     "id": 34,
//     "y": 1,
//     "x": 1,
//     "price": 300.00,
//     "status": "IsFree",
//     "reservation": null,
//     "buy": null
//     },
//     {
//     "id": 35,
//     "y": 1,
//     "x": 2,
//     "price": 300.00,
//     "status": "IsFree",
//     "reservation": null,
//     "buy": null
//     },
//     {
//     "id": 36,
//     "y": 1,
//     "x": 3,
//     "price": 300.00,
//     "status": "IsFree",
//     "reservation": null,
//     "buy": null
//     },
//     {
//     "id": 37,
//     "y": 1,
//     "x": 4,
//     "price": 300.00,
//     "status": "IsFree",
//     "reservation": null,
//     "buy": null
//     },
    