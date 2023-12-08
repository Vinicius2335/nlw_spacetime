import { getUser } from '@/lib/auth'
import { User } from 'lucide-react'
import Image from 'next/image'

export function Profile() {
  const { name, avatarUrl } = getUser()

  return (
    <div className="flex items-center gap-3 text-left">
      <Image
        src={avatarUrl}
        alt="User Profile Image"
        width={40}
        height={50}
        className="h-10 w-10 rounded-full"
      />

      <p className="max-w-[140px] text-sm leading-snug">
        {name}
        <a
          href=""
          className="block text-red-400 transition-colors hover:text-red-300"
        >
          Quero Sair
        </a>
      </p>
    </div>
  )
}
