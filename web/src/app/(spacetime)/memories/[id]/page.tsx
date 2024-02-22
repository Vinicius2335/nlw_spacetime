import { api } from '@/lib/api'
import dayjs from 'dayjs'
import ptBr from 'dayjs/locale/pt-br'
import { ArrowLeft, X } from 'lucide-react'
import { cookies } from 'next/headers'
import Image from 'next/image'
import Link from 'next/link'
import { Memory } from '../../page'
import CheckboxMemory from './CheckboxMemory'
import DialogEditMemory from './DialogEditMemory'
import { Toaster } from 'sonner'

interface MemoryDetatilsProps {
  params: {
    id: string
  }
}

dayjs.locale(ptBr)

export default async function MemoryDetails({ params }: MemoryDetatilsProps) {
  const token = cookies().get('token')?.value

  const response = await api.get(`/memories/${params.id}`, {
    headers: { Authorization: `Bearer ${token}` },
  })

  const memory: Memory = response.data

  return (
    <div className="flex flex-col gap-10 p-8">
      <Toaster richColors />

      <h1>{dayjs(memory.createdAt).format('D[ de ]MMMM[, ]YYYY')}</h1>
      <h2>Descrição: {memory.content}</h2>
      <Image
        src={`http://localhost:8080${memory.coverUrl}`}
        width={592}
        height={280}
        alt=""
        className="aspect-video w-full rounded-lg object-cover"
      />

      <CheckboxMemory isPublic={memory.public} />

      <div className="flex items-center justify-between">
        <Link
          href={`/`}
          className="flex items-center gap-2 text-sm text-gray-200 hover:text-gray-100"
        >
          <ArrowLeft className="h-4 w-4" /> Voltar
        </Link>

        <div className="flex items-center justify-center gap-2">
          <button className="flex items-center justify-center gap-1 rounded-md bg-red-500 px-2 py-1.5 text-sm text-zinc-100 transition duration-300 ease-in-out hover:scale-110 hover:bg-red-600">
            <X className="h-4 w-4" />
            Remover
          </button>

          <DialogEditMemory memory={memory} />
        </div>
      </div>
    </div>
  )
}
