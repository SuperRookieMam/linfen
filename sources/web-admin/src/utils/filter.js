export default {
  dateFormat (date) {
    if (!date) return ''
    date = new Date(date)
    const Y = date.getFullYear()
    const M = (date.getMonth() + 1).toString().padStart(2, 0)
    const d = date.getDate().toString().padStart(2, 0)
    // const H = date.getHours().toString().padStart(2, 0)
    // const m = date.getMinutes().toString().padStart(2, 0)
    // const s = date.getSeconds().toString().padStart(2, 0)
    // return `${Y}年${M}月${d}日 ${H}:${m}:${s}`
    return `${Y}.${M}.${d}`
  },

  staffStatus (status) {
    switch (status) {
      case '1':
        return '在职'
      case '2':
        return '试用'
      case '0':
        return '离职'
      default:
        return ''
    }
  },

  empStatus (status) {
    switch (status) {
      case '1':
        return '进行中'
      case '2':
        return '待岗中'
      case '0':
        return '离职'
      default:
        return ''
    }
  }
}
