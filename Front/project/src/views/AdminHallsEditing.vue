<template>
    <v-container>
        <v-layout>
            <v-spacer />
            <v-btn sm1 color="primary" @click="createItem">Создать</v-btn>
            <v-spacer />

            <v-dialog v-model="dialog" persistent width="500">
                <v-card>
                    <v-card-title>{{dialogTitle}}</v-card-title>
                    <v-card-text>
                        <v-text-field
                            v-model="editingItem.number"
                            label="Номер"
                            mask="###"
                            clearable
                        />
                        <v-text-field
                            v-model="editingItem.height"
                            label="Высота"
                            mask="##"
                            clearable
                        />
                        <v-text-field
                            v-model="editingItem.width"
                            label="Ширина"
                            mask="##"
                            clearable
                        />
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer />
                        <v-btn @click="confirmDialog" color="primary">{{confirmBtn}}</v-btn>
                        <v-btn @click="dialog = false">Отмена</v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
        </v-layout>
        <v-layout>
            <!-- <v-flex sm12 class="cardHolder">
                <HallCard v-for="n in 8" :key="n" :number="n" />
            </v-flex> -->

            <v-flex sm12>
                <v-card>
                    <v-data-table
                        :headers="headers"
                        :items="$store.state.Hall.hallList"
                        hide-actions
                        no-data-text="Нет данных"
                    >
                        <template v-slot:items="props">
                            <td>{{ props.item.number }}</td>
                            <td>{{ props.item.width }}</td>
                            <td>{{ props.item.height }}</td>
                            <td class="text-xs-right">
                                <v-btn
                                    flat
                                    icon
                                    color="amber"
                                    @click="changeItem(props.item, props.index)"
                                >
                                    <v-icon>edit</v-icon>
                                </v-btn>
                                <v-btn flat icon color="red" @click="deleteItem(props.item)">
                                    <v-icon>delete</v-icon>
                                </v-btn>
                            </td>
                        </template>
                    </v-data-table>
                </v-card>
            </v-flex>

        </v-layout>
    </v-container>
</template>

<script>
import HallCard from "@/components/AdminHallCard";

export default {
    components: {
        HallCard
    },
    data() {
        return {
            dialog: false,
            dialogTitle: "Создание зала",
            confirmBtn: "Создать",
            headers: [
                {
                    text: "Номер зала",
                    align: "left",
                    sortable: false,
                    value: "hall"
                },
                {
                    text: "Ширина",
                    align: "left",
                    sortable: false,
                    value: "hall"
                },
                {
                    text: "Высота",
                    align: "left",
                    sortable: false,
                    value: "hall"
                },
                {
                    text: "Действия",
                    align: "right",
                    sortable: false,
                    value: "timeEnd"
                }
            ],
            defaultItem: {
                number: "",
                height: "",
                width: ""
            },
            editingItem: {
                number: "",
                height: "",
                width: ""
            }
        };
    },
    methods: {
        createItem() {
            Object.assign(this.editingItem, this.defaultItem);
            this.dialog = true;
        },
        confirmDialog() {
            this.$store.dispatch("Hall/GET_ALL_HALLS");
            this.dialog = false;
        }
    },
    created(){
        this.$store.dispatch("Hall/GET_ALL_HALLS");
    }
};
</script>

<style lang="sass" scoped>
.cardHolder
    display: flex
    flex-direction: row
    flex-wrap: wrap
    justify-content: center
    & div
        margin: 15px
</style>
