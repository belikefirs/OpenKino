<template>
    <WrapperCent>
        <div class="wrapper-SessionFilm">
            <div class="imageFilm">

            </div>
            <div class="Sessions">
                <li v-for="(session, index) in listSession" :key="index.id">
                    <label @click="showInformation(session.id)">{{session.start}}</label>
                </li>
            </div>
        </div>
    </WrapperCent>
</template>

<script>
import WrapperCent from '@/components/AppWrapperCenter.vue'
import Cinema from '@/components/AppCinema.vue'
import Modal from '@/components/AppModalWindow.vue'
export default {
    components: {
        WrapperCent, Cinema, Modal
    },
    data() {
        return {
            listSession: null
        }
    },
    methods: {
        showInformation(sId) {
            this.$router.push({name: 'FilmsInformation', params:{Pid:sId}});
        },
    },
    mounted() {
        this.$store.dispatch('PageFilms/GET_SESSIONS').then(listSession => this.listSession = listSession);
    }
}
</script>

<style>
.wrapper-SessionFilm {
    display: flex;
}
</style>