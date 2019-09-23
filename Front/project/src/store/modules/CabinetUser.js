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
        const authHeader = localStorage.getItem('token')
        return AXIOS.get('/card/allByKinoUser', { headers: {
            Authorization: 'Bearer ' + authHeader
        }}).then(({data}) => {
            return data;
        })
    },
    DONATE_CARD (context, data) {
        return AXIOS.put('/card/add/' + data.id + ',' + data.money);
        
    },
    DELETE_CARD (context, data) {
        return AXIOS.delete('/card/' + data.id);
    },
    GET_INFO_RESER (context, data) {
        const authHeader = localStorage.getItem('token')
        return AXIOS.get('/reser/listRes/0', { headers: {
            Authorization: 'Bearer ' + authHeader
        }}).then(({data}) => {
            return data;
        })
    },
    GET_INFO_BUY (context, data) {
        const authHeader = localStorage.getItem('token')
        return AXIOS.get('/reser/listRes/2', { headers: {
            Authorization: 'Bearer ' + authHeader
        }}).then(({data}) => {
            return data;
        })
    },

}

export default {
    namespaced: true,
    actions
}
// [
//     [
//         900.00,
//         9,
//         {
//             "month": "AUGUST",
//             "year": 2019,
//             "dayOfMonth": 25,
//             "hour": 16,
//             "minute": 30,
//             "monthValue": 8,
//             "nano": 0,
//             "second": 0,
//             "dayOfWeek": "SUNDAY",
//             "dayOfYear": 237,
//             "chronology": {
//                 "id": "ISO",
//                 "calendarType": "iso8601"
//             }
//         },
//         "Hatiko",
//         [
//             [
//                 1,
//                 2
//             ],
//             [
//                 1,
//                 5
//             ],
//             [
//                 1,
//                 6
//             ]
//         ]
//     ],
//     [
//         750.00,
//         666,
//         {
//             "month": "AUGUST",
//             "year": 2019,
//             "dayOfMonth": 25,
//             "hour": 16,
//             "minute": 30,
//             "monthValue": 8,
//             "nano": 0,
//             "second": 0,
//             "dayOfWeek": "SUNDAY",
//             "dayOfYear": 237,
//             "chronology": {
//                 "id": "ISO",
//                 "calendarType": "iso8601"
//             }
//         },
//         "Mr Robot",
//         [
//             [
//                 7,
//                 3
//             ],
//             [
//                 8,
//                 3
//             ],
//             [
//                 9,
//                 3
//             ]
//         ]
//     ]
// ]