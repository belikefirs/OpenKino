<template>
    <!-- <div class="AdminPanel">
        <h1>Панель администратора</h1>
        <AppButton class="AdminButton" v-for="item in buttons" :key="item.text" :url="{name: item.link}" >{{item.text}}</AppButton>
    </div> -->
    <v-navigation-drawer
      stateless
      value="true"
    >
        <v-list>
            <v-list-tile>
                <v-list-tile-title>Панель администратора</v-list-tile-title>
            </v-list-tile>
    
            <v-list-group
                no-action
                
                prepend-icon="account_circle"
                value="true"
            >
            <template v-slot:activator>
                <v-list-tile>Фильмы</v-list-tile>
            </template>

            <v-list-tile
                v-for="item in films"
                :key="'films_' + item.name"
            >
                <v-list-tile-title v-text="item.name"></v-list-tile-title>
                <v-list-tile-action>
                    <v-icon v-text="item.icon"></v-icon>
                </v-list-tile-action>
            </v-list-tile>

            </v-list-group>
        </v-list>
    </v-navigation-drawer>
</template>

<script>
import AppButton from '@/components/AppButton.vue'

export default {
    components:{
        AppButton,
    },
    data () {
        return {
            films: [
                {name: 'Добавить', icon: 'add'},
                {name: 'Изменить', icon: 'add'},
                {name: 'Удалить', icon: 'add'},
            ],
        }
    }
}
</script>

<style scoped>
h1{
    font-family: 'Roboto', sans-serif;
	font-size: 30px;
	font-weight: 300;
    text-shadow: 0 0 10px white;
    margin: 15px 0;
}
.AdminPanel{
    background: hsla(0, 0%, 0%, 0.2);
    padding: 15px;
    width: 400px;
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    user-select: none;
}
.AdminButton{
    background: rgba(255,255,255, 0.5);
    color: black;
    border: 1px solid black;
    border-radius: 0px;
    padding: 0 15px;
    margin: 9px 0;
    width: 100%;
    height: 42px;
    font-family: 'Roboto', sans-serif;
	font-size: 18px;
	font-weight: 300;
}
.AdminButton:hover{
    background: rgba(0,0,0, 0.5);
    color: white;
    border-color: white;
}
</style>
