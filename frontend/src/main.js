import { createApp } from 'vue'
import App from './App.vue'
import { store } from './store/store';

//Vue.config.productionTip = false

createApp(App)
    .use(store)
    .mount('#app')
