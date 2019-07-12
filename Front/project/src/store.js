import Vue from 'vue';
import Vuex from 'vuex';
import AXIOS from 'axios';

Vue.use(Vuex);

const hall = {
  id: 1,
  width: 50,
  height: 50,
  places: [
    {
      id: 5,
      x: 5,
      y: 3,
      type: 'SEED',
    },

    {
      id: 3,
      x: 3,
      y: 4,
      type: 'SEED_FULL'
    },

    {
      id: 6,
      x: 2,
      y: 2,
      type: 'EMPTY'
    }
  ]
}

export default new Vuex.Store({
  state: {
    hall: null
  },
  mutations: {
    setHall (state, data) {
      state.hall = data
    }
  },
  actions: {
    TEXT (context, payload)  {
      //return AXIOS.get('/')
      return new Promise(resolve => {
      	context.commit('setHall', hall)
      	console.log('payload', payload)
      	resolve(hall)

      }, reject => {

      });
    }
  }
});
