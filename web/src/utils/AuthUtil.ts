import { api } from '@/lib/api'
import { getCookie } from 'cookies-next'

export function setAuthHeader() {
  const token = getCookie('token')
  // adicionando em todas as requisiçoes um cabeçalho
  api.defaults.headers.common.Authorization = `Bearer ${token}`
  // console.log(api.defaults.headers)
}
