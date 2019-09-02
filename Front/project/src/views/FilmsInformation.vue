<template>
    <WrapperCent>
        <div class="wrapper-Information">
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
    },
}
</script>

<style>

</style>
