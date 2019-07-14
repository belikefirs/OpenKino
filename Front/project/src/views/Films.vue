<template>
    <div class="wrapper-film">
        <Modal :title="'Бронирование билетов'" :width="500" :height="500">
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