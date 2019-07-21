<template>
    <div>
        <FilmFilter></FilmFilter>
        <SelectionsForYou></SelectionsForYou>
    </div>
</template>

<script>
import FilmFilter from '@/components/FilmFilter.vue'
import SelectionsForYou from '@/components/FilmsSelectionsForYou.vue'
import WrapperCent from '@/components/AppWrapperCenter.vue'

export default {
    components: {
        FilmFilter, SelectionsForYou, WrapperCent
    }
}
</script>

<style lang="sass">

</style>