'use client'

import { api } from '@/lib/api'
import { setAuthHeader } from '@/utils/AuthUtil'
import { deleteCookie } from 'cookies-next'
import { useRouter } from 'next/navigation'

export function LogoutButton() {
  const router = useRouter()

  async function handleOnSair() {
    try {
      setAuthHeader()

      await api.post('/auth/logout')

      deleteCookie('token')
      router.refresh()
      router.push('/')
    } catch (err) {
      throw new Error('Error logging out')
    }
  }

  return (
    <button
      onClick={handleOnSair}
      className="block text-red-400 transition-colors hover:text-red-300"
    >
      Quero Sair
    </button>
  )
}
