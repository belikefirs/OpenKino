<template>
    <v-app id="Admin" :dark="dark">
        <v-navigation-drawer style="display: flex; flex-direction: column; overflow: hidden;"
        permanent
        fixed
        app
        >
            <v-toolbar flat>
                <v-list>
                    <v-list-tile>
                        <v-list-tile-title>Панель администратора</v-list-tile-title>
                    </v-list-tile>
                </v-list>
            </v-toolbar>

            <v-divider></v-divider>

            <v-list>
                <v-list-group prepend-icon="account_circle">
                    <template v-slot:activator>
                        <v-list-tile>
                            <v-list-tile-title>Редактирование</v-list-tile-title>
                        </v-list-tile>
                    </template>
                    <v-list-tile v-for="item in navigation" :key="item.name" :to="{name: item.route}">
                        <v-list-tile-content>
                            <v-list-tile-title v-text="item.name"></v-list-tile-title>
                        </v-list-tile-content>
                        
                        <v-list-tile-action>
                            <v-icon v-text="item.icon"></v-icon>
                        </v-list-tile-action>
                    </v-list-tile>
                
                </v-list-group>
            </v-list>

            <v-spacer></v-spacer>

            <v-divider></v-divider>

            <v-list>
                <v-list-tile>
                    <v-list-tile-action>
                        <v-switch v-model="dark" :label="textTheme"></v-switch>
                    </v-list-tile-action>
                </v-list-tile>
            </v-list>

        </v-navigation-drawer>  

        <v-content>
            <v-container fluid fill-height>
                <v-layout>
                    <v-flex align-center justify-center>
                        <router-view></router-view>
                    </v-flex>
                </v-layout>
            </v-container>
        </v-content>

        
    </v-app>
</template>

<script>
import AdminPanel from '@/components/AppAdminPanel.vue'

export default {
    components:{
        AdminPanel,
    },
    data () {
        return {
            dark: false,
            navigation: [
                {name: 'Фильмы', icon: 'edit', route: 'filmsEditing'},
            ],
        }
    },
    methods:{
        
    },
    computed:{
        textTheme(){
            return 'Тема: ' + (this.dark ? 'Темная' : 'Светлая');
        }
    },
}
</script>

<style scoped>
.tile:hover {
    background: green;
}
.active-tile{
    background: green;
    color: red;
}
</style>
