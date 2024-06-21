import { createRouter, createWebHistory } from 'vue-router'
import DietasList from '@/components/DietasList.vue'
import ComidaDetail from '@/components/ComidaDetail.vue'

const routes = [
  { path: '/', name: 'DietasList', component: DietasList },
  { path: '/comida/:id', name: 'ComidaDetail', component: ComidaDetail }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
