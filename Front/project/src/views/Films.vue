<template>
    <div class="wrapper-home">
        <Modal>
            <template v-slot:title>Бронирование билетов</template>
            <template v-slot:content>               
                <AppCinema></AppCinema>
            </template>
        </Modal>
    </div>
</template>

<script>
import AppCinema from '@/components/AppCinema.vue'
import Modal from '@/components/AppModalWindow.vue'

export default {
    components: {
        AppCinema, Modal
    }
}
</script>

<style scoped>

</style>