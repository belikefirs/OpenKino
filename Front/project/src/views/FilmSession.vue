<template>
    <WrapperCent>
        <div class="wrapper-SessionFilm">
            <div class="block-image">

            </div>
            <div class="block-text">
                <p class="descriptionFilm">Пока Мстители и их союзники продолжают защищать мир от различных опасностей, с которыми не смог бы справиться один супергерой,
                     новая угроза возникает из космоса: Танос. Межгалактический тиран преследует цель собрать все шесть Камней Бесконечности — 
                     артефакты невероятной силы, с помощью которых можно менять реальность по своему желанию. Всё, с чем Мстители сталкивались ранее, 
                     вело к этому моменту — судьба Земли никогда ещё не была столь неопределённой.</p>
                <li v-for="(session, index) in listSession" :key="index.id" class="listSession">
                    <label @click="showInformation(session.id)">{{session.start.substring(11, 16)}} - {{session.end.substring(11, 16)}}</label>
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
.block-image {
    width: 30%;
}
.block-inf {
    width: 70%;
}
.listSession {
    list-style: none;
    background: rgba(22, 22, 22, 0.9);
    color: #fff;
    font-size: 18px;
    font-weight: 400;
    padding: 20px;
    width: 20%;
    text-align: center;
    display: inline-block;
    border-radius: 10px;
    margin: 0 10px 10px 0;
}
.descriptionFilm {
    font-size: 20px;
    font-weight: 400;
    margin-bottom: 50px;
    background: rgba(255, 255, 255, 0.9);
    padding: 15px;
    border-radius: 5px 30px 30px 5px;
    margin-top: 5px;
}
</style>