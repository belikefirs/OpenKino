<template>
    <v-card class="AdminHallCard" color="#1976d2">
        <v-card-text class="cardbody">
            <p style="margin: 15px">{{number}}</p>
            <div class="hallbody">
                <div class="screen"></div>
                <div class="places" :style="{width: hall.width * (placeSize + placeMargin) + 'px', height: hall.height * (placeSize + placeMargin) + 'px'}">
                    <div class="place"
                    v-for="(place) in hall.places" :key="place.id"
                    :style="{top: place.Y * (placeSize + placeMargin) + 'px', left: place.X * (placeSize + placeMargin) + 'px', height: placeSize + 'px', width: placeSize + 'px'}"
                    ></div>

                </div>
            </div>
        </v-card-text>

        <v-card-actions style="display: flex">
            <v-spacer />
            <v-btn @click="changeClick" icon>
                <v-icon color="amber">edit</v-icon>
            </v-btn>
            <v-btn @click="removeClick" icon>
                <v-icon color="red">delete</v-icon>
            </v-btn>
        </v-card-actions>
    </v-card>
</template>

<script>
export default {
    props: {
        number: {
            type: Number,
            required: true
        }
    },
    data() {
        return {
            placeSize: 15,
            placeMargin: 5,
            hall: {
                number: "1",
                width: 10,
                height: 3,
                places: [
                    { id: 0, X: 0, Y: 0 },
                    { id: 1, X: 1, Y: 0 },
                    { id: 2, X: 2, Y: 0 },
                    { id: 3, X: 3, Y: 0 },
                    { id: 4, X: 4, Y: 0 },
                    { id: 5, X: 5, Y: 0 },
                    { id: 6, X: 6, Y: 0 },
                    { id: 7, X: 7, Y: 0 },
                    // { id: 8, X: 8, Y: 0 },
                    { id: 9, X: 9, Y: 0 },

                    { id: 10, X: 0, Y: 1 },
                    { id: 11, X: 1, Y: 1 },
                    { id: 12, X: 2, Y: 1 },
                    { id: 13, X: 3, Y: 1 },
                    { id: 14, X: 4, Y: 1 },
                    { id: 15, X: 5, Y: 1 },
                    { id: 16, X: 6, Y: 1 },
                    { id: 17, X: 7, Y: 1 },
                    // { id: 18, X: 8, Y: 1 },
                    { id: 19, X: 9, Y: 1 },

                    { id: 20, X: 0, Y: 2 },
                    { id: 21, X: 1, Y: 2 },
                    { id: 22, X: 2, Y: 2 },
                    { id: 23, X: 3, Y: 2 },
                    { id: 24, X: 4, Y: 2 },
                    { id: 25, X: 5, Y: 2 },
                    { id: 26, X: 6, Y: 2 },
                    { id: 27, X: 7, Y: 2 },
                     { id: 38, X: 8, Y: 2 },
                    { id: 39, X: 9, Y: 2 },
                ]
            }
        };
    },
    methods: {
        changeClick() {},
        removeClick() {}
    }
};
</script>

<style lang="sass" scoped>
.AdminHallCard
    width: 300px
    height: 200px
    color: white
    display: flex
    flex-direction: column
    .cardbody
        flex: 1
        padding: 0
        display: flex
        flex-direction: row
        .hallbody
            margin-top: 20px
            flex: 1
            position: relative
            display: flex
            justify-content: center 
            align-items: center
            .screen
                position: absolute
                top: 0
                left: 0
                margin: 0 15px
                width: calc(100% - 30px)
                height: 4px
                background: white
            .places
                position: relative
                .place
                    position: absolute
                    background: white
                    border-radius: 40%
</style>
