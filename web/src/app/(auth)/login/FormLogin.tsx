'use client'

import { api } from '@/lib/api'
import { useRouter } from 'next/navigation'
import { FormEvent, useRef } from 'react'
import { setCookie } from 'cookies-next'
import { Toaster, toast } from 'sonner'
import { AxiosError } from 'axios'

interface ErrorResponse {
  error: string
  message: string
  status: number
}

export function FormLogin() {
  const router = useRouter()
  const emailInputRef = useRef<HTMLInputElement>(null)
  const passwordInputRef = useRef<HTMLInputElement>(null)

  async function handleOnSubmit(e: FormEvent) {
    e.preventDefault()

    const email = emailInputRef.current?.value
    const password = passwordInputRef.current?.value

    // alert(JSON.stringify({ email, password }, null, 2))

    try {
      const response = await api
        .post('/auth/login', { email, password })
        .then((resp) => resp.data)

      // path: '/' -> significa que toda aplicação pode acessar o cookie
      // max age: é o tempo em segundos
      // cookie expira em 30 dias
      const cookieExpiresInSeconds = 60 * 60 * 24 * 30
      setCookie('token', response.token, {
        path: '/',
        maxAge: cookieExpiresInSeconds,
      })

      router.push('/')
      router.refresh()
    } catch (ex) {
      const error = ex as AxiosError<ErrorResponse>

      if (error.response?.data.status === 401) {
        toast.error(error.response.data.message)
        return
      }
      toast.error('Erro ao tentar realizar login, tente novamente.')
    }
  }

  function handleOnRegister() {
    router.push('/register')
  }

  return (
    <>
      <Toaster richColors duration={2000} />

      <form className="space-y-6" onSubmit={handleOnSubmit}>
        <div>
          <label className="block text-sm font-medium leading-6">Email</label>
          <div className="mt-2">
            <input
              id="email"
              name="email"
              type="email"
              ref={emailInputRef}
              required
              className="block w-full rounded-md border-0 px-1.5 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
            />
          </div>
        </div>

        <div>
          <div className="flex items-center justify-between">
            <label
              htmlFor="password"
              className="block text-sm font-medium leading-6"
            >
              Password
            </label>
            <div className="text-sm">
              <a
                href="#"
                className="font-semibold text-indigo-600 hover:text-indigo-500"
              >
                Forgot password?
              </a>
            </div>
          </div>
          <div className="mt-2">
            <input
              id="password"
              name="password"
              type="password"
              ref={passwordInputRef}
              required
              className="block w-full rounded-md border-0 px-1.5 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
            />
          </div>
        </div>

        <div>
          <button
            type="submit"
            className="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
          >
            Login
          </button>
        </div>
      </form>

      <p className="mt-10 text-center text-sm ">
        Não possui uma conta?
        <button
          onClick={handleOnRegister}
          className="ml-2 font-semibold leading-6 text-indigo-600 hover:text-indigo-500"
        >
          Registrar-se
        </button>
      </p>
    </>
  )
}
