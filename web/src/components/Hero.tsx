import Image from 'next/image'
import LogoImg from '@/assets/nlw-spacetime-logo.svg'
import Link from 'next/link'

export function Hero() {
  return (
    <div className="max-w-[420px] space-y-5">
      <Image src={LogoImg} alt="Logo Nlw Spacetime" />

      <div>
        <h1 className="text-5xl font-bold leading-tight text-gray-50">
          Sua cápsula do tempo
        </h1>
        <p className="text-lg leading-relaxed">
          Colecione momentos marcantes da sua jornada e compartilhe (se quiser)
          com o mundo!
        </p>
      </div>

      <Link
        href="/memories/new"
        className="inline-block rounded-full bg-green-500 px-5 py-3 font-alt text-sm uppercase leading-none text-black transition-colors hover:bg-green-700"
      >
        Cadastrar Lembrança
      </Link>
    </div>
  )
}
