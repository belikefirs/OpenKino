<template>
    <WrapperCent>
        <div class="wrapper-SessionFilm">
            <div class="block1">

            </div>
            <div class="block2">
                <p class="descriptionFilm">Lorem ipsum dolor sit amet consectetur adipisicing elit. Laboriosam magnam voluptates sunt harum,
                     corrupti aliquam tempore temporibus. Unde praesentium optio soluta quod quisquam, 
                     eaque rerum rem vitae corporis, fugiat officiis.Lorem ipsum dolor sit amet consectetur adipisicing elit. Laboriosam magnam voluptates sunt harum,
                     corrupti aliquam tempore temporibus. Unde praesentium optio soluta quod quisquam, 
                     eaque rerum rem vitae corporis, fugiat officiis.Lorem ipsum dolor sit amet consectetur adipisicing elit. Laboriosam magnam voluptates sunt harum,
                     corrupti aliquam tempore temporibus. Unde praesentium optio soluta quod quisquam, 
                     eaque rerum rem vitae corporis, fugiat officiis.Lorem ipsum dolor sit amet consectetur adipisicing elit. Laboriosam magnam voluptates sunt harum,
                     corrupti aliquam tempore temporibus. Unde praesentium optio soluta quod quisquam, 
                     eaque rerum rem vitae corporis, fugiat officiis.</p>
                <li v-for="(session, index) in listSession" :key="index.id" class="listSession">
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
    width: 100%;
}
.block1 {
    width: 30%;
}
.block2 {
    width: 70%;
}
.listSession {
    list-style: none;
    background: rgba(124, 124, 124, 0.514);
    color: #222;
    font-size: 18px;
    font-weight: 400;
    padding: 20px;
    width: 200px;
    text-align: justify;
}
.descriptionFilm {
    font-size: 16px;
    font-weight: 400;
    margin-bottom: 50px;
}
</style>