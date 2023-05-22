'use client'

import { API } from '@/libs/axios'
import { User } from 'lucide-react'

export function Login() {
  async function handleOnLogin() {
    const registerResponse = await API.get('/teste')
    const testeResponse = registerResponse.data
    console.log(testeResponse)
  }

  return (
    <button
      onClick={handleOnLogin}
      className="flex items-center gap-3 text-left transition-colors hover:text-gray-50"
    >
      <div className="flex h-10 w-10  items-center justify-center rounded-full bg-gray-400">
        <User className="h-5 w-5 text-gray-500" />
      </div>
      <p className="max-w-[140px] text-sm leading-snug">
        <span className="underline underline-offset-2">Crie sua conta</span> e
        salve suas memórias
      </p>
    </button>
  )
}
