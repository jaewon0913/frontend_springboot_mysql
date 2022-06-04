<template>
  <div class="clearAllContainer shadow">
      <span class="claerAllBtn" v-on:click="clearTodo()">Clear All</span>
  </div>
</template>

<script>
import { mapMutations } from 'vuex'

export default {
  methods: {
    ...mapMutations({
      clearTodo: 'clearAllItems'
    })
  }
}
</script>

<style scoped>
.clearAllContainer {
  width: 100%;
  height: 50px;
  line-height: 50px;
  background-color: white;
  border-radius: 5px;
  margin: 0 auto;
}

.claerAllBtn {
  color: #e20303;
  display: block;
}
</style>