<template>
    <v-app id="Admin" :dark="dark">
        <!-- navigation -->
        <v-navigation-drawer style="display: flex; flex-direction: column; overflow: hidden;"
        disable-resize-watcher
        disable-route-watcher
        v-model="drawer"
        fixed
        clipped
        app>
            <v-divider/>
            <v-list>
                <v-list-group
                v-for="item in navigation" :key="item.name"
                no-action>
                    <template v-slot:activator>
                        <v-list-tile>
                            <v-list-tile-action>
                                <v-icon v-text="item.icon"></v-icon>
                            </v-list-tile-action>
                            <v-list-tile-content>
                                <v-list-tile-title v-text="item.name"></v-list-tile-title>
                            </v-list-tile-content>
                        </v-list-tile>
                    </template>
                    <v-list-tile v-for="sub in item.subTabs" :key="sub.name" :to="{name: sub.route}" @click="title = sub.name">
                        <v-list-tile-action>
                            <v-icon v-text="sub.icon"></v-icon>
                        </v-list-tile-action>
                        <v-list-tile-content>
                            <v-list-tile-title v-text="sub.name"></v-list-tile-title>
                        </v-list-tile-content>
                        
                    </v-list-tile>
                </v-list-group> 
            </v-list>
            <v-spacer/>
            <v-divider/>
            <v-list>
                <v-list-tile>
                    <v-list-tile-action>
                        <v-switch v-model="dark" :label="textTheme"></v-switch>
                    </v-list-tile-action>
                </v-list-tile>
            </v-list>
        </v-navigation-drawer> 
        <!-- toolbar -->
        <v-toolbar clipped-left fixed app>
            <v-btn icon @click.stop="drawer = !drawer">
                <v-icon v-if="drawer">chevron_left</v-icon>
                <v-icon v-else>menu</v-icon>
            </v-btn>
            <v-toolbar-title class="text-xs-center" style="font-size: 16px">
                Панель администратора / {{title}}
            </v-toolbar-title>
        </v-toolbar>
        <!-- content -->
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
import 'vuetify/dist/vuetify.min.css';
import AdminPanel from '@/components/AppAdminPanel.vue'

export default {
    components:{
        AdminPanel,
    },
    data () {
        return {
            drawer: false,
            dark: false,
            title: '',
            navigation: [
                {
                    name: 'Управление фильмами', icon: 'camera_roll',
                    subTabs: [
                        {name: 'Фильмы', icon: 'theaters', route: 'filmsEditing'},
                        // {name: 'Жанры', icon: 'favorite', route: 'genreEditing'},
                    ],
                },
                {
                    name: 'Управление сеансами', icon: 'local_play',
                    subTabs: [
                        {name: 'Сеансы', icon: 'local_play', route: 'sessionsEditing'},
                    ],
                },
            ],
        }
    },
    created(){
        for (let i = 0; i < this.navigation.length; i++) 
            for (let j = 0; j < this.navigation[i].subTabs.length; j++) 
                if (this.navigation[i].subTabs[j].route == this.$route.name)
                    this.title = this.navigation[i].subTabs[j].name;
    },
    methods:{

    },
    computed:{
        textTheme(){
            return 'Тема: ' + (this.dark ? 'Темная' : 'Светлая');
        },
    },
}
</script>