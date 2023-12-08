'use client'

import { useRouter } from 'next/navigation'
import { FormEvent, useRef } from 'react'

export function FormRegister() {
  const router = useRouter()
  const nameInputRef = useRef<HTMLInputElement>(null)
  const emailInputRef = useRef<HTMLInputElement>(null)
  const passwordInputRef = useRef<HTMLInputElement>(null)
  const confirmPasswordInputRef = useRef<HTMLInputElement>(null)
  const avatarInputRef = useRef<HTMLInputElement>(null)

  function handleOnSubmit(e: FormEvent) {
    e.preventDefault()

    const email = emailInputRef.current?.value
    const name = nameInputRef.current?.value
    const password = passwordInputRef.current?.value
    const confirmPassword = confirmPasswordInputRef.current?.value
    const avatarUrl = avatarInputRef.current?.value

    alert(
      JSON.stringify(
        { email, name, password, confirmPassword, avatarUrl },
        null,
        2,
      ),
    )

    router.push('/login')
  }

  return (
    <>
      <form className="flex gap-4" onSubmit={handleOnSubmit}>
        <div className="w-[350px] space-y-4">
          <div>
            <label className="block text-sm font-medium leading-6">Nome</label>
            <div className="mt-2">
              <input
                id="name"
                name="name"
                type="text"
                ref={nameInputRef}
                required
                className="block w-full rounded-md border-0 px-1.5 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              />
            </div>
          </div>

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
            <label className="block text-sm font-medium leading-6">
              AvatarURL
            </label>
            <div className="mt-2">
              <input
                id="avatar"
                name="avatar"
                type="url"
                ref={avatarInputRef}
                required
                className="block w-full rounded-md border-0 px-1.5 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              />
            </div>
          </div>
        </div>

        <div className="w-[350px] space-y-4">
          <div>
            <label
              htmlFor="password"
              className="block text-sm font-medium leading-6"
            >
              Password
            </label>
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
            <label
              htmlFor="password"
              className="block text-sm font-medium leading-6"
            >
              Confirmar Password
            </label>
            <div className="mt-2">
              <input
                id="confirmPassword"
                name="confirmPassword"
                type="password"
                ref={confirmPasswordInputRef}
                required
                className="block w-full rounded-md border-0 px-1.5 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              />
            </div>
          </div>

          <div>
            <button
              type="submit"
              className="mt-12 flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
            >
              Registar
            </button>
          </div>
        </div>
      </form>
    </>
  )
}
