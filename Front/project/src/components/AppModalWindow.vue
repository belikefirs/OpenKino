<template>
    <transition name="trShow">
        <div class="wrapper_module_window" v-if="show" @click.self="changeBlur">
            <div v-if="show" class="container" :style="{'border-radius' : title ? '8px' : '0'}"> 
                <p class="title" v-if="title">{{title}}</p>
                <div class="wrapper-content">
                    <slot name="content"></slot>
                </div>
                <div class="wrapper-buttons">
                    <slot name="buttons"></slot>  
                </div>
            </div>
        </div>
    </transition>
</template>

<script>
export default {
    props:{
        title: String,
        show: {
            type: Boolean,
            required: true,
        },
        width: {
            type: Number,
            required: false,
        },
        height: {
            type: Number,
            required: false,
        },
    },
    methods:{
		changeBlur(){
			this.$emit("showBlur");
		}
    },
    computed:{

    }
}
</script>


<style scoped>
.wrapper_module_window {
    z-index: 200;
    position: fixed;
    top: 0;
    left: 0;
    height: 100vh;
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: top;
    align-items: top;
    background: rgba(31,31,31,0.9);
}
.container{
    /* z-index: 201; */
    background: #111;
    margin: 100px auto 0;
    transition: all 1s;
}
.title{
    padding: 20px;
    font-size: 27px;
    font-weight: 100;
    color: #ffffff;   
    text-align: left;
    letter-spacing: 1px;
    font-weight: 100;
}
.wrapper-buttons {
    margin-left: 20px
}

.trShow-enter, .trShow-leave-to {
    opacity: 0;
    transform: translateY(-1000px);
}
.trShow-enter-active, .trShow-leave-active {
    transition: all .5s;
}
.trShow-move{
    transition: all 1s;
}
</style>

<style lang="sass" scoped>
.wrapper-buttons
    a
        text-decoration: none
        color: white
        font-size: 18px
        font-weight: 100
</style>