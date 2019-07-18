<template>
    <v-app id="Admin" :dark="dark">
        <v-navigation-drawer style="display: flex; flex-direction: column; overflow: hidden;"
        v-model="drawer"
        :mini-variant.sync="mini"
        permanent
        fixed
        app
        >
            <v-toolbar flat>
                <v-list>
                    <v-list-tile>
                        <v-list-tile-content v-if="!mini">
                            <v-list-tile-title>Панель администратора</v-list-tile-title>
                        </v-list-tile-content>
                        <v-list-tile-action>
                            <v-btn icon @click.stop="mini=!mini">
                                <v-icon v-if="!mini">chevron_left</v-icon>
                                <v-icon v-else>menu</v-icon>
                            </v-btn>
                        </v-list-tile-action>
                    </v-list-tile>
                </v-list>
            </v-toolbar>

            <v-divider></v-divider>

            <v-list>
                <v-list-group prepend-icon="settings">
                    <template v-slot:activator>
                        <v-list-tile>
                            <v-list-tile-title v-text="'Редактирование'"></v-list-tile-title>
                        </v-list-tile>
                    </template>
                    <v-list-tile v-for="item in navigation" :key="item.name" :to="{name: item.route}">
                        <v-list-tile-content v-if="!mini">
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
            drawer: null,
            mini: false,
            dark: false,
            navigation: [
                {name: 'Фильмы', icon: 'movie', route: 'filmsEditing'},
            ],
        }
    },
    methods:{
        
    },
    computed:{
        textTheme(){
            if (this.mini) return '';
            return 'Тема: ' + (this.dark ? 'Темная' : 'Светлая');
        }
    },
}
</script>
