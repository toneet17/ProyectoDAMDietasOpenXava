import { defineStore } from 'pinia'

export const useMessageStore = defineStore('messageStore', {
  state: () => ({
    messages: []
  }),
  actions: {
    addMessage(type, title) {
      this.messages.push({ id: this.messages.length + 1, type, title })
    },
    deleteMessage(id) {
      const index = this.messages.findIndex((item) => item.id == id)
      if (index != -1) {
        this.messages.splice(index, 1)
      }
    }
  }
})
