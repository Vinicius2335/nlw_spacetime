import Image from 'next/image'
import LogoImg from '@/assets/nlw-spacetime-logo.svg'
import { FormRegister } from './FormRegister'

export default function Register() {
  return (
    <div className="flex min-h-screen flex-col justify-center bg-[url(../assets/bg-stars.svg)] bg-cover">
      <div className="sm:mx-auto sm:w-full sm:max-w-sm">
        <Image
          className="mx-auto h-10 w-auto"
          src={LogoImg}
          alt="Nlw Spacetime Logo"
        />
        <h2 className="mt-10 text-center text-2xl font-bold leading-9 tracking-tight">
          Registar sua conta
        </h2>
      </div>

      <div className="mt-10 flex justify-center">
        <FormRegister />
      </div>
    </div>
  )
}
