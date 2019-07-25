<template>
    <WrapperCent>
        <div class="wrapper-Information">
            <div class="timeCinema">
                <div class="timefirst t"><p style="margin: 5px 0 0 0">8:00</p></div>
                <div class="timesecond t"><p style="margin: 5px 0 0 0">11:00</p></div>
            </div>
            <Cinema></Cinema>
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
    }
}
</script>

<style>
.timeCinema {
    display: flex;
    flex-direction: row;
}
.t{
    width: 120px;
    height: 35px;
    background: white;
    color: black;
    text-align: center;
    margin-right: 50px;
    margin-top: 10px;
}

</style>
